package org.tensorflow.lite.examples.styletransfer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 -2\u00020\u0001:\u0001-B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J\u0006\u0010(\u001a\u00020%J\u0006\u0010)\u001a\u00020%J\u0006\u0010*\u001a\u00020%J\u0006\u0010+\u001a\u00020,R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u0006."}, d2 = {"Lorg/tensorflow/lite/examples/styletransfer/SignupActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "_addressText", "Landroid/widget/EditText;", "get_addressText", "()Landroid/widget/EditText;", "set_addressText", "(Landroid/widget/EditText;)V", "_emailText", "get_emailText", "set_emailText", "_loginLink", "Landroid/widget/TextView;", "get_loginLink", "()Landroid/widget/TextView;", "set_loginLink", "(Landroid/widget/TextView;)V", "_mobileText", "get_mobileText", "set_mobileText", "_nameText", "get_nameText", "set_nameText", "_passwordText", "get_passwordText", "set_passwordText", "_reEnterPasswordText", "get_reEnterPasswordText", "set_reEnterPasswordText", "_signupButton", "Landroid/widget/Button;", "get_signupButton", "()Landroid/widget/Button;", "set_signupButton", "(Landroid/widget/Button;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onSignupFailed", "onSignupSuccess", "signup", "validate", "", "Companion", "app_debug"})
public final class SignupActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.Nullable()
    private android.widget.EditText _nameText;
    @org.jetbrains.annotations.Nullable()
    private android.widget.EditText _addressText;
    @org.jetbrains.annotations.Nullable()
    private android.widget.EditText _emailText;
    @org.jetbrains.annotations.Nullable()
    private android.widget.EditText _mobileText;
    @org.jetbrains.annotations.Nullable()
    private android.widget.EditText _passwordText;
    @org.jetbrains.annotations.Nullable()
    private android.widget.EditText _reEnterPasswordText;
    @org.jetbrains.annotations.Nullable()
    private android.widget.Button _signupButton;
    @org.jetbrains.annotations.Nullable()
    private android.widget.TextView _loginLink;
    private static final java.lang.String TAG = "SignupActivity";
    public static final org.tensorflow.lite.examples.styletransfer.SignupActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.EditText get_nameText() {
        return null;
    }
    
    public final void set_nameText(@org.jetbrains.annotations.Nullable()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.EditText get_addressText() {
        return null;
    }
    
    public final void set_addressText(@org.jetbrains.annotations.Nullable()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.EditText get_emailText() {
        return null;
    }
    
    public final void set_emailText(@org.jetbrains.annotations.Nullable()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.EditText get_mobileText() {
        return null;
    }
    
    public final void set_mobileText(@org.jetbrains.annotations.Nullable()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.EditText get_passwordText() {
        return null;
    }
    
    public final void set_passwordText(@org.jetbrains.annotations.Nullable()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.EditText get_reEnterPasswordText() {
        return null;
    }
    
    public final void set_reEnterPasswordText(@org.jetbrains.annotations.Nullable()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.Button get_signupButton() {
        return null;
    }
    
    public final void set_signupButton(@org.jetbrains.annotations.Nullable()
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.TextView get_loginLink() {
        return null;
    }
    
    public final void set_loginLink(@org.jetbrains.annotations.Nullable()
    android.widget.TextView p0) {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void signup() {
    }
    
    public final void onSignupSuccess() {
    }
    
    public final void onSignupFailed() {
    }
    
    public final boolean validate() {
        return false;
    }
    
    public SignupActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lorg/tensorflow/lite/examples/styletransfer/SignupActivity$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}