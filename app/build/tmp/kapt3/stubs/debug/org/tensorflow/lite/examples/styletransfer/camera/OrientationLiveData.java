package org.tensorflow.lite.examples.styletransfer.camera;

import java.lang.System;

/**
 * Calculates closest 90-degree orientation to compensate for the device
 * rotation relative to sensor orientation, i.e., allows user to see camera
 * frames with the expected orientation.
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0014J\b\u0010\f\u001a\u00020\u000bH\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lorg/tensorflow/lite/examples/styletransfer/camera/OrientationLiveData;", "Landroidx/lifecycle/LiveData;", "", "context", "Landroid/content/Context;", "characteristics", "Landroid/hardware/camera2/CameraCharacteristics;", "(Landroid/content/Context;Landroid/hardware/camera2/CameraCharacteristics;)V", "listener", "Landroid/view/OrientationEventListener;", "onActive", "", "onInactive", "Companion", "app_debug"})
public final class OrientationLiveData extends androidx.lifecycle.LiveData<java.lang.Integer> {
    private final android.view.OrientationEventListener listener = null;
    public static final org.tensorflow.lite.examples.styletransfer.camera.OrientationLiveData.Companion Companion = null;
    
    @java.lang.Override()
    protected void onActive() {
    }
    
    @java.lang.Override()
    protected void onInactive() {
    }
    
    public OrientationLiveData(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.hardware.camera2.CameraCharacteristics characteristics) {
        super(null);
    }
    
    /**
     * Computes rotation required to transform from the camera sensor orientation to the
     * device's current orientation in degrees.
     *
     * @param characteristics the [CameraCharacteristics] to query for the sensor orientation.
     * @param surfaceRotation the current device orientation as a Surface constant
     * @return the relative rotation from the camera sensor to the current device orientation.
     */
    private static final int computeRelativeRotation(android.hardware.camera2.CameraCharacteristics characteristics, int surfaceRotation) {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0003\u00a8\u0006\b"}, d2 = {"Lorg/tensorflow/lite/examples/styletransfer/camera/OrientationLiveData$Companion;", "", "()V", "computeRelativeRotation", "", "characteristics", "Landroid/hardware/camera2/CameraCharacteristics;", "surfaceRotation", "app_debug"})
    public static final class Companion {
        
        /**
         * Computes rotation required to transform from the camera sensor orientation to the
         * device's current orientation in degrees.
         *
         * @param characteristics the [CameraCharacteristics] to query for the sensor orientation.
         * @param surfaceRotation the current device orientation as a Surface constant
         * @return the relative rotation from the camera sensor to the current device orientation.
         */
        private final int computeRelativeRotation(android.hardware.camera2.CameraCharacteristics characteristics, int surfaceRotation) {
            return 0;
        }
        
        private Companion() {
            super();
        }
    }
}