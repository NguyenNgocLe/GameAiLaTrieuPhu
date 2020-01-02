
package com.example.ailatrieuphu.View;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ailatrieuphu.PresenterImp.ChoosePresenter.ChoosePresenterImp;
import com.example.ailatrieuphu.R;
import com.example.ailatrieuphu.Utilities.Barchart.BarchartActivity;
import com.example.ailatrieuphu.Utilities.RingProgressbarAsyntask;
import com.github.mikephil.charting.charts.BarChart;

import org.json.JSONObject;

import java.util.ArrayList;

import io.netopen.hotbitmapgg.library.view.RingProgressBar;

public class ChooseActivity extends AppCompatActivity implements RingProgressBar.OnProgressListener,
        ChooseView,
        View.OnClickListener {
    private RingProgressBar mRingProgressBar;
    private int progress = 1, mMaxProgress;
    private RingProgressbarAsyntask mThreadCountdown;
    private TextView timeAnswer;
    //
    private ImageButton imbUndo;
    private ImageButton button5050;
    private ImageButton imbSupportAudience;
    private ImageButton imbCallPeople;
    private Button btnQuestionNumber;
    private Button btnCredit;
    private TextView txtQuestion;
    private TextView txtScore;
    private int[] mListIdQuestion;
    private ProgressBar progressBarLoadData;
    private View layoutContent;

    //
    private ChoosePresenterImp choosePresenterImp;
    private BarChart barChart;
    private ArrayList<Button> listButton;

    //dialog
    //dialog Answer
    private Dialog dialogAnswer;
    private Button buttonOkDialogAnswer;
    private TextView textTitleDialogAnswer, textCorectDialogAnswer;

    //dialog random
    private Dialog dialogRandom;
    private Button buttonOkDialogRandom, buttonCancelDialogRandom;
    private TextView textTitleDialogRandom, textContentDialogRandom;

    //dialog 50/50
    private Dialog dialog5050;
    private Button buttonOkDialog5050, buttonCancelDialog5050;
    private TextView textTitleDialog5050, textContentDialog5050;

    //dialog call people
    private Dialog dialogCallPeople;
    private Button buttonOkDialogCallPeople, buttonCancelDialogCallPeople;
    private TextView textTitleDialogCallPeople, textContentDialogCallPeople;

    //dialog buy credit
    private Dialog dialogBuyCredit;
    private Button buttonOkDialogBuyCredit, buttonCancelDialogBuyCredit;
    private TextView textTitleDialogBuyCredit, textContentDialogBuyCredit;

    // button number score credit
    private Button buttonScoreCredit;
    private int ScoreCredit = 0;

    // Json Player
    private JSONObject saveJsonPlayer;

    // Image button heart
    private ArrayList<ImageButton> imageButtonsHeart;

    //
    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_answer);
        //
        InitialView();
        // lấy dữ liệu từ màn hình main
        choosePresenterImp.handlingGetQuestionByCategoryField();
    }

    @Override
    public void progressToComplete() {
        Toast.makeText(this, "Hoàn tất!", Toast.LENGTH_SHORT).show();
    }

    public void InitialView() {
        layoutContent = findViewById(R.id.contentLayout);
        progressBarLoadData = findViewById(R.id.process_loadData);
        btnQuestionNumber = findViewById(R.id.edtNumberQuestion);
        txtQuestion = findViewById(R.id.txtQuestion);
        listButton = new ArrayList<>();
        listButton.add((Button) findViewById(R.id.A));
        listButton.add((Button) findViewById(R.id.B));
        listButton.add((Button) findViewById(R.id.C));
        listButton.add((Button) findViewById(R.id.D));
        listButton.get(0).setOnClickListener(this);
        listButton.get(1).setOnClickListener(this);
        listButton.get(2).setOnClickListener(this);
        listButton.get(3).setOnClickListener(this);
        this.imbUndo = findViewById(R.id.imbUndo);
        this.button5050 = findViewById(R.id.imbFiftyPercent);
        this.imbSupportAudience = findViewById(R.id.imbSupportAudience);
        this.imbCallPeople = findViewById(R.id.imbCallPeople);
        this.btnCredit = findViewById(R.id.btnCredit); // tro giup mua cau hoi
        imbUndo.setOnClickListener(this);
        button5050.setOnClickListener(this);
        imbSupportAudience.setOnClickListener(this);
        imbCallPeople.setOnClickListener(this);
        btnCredit.setOnClickListener(this);

        //dialog Answer
        dialogAnswer = new Dialog(this);
        dialogAnswer.setContentView(R.layout.dialog_answer_notification);
        buttonOkDialogAnswer = dialogAnswer.findViewById(R.id.btnOk);
        textCorectDialogAnswer = dialogAnswer.findViewById(R.id.txtContentDialog);
        textTitleDialogAnswer = dialogAnswer.findViewById(R.id.txtTitleDialog);
        buttonOkDialogAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePresenterImp.onButtonOkDialogAnswerClick();
            }
        });

        //dialog Random
        dialogRandom = new Dialog(this);
        dialogRandom.setContentView(R.layout.activity_custom_dialog_credit);
        buttonOkDialogRandom = dialogRandom.findViewById(R.id.btnOkDialogCredit);
        buttonCancelDialogRandom = dialogRandom.findViewById(R.id.btnCancelDialogCredit);
        textContentDialogRandom = dialogRandom.findViewById(R.id.txtContentDialogCredit);
        textTitleDialogRandom = dialogRandom.findViewById(R.id.txtTitleDialogCredit);
        buttonOkDialogRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePresenterImp.onButtonOkDialogRandomClick();
            }
        });

        buttonCancelDialogRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePresenterImp.onButtonCancelDialogRandomClick();
            }
        });

        //dialog 50/50
        dialog5050 = new Dialog(this);
        dialog5050.setContentView(R.layout.activity_custom_dialog_credit);
        buttonOkDialog5050 = dialog5050.findViewById(R.id.btnOkDialogCredit);
        buttonCancelDialog5050 = dialog5050.findViewById(R.id.btnCancelDialogCredit);
        textContentDialog5050 = dialog5050.findViewById(R.id.txtContentDialogCredit);
        textTitleDialog5050 = dialog5050.findViewById(R.id.txtTitleDialogCredit);
        buttonOkDialog5050.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePresenterImp.onButtonOkDialog5050Click();
            }
        });

        buttonCancelDialog5050.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePresenterImp.onButtonCancelDialog5050Click();
            }
        });

        //dialog call people
        dialogCallPeople = new Dialog(this);
        dialogCallPeople.setContentView(R.layout.activity_custom_dialog_credit);
        buttonOkDialogCallPeople = dialogCallPeople.findViewById(R.id.btnOkDialogCredit);
        buttonCancelDialogCallPeople = dialogCallPeople.findViewById(R.id.btnCancelDialogCredit);
        textContentDialogCallPeople = dialogCallPeople.findViewById(R.id.txtContentDialogCredit);
        textTitleDialogCallPeople = dialogCallPeople.findViewById(R.id.txtTitleDialogCredit);
        buttonOkDialogCallPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePresenterImp.onButtonOkDialogCallPeopleClick();
            }
        });
        buttonCancelDialogCallPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePresenterImp.onButtonCancelDialogCallPeopleClick();
            }
        });

        // dialog buy credit
        dialogBuyCredit = new Dialog(this);
        dialogBuyCredit.setContentView(R.layout.activity_custom_dialog_credit);
        buttonOkDialogBuyCredit = dialogBuyCredit.findViewById(R.id.btnOkDialogCredit);
        buttonCancelDialogBuyCredit = dialogBuyCredit.findViewById(R.id.btnCancelDialogCredit);
        textContentDialogBuyCredit = dialogBuyCredit.findViewById(R.id.txtContentDialogCredit);
        textTitleDialogBuyCredit = dialogBuyCredit.findViewById(R.id.txtTitleDialogCredit);
        buttonOkDialogBuyCredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePresenterImp.onButtonOkDialogBuyCreditClick();
            }
        });

        buttonCancelDialogBuyCredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePresenterImp.onButtonCancelDialogBuyCreditClick();
            }
        });

        //
        txtScore = findViewById(R.id.txtScoreQuestion);
        this.imbUndo = findViewById(R.id.imbUndo);
        this.button5050 = findViewById(R.id.imbFiftyPercent);
        this.imbSupportAudience = findViewById(R.id.imbSupportAudience);
        this.imbCallPeople = findViewById(R.id.imbCallPeople);
        this.btnCredit = findViewById(R.id.btnCredit);
        // button điểm credit trên header
        this.buttonScoreCredit = findViewById(R.id.btnScoreCredit);
        // Image button mạng của người chơi

        //RingProgress
        mRingProgressBar = findViewById(R.id.ringProgress); // tìm cái ringProgressbar
        timeAnswer = findViewById(R.id.txtTimeAnswer); // tìm cái textview để trừ thời gian khi luồng của ringprogressbar
        mRingProgressBar.setOnProgressListener(this); // xét sự kiện khi cho ringProgressbar
        mRingProgressBar.setMax(10); // xét thời gian tối đa ringProgressbar sẽ được chạy tính bằng second
        mMaxProgress = mRingProgressBar.getMax(); // chỉ số của max ring hiện tại max của ring
//        mThreadCountdown = new RingProgressbarAsyntask(this, timeAnswer, mRingProgressBar, progress, mMaxProgress); // luồng xử lý việc bất đồng bộ của RingProgressbar countdown
//        mThreadCountdown.execute(); // thực thi RingProgressBar
        // tạo lớp đối tượng choosePresenter để gọi hàm xử lý gán câu hỏi cho màn hình
        choosePresenterImp = new ChoosePresenterImp(this, this);

//        btnOkDialog.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                choosePresenterImp.onButtonOkDialogAnswerClick();
//            }
//        });
//        btnOKUndoSupport.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                choosePresenterImp.onButtonOkSupportClick();
//            }
//        });
//        btnCancelSupportAnswer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                choosePresenterImp.onButtonCancelSupportClick();
//            }
//        });
    }

    @Override
    public void setQuesA(String text) {
        listButton.get(0).setText(text);
    }

    @Override
    public void setQuesB(String text) {
        listButton.get(1).setText(text);
    }

    @Override
    public void setQuesC(String text) {
        listButton.get(2).setText(text);
    }

    @Override
    public void setQuesD(String text) {
        listButton.get(3).setText(text);
    }

    @Override
    public void setTextQues(String text) {
        txtQuestion.setText(text);
    }

    @Override
    public void setTextCredit(String text) {
        btnCredit.setText(text);
    }

    @Override
    public String getTextA() {
        return listButton.get(0).getText().toString();
    }

    @Override
    public String getTextB() {
        return listButton.get(1).getText().toString();
    }

    @Override
    public String getTextC() {
        return listButton.get(2).getText().toString();
    }

    @Override
    public String getTextD() {
        return listButton.get(3).getText().toString();
    }

    @Override
    public String getTextCredit() {
        return btnCredit.getText().toString();
    }

    @Override
    public void setQuesId(int id) {

    }

    @Override
    public void setScore(String score) {
        txtScore.setText(score);
    }

    @Override
    public void showProcessLoadData() {
        progressBarLoadData.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProcessLoadData() {
        progressBarLoadData.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showLayoutContent() {
        layoutContent.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLayoutContent() {
        layoutContent.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setTextTitleDialog(String text) {
        textTitleDialogAnswer.setText(text);
    }

    @Override
    public void setTextTitleQuestionSupportDialog(String text) {
//        txtTitleQuestionSupport.setText(text);
    }

    @Override
    public void setTextContentQuestionSupportDialog(String text) {
//        txtContentQuestionSupport.setText(text);
    }

    @Override
    public void setTextTitleFiftyPercentSupportDialog(String text) {
//        txtTitleFiftyPercentSupport.setText(text);
    }

    @Override
    public void setTextContentFiftyPercentSupportDialog(String text) {
//        txtContentFiftyPercentSupport.setText(text);
    }

    @Override
    public void setAnswerTitleDialog(String text) {
//        txtAnswerCorrect.setText(text);
    }

    @Override
    public void hideDialogSupportAnswer() {
//        dialogFiftyPercentSupport.dismiss();
    }

    @Override
    public void showDialogQuestionSupport() {
//        dialogQuestion.show();
    }

    @Override
    public void setQuestionNumber(String number) {
        btnQuestionNumber.setText(number);
    }

    @Override
    public void showToastStringText(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show(); // text debug :))
    }

    @Override
    public void hiddenImageButtonSupportUndoQuestion() {
        imbUndo.setEnabled(false);
        imbUndo.setBackgroundColor(Color.parseColor("#3f3c3c"));
//        imbUndo.setImageResource(R.drawable.animation_button_gray);
    }

    @Override
    public void hiddenImageButtonFiftyPercentQuestion() {
        button5050.setEnabled(false);
        button5050.setBackgroundColor(Color.parseColor("#3f3c3c"));
    }

    @Override
    public void hiddenImageButtonSupportSupportAudiencesQuestion() {
        imbSupportAudience.setEnabled(false);
        imbSupportAudience.setBackgroundColor(Color.parseColor("#3f3c3c"));
    }

    @Override
    public void hiddenImageButtonSupportCallPeopleQuestion() {
        imbCallPeople.setEnabled(false);
        imbCallPeople.setBackgroundColor(Color.parseColor("#3f3c3c"));
    }

    @Override
    public void hiddenImageButtonSupportBuyQuestionByCredit() {
        btnCredit.setEnabled(false);
        btnCredit.setBackgroundColor(Color.parseColor("#3f3c3c"));
    }

    @Override
    public void startActivityBarChart() {
        Intent intent = new Intent(this, BarchartActivity.class);
        startActivity(intent);
    }

    @Override
    public void setBarChart(BarChart barchart) {
        this.barChart = barchart;
    }

    @Override
    public BarChart getBarChart() {
        return barChart;
    }

    @Override
    public void setListButton(ArrayList<Button> button) {
        this.listButton = button;
    }

    @Override
    public Button getListButton(int index) {
        return this.listButton.get(index);
    }

    @Override
    public int getIdButton(String string) {
        switch (string) {
            case "A": {
                return 0;
            }
            case "B": {
                return 1;
            }
            case "C": {
                return 2;
            }
            default: {
                return 3;
            }
        }
    }

    @Override
    public void hiddenButtonAnswer(Button button) {
        button.setEnabled(false);
        button.setBackgroundColor(Color.parseColor("#3f3c3c"));
    }

    @Override
    public void showButtonAnswer(Button button) {
        listButton.get(0).setEnabled(true);
        listButton.get(1).setEnabled(true);
        listButton.get(2).setEnabled(true);
        listButton.get(3).setEnabled(true);
        listButton.get(0).setBackgroundColor(Color.parseColor("#0090FF"));
        listButton.get(1).setBackgroundColor(Color.parseColor("#0090FF"));
        listButton.get(2).setBackgroundColor(Color.parseColor("#0090FF"));
        listButton.get(3).setBackgroundColor(Color.parseColor("#0090FF"));
    }

    @Override
    public void showDialogAnswer() {
        dialogAnswer.show();
    }

    @Override
    public void hideDialogAnswer() {
        dialogAnswer.dismiss();
    }

    @Override
    public void setTitleDialogAnswer(String text) {
        textTitleDialogAnswer.setText(text);
    }

    @Override
    public void setCorrectDialogAnswer(String text) {
        textCorectDialogAnswer.setText(text);
    }

    @Override
    public void showDialogRandom() {
        dialogRandom.show();
    }

    @Override
    public void hideDialogRandom() {
        dialogRandom.dismiss();
    }

    @Override
    public void setTitleDialogRandom(String text) {
        textTitleDialogRandom.setText(text);
    }

    @Override
    public void setContentDialogRandom(String text) {
        textContentDialogRandom.setText(text);
    }

    @Override
    public void showDialog5050() {
        dialog5050.show();
    }

    @Override
    public void hideDialog5050() {
        dialog5050.dismiss();
    }

    @Override
    public void setTitleDialog5050(String text) {
        textTitleDialog5050.setText(text);
    }

    @Override
    public void setContentDialog5050(String text) {
        textContentDialog5050.setText(text);
    }

    @Override
    public void showDialogCallPeople() {
        dialogCallPeople.show();
    }

    @Override
    public void hideDialogCallPeople() {
        dialogCallPeople.dismiss();
    }

    @Override
    public void setTitleDialogCallPeople(String text) {
        textTitleDialogCallPeople.setText(text);
    }

    @Override
    public void setContentDialogCallPeople(String text) {
        textContentDialogCallPeople.setText(text);
    }

    @Override
    public void showDialogBuyCredit() {
        dialogBuyCredit.show();
    }

    @Override
    public void hideDialogBuyCredit() {
        dialogBuyCredit.dismiss();
    }

    @Override
    public void setTitleDialogBuyCredit(String text) {
        textTitleDialogBuyCredit.setText(text);
    }

    @Override
    public void setContentDialogBuyCredit(String text) {
        textContentDialogBuyCredit.setText(text);
    }

    @Override
    public void setScoreButtonCredit(String text) {
        this.buttonScoreCredit.setText(text);
    }

    @Override
    public String getScoreButtonCredit() {
        return this.buttonScoreCredit.getText().toString();
    }

    @Override
    public int convertStringToIntCredit(String text) {
        return this.ScoreCredit = Integer.parseInt(text);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.A: {
                choosePresenterImp.onButtonAClick();
                break;
            }
            case R.id.B: {
                choosePresenterImp.onButtonBClick();
                break;
            }
            case R.id.C: {
                choosePresenterImp.onButtonCClick();
                break;
            }
            case R.id.D: {
                choosePresenterImp.onButtonDClick();
                break;
            }
            case R.id.imbUndo: {
                choosePresenterImp.onImageButtonUndoClick();
                break;
            }
            case R.id.imbFiftyPercent: {
                choosePresenterImp.onImageButton5050Click();
                break;
            }
            case R.id.imbSupportAudience: {
                choosePresenterImp.onImageButtonSupportAudiencesClick();
                break;
            }
            case R.id.imbCallPeople: {
                choosePresenterImp.onImageButtonCallPeopleClick();
                break;
            }
            case R.id.btnCredit: {
                choosePresenterImp.onImageButtonCreditClick();
                break;
            }
        }
    }
}

