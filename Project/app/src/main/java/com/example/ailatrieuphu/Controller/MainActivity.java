package com.example.ailatrieuphu.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ailatrieuphu.R;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnNewGame;
    JSONObject saveJson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        initiView();
    }

    public void initiView() {
        this.btnNewGame = findViewById(R.id.btnNewGame);
        btnNewGame.setOnClickListener(this);
        Intent getJson = getIntent(); // lấy dữ liệu từ màn hình login
        getJson.getStringExtra("nguoi_dung"); // lấy đc dữ liệu của người dùng
        try {
            saveJson = new JSONObject(getJson.getStringExtra("nguoi_dung"));
            //Log.d("abc", luuJson.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Log.d("debug" ,id + "");
        switch (id) {
            case R.id.btnNewGame: {
                handlingNewGame();
            }
            default: {
                break;
            }
        }
    }

    public void handlingNewGame() {
        Intent intent = new Intent(this, ChooseActivity.class);
        startActivity(intent);
    }
}
