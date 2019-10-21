package com.example.ailatrieuphu.LoginScreen.View;

public interface LoginView {
    void showButtonSignin();
    void showButtonSignup();
    void showButtonForgot();
    void hideButtonSignin();
    void hideButtonSignup();
    void hideButtonForgot();
    void showToast(String text);
    String getTextName();
    String getPassword();
}
