package com.example.ailatrieuphu.Utilities.Adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.ailatrieuphu.Object.Question;
import com.example.ailatrieuphu.Object.User;

import java.util.List;

public class QuestionAdapter extends FragmentStatePagerAdapter {

    private List<Question> questionModelList;
    private Context context;
    private User userPlayer;

    public List<Question> getQuestionModelList() {
        return questionModelList;
    }

    public void setQuestionModelList(List<Question> questionModelList) {
        this.questionModelList = questionModelList;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public User getUserPlayer() {
        return userPlayer;
    }

    public void setUserPlayer(User userPlayer) {
        this.userPlayer = userPlayer;
    }

    public QuestionAdapter(FragmentManager fragment, List<Question> questionList, Context context, User userPlayer) {
        super(fragment);
        this.questionModelList = questionList;
        this.context = context;
        this.userPlayer = userPlayer;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        // dang lam toi day
        return null;
    }

    @Override
    public int getCount() {
        return questionModelList.size();
    }
}
