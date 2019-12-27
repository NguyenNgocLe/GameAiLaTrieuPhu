package com.example.ailatrieuphu.Object;

import org.json.JSONException;
import org.json.JSONObject;

public class User {
    private int id;
    private int score;
    private int credit;
    private String username;
    private String email;
    private String password;
    private String prePassword;
    private String avatar;
    private String delete;

    public User() {

    }

    public User(JSONObject jsonObject) {
        try {
            this.id = jsonObject.getInt("id");
            this.username = jsonObject.getString("ten_dang_nhap");
            this.email = jsonObject.getString("email");
            this.avatar = jsonObject.getString("hinh_dai_dien");
            this.score = jsonObject.getInt("diem_cao_nhat");
            this.credit = jsonObject.getInt("credit");
            this.delete = jsonObject.getString("deleted_at");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public boolean isEmpty() {
        return (username.equals("") || email.equals("") || password.equals("") || prePassword.equals(""));
    }

    public boolean isUpdateEmpty() {
        return (username.equals("") || email.equals("") || password.equals("") || prePassword.equals(""));
    }

    public User(String username, String email, String password, String prePassword) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.prePassword = prePassword;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
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
