
package com.example.ailatrieuphu.Controller;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ailatrieuphu.R;
import com.example.ailatrieuphu.Utilities.RingProgressbarAsyntask;

import io.netopen.hotbitmapgg.library.view.RingProgressBar;

public class ChooseActivity extends AppCompatActivity implements RingProgressBar.OnProgressListener {

    private RingProgressBar mRingProgressBar;
    private int progress = 1, mMaxProgress;
    private RingProgressbarAsyntask mThreadCountdown;
    private TextView timeAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_answer);
        //
        InitiView();
    }

    // hết thời gian thì sẽ hoàn tất và xử lý việc gì đó ví dụ trừ mạng.
    @Override
    public void progressToComplete() {
        Toast.makeText(this, "Hoàn tất!", Toast.LENGTH_SHORT).show();

    }

    public void InitiView() {
        //RingProgress
        mRingProgressBar = findViewById(R.id.ringProgress); // tìm cái ringProgressbar
        timeAnswer = findViewById(R.id.txtTimeAnswer); // tìm cái textview để trừ thời gian khi luồng của ringprogressbar
        mRingProgressBar.setOnProgressListener(this); // xét sự kiện khi cho ringProgressbar
        mRingProgressBar.setMax(10); // xét thời gian tối đa ringProgressbar sẽ được chạy tính bằng second
        mMaxProgress = mRingProgressBar.getMax();// chỉ số của max ring hiện tại max của ring
        mThreadCountdown = new RingProgressbarAsyntask(this, timeAnswer, mRingProgressBar, progress, mMaxProgress); // luồng xử lý việc bất đồng bộ của RingProgressbar countdown
        mThreadCountdown.execute(); // thực thi RingProgressBar
    }

}
