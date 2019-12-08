package com.example.ailatrieuphu.Controller;

public interface LoginView {
    void showButtonForgot();
    void hideButtonForgot();
    void showToast(String text);
    String getTextName();
    String getPassword();
    void handlingLogin();
    void showAccountFailed();
    void loginSuccess();
    void loginFailed();
}
