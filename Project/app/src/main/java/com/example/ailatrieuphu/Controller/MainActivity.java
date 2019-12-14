package com.example.ailatrieuphu.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ailatrieuphu.R;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnManageAccount, btnNewGame, btnPlayHistory, btnRankPlayer, btnBuyCredit;

    JSONObject saveJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        initialView();
    }

    public void initialView() {
        this.btnNewGame = findViewById(R.id.btnNewGame);
        this.btnManageAccount = findViewById(R.id.btnManageAccountLogin);
        this.btnPlayHistory = findViewById(R.id.btnPlayHistory);
        this.btnRankPlayer = findViewById(R.id.btnRankPlayer);
        this.btnBuyCredit = findViewById(R.id.btnBuyCredit);
        //
        btnNewGame.setOnClickListener(this);
        btnManageAccount.setOnClickListener(this);
        btnPlayHistory.setOnClickListener(this);
        btnRankPlayer.setOnClickListener(this);
        btnBuyCredit.setOnClickListener(this);
        //
        Intent getJson = getIntent(); // lấy dữ liệu từ màn hình login
        getJson.getStringExtra("nguoi_dung"); // lấy đc dữ liệu của người dùng
        try {
            saveJson = new JSONObject(getJson.getStringExtra("nguoi_dung"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnManageAccountLogin: {
                handlingManageAccountLogin();
                break;
            }
            case R.id.btnNewGame: {
                handlingNewGame();
                break;
            }
            case R.id.btnPlayHistory: {
                handlingPlayHistory();
                break;
            }
            case R.id.btnRankPlayer: {
                btnRankPlayer();
                break;
            }
            case R.id.btnBuyCredit: {
                btnBuyCredit();
                break;
            }
            default: {
                break;
            }
        }
    }

    public void handlingManageAccountLogin() {
        Intent intent = new Intent(this, ManageActivity.class);
        //Log.e("aaaa","json ok " + getIntent().getStringExtra("nguoi_dung"));
        intent.putExtra("nguoi_dung",getIntent().getStringExtra("nguoi_dung")); // gửi dữ liệu người dùng từ login sang main activity sang manage
        startActivity(intent);
    }

    public void handlingNewGame() {
        Intent intent = new Intent(this, QuestionActivity.class);
        intent.putExtra("nguoi_dung", getIntent().getStringExtra("nguoi_dung"));
        startActivity(intent);
    }

    public void handlingPlayHistory() {
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }

    public void btnRankPlayer() {
        Intent intent = new Intent(this, RankActivity.class);
        startActivity(intent);
    }

    public void btnBuyCredit() {
        Intent intent = new Intent(this, BuyActivity.class);
        startActivity(intent);
    }
}
