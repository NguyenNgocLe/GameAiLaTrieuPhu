package com.example.ailatrieuphu.LoginScreen.Presenter;

import com.example.ailatrieuphu.LoginScreen.Model.LoginModel;
import com.example.ailatrieuphu.LoginScreen.View.LoginView;

public class LoginPresenterImp implements LoginPresenter {

    private LoginModel model;
    private LoginView callback;


    public LoginPresenterImp(LoginView callback) {
        model = new LoginModel();
        this.callback = callback;
    }

    @Override
    public void onButtonSignInClick() {
        callback.showToast("name: " + model.getCurrentName()+"\npass: " + model.getCurrentPassword());
        callback.hideButtonForgot();
    }

    @Override
    public void onButtonSignUpClick() {
        model.setCurrentName(callback.getTextName());
        model.setCurrentPassword(callback.getPassword());
        callback.showButtonForgot();
    }

    @Override
    public void onButtonForgotClick() {

    }
}
