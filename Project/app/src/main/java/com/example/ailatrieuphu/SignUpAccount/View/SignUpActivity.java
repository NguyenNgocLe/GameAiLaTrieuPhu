package com.example.ailatrieuphu.SignUpAccount.View;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ailatrieuphu.R;

public class SignUpActivity extends AppCompatActivity implements SignUpView, View.OnClickListener {

    EditText edtUserNameLogin, edtEmail, edtPassword, edtPrePassword;
    private String messengerToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_account);
        intView();
        showButtonSignUpClick();
        // dang lam do dang
        
    }

    private void intView() {
        edtUserNameLogin = findViewById(R.id.edtUserNameSignUp);
        edtEmail = findViewById(R.id.edtEmailSignUp);
        edtPassword = findViewById(R.id.edtPasswordSignUp);
        edtPrePassword = findViewById(R.id.edtConfirmPasswordSignUp);
    }

    @Override
    public void showButtonSignUpClick() {
        if (edtUserNameLogin.equals("")) {
            messengerToast = "Tên đăng nhập không được để trống! \n";
            showToast(messengerToast);
        } else if (edtEmail.equals("")) {
            messengerToast = "Email không được để trống! \n";
        } else if (edtPassword.equals("")) {
            messengerToast = "Password không được để trống! \n";
        } else if (edtPrePassword.equals("")) {
            messengerToast = "Xác nhận mật khẩu không được để trống! \n";
        } else if (checkDataSignUp()) {
            messengerToast = "Mật khẩu bạn nhập không khớp với xác nhận mật khẩu! \n";
        }
        showToast(messengerToast);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnSignUpAccount: {
                if (id == 1) {
                    messengerToast = "Đăng ký thành công!";
                    showToast(messengerToast);
                } else {
                    messengerToast = "Đăng ký thất bại!";
                    showToast(messengerToast);
                }
                break;
            }
        }
    }

    @Override
    public boolean checkDataSignUp() {
        if (edtPassword.equals(edtPrePassword.getText().toString()))
            return true;
        else
            return false;
    }

    @Override
    public void showToast(String messengerToast) {
        Toast.makeText(SignUpActivity.this, messengerToast, Toast.LENGTH_SHORT).show();
    }
}
