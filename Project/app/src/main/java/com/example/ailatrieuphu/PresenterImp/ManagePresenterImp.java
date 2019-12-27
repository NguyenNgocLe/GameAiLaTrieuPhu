package com.example.ailatrieuphu.PresenterImp;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.example.ailatrieuphu.Controller.ManageView;
import com.example.ailatrieuphu.Model.ManageModel;
import com.example.ailatrieuphu.Object.User;
import com.example.ailatrieuphu.Utilities.Dialog.CustomDialog;

public class ManagePresenterImp implements ManagePresenter {

    ManageView manageView;

    public ManagePresenterImp(ManageView manageView) {
        this.manageView = manageView;
    }

    @Override
    public boolean checkTextViewUserNameLogin(String email, String password, String prePassword) {
        if (!email.equals("") || password.equals("") || prePassword.equals("")) {
            return true;
        } else if (password.equals(prePassword)) {
            return true;
        }
        return false;
    }

    public static void onButtonUpdateAccountClick(Context context, User nguoi_dung) {
        checkDataUpdateAccount(context, nguoi_dung);
    }


    public static void checkDataUpdateAccount(Context context, User nguoi_dung) {
        if (nguoi_dung.isUpdateEmpty() || !(nguoi_dung.getPassword().equals(nguoi_dung.getPrePassword()))) {
            new CustomDialog(context, "Thông báo", "Dữ liệu không hợp lệ!", "OK", CustomDialog.SIZE_M).show();
        } else {
            Log.d("object", nguoi_dung.toString());
            ManageModel.updateAccount(context,nguoi_dung);
            ((Activity)context).finish(); // tắt màn hình hiện tại và chuyển qua màn hình login
        }
    }



}
