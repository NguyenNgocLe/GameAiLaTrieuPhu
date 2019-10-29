package com.example.ailatrieuphu.ShowQuestion.Model;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ShowModel {
    private Button btnAnswerA, btnAnswerB, btnAnswerC, btnAnswerD, btnQuestionNumber, btnScoreCredit;
    private Button btnFiftyPercent, btnSupportAudience, btnCallPeople, btnUseCredit;
    private ImageButton imbLifePlayer;
    private TextView txtQuestion, txtTimeAnswer, txtScorePlayer, txtUserNamePlayer;
    private ProgressBar psbAnimationTime;

    //
    public ShowModel() {

    }

    public ShowModel(Button btnAnswerA, Button btnAnswerB, Button btnAnswerC, Button btnAnswerD, Button btnQuestionNumber, Button btnScoreCredit, Button btnFiftyPercent, Button btnSupportAudience, Button btnCallPeople, Button btnUseCredit, ImageButton imbLifePlayer, TextView txtQuestion, TextView txtTimeAnswer, TextView txtScorePlayer, TextView txtUserNamePlayer, ProgressBar psbAnimationTime) {
        this.btnAnswerA = btnAnswerA;
        this.btnAnswerB = btnAnswerB;
        this.btnAnswerC = btnAnswerC;
        this.btnAnswerD = btnAnswerD;
        this.btnQuestionNumber = btnQuestionNumber;
        this.btnScoreCredit = btnScoreCredit;
        this.btnFiftyPercent = btnFiftyPercent;
        this.btnSupportAudience = btnSupportAudience;
        this.btnCallPeople = btnCallPeople;
        this.btnUseCredit = btnUseCredit;
        this.imbLifePlayer = imbLifePlayer;
        this.txtQuestion = txtQuestion;
        this.txtTimeAnswer = txtTimeAnswer;
        this.txtScorePlayer = txtScorePlayer;
        this.txtUserNamePlayer = txtUserNamePlayer;
        this.psbAnimationTime = psbAnimationTime;
    }

    public ShowModel(ShowModel showModel) {
        this.btnAnswerA = showModel.btnAnswerA;
        this.btnAnswerB = showModel.btnAnswerB;
        this.btnAnswerC = showModel.btnAnswerC;
        this.btnAnswerD = showModel.btnAnswerD;
        this.btnQuestionNumber = showModel.btnQuestionNumber;
        this.btnScoreCredit = showModel.btnScoreCredit;
        this.btnFiftyPercent = showModel.btnFiftyPercent;
        this.btnSupportAudience = showModel.btnSupportAudience;
        this.btnCallPeople = showModel.btnCallPeople;
        this.btnUseCredit = showModel.btnUseCredit;
        this.imbLifePlayer = showModel.imbLifePlayer;
        this.txtQuestion = showModel.txtQuestion;
        this.txtTimeAnswer = showModel.txtTimeAnswer;
        this.txtScorePlayer = showModel.txtScorePlayer;
        this.txtUserNamePlayer = showModel.txtUserNamePlayer;
        this.psbAnimationTime = showModel.psbAnimationTime;
    }
    //
    public Button getBtnAnswerA() {
        return btnAnswerA;
    }

    public void setBtnAnswerA(Button btnAnswerA) {
        this.btnAnswerA = btnAnswerA;
    }

    public Button getBtnAnswerB() {
        return btnAnswerB;
    }

    public void setBtnAnswerB(Button btnAnswerB) {
        this.btnAnswerB = btnAnswerB;
    }

    public Button getBtnAnswerC() {
        return btnAnswerC;
    }

    public void setBtnAnswerC(Button btnAnswerC) {
        this.btnAnswerC = btnAnswerC;
    }

    public Button getBtnAnswerD() {
        return btnAnswerD;
    }

    public void setBtnAnswerD(Button btnAnswerD) {
        this.btnAnswerD = btnAnswerD;
    }

    public Button getBtnQuestionNumber() {
        return btnQuestionNumber;
    }

    public void setBtnQuestionNumber(Button btnQuestionNumber) {
        this.btnQuestionNumber = btnQuestionNumber;
    }

    public Button getBtnScoreCredit() {
        return btnScoreCredit;
    }

    public void setBtnScoreCredit(Button btnScoreCredit) {
        this.btnScoreCredit = btnScoreCredit;
    }

    public Button getBtnFiftyPercent() {
        return btnFiftyPercent;
    }

    public void setBtnFiftyPercent(Button btnFiftyPercent) {
        this.btnFiftyPercent = btnFiftyPercent;
    }

    public Button getBtnSupportAudience() {
        return btnSupportAudience;
    }

    public void setBtnSupportAudience(Button btnSupportAudience) {
        this.btnSupportAudience = btnSupportAudience;
    }

    public Button getBtnCallPeople() {
        return btnCallPeople;
    }

    public void setBtnCallPeople(Button btnCallPeople) {
        this.btnCallPeople = btnCallPeople;
    }

    public Button getBtnUseCredit() {
        return btnUseCredit;
    }

    public void setBtnUseCredit(Button btnUseCredit) {
        this.btnUseCredit = btnUseCredit;
    }

    public ImageButton getImbLifePlayer() {
        return imbLifePlayer;
    }

    public void setImbLifePlayer(ImageButton imbLifePlayer) {
        this.imbLifePlayer = imbLifePlayer;
    }

    public TextView getTxtQuestion() {
        return txtQuestion;
    }

    public void setTxtQuestion(TextView txtQuestion) {
        this.txtQuestion = txtQuestion;
    }

    public TextView getTxtTimeAnswer() {
        return txtTimeAnswer;
    }

    public void setTxtTimeAnswer(TextView txtTimeAnswer) {
        this.txtTimeAnswer = txtTimeAnswer;
    }

    public TextView getTxtScorePlayer() {
        return txtScorePlayer;
    }

    public void setTxtScorePlayer(TextView txtScorePlayer) {
        this.txtScorePlayer = txtScorePlayer;
    }

    public TextView getTxtUserNamePlayer() {
        return txtUserNamePlayer;
    }

    public void setTxtUserNamePlayer(TextView txtUserNamePlayer) {
        this.txtUserNamePlayer = txtUserNamePlayer;
    }

    public ProgressBar getPsbAnimationTime() {
        return psbAnimationTime;
    }

    public void setPsbAnimationTime(ProgressBar psbAnimationTime) {
        this.psbAnimationTime = psbAnimationTime;
    }
}
