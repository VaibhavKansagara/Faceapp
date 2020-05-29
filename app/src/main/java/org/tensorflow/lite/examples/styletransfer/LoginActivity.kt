package org.tensorflow.lite.examples.styletransfer

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {

    var _emailText: EditText? = null
    var _passwordText: EditText? = null
    var _loginButton: Button? = null
    var _signupLink: TextView? = null

    val EMAIL_ADDRESS_PATTERN: Pattern = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        _loginButton = findViewById(R.id.btn_login) as Button
        _signupLink = findViewById(R.id.link_signup) as TextView
        _passwordText = findViewById(R.id.input_password) as EditText
        _emailText = findViewById(R.id.input_email) as EditText

        _loginButton!!.setOnClickListener { login() }
        _signupLink!!.setOnClickListener {
		// Start the Signup activity
		val intent = Intent(applicationContext, SignupActivity::class.java)
		startActivity(intent)
		finish()
        }
    }

    fun login() {
       Log.d(TAG, "Login")
        val email = _emailText!!.text.toString()
        val password = _passwordText!!.text.toString()

       if (!validate(email,password)) {
           onLoginFailed()
           return
       }

       _loginButton!!.isEnabled = false

       // TODO: Implement your own authentication logic here.
        val sp = this.getSharedPreferences("Login", Context.MODE_PRIVATE)
        val newPass = sp.getString(email, null)

        if (newPass == password) {
            onLoginSuccess()
        } else {
            onLoginFailed()
        }
    }

    override fun onBackPressed() {
        // Disable going back to the MainActivity
        moveTaskToBack(true)
    }

    fun onLoginSuccess() {
        _loginButton!!.isEnabled = true
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    fun onLoginFailed() {
        Toast.makeText(baseContext, "Login failed", Toast.LENGTH_LONG).show()

        _loginButton!!.isEnabled = true
    }

    fun validate(email: String, password: String): Boolean {
        var valid = true
        if (email.isEmpty() || !EMAIL_ADDRESS_PATTERN.matcher(email).matches()) {
            valid = false
        }
        if (password.isEmpty() || password.length < 4 || password.length > 10) {
            valid = false
        }
        return valid
    }

    companion object {
        private val TAG = "LoginActivity"
    }
}