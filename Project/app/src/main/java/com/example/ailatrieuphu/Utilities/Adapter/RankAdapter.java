package com.example.ailatrieuphu.Utilities.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ailatrieuphu.R;
import com.example.ailatrieuphu.Object.UserAccount;

import java.util.ArrayList;

public class RankAdapter extends RecyclerView.Adapter<RankAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    private Context context;
    ArrayList<UserAccount> data = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // tìm cái layout nào cho recycleview
        mInflater = LayoutInflater.from(context);
        View mItemView = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rank_player, parent, false);
        return new ViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // đổ dữ liệu của arraylist người chơi lên cho từng item trên recycleview
        holder.txtUserName.setText(data.get(position).getUserName());
        holder.txtScore.setText(data.get(position).getScore()+"");
        holder.btnNumber.setText(data.get(position).getId()+"");
    }

    public RankAdapter(Context context, ArrayList<UserAccount> data) {

        this.context = context;
        // truyền dữ liệu qua cái màn hình bên kia
        this.data = data; // dữ liệu truyền qua
    }

    public RankAdapter(ArrayList<UserAccount> data) {
        // truyền dữ liệu qua cái màn hình bên kia
        this.data = data; // dữ liệu truyền qua
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        Button btnNumber;
        TextView txtUserName, txtScore;

        @SuppressLint("CutPasteId")
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // ánh xạ các text cho item layout bên kia
            txtUserName = (TextView) itemView.findViewById(R.id.txtUserNamePlayer);
            txtScore = (TextView) itemView.findViewById(R.id.txtUserNamePlayer);
            btnNumber = (Button) itemView.findViewById(R.id.btnRankPlayer);
        }
    }
}
