package org.tensorflow.lite.examples.styletransfer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 )2\u00020\u0001:\u0001)B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u001dH\u0016J\u0012\u0010\u001f\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0006\u0010\"\u001a\u00020\u001dJ\u0006\u0010#\u001a\u00020\u001dJ\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020\'R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006*"}, d2 = {"Lorg/tensorflow/lite/examples/styletransfer/LoginActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "EMAIL_ADDRESS_PATTERN", "Ljava/util/regex/Pattern;", "getEMAIL_ADDRESS_PATTERN", "()Ljava/util/regex/Pattern;", "_emailText", "Landroid/widget/EditText;", "get_emailText", "()Landroid/widget/EditText;", "set_emailText", "(Landroid/widget/EditText;)V", "_loginButton", "Landroid/widget/Button;", "get_loginButton", "()Landroid/widget/Button;", "set_loginButton", "(Landroid/widget/Button;)V", "_passwordText", "get_passwordText", "set_passwordText", "_signupLink", "Landroid/widget/TextView;", "get_signupLink", "()Landroid/widget/TextView;", "set_signupLink", "(Landroid/widget/TextView;)V", "login", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onLoginFailed", "onLoginSuccess", "validate", "", "email", "", "password", "Companion", "app_debug"})
public final class LoginActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.Nullable()
    private android.widget.EditText _emailText;
    @org.jetbrains.annotations.Nullable()
    private android.widget.EditText _passwordText;
    @org.jetbrains.annotations.Nullable()
    private android.widget.Button _loginButton;
    @org.jetbrains.annotations.Nullable()
    private android.widget.TextView _signupLink;
    @org.jetbrains.annotations.NotNull()
    private final java.util.regex.Pattern EMAIL_ADDRESS_PATTERN = null;
    private static final java.lang.String TAG = "LoginActivity";
    public static final org.tensorflow.lite.examples.styletransfer.LoginActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.EditText get_emailText() {
        return null;
    }
    
    public final void set_emailText(@org.jetbrains.annotations.Nullable()
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
    public final android.widget.Button get_loginButton() {
        return null;
    }
    
    public final void set_loginButton(@org.jetbrains.annotations.Nullable()
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.TextView get_signupLink() {
        return null;
    }
    
    public final void set_signupLink(@org.jetbrains.annotations.Nullable()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.regex.Pattern getEMAIL_ADDRESS_PATTERN() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void login() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    public final void onLoginSuccess() {
    }
    
    public final void onLoginFailed() {
    }
    
    public final boolean validate(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
        return false;
    }
    
    public LoginActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lorg/tensorflow/lite/examples/styletransfer/LoginActivity$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}