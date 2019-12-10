package com.example.ailatrieuphu.Controller;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ailatrieuphu.R;

public class ForgotActivity extends AppCompatActivity {

    private EditText edtUserName, edtEmail;
    private Button btnLayLaiMatKhau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        initial();
        //
    }

//    public ForgotActivity(EditText edtUserName, EditText edtEmail, Button btnLayLaiMatKhau) {
//        this.edtUserName = edtUserName;
//        this.edtEmail = edtEmail;
//        this.btnLayLaiMatKhau = btnLayLaiMatKhau;
//    }

    public void initial() {
        edtUserName = findViewById(R.id.edtUserNameForgotPassword);
        edtEmail = findViewById(R.id.edtEmailForgotPassword);
        btnLayLaiMatKhau = findViewById(R.id.btnPasswordRetrieval);
    }
    public EditText getEdtUserName() {
        return edtUserName;
    }

    public void setEdtUserName(EditText edtUserName) {
        this.edtUserName = edtUserName;
    }

    public EditText getEdtEmail() {
        return edtEmail;
    }

    public void setEdtEmail(EditText edtEmail) {
        this.edtEmail = edtEmail;
    }

    public Button getBtnLayLaiMatKhau() {
        return btnLayLaiMatKhau;
    }

    public void setBtnLayLaiMatKhau(Button btnLayLaiMatKhau) {
        this.btnLayLaiMatKhau = btnLayLaiMatKhau;
    }
}
