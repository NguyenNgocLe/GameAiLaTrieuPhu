package com.example.ailatrieuphu.PresenterImp.ChoosePresenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.ailatrieuphu.Model.ChooseModel;
import com.example.ailatrieuphu.Object.Question;
import com.example.ailatrieuphu.Utilities.Api.NetworkUtils;
import com.example.ailatrieuphu.View.ChooseView;

import org.json.JSONException;
import org.json.JSONObject;

public class ChoosePresenterImp implements ChoosePresenter {
    private ChooseModel model;
    private ChooseView callBack;

    public ChoosePresenterImp(Context context, ChooseView callBack) {
        model = new ChooseModel(context);
        this.callBack = callBack;
    }

    // cần load câu hỏi lên layout và random câu hỏi theo lĩnh vực đó
    @Override
    @SuppressLint("StaticFieldLeak")
    public void handlingGetQuestionByCategoryField() {
        (new AsyncTask<String, Void, String>(

        ) {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                callBack.hideLayoutContent();
                callBack.showProcessLoadData();
            }

            @Override
            protected String doInBackground(String... strings) {
                return NetworkUtils.getJSONData(NetworkUtils.FIELD_URL + model.getCategoryId()
                        , NetworkUtils.GET,
                        null);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                callBack.showLayoutContent();
                callBack.hideProcessLoadData();
                try {
                    model.setQuestions(Question.getArrQuestionFromJson(new JSONObject(s)));
                    Log.e("json-err", "size data: " + model.getQuestions().size());
                    model.setCurrentQuestion(model.getQuestions().get(0));
                    callBack.setTextQues(model.getCurrentQuestion().getQuestion());
                    callBack.setScore(String.valueOf(model.getCurrentScore()));
                    callBack.setQuestionNumber(String.valueOf(model.getCurrentQuestionNumber()));
                    callBack.setQuesA(model.getCurrentQuestion().getAnswer_a());
                    callBack.setQuesB(model.getCurrentQuestion().getAnswer_b());
                    callBack.setQuesC(model.getCurrentQuestion().getAnswer_c());
                    callBack.setQuesD(model.getCurrentQuestion().getAnswer_d());
                    callBack.setQuesId(model.getCurrentQuestionNumber());
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.e("json-err", e + "");
                }
            }
        }).execute();
    }

    @Override
    public void onButtonAClick() {
        String title = "";
        if (callBack.getTextA().toLowerCase().equals(model.getCurrentQuestion().getAnswer_correct())) {
            title = "Câu trả lời chính xác!";
            model.setCurrentScore(model.getCurrentScore() + 1);
        } else {
            title = "Sai rồi!";
        }
        model.getQuestions().remove(model.getCurrentQuestion());
        callBack.setTextTitleDialog(title);
        callBack.setAnswerTitleDialog("A");
        callBack.showDialogAnswer();
    }

    @Override
    public void onButtonBClick() {
        String title = "";
        if (callBack.getTextB().toLowerCase().equals(model.getCurrentQuestion().getAnswer_correct())) {
            title = "Câu trả lời chính xác!";
            model.setCurrentScore(model.getCurrentScore() + 1);
        } else {
            title = "Sai rồi!";
        }
        model.getQuestions().remove(model.getCurrentQuestion());
        callBack.setTextTitleDialog(title);
        callBack.setAnswerTitleDialog("B");
        callBack.showDialogAnswer();
    }

    @Override
    public void onButtonCClick() {
        String title = "";
        if (callBack.getTextC().toLowerCase().equals(model.getCurrentQuestion().getAnswer_correct())) {
            title = "Câu trả lời chính xác!";
            model.setCurrentScore(model.getCurrentScore() + 1);
        } else {
            title = "Sai rồi!";
        }
        model.getQuestions().remove(model.getCurrentQuestion());
        callBack.setTextTitleDialog(title);
        callBack.setAnswerTitleDialog("C");
        callBack.showDialogAnswer();
    }

    @Override
    public void onButtonDClick() {
        String title = "";
        if (callBack.getTextD().toLowerCase().equals(model.getCurrentQuestion().getAnswer_correct())) {
            title = "Câu trả lời chính xác!";
            model.setCurrentScore(model.getCurrentScore() + 1); // tang diem
        } else {
            title = "Sai rồi!";
        }
        model.getQuestions().remove(model.getCurrentQuestion()); //xoa cau hoi da choi
        callBack.setTextTitleDialog(title);
        callBack.setAnswerTitleDialog("D");
        callBack.showDialogAnswer();
    }

    @Override
    public void onButtonOkClick() {
        callBack.hideDialogAnswer();
        model.setCurrentQuestion(model.getRandomQuestion());
        model.setCurrentQuestionNumber(model.getCurrentQuestionNumber() + 1);
        callBack.setScore(String.valueOf(model.getCurrentScore()));
        callBack.setQuestionNumber(String.valueOf(model.getCurrentQuestionNumber()));
        callBack.setTextQues(model.getCurrentQuestion().getQuestion());
        callBack.setQuesA(model.getCurrentQuestion().getAnswer_a());
        callBack.setQuesB(model.getCurrentQuestion().getAnswer_b());
        callBack.setQuesC(model.getCurrentQuestion().getAnswer_c());
        callBack.setQuesD(model.getCurrentQuestion().getAnswer_d());
    }

    @Override
    public void onImageButtonUndoClick() {
        // set custom dialog button undo
        String title = "Bạn có muốn chuyển sang câu khác?";
        callBack.setTextTitleQuestionSupportDialog(title);
        String content = "OK hơm!";
        callBack.setTextContentQuestionSupportDialog(content);
        callBack.showDialogQuestionSupport();
    }

    @Override
    public void onImageButtonFiftyPercentClick() {

    }

    @Override
    public void onImageButtonSupportAudiencesClick() {

    }

    @Override
    public void onImageButtonCallPeopleClick() {

    }

    @Override
    public void onImageButtonCreditClick() {

    }
}
