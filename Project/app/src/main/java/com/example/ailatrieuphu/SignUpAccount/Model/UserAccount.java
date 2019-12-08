package com.example.ailatrieuphu.SignUpAccount.Model;

public class UserAccount {
    private String userName;
    private String email;
    private String password;
    private String prePassword;
    private String pathImage;

    public UserAccount() {

    }

    public UserAccount(String userName, String email, String password, String prePassword, String pathImage) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.prePassword = prePassword;
        this.pathImage = pathImage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrePassword() {
        return prePassword;
    }

    public void setPrePassword(String prePassword) {
        this.prePassword = prePassword;
    }

    public boolean empty() {
        return (userName.equals("") || email.equals("") || password.equals("") || prePassword.equals(""));
    }

    public boolean isConfirmPassCorrect(String prePassword, String password) {
        return password.equals(prePassword.trim());
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }
}
