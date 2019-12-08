package com.example.ailatrieuphu.SignUpAccount.Presenter;

import android.content.Context;
import android.util.Log;

import com.example.ailatrieuphu.SignUpAccount.Model.SignUpModel;
import com.example.ailatrieuphu.SignUpAccount.Model.UserAccount;
import com.example.ailatrieuphu.SignUpAccount.View.SignUpView;

public class SignUpPresenterImp implements SignUpPresenter {
    private SignUpModel model;
    private SignUpView signUpView;
    private Context context;

    public SignUpPresenterImp(Context context, SignUpView signUpView) {
        this.signUpView = signUpView;
        model = new SignUpModel(context);
        this.context = context;
    }

    @Override
    public void onButtonSignUpClick() {
        // lấy dữ liệu người dùng nhập vào
        String userName = signUpView.getEdtUserNameLoginText();
        String email = signUpView.getEdtEmailLoginText();
        String password = signUpView.getPasswordLoginText();
        String prePassword = signUpView.getPrePassWordLoginText();
        model.setCurrentUser(userName, email, password, prePassword);
        checkDataSignUpAndSync(model.getCurrentUser());
    }

    @Override
    public void checkDataSignUpAndSync(UserAccount userAccount) {
        //Log.d("object", userAccount.toString());
        if (userAccount.empty() || !(userAccount.getPassword().equals(userAccount.getPrePassword()))) {
            signUpView.signUpFailed();
        } else {
            Log.d("dangky", "thanh cong");
            signUpView.signUpSuccess();
            model.addSignUpAccount(context);
        }
    }

}
