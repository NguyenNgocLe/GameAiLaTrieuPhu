package com.example.ailatrieuphu.Model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.ailatrieuphu.Object.Question;
import com.example.ailatrieuphu.Object.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Random;

public class ChooseModel {
    private Context context;
    private int categoryId;
    private Question currentQuestion;
    private int currentQuestionNumber = 1;
//    private int currentScore = 0;
    private ArrayList<Question> questions = new ArrayList<>();
    private int currentHeart = 5;
    private User currentUser = null;
    private final int MAX_COUNTDOWN = 10;
//    private int

    public ChooseModel(Context context) {
        categoryId = ((Activity) context).getIntent().getIntExtra("id", 1);
        Intent intent = ((Activity) context).getIntent();
        if (intent != null) {
            try {
                currentUser = new User(new JSONObject(intent.getStringExtra("nguoi_dung")));
//                currentUser = User.fromJsonString(new JSONObject(intent.getStringExtra("nguoi_dung")).toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            Log.e("aaaa", "null");
        }
    }

    public int getCurrentHeart() {
        return currentHeart;
    }

    public void setCurrentHeart(int currentHeart) {
        this.currentHeart = currentHeart;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Question currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public Question getRandomQuestion() {
        return questions.get((new Random()).nextInt(questions.size() - 1));
    }

    public int getCurrentQuestionNumber() {
        return currentQuestionNumber;
    }

    public void setCurrentQuestionNumber(int currentQuestionNumber) {
        this.currentQuestionNumber = currentQuestionNumber;
    }

    public int getCurrentScore() {
        return currentUser.getScore();
    }

    public void setCurrentScore(int currentScore) {
        this.currentUser.setScore(currentScore);
    }

    public Bundle getBundleResult() {
        Bundle result = new Bundle();
//        result.putInt("score", currentScore);
        result.putString("user",this.currentUser.toStringJson());
        result.putInt("numberQuestion",this.currentQuestionNumber);
        return result;
    }

    public User getCurrentUser(){
        return currentUser;
    }

    public int getMaxCountDown() {
        return MAX_COUNTDOWN;
    }
}
