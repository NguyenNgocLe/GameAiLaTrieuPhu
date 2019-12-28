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
        if ("A".equals(model.getCurrentQuestion().getAnswer_correct())) {
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
        if ("B".equals(model.getCurrentQuestion().getAnswer_correct())) {
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
        if ("C".equals(model.getCurrentQuestion().getAnswer_correct())) {
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
        if ("D".equals(model.getCurrentQuestion().getAnswer_correct())) {
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
        callBack.setScore("Điểm: "+String.valueOf(model.getCurrentScore()));
        callBack.setQuestionNumber(String.valueOf(model.getCurrentQuestionNumber()));
        callBack.setTextQues(model.getCurrentQuestion().getQuestion());
        callBack.setQuesA(model.getCurrentQuestion().getAnswer_a());
        callBack.setQuesB(model.getCurrentQuestion().getAnswer_b());
        callBack.setQuesC(model.getCurrentQuestion().getAnswer_c());
        callBack.setQuesD(model.getCurrentQuestion().getAnswer_d());
        // hidden button support random question
    }

    @Override
    public void onButtonOkSupportClick() {
        callBack.hideDialogSupportAnswer();
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
    public void onButtonCancelSupportClick() {
        callBack.hideDialogSupportAnswer();
    }

    @Override
    public void onImageButtonUndoClick() {
        String title = "Bạn có muốn chuyển sang câu khác?";
        callBack.setTextTitleQuestionSupportDialog(title);
        String content = "Bạn chỉ được sử dụng quyền trợ giúp 1 lần!";
        callBack.setTextContentQuestionSupportDialog(content);
        callBack.showDialogQuestionSupport();
//        if () {
            hiddenButtonUndoClick();
//        }
    }

    @Override
    public void onImageButtonFiftyPercentClick() {
        String title = "Bạn có muốn sử dụng 50:50?";
        callBack.setTextTitleQuestionSupportDialog(title);
        String content = "Bạn chỉ được sử dụng quyền trợ giúp 1 lần!";
        callBack.setTextContentQuestionSupportDialog(content);
        callBack.showDialogQuestionSupport();
    }

    @Override
    public void onImageButtonSupportAudiencesClick() {
        String title = "Bạn có muốn hỏi ý kiến khán giả?";
        callBack.setTextTitleQuestionSupportDialog(title);
        String content = "Bạn chỉ được sử dụng quyền trợ giúp 1 lần!";
        callBack.setTextContentQuestionSupportDialog(content);
        callBack.showDialogQuestionSupport();
    }

    @Override
    public void onImageButtonCallPeopleClick() {
        String title = "Bạn có muốn gọi điện thoại cho người thân?";
        callBack.setTextTitleQuestionSupportDialog(title);
        String content = "Bạn chỉ được sử dụng quyền trợ giúp 1 lần!";
        callBack.setTextContentQuestionSupportDialog(content);
        callBack.showDialogQuestionSupport();
    }

    @Override
    public void onImageButtonCreditClick() {
        String title = "Bạn có muốn sử dụng credit mua câu hỏi?";
        callBack.setTextTitleQuestionSupportDialog(title);
        String content = "Bạn được sử dụng quyền trợ giúp nhiều lần!";
        callBack.setTextContentQuestionSupportDialog(content);
        callBack.showDialogQuestionSupport();
    }

    @Override
    public void hiddenButtonUndoClick() {
        callBack.hiddenImageButtonSupportUndoQuestion();
    }

    @Override
    public void hiddenButtonFiftyPercentClick() {

    }

    @Override
    public void hiddenButtonSupportAudiences() {

    }

    @Override
    public void hiddenButtonCallPeople() {

    }

    @Override
    public void showButtonUndoClick() {

    }

    @Override
    public void showButtonFiftyPercentClick() {

    }

    @Override
    public void showButtonSupportAudiences() {

    }

    @Override
    public void showButtonCallPeople() {

    }
}
