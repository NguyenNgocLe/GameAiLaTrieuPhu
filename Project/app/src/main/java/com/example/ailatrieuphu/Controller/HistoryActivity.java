package com.example.ailatrieuphu.Controller;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ailatrieuphu.R;
import com.example.ailatrieuphu.UserAccount.UserAccount;
import com.example.ailatrieuphu.Utilities.Adapter.PlayerAdapter;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<UserAccount> userAccounts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        //
        this.recyclerView = findViewById(R.id.RecylerView);
        userAccounts = new ArrayList<>();
        UserAccount userAccount = new UserAccount("cc","aaaa","ancnc","sns",0,100,1,200,false);
        for (int i = 0; i < 20; i++) {
            userAccounts.add(userAccount);
        }
        //
        PlayerAdapter playerAdapter = new PlayerAdapter(this, userAccounts);
        // thiết lập 1 layout manager mặc định
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(playerAdapter);

    }
//    public void
}
