package com.example.ailatrieuphu.LoginScreen.View;

public interface LoginView {
    void showButtonSignIn();
    void showButtonSignUp();
    void showButtonForgot();
    void hideButtonSignIn();
    void hideButtonSignUp();
    void hideButtonForgot();
    void showToast(String text);
    String getTextName();
    String getPassword();
}
