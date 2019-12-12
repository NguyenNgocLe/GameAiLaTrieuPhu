package com.example.ailatrieuphu.Model;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.ailatrieuphu.Object.User;
import com.example.ailatrieuphu.Utilities.Api.apiAsyncTask;
import com.example.ailatrieuphu.Utilities.Dialog.CustomDialog;

import org.json.JSONException;
import org.json.JSONObject;
import android.content.Context;
import android.content.Intent;

import java.util.HashMap;
import java.util.Map;

public class ManageModel {
        // dang làm tới đây chưa đưa tên đăng nhập vào màn hình đăng nhập được để cập nhật các trường dữ liệu ở dưới trừ cái tên đăng nhập ra
    public static void updateAccount(Context context, User nguoi_dung) {
        Map<String, String> parametes = new HashMap<>();
        parametes.put("ten_dang_nhap", nguoi_dung.getUsername());
        parametes.put("email", nguoi_dung.getEmail());
        parametes.put("mat_khau", nguoi_dung.getPassword());
        //

        apiAsyncTask apiAsyncTask_call_api = new apiAsyncTask(context, "POST", parametes, "Cập nhật tài khoản", "Chờ xíu nha...") {
            @Override
            public void xuLy(Context context, String json) {
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    if (jsonObject.getBoolean("success")) {
                        Log.d("vo1", "vo thanh cong chua");
                        new CustomDialog(context, "Thông báo", "Cập nhật thành công!", "OK", CustomDialog.SIZE_M).show();
                    } else {
                        Log.d("vo2", "vo that bai chua");
                        new CustomDialog(context, "Thông báo", "Cập nhật thất bại!", "OK", CustomDialog.SIZE_M).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        apiAsyncTask_call_api.execute("nguoi-choi/cap-nhat");
    }
}
