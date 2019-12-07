package com.example.ailatrieuphu.LoginScreen.Presenter;

public interface LoginPresenter {
    void onButtonSignInClick();
    void onButtonSignUpClick();
    void onButtonForgotClick();
    void checkUserLogin(String userName, String password);
    boolean checkTextViewUserNameLogin();
    boolean checkTextViewPasswordLogin();
    void onTextViewFacebookSignInClick();
    void onTextViewGoogleSignInClick();
}
