package com.example.ailatrieuphu.PresenterImp;

import android.content.Context;

import com.example.ailatrieuphu.Model.QuestionModel;
import com.example.ailatrieuphu.Object.User;

public class QuestionPresenterImp {
    public QuestionPresenterImp(QuestionModel questionModel, Context context, User nguoi_dung) {
        this.questionModel = questionModel;
        this.context = context;
        this.nguoi_dung = nguoi_dung;
    }

    private QuestionModel questionModel;
    private Context context;
    User nguoi_dung;

    public QuestionPresenterImp() {

    }

    public void loadDataField() {
        questionModel = new QuestionModel();
        //nguoi_dung = new User();
        questionModel.handlingDataField(context);
    }
}
