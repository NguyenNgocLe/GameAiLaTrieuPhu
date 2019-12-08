package com.example.ailatrieuphu.MainActivity.View;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ailatrieuphu.R;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements MainView{

    JSONObject saveJson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        InitiView();
    }

    public void InitiView() {
        Intent getJson = getIntent(); // lấy dữ liệu từ màn hình login
        getJson.getStringExtra("nguoi_dung"); // lấy đc dữ liệu của người dùng
        try {
            saveJson = new JSONObject(getJson.getStringExtra("nguoi_dung"));
            //Log.d("abc", luuJson.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
