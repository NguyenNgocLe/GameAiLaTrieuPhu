package com.example.ailatrieuphu.LoginScreen.Presenter;

import com.example.ailatrieuphu.LoginScreen.Model.LoginModel;
import com.example.ailatrieuphu.LoginScreen.View.LoginView;

public class LoginPresenterImp implements LoginPresenter {

    private LoginModel model;
    private LoginView view;


    public LoginPresenterImp(LoginView view) {
        model = new LoginModel();
        this.view = view;
    }

    @Override
    public void onButtonSignInClick() {
        view.showToast("name: " + model.getCurrentName() + "\npass: " + model.getCurrentPassword());
        view.hideButtonForgot();
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
}
