package com.example.ailatrieuphu.Utilities.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ailatrieuphu.R;
import com.example.ailatrieuphu.UserAccount.UserAccount;

import java.util.ArrayList;

public class RankAdapter extends RecyclerView.Adapter<RankAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    ArrayList<UserAccount> data = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rank_player, parent, false);
        return new ViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // xét sự kiện hoặc sét text để kết nối dữ liệu
        String txtUserName, txtScore;
        txtUserName = data.get(position).getUserName();
        txtScore = String.valueOf(data.get(position).getScore());
        //
    }

    public RankAdapter(Context context, ArrayList<UserAccount> data) {
        mInflater = LayoutInflater.from(context);
        // truyền dữ liệu qua cái màn hình bên kia
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
