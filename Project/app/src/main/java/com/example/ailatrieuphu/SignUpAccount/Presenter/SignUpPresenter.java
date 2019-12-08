package com.example.ailatrieuphu.SignUpAccount.Presenter;

import com.example.ailatrieuphu.SignUpAccount.Model.UserAccount;

public interface SignUpPresenter {
    void onButtonSignUpClick();
    void checkDataSignUpAndSync(UserAccount userAccount);
}
