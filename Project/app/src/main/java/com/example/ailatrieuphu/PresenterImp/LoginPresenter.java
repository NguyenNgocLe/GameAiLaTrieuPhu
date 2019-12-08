package com.example.ailatrieuphu.PresenterImp;

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
