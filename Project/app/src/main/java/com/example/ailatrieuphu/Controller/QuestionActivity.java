package com.example.ailatrieuphu.Controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ailatrieuphu.PresenterImp.QuestionPresenterImp;
import com.example.ailatrieuphu.R;
import com.example.ailatrieuphu.Utilities.Api.apiAsyncTask;
import com.example.ailatrieuphu.View.ChooseActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QuestionActivity extends AppCompatActivity implements View.OnClickListener {
    // địa lý, thể thao, lịch sử, âm nhạc, văn học, khoa học tự nhiên
    private JSONObject jsonObject;
    private Button[] btnDataField;
    private int[] mListIdField;
    private QuestionPresenterImp questionPresenterImp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_field);
        //
        questionPresenterImp = new QuestionPresenterImp();
        initialView();
    }

    //
    public void initialView() {
        btnDataField = new Button[4];
        btnDataField[0] = findViewById(R.id.A);
        btnDataField[1] = findViewById(R.id.B);
        btnDataField[2] = findViewById(R.id.C);
        btnDataField[3] = findViewById(R.id.D);
        //
        this.btnDataField[0].setOnClickListener(this);
        this.btnDataField[1].setOnClickListener(this);
        this.btnDataField[2].setOnClickListener(this);
        this.btnDataField[3].setOnClickListener(this);
        //
        mListIdField = new int[4];

        // dữ thông tin người chơi để qua màn hình câu hỏi sẽ xét điểm gói credit cho người chơi đó
        @SuppressLint("StaticFieldLeak") apiAsyncTask apiAsyncTask = new apiAsyncTask(this, "GET", null, "Load lĩnh vực", "Chờ xíu nha") {
            @Override
            public void xuLy(Context context, String json) {
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(json);
                    JSONArray jsonArray = (JSONArray) jsonObject.getJSONArray("data");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        mListIdField[i] = jsonArray.getJSONObject(i).getInt("id");
                        //Log.d("id", mListIdField[i] + " ");
                        btnDataField[i].setText(jsonArray.getJSONObject(i).getString("ten_linh_vuc"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        apiAsyncTask.execute("linh-vuc/danh-sach");
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.A: {
                startActivityAnswerWithFieldOne();
                break;
            }
            case R.id.B: {
                startActivityAnswerWithFieldTwo();
                break;
            }
            case R.id.C: {
                startActivityAnswerWithFieldThree();
                break;
            }
            case R.id.D: {
                startActivityAnswerWithFieldFour();
                break;
            }
        }
    }

    //
    public void startActivityAnswerWithFieldOne() {
        Intent intent = new Intent(this, ChooseActivity.class);
        intent.putExtra("id", 1);
        startActivity(intent);
    }

    //
    public void startActivityAnswerWithFieldTwo() {
        Intent intent = new Intent(this, ChooseActivity.class);
        intent.putExtra("id", 2);
        startActivity(intent);
    }

    //
    public void startActivityAnswerWithFieldThree() {
        Intent intent = new Intent(this, ChooseActivity.class);
        intent.putExtra("id", 3);
        startActivity(intent);
    }

    //
    public void startActivityAnswerWithFieldFour() {
        Intent intent = new Intent(this, ChooseActivity.class);
        intent.putExtra("id", 4);
        startActivity(intent);
    }
}