package com.example.ailatrieuphu.Utilities.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ailatrieuphu.R;
import com.example.ailatrieuphu.Object.UserAccount;

import java.util.ArrayList;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    ArrayList<UserAccount> data = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // ánh xạ cái view mình muốn xét
        View mItemView = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history_player, parent, false);
        return new ViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // xét sự kiện hoặc sét text kết nối dữ liệu
        String txtUserName, txtEmail, txtHighScore, txtCredit;
        txtUserName = data.get(position).getUserName(); // sét text
        txtEmail = data.get(position).getEmail();
        txtHighScore = String.valueOf(data.get(position).getScore());
        txtCredit = String.valueOf(data.get(position).getCredit());

    }

    public PlayerAdapter(Context context, ArrayList<UserAccount> data) {
        mInflater = LayoutInflater.from(context); //
        this.data = data; // dữ liệu truyền qua
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
