package com.example.ailatrieuphu.Controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ailatrieuphu.R;
import com.example.ailatrieuphu.Utilities.Dialog.CustomDialogCredit;

public class BuyActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnCreditFiveThousandDollars, btnCreditThreeThousand, btnCreditOneThousandDollars, btnCreditFiveHundredDollars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_credit);
        //
        initialView();
        this.btnCreditFiveThousandDollars.setOnClickListener(this);
        this.btnCreditThreeThousand.setOnClickListener(this);
        this.btnCreditOneThousandDollars.setOnClickListener(this);
        this.btnCreditFiveHundredDollars.setOnClickListener(this);
    }

    public void initialView() {
        this.btnCreditFiveThousandDollars = findViewById(R.id.btnCreditFiveThousandDollars);
        this.btnCreditThreeThousand = findViewById(R.id.btnCreditThreeThousandDollars);
        this.btnCreditOneThousandDollars = findViewById(R.id.btnCreditOneThousandDollars);
        this.btnCreditFiveHundredDollars = findViewById(R.id.btnCreditFiveHundredDollars);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnCreditFiveThousandDollars: {
                new CustomDialogCredit(this, "Thông báo!", "Bạn muốn mua gói credit 5.000?", "OK","Cancel",CustomDialogCredit.SIZE_M).show();
                break;
            }
            case R.id.btnCreditThreeThousandDollars: {
                new CustomDialogCredit(this, "Thông báo!", "Bạn muốn mua gói credit 3.000?", "OK","Cancel",CustomDialogCredit.SIZE_M).show();
                break;
            }
            case R.id.btnCreditOneThousandDollars: {
                new CustomDialogCredit(this, "Thông báo!", "Bạn muốn mua gói credit 1.000?", "OK","Cancel",CustomDialogCredit.SIZE_M).show();

                break;
            }
            case R.id.btnCreditFiveHundredDollars: {
                new CustomDialogCredit(this, "Thông báo!", "Bạn muốn mua gói credit 500?", "OK","Cancel",CustomDialogCredit.SIZE_M).show();

                break;
            }
            default:
                break;
        }
    }

    public Button getBtnCreditFiveThousandDollars() {
        return btnCreditFiveThousandDollars;
    }

    public void setBtnCreditFiveThousandDollars(Button btnCreditFiveThousandDollars) {
        this.btnCreditFiveThousandDollars = btnCreditFiveThousandDollars;
    }
}
