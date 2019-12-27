package com.example.ailatrieuphu.Model;

public class ForgotModel {
    private String userName;
    private String Email;

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
