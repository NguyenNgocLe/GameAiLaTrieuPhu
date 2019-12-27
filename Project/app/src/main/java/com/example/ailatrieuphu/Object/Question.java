package com.example.ailatrieuphu.Object;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Question {
    private int id;
    private int fieldId;
    private String question;
    private String answer_correct;
    private String answer_a;
    private String answer_b;
    private String answer_c;
    private String answer_d;

    public Question() {

    }

    public Question(String question, String answer_correct, String answer_wrong, String answer_a, String answer_b, String answer_c, String answer_d) {
        this.question = question;
        this.answer_correct = answer_correct;
        this.answer_a = answer_a;
        this.answer_b = answer_b;
        this.answer_c = answer_c;
        this.answer_d = answer_d;
    }

    public Question(JSONObject json){
        try {
            this.id = json.getInt("id");
            this.question = json.getString("noi_dung");
            this.answer_a = json.getString("phuong_an_a");
            this.answer_b = json.getString("phuong_an_b");
            this.answer_c = json.getString("phuong_an_c");
            this.answer_d = json.getString("phuong_an_d");
            this.answer_correct = json.getString("dap_an");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Question> getArrQuestionFromJson(JSONObject json){
        ArrayList<Question> results = new ArrayList<>();
        try {
            JSONArray arr = json.getJSONArray("data");
            for(int i=0;i<arr.length();i++){
                results.add(new Question(arr.getJSONObject(i)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return results;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer_correct() {
        return answer_correct;
    }

    public void setAnswer_correct(String answer_correct) {
        this.answer_correct = answer_correct;
    }

    public String getAnswer_a() {
        return answer_a;
    }

    public void setAnswer_a(String answer_a) {
        this.answer_a = answer_a;
    }

    public String getAnswer_b() {
        return answer_b;
    }

    public void setAnswer_b(String answer_b) {
        this.answer_b = answer_b;
    }

    public String getAnswer_c() {
        return answer_c;
    }

    public void setAnswer_c(String answer_c) {
        this.answer_c = answer_c;
    }

    public String getAnswer_d() {
        return answer_d;
    }

    public void setAnswer_d(String answer_d) {
        this.answer_d = answer_d;
    }
}
