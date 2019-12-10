package com.example.ailatrieuphu.UserAccount;

public class UserAccount {
    private String userName, passWord, email, avatar;
    private int score, credit, id, highedScore;
    private boolean delete;

    public UserAccount(){

    }

    public UserAccount(String userName, String passWord, String email, String avatar, int score, int credit, int id, int highedScore, boolean delete) {
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.avatar = avatar;
        this.score = score;
        this.credit = credit;
        this.id = id;
        this.highedScore = highedScore;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHighedScore() {
        return highedScore;
    }

    public void setHighedScore(int highedScore) {
        this.highedScore = highedScore;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }
}