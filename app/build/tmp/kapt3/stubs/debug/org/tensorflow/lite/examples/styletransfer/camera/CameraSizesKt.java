package org.tensorflow.lite.examples.styletransfer.camera;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 2, d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006\u001aC\u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\t0\r2\u0006\u0010\u000e\u001a\u00020\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0002\u0010\u0011\u001a\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\b\"\u0011\u0010\u0000\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0016"}, d2 = {"SIZE_1080P", "Lorg/tensorflow/lite/examples/styletransfer/camera/SmartSize;", "getSIZE_1080P", "()Lorg/tensorflow/lite/examples/styletransfer/camera/SmartSize;", "getDisplaySmartSize", "display", "Landroid/view/Display;", "getPreviewOutputSize", "Landroid/util/Size;", "T", "characteristics", "Landroid/hardware/camera2/CameraCharacteristics;", "targetClass", "Ljava/lang/Class;", "aspectRatio", "format", "", "(Landroid/view/Display;Landroid/hardware/camera2/CameraCharacteristics;Ljava/lang/Class;Landroid/util/Size;Ljava/lang/Integer;)Landroid/util/Size;", "verifyAspectRatio", "", "width", "height", "app_debug"})
public final class CameraSizesKt {
    
    /**
     * Standard High Definition size for pictures and video
     */
    @org.jetbrains.annotations.NotNull()
    private static final org.tensorflow.lite.examples.styletransfer.camera.SmartSize SIZE_1080P = null;
    
    @org.jetbrains.annotations.NotNull()
    public static final org.tensorflow.lite.examples.styletransfer.camera.SmartSize getSIZE_1080P() {
        return null;
    }
    
    /**
     * Returns a [SmartSize] object for the given [Display]
     */
    @org.jetbrains.annotations.NotNull()
    public static final org.tensorflow.lite.examples.styletransfer.camera.SmartSize getDisplaySmartSize(@org.jetbrains.annotations.NotNull()
    android.view.Display display) {
        return null;
    }
    
    public static final boolean verifyAspectRatio(int width, int height, @org.jetbrains.annotations.NotNull()
    android.util.Size aspectRatio) {
        return false;
    }
    
    /**
     * Returns the largest available PREVIEW size. For more information, see:
     * https://d.android.com/reference/android/hardware/camera2/CameraDevice
     */
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object>android.util.Size getPreviewOutputSize(@org.jetbrains.annotations.NotNull()
    android.view.Display display, @org.jetbrains.annotations.NotNull()
    android.hardware.camera2.CameraCharacteristics characteristics, @org.jetbrains.annotations.NotNull()
    java.lang.Class<T> targetClass, @org.jetbrains.annotations.NotNull()
    android.util.Size aspectRatio, @org.jetbrains.annotations.Nullable()
    java.lang.Integer format) {
        return null;
    }
}