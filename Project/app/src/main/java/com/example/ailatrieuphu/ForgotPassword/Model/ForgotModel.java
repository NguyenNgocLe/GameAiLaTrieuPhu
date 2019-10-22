package com.example.ailatrieuphu.ForgotPassword.Model;

import android.widget.Button;

public class ForgotModel {
    private String userName;
    private String Email;
    private Button btn; // dang lam do dang
    public ForgotModel(){

    }
    public ForgotModel(String userName, String email) {
        this.userName = userName;
        Email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
