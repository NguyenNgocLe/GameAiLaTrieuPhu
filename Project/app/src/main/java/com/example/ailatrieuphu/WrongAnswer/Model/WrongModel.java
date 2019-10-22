package com.example.ailatrieuphu.WrongAnswer.Model;

import android.widget.Button;

public class WrongModel {
    private Button answerA, answerB, answerC, answerD;

    public WrongModel(){

    }

    public WrongModel(Button answerA, Button answerB, Button answerC, Button answerD) {
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
    }

    public WrongModel(WrongModel wrongModel){
        answerA = wrongModel.answerA;
        answerB = wrongModel.answerB;
        answerC = wrongModel.answerC;
    }

    public Button getAnswerA() {
        return answerA;
    }

    public void setAnswerA(Button answerA) {
        this.answerA = answerA;
    }

    public Button getAnswerB() {
        return answerB;
    }

    public void setAnswerB(Button answerB) {
        this.answerB = answerB;
    }

    public Button getAnswerC() {
        return answerC;
    }

    public void setAnswerC(Button answerC) {
        this.answerC = answerC;
    }

    public Button getAnswerD() {
        return answerD;
    }

    public void setAnswerD(Button answerD) {
        this.answerD = answerD;
    }
}
