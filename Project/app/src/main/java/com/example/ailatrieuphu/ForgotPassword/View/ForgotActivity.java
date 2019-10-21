package com.example.ailatrieuphu.ForgotPassword.View;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ailatrieuphu.R;

public class ForgotActivity extends AppCompatActivity {

    private String userName, Email;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
    }
}
