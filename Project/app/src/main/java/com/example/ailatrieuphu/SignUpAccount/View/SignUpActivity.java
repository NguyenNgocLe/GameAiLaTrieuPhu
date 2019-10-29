package com.example.ailatrieuphu.SignUpAccount.View;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ailatrieuphu.R;

public class SignUpActivity extends AppCompatActivity implements SignUpView, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_account);
        //
    }

    @Override
    public void showButtonSignUpClick() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnSignupAccount: {
                // dang lam
                break;
            }
        }
    }
}
