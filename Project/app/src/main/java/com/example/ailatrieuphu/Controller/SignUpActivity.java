package com.example.ailatrieuphu.Controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ailatrieuphu.Object.User;
import com.example.ailatrieuphu.PresenterImp.SignUpPresenterImp;
import com.example.ailatrieuphu.R;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnSignUp;
    private EditText edtUserNameLogin, edtEmail, edtPassword, edtPrePassword;
    ImageView edtPathImage;
    private User nguoi_dung;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_account);

        intView();
    }

    private void intView() {
        edtUserNameLogin = findViewById(R.id.edtUserNameSignUp);
        //Log.d("abc", edtUserNameLogin.toString());
        edtEmail = findViewById(R.id.edtEmailSignUp);
        edtPassword = findViewById(R.id.edtPasswordSignUp);
        edtPrePassword = findViewById(R.id.edtConfirmPasswordSignUp);
        edtPathImage = findViewById(R.id.imgSignUp);
        mBtnSignUp = findViewById(R.id.btnSignUpAccount);
        mBtnSignUp.setOnClickListener(this);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnSignUpAccount: {

                //set data
                nguoi_dung = new User();
                nguoi_dung.setUsername(edtUserNameLogin.getText().toString());
                nguoi_dung.setEmail(edtEmail.getText().toString());
                nguoi_dung.setPassword(edtPassword.getText().toString());
                nguoi_dung.setPrePassword(edtPrePassword.getText().toString());

                SignUpPresenterImp.onButtonSignUpClick(this, nguoi_dung);
                break;
            }
            default: {
                break;
            }
        }
    }

//
//    @Override
//    public void showButtonSignUpClick() {
//
//    }
//
//    @Override
//    public boolean checkDataSignUp() {
//        if (edtPassword.equals(edtPrePassword.getText().toString().trim()))
//            return true;
//        else
//            return false;
//    }
//
//    @Override
//    public void showToast(String messengerToast) {
//        Toast.makeText(SignUpActivity.this, messengerToast, Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public  void signUpSuccess() {
//        //new CustomDialog(this, "Thông báo", "Đăng ký thành công!", "OK", CustomDialog.SIZE_M).show();
//    }
//
//    @Override
//    public void signUpFailed() {
//       // Log.d("loioday","ccbskdfj");
//        new CustomDialog(this, "Thông báo", "Đăng ký thất bại!", "Cancel", CustomDialog.SIZE_M).show();
//    }
//
//    @Override
//    public void prePasswordDoesNotMatch() {
//        new CustomDialog(this, "Thông báo", "Mật khẩu không trùng khớp", "Thoát", CustomDialog.SIZE_M).show();
//    }
//
//    @Override
//    public String getEdtUserNameLoginText() {
//        return edtUserNameLogin.getText().toString().trim();
//    }
//
//    @Override
//    public String getEdtEmailLoginText() {
//        return edtEmail.getText().toString().trim();
//    }
//
//    @Override
//    public String getPasswordLoginText() {
//        return edtPassword.getText().toString().trim();
//    }
//
//    @Override
//    public String getPrePassWordLoginText() {
//        return edtPrePassword.getText().toString().trim();
//    }
//
//    @Override
//    public String getPathImageLoginText() {
//        return edtPathImage.toString(); // ????
//    }
//
//    @Override
//    public void setEdtUsernameLogin(String s) {
//        edtUserNameLogin.setText(s);
//    }
}
