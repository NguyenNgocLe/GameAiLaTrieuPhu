package com.example.ailatrieuphu.SignUpAccount.Model;

import android.annotation.SuppressLint;
import android.content.Context;

import com.example.ailatrieuphu.SignUpAccount.View.SignUpActivity;
import com.example.ailatrieuphu.Api.apiAsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignUpModel {

    private UserAccount currentUser;
    private Context context;
    private SignUpActivity signUpActivity;

    public SignUpModel(Context context) {
        this.context = context;
        currentUser = new UserAccount();
        signUpActivity = new SignUpActivity();
    }

    public UserAccount getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String nameLogin, String emailLogin, String password, String conFirmPassword) {
        this.currentUser.setUserName(nameLogin);
        this.currentUser.setEmail(emailLogin);
        this.currentUser.setPassword(password);
        this.currentUser.setPrePassword(conFirmPassword);
    }

    public void addSignUpAccount(Context context) {
        Map<String, String> paramets = new HashMap<>();
        paramets.put("ten_dang_nhap", currentUser.getUserName());
        paramets.put("email", currentUser.getEmail());
        paramets.put("mat_khau", currentUser.getPassword());
        //paramets.put("hinh_dai_dien", currentUser.getPathImage());
        // lấy api gọi hàm xử lý đưa dữ liệu lên để đăng ký tài khoản
        @SuppressLint("StaticFieldLeak") apiAsyncTask apiAsyncTask_call_api = new apiAsyncTask(context, "POST", paramets, "Đăng ký", "Chờ xíu nha...") {

            @Override
            public void xuLy(Context context, String json) {
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    if (jsonObject.getBoolean("success")) {
                        signUpActivity.signUpSuccess();
                    } else {
                        signUpActivity.signUpFailed();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        apiAsyncTask_call_api.execute("nguoi-choi/dang-ky");
    }
}
