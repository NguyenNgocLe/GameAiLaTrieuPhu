package com.example.ailatrieuphu.Model;

import android.content.Context;
import android.util.Log;

import com.example.ailatrieuphu.Utilities.Api.apiAsyncTask;
import com.example.ailatrieuphu.Utilities.Dialog.CustomDialog;
import com.example.ailatrieuphu.Object.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignUpModel {

    //dang ky
    public static void addSignUpAccount(Context context, User nguoi_dung) {
        Map<String, String> paramets = new HashMap<>();
        paramets.put("ten_dang_nhap", nguoi_dung.getUsername());
        paramets.put("email", nguoi_dung.getEmail());
        paramets.put("mat_khau", nguoi_dung.getPassword());

        //lấy api gọi hàm xử lý đưa dữ liệu lên để đăng ký tài khoản
        Log.d("api", paramets + "");
        apiAsyncTask apiAsyncTask_call_api = new apiAsyncTask(context, "POST", paramets, "Đăng ký", "Chờ xíu nha...") {

            @Override
            public void xuLy(Context context, String json) {
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    if (jsonObject.getBoolean("success")) {
                        new CustomDialog(context, "Thông báo", "Đăng ký thành công!", "OK", CustomDialog.SIZE_M).show();
                    } else {
                        new CustomDialog(context, "Thông báo", "Đăng ký thất bại!", "OK", CustomDialog.SIZE_M).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        apiAsyncTask_call_api.execute("nguoi-choi/dang-ky");
    }
}
