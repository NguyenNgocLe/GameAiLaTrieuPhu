
package com.example.ailatrieuphu.View;

import android.annotation.SuppressLint;
import android.app.Dialog;
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
import com.example.ailatrieuphu.Utilities.RingProgressbarAsyntask;

import org.json.JSONObject;

import io.netopen.hotbitmapgg.library.view.RingProgressBar;

public class ChooseActivity extends AppCompatActivity implements RingProgressBar.OnProgressListener,
        ChooseView,
        View.OnClickListener{
    private RingProgressBar mRingProgressBar;
    private int progress = 1, mMaxProgress;
    private RingProgressbarAsyntask mThreadCountdown;
    private TextView timeAnswer;
    //
    private JSONObject jsonObject;
    private Button btnA;
    private Button btnB;
    private Button btnC;
    private Button btnD;
    private Button btnQuestion;
    private ImageButton btnUndo;
    private ImageButton btnFiftyPercent;
    private ImageButton btnSupportAudience;
    private ImageButton btnCallPeople;
    private Button buttonQuestionNumber;
    private Button btnCredit;
    private TextView txtQuestion;
    private TextView txtScore;
    private int[] mListIdQuestion;
    private int categoryId;
    private ProgressBar progressBarLoadData;
    private View layoutContent;
    private Dialog dialogNotify;
    private TextView titleDialogNotify, answerCorect;
    private Button buttonOkDialog;
    //
    private ChoosePresenterImp choosePresenterImp;

    //
    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_answer);
        //
        InitialView();
//        Intent intent = getIntent();
//        if (intent != null) {
//            categoryId = intent.getIntExtra("id", 1);
//        }
        choosePresenterImp.handlingGetQuestionByCategoryField();
    }

    @Override
    public void progressToComplete() {
        Toast.makeText(this, "Hoàn tất!", Toast.LENGTH_SHORT).show();
    }

    public void InitialView() {
        layoutContent = findViewById(R.id.contentLayout);
        progressBarLoadData = findViewById(R.id.process_loadData);
        buttonQuestionNumber = findViewById(R.id.edtNumberQuestion);
        txtQuestion = findViewById(R.id.txtQuestion);
        btnA = findViewById(R.id.A);
        btnB = findViewById(R.id.B);
        btnC = findViewById(R.id.C);
        btnD = findViewById(R.id.D);
        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnD.setOnClickListener(this);
        dialogNotify = new Dialog(this);
        dialogNotify.setContentView(R.layout.thong_bao);
        titleDialogNotify = dialogNotify.findViewById(R.id.txtTitle);
        answerCorect = dialogNotify.findViewById(R.id.txtContent);
        buttonOkDialog = dialogNotify.findViewById(R.id.btnOk);
        txtScore = findViewById(R.id.txtScoreQuestion);
        this.btnUndo = findViewById(R.id.btnUndo);
        this.btnFiftyPercent = findViewById(R.id.btnFiftyPercent);
        this.btnSupportAudience = findViewById(R.id.btnSupportAudience);
        this.btnCallPeople = findViewById(R.id.btnCallPeople);
        this.btnCredit = findViewById(R.id.btnCredit);
        //RingProgress
        mRingProgressBar = findViewById(R.id.ringProgress); // tìm cái ringProgressbar
        timeAnswer = findViewById(R.id.txtTimeAnswer); // tìm cái textview để trừ thời gian khi luồng của ringprogressbar
        mRingProgressBar.setOnProgressListener(this); // xét sự kiện khi cho ringProgressbar
        mRingProgressBar.setMax(10); // xét thời gian tối đa ringProgressbar sẽ được chạy tính bằng second
        mMaxProgress = mRingProgressBar.getMax(); // chỉ số của max ring hiện tại max của ring
//        mThreadCountdown = new RingProgressbarAsyntask(this, timeAnswer, mRingProgressBar, progress, mMaxProgress); // luồng xử lý việc bất đồng bộ của RingProgressbar countdown
//        mThreadCountdown.execute(); // thực thi RingProgressBar
        // tạo lớp đối tượng choosePresenter để gọi hàm xử lý gán câu hỏi cho màn hình
        choosePresenterImp = new ChoosePresenterImp(this,this);

        buttonOkDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePresenterImp.onButtonOkClick();
            }
        });

    }


    @Override
    public void setQuesA(String text) {
        btnA.setText(text);
    }

    @Override
    public void setQuesB(String text) {
        btnB.setText(text);
    }

    @Override
    public void setQuesC(String text) {
        btnC.setText(text);
    }

    @Override
    public void setQuesD(String text) {
        btnD.setText(text);
    }

    @Override
    public void setTextQues(String text) {
        txtQuestion.setText(text);
    }

    @Override
    public String getTextA() {
        return btnA.getText().toString();
    }

    @Override
    public String getTextB() {
        return btnB.getText().toString();
    }

    @Override
    public String getTextC() {
        return btnC.getText().toString();
    }

    @Override
    public String getTextD() {
        return btnD.getText().toString();
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
        titleDialogNotify.setText(text);
    }

    @Override
    public void setAnswerTitleDialog(String text) {
        answerCorect.setText(text);
    }

    @Override
    public void showDialogAnswer() {
        dialogNotify.show();
    }

    @Override
    public void hideDialogAnswer() {
        dialogNotify.dismiss();
    }

    @Override
    public void setQuestionNumber(String number) {
        buttonQuestionNumber.setText(number);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.A:{
                choosePresenterImp.onButtonAClick();
                break;
            }
            case R.id.B:{
                choosePresenterImp.onButtonBClick();
                break;
            }
            case R.id.C:{
                choosePresenterImp.onButtonCClick();
                break;
            }
            case R.id.D:{
                choosePresenterImp.onButtonDClick();
                break;
            }
        }
    }
}

