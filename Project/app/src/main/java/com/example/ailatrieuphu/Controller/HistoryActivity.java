package com.example.ailatrieuphu.Controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

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
        this.recyclerView = findViewById(R.id.RecylerView);
//         thiết lập 1 layout manager mặc định
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        @SuppressLint("StaticFieldLeak") apiAsyncTask apiAsyncTask = new apiAsyncTask(this, "GET", null, "Lấy lịch sử chơi", "chờ xíu nha...") {
            @Override
            public void xuLy(Context context, String json) {
                ArrayList<UserAccount> userAccounts = new ArrayList<UserAccount>();
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    JSONArray jsonArray = (JSONArray) jsonObject.getJSONArray("data");
                    Log.e("json", jsonArray + " ");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        userAccounts.add(new UserAccount(jsonObject.getJSONObject("data")));
                        Toast.makeText(context, "abc", Toast.LENGTH_SHORT).show();
                    }
                    RankAdapter adapter = new RankAdapter(context, userAccounts);
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        apiAsyncTask.execute("luot-choi/danh-sach");
    }
}
