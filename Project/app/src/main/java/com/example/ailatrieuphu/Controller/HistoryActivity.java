package com.example.ailatrieuphu.Controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ailatrieuphu.Object.UserAccount;
import com.example.ailatrieuphu.R;
import com.example.ailatrieuphu.Utilities.Adapter.PlayerAdapter;
import com.example.ailatrieuphu.Utilities.Api.apiAsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<UserAccount> userAccounts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        //
        handlingGetDataHistoryPlayer();
    }

    //
    public void handlingGetDataHistoryPlayer() {
        // ánh xạ
        recyclerView = findViewById(R.id.RecylerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.HORIZONTAL));
        userAccounts = new ArrayList<>();
        //
        @SuppressLint("StaticFieldLeak") apiAsyncTask apiAsyncTask = new apiAsyncTask(this, "GET", null, "Lấy lịch sử chơi", "chờ xíu nha...") {
            @Override
            public void xuLy(Context context, String json) {
                JSONObject jsonObject = null;
                if (json != null) {
                    try {
                        ArrayList<UserAccount> userAccounts = new ArrayList<>();
                        jsonObject = new JSONObject(json);
                        //Log.e("json", jsonObject + " ");
                        JSONArray jsonArray = (JSONArray) jsonObject.getJSONArray("data");
                        Log.e("arr", jsonArray.toString() + " ");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            Log.e("cc", jsonArray.getJSONObject(i) + " ");
                            userAccounts.add(new UserAccount(jsonArray.getJSONObject(i)));
                        }
                        Log.e("his", jsonArray + "");
                        PlayerAdapter playerAdapter;
                        playerAdapter = new PlayerAdapter(context, userAccounts);
                        recyclerView.setAdapter(playerAdapter);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(context, "k co du lieu", Toast.LENGTH_SHORT).show();
                }

            }
        };
        apiAsyncTask.execute("luot-choi/danh-sach");
    }
}
