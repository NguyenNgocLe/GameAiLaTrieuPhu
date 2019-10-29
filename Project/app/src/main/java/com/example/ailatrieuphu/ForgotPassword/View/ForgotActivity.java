package com.example.ailatrieuphu.ForgotPassword.View;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ailatrieuphu.R;

public class ForgotActivity extends AppCompatActivity {

    private TextView userName, email;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
    }

    void initView(){
        userName = findViewById(R.id.txtUserNameForgotPassword);
        email = findViewById(R.id.txtEmailForgotPassword);
    }
}
