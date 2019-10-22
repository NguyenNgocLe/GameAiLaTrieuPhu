package com.example.ailatrieuphu.SignUpAccount.Model;

import android.widget.Button;

public class SignupModel {
    private String nameLogin, EmailLogin, Password, cofirmPassword;
    private Button Signup;

    public SignupModel(){

    }

    public SignupModel(String nameLogin, String emailLogin, String password, String cofirmPassword, Button signup) {
        this.nameLogin = nameLogin;
        EmailLogin = emailLogin;
        Password = password;
        this.cofirmPassword = cofirmPassword;
        Signup = signup;
    }

    public String getNameLogin() {
        return nameLogin;
    }

    public void setNameLogin(String nameLogin) {
        this.nameLogin = nameLogin;
    }

    public String getEmailLogin() {
        return EmailLogin;
    }

    public void setEmailLogin(String emailLogin) {
        EmailLogin = emailLogin;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getCofirmPassword() {
        return cofirmPassword;
    }

    public void setCofirmPassword(String cofirmPassword) {
        this.cofirmPassword = cofirmPassword;
    }

    public Button getSignup() {
        return Signup;
    }

    public void setSignup(Button signup) {
        Signup = signup;
    }
}
