package com.example.ailatrieuphu.Utilities.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.ailatrieuphu.R;

public class CustomDialogFiftyPercentSupport extends Dialog implements View.OnClickListener {

    private Context context;
    private String titleFiftyPercentSupport, contentFiftyPercentSupport;
    private String textButtonOkFiftyPercentSupport, textButtonCancelFiftyPercentSupport;
    private int numberCredit;
    private int SIZE;

    public static int SIZE_M = 15, SIZE_L = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog_fifty_percent_support);
        // anh xa
        TextView mTitleFiftyPercentSupport = findViewById(R.id.txtTitleDialogFiftyPercentSupport);
        TextView mContentFiftyPercentSupport = findViewById(R.id.txtContentDialogFiftyPercentSupport);
        Button mButtonOkFiftyPercentSupport = findViewById(R.id.btnOkFiftyPercentSupport);
        Button mButtonCancelFiftyPercentSupport = findViewById(R.id.btnCancelFiftyPercentSupport);
        // settext
        mTitleFiftyPercentSupport.setText(this.titleFiftyPercentSupport);
        mContentFiftyPercentSupport.setText(this.contentFiftyPercentSupport);
        mButtonOkFiftyPercentSupport.setText(this.textButtonOkFiftyPercentSupport);
        mButtonCancelFiftyPercentSupport.setText(this.textButtonCancelFiftyPercentSupport);
        mContentFiftyPercentSupport.setTextSize(SIZE);
        // su kien
        mButtonOkFiftyPercentSupport.setOnClickListener(this);
        mButtonCancelFiftyPercentSupport.setOnClickListener(this);
    }

    public CustomDialogFiftyPercentSupport(@NonNull Context context, Context context1, String titleFiftyPercentSupport, String contentFiftyPercentSupport, String textButtonOkFiftyPercentSupport, String textButtonCancelFiftyPercentSupport, int numberCredit, int size) {
        super(context);
        this.context = context1;
        this.titleFiftyPercentSupport = titleFiftyPercentSupport;
        this.contentFiftyPercentSupport = contentFiftyPercentSupport;
        this.textButtonOkFiftyPercentSupport = textButtonOkFiftyPercentSupport;
        this.textButtonCancelFiftyPercentSupport = textButtonCancelFiftyPercentSupport;
        this.numberCredit = numberCredit;
        SIZE = size;
    }

    @Override
    public void onClick(View v) {
        this.dismiss();
    }
}
