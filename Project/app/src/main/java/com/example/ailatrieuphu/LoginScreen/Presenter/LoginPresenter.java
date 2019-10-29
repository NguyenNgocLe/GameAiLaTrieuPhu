package com.example.ailatrieuphu.LoginScreen.Presenter;

public interface LoginPresenter {
    void onButtonSignInClick();
    void onButtonSignUpClick();
    void onButtonForgotClick();
    boolean checkTextViewUserNameLogin();
    boolean checkTextViewPasswordLogin();
    void onTextViewFacebookSignInClick();
    void onTextViewGoogleSignInClick();
}
