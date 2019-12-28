package com.example.ailatrieuphu.Utilities.Barchart;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ailatrieuphu.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Objects;

public class Barchart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barchart);
        BarChart mchart = (BarChart) findViewById(R.id.barChart);
        toTuVan(mchart);
    }
    @SuppressLint("ResourceType")
    public void toTuVan(View view) {
        final Dialog dialog= new Dialog(this);
        dialog.setContentView(R.layout.activity_barchart);
        dialog.setCanceledOnTouchOutside(false);//->Click vào bên ngoài thì đóng dialog
        Objects.requireNonNull(dialog.getWindow()).setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT);
        toTuVan(dialog);
        dialog.show();
    }
    public void toTuVan(Dialog dialog){

        BarChart barChart = dialog.findViewById(R.id.barChart);

        ArrayList<BarEntry> datas = new ArrayList<>();

        int random_one = (int) (Math.random() * 100);
        int r2 = 100 - random_one;
        int random_two = (int) (Math.random() * 100 % (r2 + 1));
        int r3 = 100 - (random_one + random_two);
        int random_three = (int) (Math.random() * 100 % (r3 + 1));
        int random_four = 100 - (random_one + random_two + random_three);

        datas.add(new BarEntry(0,random_one));
        datas.add(new BarEntry(1, random_two));
        datas.add(new BarEntry(2, random_three));
        datas.add(new BarEntry(3, random_four));

        BarDataSet barDataSet = new BarDataSet(datas, "");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextSize(20f);


        BarData barData = new BarData( barDataSet);
        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        final String[] labels=new String[]{"A","B","C","D"};
        IndexAxisValueFormatter formatter=new IndexAxisValueFormatter(labels);
        xAxis.setTextSize(18f);
        xAxis.setGranularity(1f);

        xAxis.setValueFormatter(formatter);
        //gán dữ liệu vào barChart
        barChart.setData(barData);

        //Khong ve luoi tren bieu do
        xAxis.setDrawGridLines(false);
        barChart.getAxisLeft().setEnabled(false);
        barChart.getAxisRight().setEnabled(false);
        barChart.getLegend().setEnabled(false);
        barChart.getDescription().setEnabled(false);
        //Zoom bieu do
        barChart.setDoubleTapToZoomEnabled(false);
        //Touch biêu đồ
        barChart.setTouchEnabled(false);

        barChart.animateY(3000);
        barChart.invalidate();
    }
}
