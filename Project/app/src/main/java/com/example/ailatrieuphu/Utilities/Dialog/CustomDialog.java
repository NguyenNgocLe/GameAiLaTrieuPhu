package com.example.ailatrieuphu.Utilities.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.ailatrieuphu.R;

public class CustomDialog extends Dialog implements android.view.View.OnClickListener {

    private Context context;
    private String title;
    private String content;
    private String textButton;
    private int SIZE;
    public static int SIZE_M = 15, SIZE_L = 20;

    public CustomDialog(@NonNull Context context, String title, String content, String textButton, int SIZE) {
        super(context);
        this.context = context;
        this.title = title;
        this.content = content;
        this.textButton = textButton;
        this.SIZE = SIZE;
    }

    public CustomDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.thong_bao);

        setCancelable(true);

//ánh xạ view
        TextView mTitle = findViewById(R.id.txtTitle);
        TextView mContent = findViewById(R.id.txtContent);
        Button mButtonOk = findViewById(R.id.btnOk);

        mTitle.setText(this.title);
        mContent.setText(this.content);
        mButtonOk.setText(this.textButton);
        mContent.setTextSize(this.SIZE);

//set onclick
        mButtonOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.dismiss();
    }
}