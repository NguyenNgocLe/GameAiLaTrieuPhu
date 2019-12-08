package com.example.ailatrieuphu.PresenterImp;

import com.example.ailatrieuphu.Model.LoginModel;
import com.example.ailatrieuphu.Controller.LoginView;

public class LoginPresenterImp implements LoginPresenter, LoginView {

    LoginView loginView;

    private LoginModel model;
    private LoginView view;

    public LoginPresenterImp(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onButtonSignInClick() {
        view.showToast("name: " + model.getCurrentName() + "\npass: " + model.getCurrentPassword());
    }

    @Override
    public void onButtonSignUpClick() {
        model.setCurrentName(view.getTextName());
        model.setCurrentPassword(view.getPassword());
        view.showButtonForgot();
    }

    @Override
    public void onButtonForgotClick() {

    }

    @Override
    public void checkUserLogin(String userName, String password) {
        if (userName.isEmpty() || password.isEmpty()) {
            loginView.showAccountFailed();
        } else {
            loginView.loginFailed();
        }
    }

    @Override
    public boolean checkTextViewUserNameLogin() {
        if (!view.getTextName().equals("")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkTextViewPasswordLogin() {
        if (!view.getPassword().equals("")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onTextViewFacebookSignInClick() {

    }

    @Override
    public void onTextViewGoogleSignInClick() {

    }

    @Override
    public void showButtonForgot() {

    }

    @Override
    public void hideButtonForgot() {

    }

    @Override
    public void showToast(String text) {

    }

    @Override
    public String getTextName() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void handlingLogin() {

    }

    @Override
    public void showAccountFailed() {

    }

    @Override
    public void loginSuccess() {

    }

    @Override
    public void loginFailed() {

    }
}
