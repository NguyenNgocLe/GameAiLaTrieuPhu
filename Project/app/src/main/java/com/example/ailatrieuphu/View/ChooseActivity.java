
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

import io.netopen.hotbitmapgg.library.view.RingProgressBar;

public class ChooseActivity extends AppCompatActivity implements RingProgressBar.OnProgressListener,
        ChooseView,
        View.OnClickListener {
    private RingProgressBar mRingProgressBar;
    private int progress = 1, mMaxProgress;
    private RingProgressbarAsyntask mThreadCountdown;
    private TextView timeAnswer;
    //
    private Button btnA;
    private Button btnB;
    private Button btnC;
    private Button btnD;
    private ImageButton imbUndo;
    private ImageButton imbFiftyPercent;
    private ImageButton imbSupportAudience;
    private ImageButton imbCallPeople;
    private Button btnQuestionNumber;
    private Button btnCredit;
    private TextView txtQuestion;
    private TextView txtScore;
    private int[] mListIdQuestion;
    private ProgressBar progressBarLoadData;
    private View layoutContent;
    private Dialog dialogNotify;
    private Dialog dialogQuestion;
    private TextView txtTitleDialogNotify, txtAnswerCorrect, txtTitleQuestionSupport, txtContentQuestionSupport;
    private Button btnOkDialog, btnOKSupportAnswer, btnCancelSupportAnswer;
    //
    private ChoosePresenterImp choosePresenterImp;

    public ChooseActivity() {

    }

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
        btnQuestionNumber = findViewById(R.id.edtNumberQuestion);
        txtQuestion = findViewById(R.id.txtQuestion);
        btnA = findViewById(R.id.A);
        btnB = findViewById(R.id.B);
        btnC = findViewById(R.id.C);
        btnD = findViewById(R.id.D);
        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnD.setOnClickListener(this);
        this.imbUndo = findViewById(R.id.imbUndo);
        this.imbFiftyPercent = findViewById(R.id.imbFiftyPercent);
        this.imbSupportAudience = findViewById(R.id.imbSupportAudience);
        this.imbCallPeople = findViewById(R.id.imbCallPeople);
        this.btnCredit = findViewById(R.id.btnCredit);
        imbUndo.setOnClickListener(this);
        imbFiftyPercent.setOnClickListener(this);
        imbSupportAudience.setOnClickListener(this);
        imbCallPeople.setOnClickListener(this);
        btnCredit.setOnClickListener(this);
        dialogNotify = new Dialog(this);
        dialogNotify.setContentView(R.layout.notification);
        txtTitleDialogNotify = dialogNotify.findViewById(R.id.txtTitle);
        txtAnswerCorrect = dialogNotify.findViewById(R.id.txtContent);
        dialogQuestion = new Dialog(this);
        dialogQuestion.setContentView(R.layout.activity_custom_dialog_credit);
        txtTitleQuestionSupport = dialogQuestion.findViewById(R.id.txtTitle);
        txtContentQuestionSupport = dialogQuestion.findViewById(R.id.txtContent);
        btnOkDialog = dialogNotify.findViewById(R.id.btnOk);
        btnOKSupportAnswer = dialogQuestion.findViewById(R.id.btnOkSupportAnswer);
        btnCancelSupportAnswer = dialogQuestion.findViewById(R.id.btnCancelSupportAnswer);
        txtScore = findViewById(R.id.txtScoreQuestion);
        this.imbUndo = findViewById(R.id.imbUndo);
        this.imbFiftyPercent = findViewById(R.id.imbFiftyPercent);
        this.imbSupportAudience = findViewById(R.id.imbSupportAudience);
        this.imbCallPeople = findViewById(R.id.imbCallPeople);
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
        choosePresenterImp = new ChoosePresenterImp(this, this);

        btnOkDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePresenterImp.onButtonOkClick();
            }
        });
        btnOKSupportAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePresenterImp.onButtonOkSupportClick();
            }
        });
        btnCancelSupportAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePresenterImp.onButtonCancelSupportClick();
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
    public void setTextCredit(String text) {
        btnCredit.setText(text);
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
        txtTitleDialogNotify.setText(text);
    }

    @Override
    public void setTextTitleQuestionSupportDialog(String text) {
        txtTitleQuestionSupport.setText(text);
    }

    @Override
    public void setTextContentQuestionSupportDialog(String text) {
        txtContentQuestionSupport.setText(text);
    }

    @Override
    public void setAnswerTitleDialog(String text) {
        txtAnswerCorrect.setText(text);
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
    public void hideDialogSupportAnswer() {
        dialogQuestion.dismiss();
    }

    @Override
    public void showDialogQuestionSupport() {
        dialogQuestion.show();
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
        imbUndo.setVisibility(View.INVISIBLE);
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
                choosePresenterImp.onImageButtonFiftyPercentClick();
                break;
            }
            case R.id.imbSupportAudience: {
                choosePresenterImp.onImageButtonSupportAudiencesClick();
                break;
            }
            case R.id.imbCallPeople: {
                choosePresenterImp.onImageButtonCallPeopleClick();
                //Toast.makeText(this, "Button call people", Toast.LENGTH_SHORT).show();
            }
            default: {
                choosePresenterImp.onImageButtonCreditClick();
                break;
            }
        }
    }
}

