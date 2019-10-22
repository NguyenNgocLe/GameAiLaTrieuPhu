package com.example.ailatrieuphu.SupportAudience.Model;

import android.widget.Button;

import com.github.mikephil.charting.charts.BarChart;

public class SupportModel {
    private Button btnThanks;
    private BarChart barChartA, barChartB, barChartC, barChartD;

    public SupportModel() {

    }

    public SupportModel(Button btnThanks, BarChart barChartA, BarChart barChartB, BarChart barChartC, BarChart barChartD) {
        this.btnThanks = btnThanks;
        this.barChartA = barChartA;
        this.barChartB = barChartB;
        this.barChartC = barChartC;
        this.barChartD = barChartD;
    }

    public SupportModel(SupportModel supportModel) {
        this.btnThanks = supportModel.btnThanks;
        this.barChartA = supportModel.barChartA;
        this.barChartB = supportModel.barChartB;
        this.barChartC = supportModel.barChartC;
        this.barChartD = supportModel.barChartD;
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
}
