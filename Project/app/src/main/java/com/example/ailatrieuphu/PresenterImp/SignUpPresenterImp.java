package com.example.ailatrieuphu.PresenterImp;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.example.ailatrieuphu.Utilities.Dialog.CustomDialog;
import com.example.ailatrieuphu.Model.SignUpModel;
import com.example.ailatrieuphu.Object.User;

public class SignUpPresenterImp  {



    public static void onButtonSignUpClick(Context context, User nguoi_dung) {
        checkDataSignUpAndSync(context, nguoi_dung);
    }


    public static void checkDataSignUpAndSync(Context context,User nguoi_dung) {
        if (nguoi_dung.isEmpty() || !(nguoi_dung.getPassword().equals(nguoi_dung.getPrePassword()))) {
            new CustomDialog(context, "Thông báo", "Dữ liệu không hợp lệ!", "OK", CustomDialog.SIZE_M).show();
        } else {
            Log.d("object", nguoi_dung.toString());
            SignUpModel.addSignUpAccount(context ,nguoi_dung);
            ((Activity)context).finish(); // tắt màn hình hiện tại và chuyển qua màn hình login
        }
    }

}
