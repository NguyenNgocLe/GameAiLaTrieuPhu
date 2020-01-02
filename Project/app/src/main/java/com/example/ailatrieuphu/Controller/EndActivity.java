package com.example.ailatrieuphu.Controller;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ailatrieuphu.R;

public class EndActivity extends AppCompatActivity implements EndView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_play);
    }

    @Override
    public void getBundleUserPlayer() {

    }
}
