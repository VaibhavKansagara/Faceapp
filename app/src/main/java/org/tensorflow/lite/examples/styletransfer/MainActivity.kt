/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.tensorflow.lite.examples.styletransfer

import android.Manifest
import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.app.Activity
import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.hardware.camera2.CameraCharacteristics
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.BounceInterpolator
import android.widget.*
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import com.bumptech.glide.request.RequestOptions
import java.io.File
import java.nio.charset.Charset
import java.security.MessageDigest
import java.util.concurrent.Executors
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.async
import org.tensorflow.lite.examples.styletransfer.RealPathUtil.getRealPath
import org.tensorflow.lite.examples.styletransfer.camera.CameraFragment

// This is an arbitrary number we are using to keep tab of the permission
// request. Where an app has multiple context for requesting permission,
// this can help differentiate the different contexts
private const val REQUEST_CODE_PERMISSIONS = 10

// This is an array of all the permission specified in the manifest
private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)

private const val TAG = "MainActivity"

class MainActivity :
  AppCompatActivity(),
  StyleFragment.OnListFragmentInteractionListener,
  CameraFragment.OnCaptureFinished {

  private var isRunningModel = false
  private val stylesFragment: StyleFragment = StyleFragment()
  private var selectedStyle: String = ""

  private lateinit var cameraFragment: CameraFragment
  private lateinit var viewModel: MLExecutionViewModel
  private lateinit var viewFinder: FrameLayout
  private lateinit var resultImageView: ImageView
  private lateinit var originalImageView: ImageView
  private lateinit var styleImageView: ImageView
  private lateinit var rerunButton: Button
  private lateinit var captureButton: ImageButton
  private lateinit var galleryButton: ImageButton
  private lateinit var progressBar: ProgressBar
  private lateinit var horizontalScrollView: HorizontalScrollView

  private var lastSavedFile = ""
  private var useGPU = false
  private lateinit var styleTransferModelExecutor: StyleTransferModelExecutor
  private val inferenceThread = Executors.newSingleThreadExecutor().asCoroutineDispatcher()
  private val mainScope = MainScope()

  private var lensFacing = CameraCharacteristics.LENS_FACING_FRONT
  private val FINAL_CHOOSE_PHOTO = 1
  private val READ_EXTERNAL_STORAGE_REQUEST_CODE = 2

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.login)

    // get reference to all views
    var et_user_name = findViewById(R.id.et_user_name) as EditText
    var et_password = findViewById(R.id.et_password) as EditText
    var btn_reset = findViewById(R.id.btn_reset) as Button
    var btn_submit = findViewById(R.id.btn_submit) as Button

    btn_reset.setOnClickListener {
      // clearing user_name and password edit text views on reset button click
      et_user_name.setText("")
      et_password.setText("")
    }

    // set on-click listener
    btn_submit.setOnClickListener {
      val user_name = et_user_name.text.trim().toString()
      val password = et_password.text.trim().toString()
      // your code to validate the user_name and password combination
      // and verify the same
      if (user_name == "username" && password == "password") {
          val toast = Toast.makeText (getApplicationContext(), "Login Succesfull", Toast.LENGTH_LONG);
          toast.show();
          setContentView(R.layout.activity_main)
          val toolbar: Toolbar = findViewById(R.id.toolbar)
          setSupportActionBar(toolbar)
          supportActionBar?.setDisplayShowTitleEnabled(false)

          viewFinder = findViewById(R.id.view_finder)
          resultImageView = findViewById(R.id.result_imageview)
          originalImageView = findViewById(R.id.original_imageview)
          styleImageView = findViewById(R.id.style_imageview)
          captureButton = findViewById(R.id.capture_button)
          galleryButton = findViewById(R.id.gallery_button)
          progressBar = findViewById(R.id.progress_circular)
          horizontalScrollView = findViewById(R.id.horizontal_scroll_view)
          val useGpuSwitch: Switch = findViewById(R.id.switch_use_gpu)

          // Request camera permissions
          if (allPermissionsGranted()) {
            addCameraFragment()
          } else {
            ActivityCompat.requestPermissions(
              this,
              REQUIRED_PERMISSIONS,
              REQUEST_CODE_PERMISSIONS
            )
          }

          viewModel = ViewModelProviders.of(this)
            .get(MLExecutionViewModel::class.java)

          viewModel.styledBitmap.observe(
            this,
            Observer { resultImage ->
              if (resultImage != null) {
                updateUIWithResults(resultImage)
              }
            }
          )

          mainScope.async(inferenceThread) {
            styleTransferModelExecutor = StyleTransferModelExecutor(this@MainActivity, useGPU)
            Log.d(TAG, "Executor created")
          }

          useGpuSwitch.setOnCheckedChangeListener { _, isChecked ->
            useGPU = isChecked
            // Disable control buttons to avoid running model before initialization
            enableControls(false)

            // Reinitialize TF Lite models with new GPU setting
            mainScope.async(inferenceThread) {
              styleTransferModelExecutor.close()
              styleTransferModelExecutor = StyleTransferModelExecutor(this@MainActivity, useGPU)

              // Re-enable control buttons
              runOnUiThread { enableControls(true) }
            }
          }

          rerunButton = findViewById(R.id.rerun_button)
          rerunButton.setOnClickListener {
            startRunningModel()
          }

          styleImageView.setOnClickListener {
            if (!isRunningModel) {
              stylesFragment.show(supportFragmentManager, "StylesFragment")
            }
          }

          galleryButton.setOnClickListener {
            pickImage()
          }

          progressBar.visibility = View.INVISIBLE
          lastSavedFile = getLastTakenPicture()
          setImageView(originalImageView, lastSavedFile)

          animateCameraButton()
          setupControls()
          enableControls(true)

          Log.d(TAG, "finished onCreate!!")
      } else {
        val toast = Toast.makeText(getApplicationContext(), "Login Unsuccesfull", Toast.LENGTH_LONG);
        toast.show();
        Log.d(TAG, "Problem logging in: username or password wrong!!")
      }
    }
  }

  private fun pickImage() {
    if (ActivityCompat.checkSelfPermission(this, READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
      val intent = Intent("android.intent.action.GET_CONTENT")
      intent.type = "image/*"
      startActivityForResult(intent, FINAL_CHOOSE_PHOTO)
    } else {
      ActivityCompat.requestPermissions(
        this,
        arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
        READ_EXTERNAL_STORAGE_REQUEST_CODE
      )
    }
  }
  private fun animateCameraButton() {
    val animation = AnimationUtils.loadAnimation(this, R.anim.scale_anim)
    animation.interpolator = BounceInterpolator()
    captureButton.animation = animation
    captureButton.animation.start()
  }

  private fun setImageView(imageView: ImageView, image: Bitmap) {
    Glide.with(baseContext)
      .load(image)
      .override(512, 512)
      .fitCenter()
      .into(imageView)
  }

  private fun setImageView(imageView: ImageView, imagePath: String) {
    Glide.with(baseContext)
      .asBitmap()
      .load(imagePath)
      .override(512, 512)
      .apply(RequestOptions().transform(CropTop()))
      .into(imageView)
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    when(requestCode) {
      FINAL_CHOOSE_PHOTO->
        if (resultCode == Activity.RESULT_OK) {
          if (data == null) {
            // display a toast
            val toast = Toast.makeText(getApplicationContext(), "Choosing From Gallery Unsuccesfull",
                                       Toast.LENGTH_LONG)
            toast.show()
            Log.d(TAG, "Choosing From Gallery Unsuccesfull")
          } else {
            val uri = data.data
            val filePath = uri?.let { getRealPath(getApplicationContext(), it) }
              val imgfile = File(filePath)
              if (imgfile.exists()) {
                  val mybitmap = BitmapFactory.decodeFile(imgfile.absolutePath)
                  setImageView(originalImageView, mybitmap)
                  lastSavedFile = imgfile.absolutePath
              }
          }
        }
    }
  }

  private fun updateUIWithResults(modelExecutionResult: ModelExecutionResult) {
    progressBar.visibility = View.INVISIBLE
    resultImageView.visibility = View.VISIBLE
    setImageView(resultImageView, modelExecutionResult.styledImage)
    val logText: TextView = findViewById(R.id.log_view)
    logText.text = modelExecutionResult.executionLog
    enableControls(true)
    horizontalScrollView.fullScroll(HorizontalScrollView.FOCUS_RIGHT)
  }

  private fun enableControls(enable: Boolean) {
    isRunningModel = !enable
    rerunButton.isEnabled = enable
    captureButton.isEnabled = enable
  }

  private fun setupControls() {
    captureButton.setOnClickListener {
      it.clearAnimation()
      cameraFragment.takePicture()
    }

    findViewById<ImageButton>(R.id.toggle_button).setOnClickListener {
      lensFacing = if (lensFacing == CameraCharacteristics.LENS_FACING_BACK) {
        CameraCharacteristics.LENS_FACING_FRONT
      } else {
        CameraCharacteristics.LENS_FACING_BACK
      }
      cameraFragment.setFacingCamera(lensFacing)
      addCameraFragment()
    }
  }

  private fun addCameraFragment() {
    cameraFragment = CameraFragment.newInstance()
    cameraFragment.setFacingCamera(lensFacing)
    supportFragmentManager.popBackStack()
    supportFragmentManager.beginTransaction()
      .replace(R.id.view_finder, cameraFragment)
      .commit()
  }

  /**
   * Process result from permission request dialog box, has the request
   * been granted? If yes, start Camera. Otherwise display a toast
   */
  override fun onRequestPermissionsResult(
    requestCode: Int,
    permissions: Array<String>,
    grantResults: IntArray
  ) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    if (requestCode == REQUEST_CODE_PERMISSIONS) {
      if (allPermissionsGranted()) {
        addCameraFragment()
        viewFinder.post { setupControls() }
      } else {
        Toast.makeText(
          this,
          "Permissions not granted by the user.",
          Toast.LENGTH_SHORT
        ).show()
        finish()
      }
    }

    if (requestCode == READ_EXTERNAL_STORAGE_REQUEST_CODE) {
      if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
        // pick image after request permission success
        pickImage()
      }
    }
  }

  /**
   * Check if all permission specified in the manifest have been granted
   */
  private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
    ContextCompat.checkSelfPermission(
      baseContext, it
    ) == PackageManager.PERMISSION_GRANTED
  }

  override fun onCaptureFinished(file: File) {
    val msg = "Photo capture succeeded: ${file.absolutePath}"
    Log.d(TAG, msg)

    lastSavedFile = file.absolutePath
    setImageView(originalImageView, lastSavedFile)
  }

  // And update once new picture is taken?
  // Alternatively we can provide user an ability to select any of taken photos
  private fun getLastTakenPicture(): String {
    val directory = baseContext.filesDir // externalMediaDirs.first()
    var files =
      directory.listFiles()?.filter { file -> file.absolutePath.endsWith(".jpg") }?.sorted()
    if (files == null || files.isEmpty()) {
      Log.d(TAG, "there is no previous saved file")
      return ""
    }

    val file = files.last()
    Log.d(TAG, "lastsavedfile: " + file.absolutePath)
    return file.absolutePath
  }

  override fun onListFragmentInteraction(item: String) {
    Log.d(TAG, item)
    selectedStyle = item
    stylesFragment.dismiss()

    startRunningModel()
  }

  private fun getUriFromAssetThumb(thumb: String): String {
    return "file:///android_asset/thumbnails/$thumb"
  }

  private fun startRunningModel() {
    if (!isRunningModel && lastSavedFile.isNotEmpty() && selectedStyle.isNotEmpty()) {
      val chooseStyleLabel: TextView = findViewById(R.id.choose_style_text_view)
      chooseStyleLabel.visibility = View.GONE
      enableControls(false)
      setImageView(styleImageView, getUriFromAssetThumb(selectedStyle))
      resultImageView.visibility = View.INVISIBLE
      progressBar.visibility = View.VISIBLE
      viewModel.onApplyStyle(
        baseContext, lastSavedFile, selectedStyle, styleTransferModelExecutor,
        inferenceThread
      )
    } else {
      Toast.makeText(this, "Previous Model still running", Toast.LENGTH_SHORT).show()
    }
  }

  // this transformation is necessary to show the top square of the image as the model
  // will work on this part only, making the preview and the result show the same base
  class CropTop : BitmapTransformation() {
    override fun transform(
      pool: BitmapPool,
      toTransform: Bitmap,
      outWidth: Int,
      outHeight: Int
    ): Bitmap {
      return if (toTransform.width == outWidth && toTransform.height == outHeight) {
        toTransform
      } else ImageUtils.scaleBitmapAndKeepRatio(toTransform, outWidth, outHeight)
    }

    override fun equals(other: Any?): Boolean {
      return other is CropTop
    }

    override fun hashCode(): Int {
      return ID.hashCode()
    }

    override fun updateDiskCacheKey(messageDigest: MessageDigest) {
      messageDigest.update(ID_BYTES)
    }

    companion object {
      private const val ID = "org.tensorflow.lite.examples.styletransfer.CropTop"
      private val ID_BYTES = ID.toByteArray(Charset.forName("UTF-8"))
    }
  }
}
