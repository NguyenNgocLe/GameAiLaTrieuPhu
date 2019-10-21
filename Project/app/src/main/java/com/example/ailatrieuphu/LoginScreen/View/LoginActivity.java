package com.example.ailatrieuphu.LoginScreen.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ailatrieuphu.LoginScreen.Presenter.LoginPresenterImp;
import com.example.ailatrieuphu.R;

public class LoginActivity extends AppCompatActivity implements LoginView,View.OnClickListener{

    private Button buttonForgot, buttonSignin, buttonSignup;
    private LoginPresenterImp loginPresenterImp;
    private TextView textviewUserName, textviewPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_account);
        initView();
        loginPresenterImp = new LoginPresenterImp(this);
        buttonForgot.setOnClickListener(this);
        buttonSignin.setOnClickListener(this);
        buttonSignup.setOnClickListener(this);
    }

    private void initView(){
        buttonForgot = findViewById(R.id.btnForgotPassword);
        buttonSignin = findViewById(R.id.btnSignin);
        buttonSignup = findViewById(R.id.btnSignup);
        textviewUserName = findViewById(R.id.txtUserName);
        textviewPassword = findViewById(R.id.txtPassword);
    }

    @Override
    public void showButtonSignin() {
        buttonSignin.setVisibility(View.VISIBLE);
    }

    @Override
    public void showButtonSignup() {
        buttonSignup.setVisibility(View.VISIBLE);
    }

    @Override
    public void showButtonForgot() {
        buttonForgot.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideButtonSignin() {
        buttonSignin.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideButtonSignup() {
        buttonSignup.setVisibility(View.INVISIBLE);
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
        return textviewUserName.getText().toString();
    }

    @Override
    public String getPassword() {
        return textviewPassword.getText().toString();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnSignin:{
                loginPresenterImp.onButtonSigninClick();
                break;
            }
            case R.id.btnForgotPassword:{
                loginPresenterImp.onButtonForgotClick();
                break;
            }
            case R.id.btnSignup:{
                loginPresenterImp.onButtonSignupClick();
                break;
            }
        }
    }
}
