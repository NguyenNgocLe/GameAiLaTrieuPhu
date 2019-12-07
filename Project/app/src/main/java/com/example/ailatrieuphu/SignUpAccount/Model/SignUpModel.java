package com.example.ailatrieuphu.SignUpAccount.Model;

public class SignUpModel /*implements ISignUp*/ {

    private String nameLogin, EmailLogin, Password, conFirmPassword;

    public SignUpModel() {

    }

    public SignUpModel(String nameLogin, String emailLogin, String password, String conFirmPassword) {
        this.nameLogin = nameLogin;
        EmailLogin = emailLogin;
        Password = password;
        this.conFirmPassword = conFirmPassword;
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
        return conFirmPassword;
    }

    public void setCofirmPassword(String conFirmPassword) {
        this.conFirmPassword = conFirmPassword;
    }

    // @Override
//    public void AddSignUpAccount() {
//        new apiAsyncTask(this, NetworkUtils.GET, null){
//            @Override
//            public void xuly(Context context, String json) {
//                // xu ly du lieu o day
//            }
//        }.execute("");
//    }
}
