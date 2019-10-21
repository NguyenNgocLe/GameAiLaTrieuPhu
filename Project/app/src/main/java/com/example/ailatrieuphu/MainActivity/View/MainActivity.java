package com.example.ailatrieuphu.MainActivity.View;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ailatrieuphu.R;

public class MainActivity extends AppCompatActivity implements MainView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
