package com.example.ailatrieuphu.Controller;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ailatrieuphu.R;
import com.example.ailatrieuphu.UserAccount.UserAccount;
import com.example.ailatrieuphu.Utilities.Adapter.RankAdapter;

import java.util.ArrayList;

public class RankActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<UserAccount> userAccounts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);
        //
        initialView();
        this.recyclerView = findViewById(R.id.RecylerViewRank);
        userAccounts = new ArrayList<>();
        UserAccount userAccount = new UserAccount("abc","xyz","abc@gmail.com","abc.jpg",0,100,1,300,false);
        for (int i = 0; i < 20; i++) {
            userAccounts.add(userAccount);
        }
        //
        RankAdapter rankAdapter = new RankAdapter(this, userAccounts);
        // thiết lập một màn hình xếp hạng mặc định
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(rankAdapter);
    }

    public void initialView() {

    }
    //
}
