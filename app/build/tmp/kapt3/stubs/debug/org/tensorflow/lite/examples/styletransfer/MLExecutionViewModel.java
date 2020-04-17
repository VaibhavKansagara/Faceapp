package org.tensorflow.lite.examples.styletransfer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J.\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lorg/tensorflow/lite/examples/styletransfer/MLExecutionViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_styledBitmap", "Landroidx/lifecycle/MutableLiveData;", "Lorg/tensorflow/lite/examples/styletransfer/ModelExecutionResult;", "styledBitmap", "Landroidx/lifecycle/LiveData;", "getStyledBitmap", "()Landroidx/lifecycle/LiveData;", "viewModelJob", "Lkotlinx/coroutines/Job;", "viewModelScope", "Lkotlinx/coroutines/CoroutineScope;", "onApplyStyle", "", "context", "Landroid/content/Context;", "contentFilePath", "", "styleFilePath", "styleTransferModelExecutor", "Lorg/tensorflow/lite/examples/styletransfer/StyleTransferModelExecutor;", "inferenceThread", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "app_debug"})
public final class MLExecutionViewModel extends androidx.lifecycle.ViewModel {
    private final androidx.lifecycle.MutableLiveData<org.tensorflow.lite.examples.styletransfer.ModelExecutionResult> _styledBitmap = null;
    private final kotlinx.coroutines.Job viewModelJob = null;
    private final kotlinx.coroutines.CoroutineScope viewModelScope = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<org.tensorflow.lite.examples.styletransfer.ModelExecutionResult> getStyledBitmap() {
        return null;
    }
    
    public final void onApplyStyle(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String contentFilePath, @org.jetbrains.annotations.NotNull()
    java.lang.String styleFilePath, @org.jetbrains.annotations.NotNull()
    org.tensorflow.lite.examples.styletransfer.StyleTransferModelExecutor styleTransferModelExecutor, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.ExecutorCoroutineDispatcher inferenceThread) {
    }
    
    public MLExecutionViewModel() {
        super();
    }
}