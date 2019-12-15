package com.example.ailatrieuphu.Controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ailatrieuphu.Object.UserAccount;
import com.example.ailatrieuphu.R;
import com.example.ailatrieuphu.Utilities.Adapter.RankAdapter;
import com.example.ailatrieuphu.Utilities.Api.apiAsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RankActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<UserAccount> userAccounts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);
        //
        handlingGetRetrievePlayerData();
    }

//    public void initialView() {
//        this.recyclerView = findViewById(R.id.RecylerViewRank);
//        userAccounts = new ArrayList<>();
//        UserAccount userAccount = new UserAccount("abc", "xyz", "abc@gmail.com", "abc.jpg", 0, 100, 1, 300, "");
//        for (int i = 0; i < 20; i++) {
//            userAccounts.add(userAccount);
//        }
//        //
//        RankAdapter rankAdapter = new RankAdapter(this, userAccounts);
//        // thiết lập một màn hình xếp hạng mặc định
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(rankAdapter);
//    }

    //
    public void handlingGetRetrievePlayerData() {
        this.recyclerView = findViewById(R.id.RecylerViewRank);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        userAccounts = new ArrayList<>();
        //
        @SuppressLint("StaticFieldLeak") apiAsyncTask apiAsyncTask = new apiAsyncTask(this, "GET", null, "Bảng xếp hạng", "Chờ xíu nha...") {
            @Override
            public void xuLy(Context context, String json) {
                JSONObject jsonObject = null;
                try {
                    ArrayList<UserAccount> userAccounts = new ArrayList<>();
                    jsonObject = new JSONObject(json);
                    JSONArray jsonArray = (JSONArray) jsonObject.getJSONArray("data");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        userAccounts.add(new UserAccount(jsonArray.getJSONObject(i)));
                    }
                    RankAdapter rankAdapter;
                    rankAdapter = new RankAdapter(context, userAccounts);
                    recyclerView.setAdapter(rankAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        apiAsyncTask.execute("nguoi-choi/danh-sach");
    }
}
