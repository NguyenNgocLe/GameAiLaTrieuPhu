package com.example.ailatrieuphu.Utilities.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.ailatrieuphu.R;

public class CustomDialogCredit extends Dialog implements View.OnClickListener {

    private Context context;
    private String title;
    private String content;
    private String textButton;
    private String textButton2;
    private int SIZE;

    public CustomDialogCredit(@NonNull Context context, Context context1, String title, String content, String textButton, String textButton2, int SIZE, int numberCredit) {
        super(context);
        this.context = context1;
        this.title = title;
        this.content = content;
        this.textButton = textButton;
        this.textButton2 = textButton2;
        this.SIZE = SIZE;
        this.numberCredit = numberCredit;
    }

    private int numberCredit;
    public static int SIZE_M = 15, SIZE_L = 20;

    public CustomDialogCredit(Context context, String title, String content, String textButton, String textButton2, int SIZE) {
        super(context);
        this.context = context;
        this.title = title;
        this.content = content;
        this.textButton = textButton;
        this.textButton2 = textButton2;
        this.SIZE = SIZE;
    }


    public CustomDialogCredit(@NonNull Context context, String s, String s1, String ok, String cancel, int sizeM, int i) {
        super(context);
        this.context = context;
        this.title = s;
        this.content = s1;
        this.textButton = ok;
        this.textButton2 = cancel;
        this.SIZE = sizeM;
        this.numberCredit = i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog_credit);
        //
        setCancelable(true);
        // ánh xạ view
        TextView mTitle = findViewById(R.id.txtTitle);
        TextView mContent = findViewById(R.id.txtContent);
        Button mButtonOk = findViewById(R.id.btnOk);
        Button mButtonCancel = findViewById(R.id.btnCancel);
        mTitle.setText(this.title);
        mContent.setText(this.content);
        mButtonOk.setText(this.textButton);
        mButtonCancel.setText(this.textButton2);
        mContent.setTextSize(this.SIZE);
        //
        mButtonOk.setOnClickListener(this);
        mButtonCancel.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnOk: {
                int numberCredit = 5000;
                // đang làm tăng số credit lên cho người chơi
                Toast.makeText(context, "5.000", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.btnCancel: {
                int numberCredit = 3000;
                Toast.makeText(context, "Cancel", Toast.LENGTH_SHORT).show();
                break;
            }
            default:
                break;
        }
        this.dismiss();
    }

    //
    public String getTextButton() {
        return textButton;
    }

    public void setTextButton(String textButton) {
        this.textButton = textButton;
    }

    public String getTextButton2() {
        return textButton2;
    }

    public void setTextButton2(String textButton2) {
        this.textButton2 = textButton2;
    }

    public int getNumberCredit() {
        return numberCredit;
    }

    public void setNumberCredit(int numberCredit) {
        this.numberCredit = numberCredit;
    }
}
