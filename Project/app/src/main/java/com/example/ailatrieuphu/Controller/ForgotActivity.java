package com.example.ailatrieuphu.Controller;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ailatrieuphu.PresenterImp.LoginPresenterImp;
import com.example.ailatrieuphu.R;

public class ForgotActivity extends AppCompatActivity implements ForgotView {
    private LoginPresenterImp loginPresenterImp;
    private TextView userName, email;
    // dang lam toi day cho gui api doi mat khau

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        //
        initView();
    }

    public ForgotActivity(TextView userName, TextView email) {
        this.userName = userName;
        this.email = email;
        //loginPresenterImp = new LoginPresenterImp();
    }

    public ForgotActivity(int contentLayoutId, TextView userName, TextView email) {
        super(contentLayoutId);
        this.userName = userName;
        this.email = email;
    }

    void initView() {
        userName = findViewById(R.id.txtUserNameForgotPassword);
        email = findViewById(R.id.txtEmailForgotPassword);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btnPasswordRetrieval: {
                //
                handlingPasswordRetrieval();
                break;
            }
            default: {

                break;
            }
        }

    }

    @Override
    public void handlingPasswordRetrieval() {
        String userName = getUserName().getText().toString().trim();
        String email = getEmail().getText().toString().trim();
        //

    }

    public TextView getUserName() {
        return userName;
    }

    public void setUserName(TextView userName) {
        this.userName = userName;
    }

    public TextView getEmail() {
        return email;
    }

    public void setEmail(TextView email) {
        this.email = email;
    }
}
