
package com.example.ailatrieuphu.Controller;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ailatrieuphu.Model.ChooseModel;
import com.example.ailatrieuphu.PresenterImp.ChoosePresenterImp;
import com.example.ailatrieuphu.R;
import com.example.ailatrieuphu.Utilities.RingProgressbarAsyntask;

import org.json.JSONObject;

import io.netopen.hotbitmapgg.library.view.RingProgressBar;

public class ChooseActivity extends AppCompatActivity implements RingProgressBar.OnProgressListener {
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
    private TextView txtQuestion;
    private TextView txtScore;
    private int[] mListIdQuestion;
    private int categoryId;
    //
    private ChooseModel chooseModel;
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
        choosePresenterImp.handlingGetQuestionByCategoryField(this);
    }

    // hết thời gian thì sẽ hoàn tất và xử lý việc gì đó ví dụ trừ mạng.
    @Override
    public void progressToComplete() {
        Toast.makeText(this, "Hoàn tất!", Toast.LENGTH_SHORT).show();
    }

    public void InitialView() {

        // ánh xạ chọn câu hỏi
        txtQuestion = findViewById(R.id.txtQuestion);
        btnA = findViewById(R.id.A);
        btnB = findViewById(R.id.B);
        btnC = findViewById(R.id.C);
        btnD = findViewById(R.id.D);
        btnQuestion = findViewById(R.id.edtNumberQuestion);
        txtQuestion = findViewById(R.id.txtScoreQuestion);
        //RingProgress
        mRingProgressBar = findViewById(R.id.ringProgress); // tìm cái ringProgressbar
        timeAnswer = findViewById(R.id.txtTimeAnswer); // tìm cái textview để trừ thời gian khi luồng của ringprogressbar
        mRingProgressBar.setOnProgressListener(this); // xét sự kiện khi cho ringProgressbar
        mRingProgressBar.setMax(10); // xét thời gian tối đa ringProgressbar sẽ được chạy tính bằng second
        mMaxProgress = mRingProgressBar.getMax();// chỉ số của max ring hiện tại max của ring
        mThreadCountdown = new RingProgressbarAsyntask(this, timeAnswer, mRingProgressBar, progress, mMaxProgress); // luồng xử lý việc bất đồng bộ của RingProgressbar countdown
        mThreadCountdown.execute(); // thực thi RingProgressBar
        // tạo lớp đối tượng choosePresenter để gọi hàm xử lý gán câu hỏi cho màn hình
        choosePresenterImp = new ChoosePresenterImp(this);
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public Button getBtnA() {
        return btnA;
    }

    public void setBtnA(Button btnA) {
        this.btnA = btnA;
    }

    public Button getBtnB() {
        return btnB;
    }

    public void setBtnB(Button btnB) {
        this.btnB = btnB;
    }

    public Button getBtnC() {
        return btnC;
    }

    public void setBtnC(Button btnC) {
        this.btnC = btnC;
    }

    public Button getBtnD() {
        return btnD;
    }

    public void setBtnD(Button btnD) {
        this.btnD = btnD;
    }

    public int[] getmListIdQuestion() {
        return mListIdQuestion;
    }

    public void setmListIdQuestion(int[] mListIdQuestion) {
        this.mListIdQuestion = mListIdQuestion;
    }

    public TextView getTxtQuestion() {
        return txtQuestion;
    }

    public void setTxtQuestion(TextView txtQuestion) {
        this.txtQuestion = txtQuestion;
    }

    public Button getBtnQuestion() {
        return btnQuestion;
    }

    public void setBtnQuestion(Button btnQuestion) {
        this.btnQuestion = btnQuestion;
    }

    public TextView getTxtScore() {
        return txtScore;
    }

    public void setTxtScore(TextView txtScore) {
        this.txtScore = txtScore;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public ChooseModel getChooseModel() {
        return chooseModel;
    }

    public void setChooseModel(ChooseModel chooseModel) {
        this.chooseModel = chooseModel;
    }

    public ChoosePresenterImp getChoosePresenterImp() {
        return choosePresenterImp;
    }

    public void setChoosePresenterImp(ChoosePresenterImp choosePresenterImp) {
        this.choosePresenterImp = choosePresenterImp;
    }
}

