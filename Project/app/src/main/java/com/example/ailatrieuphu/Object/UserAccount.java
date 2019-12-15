package com.example.ailatrieuphu.Object;

import org.json.JSONException;
import org.json.JSONObject;

public class UserAccount {
    private String userName, passWord, email, avatar;
    private int credit, id, score;
    private String delete;

    public UserAccount() {

    }

    public UserAccount(JSONObject jsonObject) {
        try {
            this.id = jsonObject.getInt("id");
            this.userName = jsonObject.getString("ten_dang_nhap");
//            this.passWord = jsonObject.getString("password");
            this.email = jsonObject.getString("email");
            this.avatar = jsonObject.getString("hinh_dai_dien");
            this.score = jsonObject.getInt("diem_cao_nhat");
            this.credit = jsonObject.getInt("credit");
            this.delete = jsonObject.getString("deleted_at");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public UserAccount(String userName, String passWord, String email, String avatar, int score, int credit, int id, int highedScore, String delete) {
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.avatar = avatar;
        this.score = score;
        this.credit = credit;
        this.id = id;
        this.score = highedScore;
        this.delete = delete;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String isDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }
}