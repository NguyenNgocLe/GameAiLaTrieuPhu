package com.example.ailatrieuphu.Object;

public class User {
    private String username;
    private String email;
    private String password;
    private String prePassword;

    public User() {

    }

    public boolean isEmpty() {
        return (username.equals("") || email.equals("") || password.equals("") || prePassword.equals(""));
    }

    public User(String username, String email, String password, String prePassword) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.prePassword = prePassword;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
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
}
