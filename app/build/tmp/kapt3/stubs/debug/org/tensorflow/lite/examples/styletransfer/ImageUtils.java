package org.tensorflow.lite.examples.styletransfer;

import java.lang.System;

/**
 * Collection of image reading and manipulation utilities in the form of static functions.
 * TODO: this class should be moved to the common code in the future
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b&\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lorg/tensorflow/lite/examples/styletransfer/ImageUtils;", "", "()V", "Companion", "app_debug"})
public abstract class ImageUtils {
    public static final org.tensorflow.lite.examples.styletransfer.ImageUtils.Companion Companion = null;
    
    public ImageUtils() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bJ\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010J5\u0010\u0011\u001a\u00020\u00062\u0018\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00130\u00132\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b\u00a2\u0006\u0002\u0010\u0017J \u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\bJ\u000e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\bH\u0002J\u0016\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u001e\u0010&\u001a\u00020\u00062\u0006\u0010\'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\bJ\u0016\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020%\u00a8\u0006."}, d2 = {"Lorg/tensorflow/lite/examples/styletransfer/ImageUtils$Companion;", "", "()V", "bitmapToByteBuffer", "Ljava/nio/ByteBuffer;", "bitmapIn", "Landroid/graphics/Bitmap;", "width", "", "height", "mean", "", "std", "computeExifOrientation", "rotationDegrees", "mirrored", "", "convertArrayToBitmap", "imageArray", "", "", "imageWidth", "imageHeight", "([[[[FII)Landroid/graphics/Bitmap;", "createEmptyBitmap", "imageHeigth", "color", "decodeBitmap", "file", "Ljava/io/File;", "decodeExifOrientation", "Landroid/graphics/Matrix;", "orientation", "loadBitmapFromResources", "context", "Landroid/content/Context;", "path", "", "scaleBitmapAndKeepRatio", "targetBmp", "reqHeightInPixels", "reqWidthInPixels", "setExifOrientation", "", "filePath", "value", "app_debug"})
    public static final class Companion {
        
        /**
         * Helper function used to convert an EXIF orientation enum into a transformation matrix
         * that can be applied to a bitmap.
         *
         * @param orientation - One of the constants from [ExifInterface]
         */
        private final android.graphics.Matrix decodeExifOrientation(int orientation) {
            return null;
        }
        
        /**
         * sets the Exif orientation of an image.
         * this method is used to fix the exit of pictures taken by the camera
         *
         * @param filePath - The image file to change
         * @param value - the orientation of the file
         */
        public final void setExifOrientation(@org.jetbrains.annotations.NotNull()
        java.lang.String filePath, @org.jetbrains.annotations.NotNull()
        java.lang.String value) {
        }
        
        /**
         * Transforms rotation and mirroring information into one of the [ExifInterface] constants
         */
        public final int computeExifOrientation(int rotationDegrees, boolean mirrored) {
            return 0;
        }
        
        /**
         * Decode a bitmap from a file and apply the transformations described in its EXIF data
         *
         * @param file - The image file to be read using [BitmapFactory.decodeFile]
         */
        @org.jetbrains.annotations.NotNull()
        public final android.graphics.Bitmap decodeBitmap(@org.jetbrains.annotations.NotNull()
        java.io.File file) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.graphics.Bitmap scaleBitmapAndKeepRatio(@org.jetbrains.annotations.NotNull()
        android.graphics.Bitmap targetBmp, int reqHeightInPixels, int reqWidthInPixels) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.nio.ByteBuffer bitmapToByteBuffer(@org.jetbrains.annotations.NotNull()
        android.graphics.Bitmap bitmapIn, int width, int height, float mean, float std) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.graphics.Bitmap createEmptyBitmap(int imageWidth, int imageHeigth, int color) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.graphics.Bitmap loadBitmapFromResources(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        java.lang.String path) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.graphics.Bitmap convertArrayToBitmap(@org.jetbrains.annotations.NotNull()
        float[][][][] imageArray, int imageWidth, int imageHeight) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}