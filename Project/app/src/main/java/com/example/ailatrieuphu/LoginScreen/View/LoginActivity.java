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

    private Button buttonForgot, buttonSignIn, buttonSignUp;
    private LoginPresenterImp loginPresenterImp;
    private TextView textViewUserName, textViewPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_account);
        initView();
        loginPresenterImp = new LoginPresenterImp(this);
        buttonForgot.setOnClickListener(this);
        buttonSignIn.setOnClickListener(this);
        buttonSignUp.setOnClickListener(this);
    }

    private void initView(){
        buttonForgot = findViewById(R.id.btnForgotPassword);
        buttonSignIn = findViewById(R.id.btnSignin);
        buttonSignUp = findViewById(R.id.btnSignup);
        textViewUserName = findViewById(R.id.txtUserName);
        textViewPassword = findViewById(R.id.txtPassword);
    }

    @Override
    public void showButtonSignIn() {
        buttonSignIn.setVisibility(View.VISIBLE);
    }

    @Override
    public void showButtonSignUp() {
        buttonSignUp.setVisibility(View.VISIBLE);
    }

    @Override
    public void showButtonForgot() {
        buttonForgot.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideButtonSignIn() {
        buttonSignIn.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideButtonSignUp() {
        buttonSignUp.setVisibility(View.INVISIBLE);
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
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnSignin:{
                loginPresenterImp.onButtonSignInClick();
                break;
            }
            case R.id.btnForgotPassword:{
                loginPresenterImp.onButtonForgotClick();
                break;
            }
            case R.id.btnSignup:{
                loginPresenterImp.onButtonSignUpClick();
                break;
            }
        }
    }
}
