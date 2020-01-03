package com.example.ailatrieuphu.Controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ailatrieuphu.PresenterImp.EndPresenterImp;
import com.example.ailatrieuphu.R;

public class EndActivity extends AppCompatActivity implements EndView, View.OnClickListener {

    private TextView txtNumberScore;
    private Button btnNumberQuestion;
    private EndPresenterImp endPresenterImp;
    private TextView txtUserNamePlayer;
    private Button btnNumberScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_play);
        initialView();
    }
    //
    @Override
    public void getBundleUserPlayer() {

    }

    @Override
    public void initialView() {
        txtNumberScore = findViewById(R.id.txtNumberScoreEndPlay);
        btnNumberQuestion = findViewById(R.id.edtNumberQuestion);
        txtUserNamePlayer = findViewById(R.id.txtUserNamePlayer);
        btnNumberScore = findViewById(R.id.btnScoreCredit);
    }

    @Override
    public void setTextNumberScore(String text) {

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnEndPlay: {
                Toast.makeText(this, "Đang xử lý phần gửi người chơi lên cho serve!!!", Toast.LENGTH_SHORT).show();
                break;
            }
            default: {
                break;
            }
        }

    }
}
