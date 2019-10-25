package com.example.ailatrieuphu.SupportAudience.Model;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;

public class SupportModel {
    private TextView txtUserName, txtScorePlayer, txtQuestion;
    private ImageButton imgHeartPlayer, imgCallPeople, imgSupportAudience, imgFiftyPercent, imgUndo;
    private Button btnThanks, btnScorePlayer, btnNumberQuestion, btnBuyCredit;
    private BarChart barChartA, barChartB, barChartC, barChartD;

    public SupportModel() {

    }


    public BarChart getBarChartA() {
        return barChartA;
    }

    public void setBarChartA(BarChart barChartA) {
        this.barChartA = barChartA;
    }

    public Button getBtnThanks() {
        return btnThanks;
    }

    public void setBtnThanks(Button btnThanks) {
        this.btnThanks = btnThanks;
    }

    public BarChart getBarChartB() {
        return barChartB;
    }

    public void setBarChartB(BarChart barChartB) {
        this.barChartB = barChartB;
    }

    public BarChart getBarChartC() {
        return barChartC;
    }

    public void setBarChartC(BarChart barChartC) {
        this.barChartC = barChartC;
    }

    public BarChart getBarChartD() {
        return barChartD;
    }

    public void setBarChartD(BarChart barChartD) {
        this.barChartD = barChartD;
    }

    public TextView getTxtUserName() {
        return txtUserName;
    }

    public void setTxtUserName(TextView txtUserName) {
        this.txtUserName = txtUserName;
    }

    public TextView getTxtScorePlayer() {
        return txtScorePlayer;
    }

    public void setTxtScorePlayer(TextView txtScorePlayer) {
        this.txtScorePlayer = txtScorePlayer;
    }

    public TextView getTxtQuestion() {
        return txtQuestion;
    }

    public void setTxtQuestion(TextView txtQuestion) {
        this.txtQuestion = txtQuestion;
    }

    public ImageButton getImgHeartPlayer() {
        return imgHeartPlayer;
    }

    public void setImgHeartPlayer(ImageButton imgHeartPlayer) {
        this.imgHeartPlayer = imgHeartPlayer;
    }

    public ImageButton getImgCallPeople() {
        return imgCallPeople;
    }

    public void setImgCallPeople(ImageButton imgCallPeople) {
        this.imgCallPeople = imgCallPeople;
    }

    public ImageButton getImgSupportAudience() {
        return imgSupportAudience;
    }

    public void setImgSupportAudience(ImageButton imgSupportAudience) {
        this.imgSupportAudience = imgSupportAudience;
    }

    public ImageButton getImgFiftyPercent() {
        return imgFiftyPercent;
    }

    public void setImgFiftyPercent(ImageButton imgFiftyPercent) {
        this.imgFiftyPercent = imgFiftyPercent;
    }

    public ImageButton getImgUndo() {
        return imgUndo;
    }

    public void setImgUndo(ImageButton imgUndo) {
        this.imgUndo = imgUndo;
    }

    public Button getBtnScorePlayer() {
        return btnScorePlayer;
    }

    public void setBtnScorePlayer(Button btnScorePlayer) {
        this.btnScorePlayer = btnScorePlayer;
    }

    public Button getBtnNumberQuestion() {
        return btnNumberQuestion;
    }

    public void setBtnNumberQuestion(Button btnNumberQuestion) {
        this.btnNumberQuestion = btnNumberQuestion;
    }

    public Button getBtnBuyCredit() {
        return btnBuyCredit;
    }

    public void setBtnBuyCredit(Button btnBuyCredit) {
        this.btnBuyCredit = btnBuyCredit;
    }
}
