package com.example.ailatrieuphu.Utilities.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ailatrieuphu.Object.UserAccount;
import com.example.ailatrieuphu.R;

import java.util.ArrayList;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder> {

    private LayoutInflater mInflater;

    private Context context;
    ArrayList<UserAccount> data = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // tìm cái layout nào cho recycler view
        mInflater = LayoutInflater.from(context);
        View mItemView = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history_player, parent, false);
        return new ViewHolder(mItemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //đổ dữ liệu của array list người chơi lên cho từng item trên recycle view
        holder.txtTime.setText(data.get(position).getDateTime() + "");

        holder.txtQuestion.setText("Số câu: "+data.get(position).getNumberQuestion());
        holder.txtScore.setText(data.get(position).getScore() + " điểm");
    }

    public PlayerAdapter(Context context, ArrayList<UserAccount> data) {
        this.context = context;
        this.data = data; // dữ liệu truyền qua
    }
    public PlayerAdapter(ArrayList<UserAccount> data) {
        this.data = data; // dữ liệu truyền qua
    }

    public PlayerAdapter(LayoutInflater mInflater) {
        this.mInflater = mInflater;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTime, txtScore, txtQuestion;

        @SuppressLint("CutPasteId")
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // anh xa qua cho thang kia
            txtTime = (TextView) itemView.findViewById(R.id.txtHistoryTimePlayer);
            txtQuestion = (TextView) itemView.findViewById(R.id.txtNumberQuestionHistoryPlayer);
            txtScore = (TextView) itemView.findViewById(R.id.txtScoreHistoryPlayer);
        }
    }
}
