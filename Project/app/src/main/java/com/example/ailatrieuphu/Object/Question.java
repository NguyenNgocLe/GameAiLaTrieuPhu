package com.example.ailatrieuphu.Object;

public class Question {
    private String question;
    private String answer_correct;
    private String answer_wrong;
    private String answer_a;
    private String answer_b;
    private String answer_c;
    private String answer_d;

    public Question() {

    }

    public Question(String question, String answer_correct, String answer_wrong, String answer_a, String answer_b, String answer_c, String answer_d) {
        this.question = question;
        this.answer_correct = answer_correct;
        this.answer_wrong = answer_wrong;
        this.answer_a = answer_a;
        this.answer_b = answer_b;
        this.answer_c = answer_c;
        this.answer_d = answer_d;
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

    public String getAnswer_wrong() {
        return answer_wrong;
    }

    public void setAnswer_wrong(String answer_wrong) {
        this.answer_wrong = answer_wrong;
    }
}
