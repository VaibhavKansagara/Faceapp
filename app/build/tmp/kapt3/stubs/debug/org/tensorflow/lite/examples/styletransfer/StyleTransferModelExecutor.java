package org.tensorflow.lite.examples.styletransfer;

import java.lang.System;

@java.lang.SuppressWarnings(value = {"GoodTime"})
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0014\u001a\u00020\u0015J\u001e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u0003J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\"\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u0005H\u0002J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0019H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lorg/tensorflow/lite/examples/styletransfer/StyleTransferModelExecutor;", "", "context", "Landroid/content/Context;", "useGPU", "", "(Landroid/content/Context;Z)V", "fullExecutionTime", "", "gpuDelegate", "Lorg/tensorflow/lite/gpu/GpuDelegate;", "interpreterPredict", "Lorg/tensorflow/lite/Interpreter;", "interpreterTransform", "numberThreads", "", "postProcessTime", "preProcessTime", "stylePredictTime", "styleTransferTime", "close", "", "execute", "Lorg/tensorflow/lite/examples/styletransfer/ModelExecutionResult;", "contentImagePath", "", "styleImageName", "formatExecutionLog", "getInterpreter", "modelName", "useGpu", "loadModelFile", "Ljava/nio/MappedByteBuffer;", "modelFile", "Companion", "app_debug"})
public final class StyleTransferModelExecutor {
    private org.tensorflow.lite.gpu.GpuDelegate gpuDelegate;
    private int numberThreads;
    private final org.tensorflow.lite.Interpreter interpreterPredict = null;
    private final org.tensorflow.lite.Interpreter interpreterTransform = null;
    private long fullExecutionTime;
    private long preProcessTime;
    private long stylePredictTime;
    private long styleTransferTime;
    private long postProcessTime;
    private boolean useGPU;
    private static final java.lang.String TAG = "StyleTransferMExec";
    private static final int STYLE_IMAGE_SIZE = 256;
    private static final int CONTENT_IMAGE_SIZE = 384;
    private static final int BOTTLENECK_SIZE = 100;
    private static final java.lang.String STYLE_PREDICT_INT8_MODEL = "style_predict_quantized_256.tflite";
    private static final java.lang.String STYLE_TRANSFER_INT8_MODEL = "style_transfer_quantized_384.tflite";
    private static final java.lang.String STYLE_PREDICT_FLOAT16_MODEL = "style_predict_f16_256.tflite";
    private static final java.lang.String STYLE_TRANSFER_FLOAT16_MODEL = "style_transfer_f16_384.tflite";
    public static final org.tensorflow.lite.examples.styletransfer.StyleTransferModelExecutor.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final org.tensorflow.lite.examples.styletransfer.ModelExecutionResult execute(@org.jetbrains.annotations.NotNull()
    java.lang.String contentImagePath, @org.jetbrains.annotations.NotNull()
    java.lang.String styleImageName, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    private final java.nio.MappedByteBuffer loadModelFile(android.content.Context context, java.lang.String modelFile) throws java.io.IOException {
        return null;
    }
    
    private final org.tensorflow.lite.Interpreter getInterpreter(android.content.Context context, java.lang.String modelName, boolean useGpu) throws java.io.IOException {
        return null;
    }
    
    private final java.lang.String formatExecutionLog() {
        return null;
    }
    
    public final void close() {
    }
    
    public StyleTransferModelExecutor(@org.jetbrains.annotations.NotNull()
    android.content.Context context, boolean useGPU) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lorg/tensorflow/lite/examples/styletransfer/StyleTransferModelExecutor$Companion;", "", "()V", "BOTTLENECK_SIZE", "", "CONTENT_IMAGE_SIZE", "STYLE_IMAGE_SIZE", "STYLE_PREDICT_FLOAT16_MODEL", "", "STYLE_PREDICT_INT8_MODEL", "STYLE_TRANSFER_FLOAT16_MODEL", "STYLE_TRANSFER_INT8_MODEL", "TAG", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}