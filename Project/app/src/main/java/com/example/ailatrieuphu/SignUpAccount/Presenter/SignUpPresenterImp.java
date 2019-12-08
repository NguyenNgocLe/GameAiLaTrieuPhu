package com.example.ailatrieuphu.SignUpAccount.Presenter;

import android.content.Context;
import android.util.Log;

import com.example.ailatrieuphu.Dialog.CustomDialog;
import com.example.ailatrieuphu.SignUpAccount.Model.SignUpModel;
import com.example.ailatrieuphu.object.User;

public class SignUpPresenterImp  {



    public static void onButtonSignUpClick(Context context, User nguoi_dung) {
        checkDataSignUpAndSync(context, nguoi_dung);
    }


    public static void checkDataSignUpAndSync(Context context,User nguoi_dung) {
//        Log.d("password", nguoi_dung.getPassword());
//        Log.d("password", nguoi_dung.getPrePassword());
        if (nguoi_dung.isEmpty() || !(nguoi_dung.getPassword().equals(nguoi_dung.getPrePassword()))) {
//            Log.d("null",nguoi_dung.isEmpty() +"");
//            Log.d("passs",nguoi_dung.getPassword().equals(nguoi_dung.getPrePassword())+"");
            new CustomDialog(context, "Thông báo", "Dữ liệu không hợp lệ!", "OK", CustomDialog.SIZE_M).show();

        } else {
            Log.d("object", nguoi_dung.toString());
            SignUpModel.addSignUpAccount(context ,nguoi_dung);

        }
    }

}
