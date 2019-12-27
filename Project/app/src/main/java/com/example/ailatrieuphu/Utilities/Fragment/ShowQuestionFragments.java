package com.example.ailatrieuphu.Utilities.Fragment;

import android.content.Context;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.ailatrieuphu.View.ChooseActivity;
import com.example.ailatrieuphu.Object.Question;
import com.example.ailatrieuphu.Object.User;
import com.example.ailatrieuphu.Utilities.Adapter.QuestionAdapter;

import java.util.List;

public class ShowQuestionFragments  extends Fragment{
    //
    private List<Question> questionList;
    private Question question;
    private QuestionAdapter questionAdapter;
    private ChooseActivity chooseActivity;
    private Button btnNumberQuestion;
    private Button btnAnswer;
    private User user;
    private boolean isCheck = false;

    public ShowQuestionFragments(List<Question> questionList, Fragment fragment, Context context, User user, QuestionAdapter questionAdapter) {
        this.questionList = questionList;
        this.questionAdapter = questionAdapter;
        this.chooseActivity = (ChooseActivity) context;
        this.user = user;
    }
}
