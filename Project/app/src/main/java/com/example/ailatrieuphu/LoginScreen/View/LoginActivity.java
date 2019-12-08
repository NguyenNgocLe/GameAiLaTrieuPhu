package com.example.ailatrieuphu.LoginScreen.View;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ailatrieuphu.Dialog.CustomDialog;
import com.example.ailatrieuphu.LoginScreen.Presenter.LoginPresenterImp;
import com.example.ailatrieuphu.MainActivity.View.MainActivity;
import com.example.ailatrieuphu.R;
import com.example.ailatrieuphu.SignUpAccount.View.SignUpActivity;
import com.example.ailatrieuphu.Api.apiAsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private Button buttonForgot, buttonSignIn, buttonSignUp;
    private LoginPresenterImp loginPresenterImp;
    private TextView textViewUserName, textViewPassword, textViewFacebook, textViewGoogle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_account);
        initView();
        loginPresenterImp = new LoginPresenterImp(this);
        buttonForgot.setOnClickListener(this);
        buttonSignIn.setOnClickListener(this);
        buttonSignUp.setOnClickListener(this);
        textViewUserName.setOnClickListener(this);
        textViewPassword.setOnClickListener(this);
        //textViewFacebook.setOnClickListener(this);
        //textViewGoogle.setOnClickListener(this);
    }

    private void initView() {
        buttonForgot = findViewById(R.id.btnForgotPassword);
        buttonSignIn = findViewById(R.id.btnSignIn);
        buttonSignUp = findViewById(R.id.btnSignUp);
        textViewUserName = findViewById(R.id.txtUserName);
        textViewPassword = findViewById(R.id.txtPassword);
    }

    @Override
    public void showButtonForgot() {
        buttonForgot.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideButtonForgot() {
        buttonForgot.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getTextName() {
        return textViewUserName.getText().toString();
    }

    @Override
    public String getPassword() {
        return textViewPassword.getText().toString();
    }

    @Override
    public void handlingLogin() {

        String userName = textViewUserName.getText().toString().trim();
        String password = textViewPassword.getText().toString().trim();
        // kiểm tra tên đăng nhập và mật khẩu có trống hay không
        loginPresenterImp.checkUserLogin(userName, password);

        Map<String, String> paramets = new HashMap<>();
        paramets.put("ten_dang_nhap", userName);
        paramets.put("mat_khau", password);

        // lấy api gọi hàm progressbar
        @SuppressLint("StaticFieldLeak") apiAsyncTask apiAsyncTask_call_api = new apiAsyncTask(this, "POST", paramets, "Đăng nhập", "Chờ chút nha...") {
            @Override
            public void xuLy(Context context, String json) {

                try {
                    JSONObject jsonObject = new JSONObject(json);
                    //Log.d("json",json);
                    Intent intent = new Intent(context, MainActivity.class);
                    // gửi dữ liệu của người dùng qua màn hình activity khác bằng string (vì api là json cần phải chuyển sang string
                    // mới nhận được dữ liệu
                    intent.putExtra("nguoi_dung", jsonObject.getJSONObject("data").toString());
                    startActivity(intent);
                    //Log.d("abc", jsonObject.getJSONObject("data").toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        apiAsyncTask_call_api.execute("nguoi-choi/kiem-tra-dang-nhap");
    }

    public void handlingSignUp() {
        // class login gọi đến class signUp
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    @Override
    public void showAccountFailed() {
        new CustomDialog(this, "Thông báo!", "Tên đăng nhập hoặc mật khẩu không được trống!", "Thoát", CustomDialog.SIZE_M).show();
        Toast.makeText(this, "user name or password is not null!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        new CustomDialog(this, "Thông báo!", "Đăng nhập thành công!", "OK", CustomDialog.SIZE_M).show();
        Toast.makeText(this, "Login success!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailed() {
        new CustomDialog(this, "Thông báo ", "Đăng nhập thất bại!", "Thoát", CustomDialog.SIZE_M).show();
        //Toast.makeText(this, "Đăng nhập thất bại!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnSignIn: {
                handlingLogin();
                break;
            }
            case R.id.btnForgotPassword: {
                loginPresenterImp.onButtonForgotClick();
                break;
            }
            case R.id.btnSignUp: {
                handlingSignUp();
                break;
            }
            default: {
                break;
            }
        }
    }

    public void btnLogin(View view) {
        // nhảy vào case để khi người dùng nhập tên đăng nhập và mật khẩu thì sẽ login vào hệ thống khi nhấn
        // button đăng nhập
    }

    public void btnSignUp(View view) {
    }
}
