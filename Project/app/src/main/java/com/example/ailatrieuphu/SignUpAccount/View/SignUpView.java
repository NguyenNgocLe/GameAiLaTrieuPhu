package com.example.ailatrieuphu.SignUpAccount.View;

public interface SignUpView {
    void showButtonSignUpClick();
    boolean checkDataSignUp();
    void showToast(String messenger);
    void signUpSuccess();
    void signUpFailed();
    void prePasswordDoesNotMatch();
    String getEdtUserNameLoginText();
    String getEdtEmailLoginText();
    String getPasswordLoginText();
    String getPrePassWordLoginText();
    String getPathImageLoginText();
    void setEdtUsernameLogin(String s);
}
