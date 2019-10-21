package com.example.ailatrieuphu.SupportAudience.View;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ailatrieuphu.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class SupportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support_audience);
        //
        BarChart barChart = (BarChart) findViewById(R.id.horizontalBar);

        ArrayList<BarEntry> entries = new ArrayList<>();

        entries.add(new BarEntry(8f, 0));
        entries.add(new BarEntry(2f, 1));
        entries.add(new BarEntry(5f, 2));
        entries.add(new BarEntry(20f, 3));

        BarDataSet barDataset = new BarDataSet(entries, "cells");

        ArrayList<String> labels = new ArrayList<>();

        labels.add("1");
        labels.add("5");
        labels.add("9");
        labels.add("13");

//        BarData data = new BarData(labels, barDataset);
//        barChart.setData(data);
//        barChart.setDescription("asdf");
//        barDataset.setColors(ColorTemplate.COLORFUL_COLORS);
    }
}
