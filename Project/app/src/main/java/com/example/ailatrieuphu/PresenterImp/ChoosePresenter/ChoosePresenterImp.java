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
                    callBack.setScore("Điểm:" + String.valueOf(model.getCurrentScore()));
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
        callBack.setAnswerTitleDialog("Đáp án đúng là: " + model.getCurrentQuestion().getAnswer_correct());
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
        callBack.setAnswerTitleDialog("Đáp án đúng là: " + model.getCurrentQuestion().getAnswer_correct());
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
        callBack.setAnswerTitleDialog("Đáp án đúng là: " + model.getCurrentQuestion().getAnswer_correct());
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
        callBack.setAnswerTitleDialog("Đáp án đúng là: " + model.getCurrentQuestion().getAnswer_correct());
        callBack.showDialogAnswer();
    }

    @Override
    public void onButtonOkDialogAnswerClick() {
        callBack.hideDialogAnswer();
        model.setCurrentQuestion(model.getRandomQuestion());
        model.setCurrentQuestionNumber(model.getCurrentQuestionNumber() + 1);
        callBack.setScore("Điểm: " + String.valueOf(model.getCurrentScore()));
        callBack.setQuestionNumber(String.valueOf(model.getCurrentQuestionNumber()));
        callBack.setTextQues(model.getCurrentQuestion().getQuestion());
        callBack.setQuesA(model.getCurrentQuestion().getAnswer_a());
        callBack.setQuesB(model.getCurrentQuestion().getAnswer_b());
        callBack.setQuesC(model.getCurrentQuestion().getAnswer_c());
        callBack.setQuesD(model.getCurrentQuestion().getAnswer_d());
        callBack.showButtonAnswer(callBack.getListButton(0)); // set lai text mau xanh cho button
        callBack.showButtonAnswer(callBack.getListButton(1)); // khi su dung quyen 50/50 bi boi den
        callBack.showButtonAnswer(callBack.getListButton(2));
        callBack.showButtonAnswer(callBack.getListButton(3));
    }

    @Override
    public void onButtonOkSupportClick() {
        callBack.hideDialogSupportAnswer();
        model.setCurrentQuestion(model.getRandomQuestion());
        model.setCurrentQuestionNumber(model.getCurrentQuestionNumber() + 1);
        callBack.setScore("Điểm:" + String.valueOf(model.getCurrentScore()));
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
        callBack.setTitleDialogRandom("Bạn có muốn chuyển sang câu khác?");
        callBack.setContentDialogRandom("Bạn chỉ được sử dụng quyền trợ giúp 1 lần!");
        callBack.showDialogRandom();
        hiddenButtonUndoClick();
    }

    @Override
    public void onImageButton5050Click() {
        String title = "Bạn có muốn sử dụng 50:50?";
        callBack.setTitleDialog5050(title);
        String content = "Bạn chỉ được sử dụng quyền trợ giúp 1 lần!";
        callBack.setContentDialog5050(content);
        callBack.showDialog5050();
    }

    @Override
    public void onImageButtonSupportAudiencesClick() {
        String title = "Bạn có muốn hỏi ý kiến khán giả?";
        String content = "Bạn chỉ được sử dụng quyền trợ giúp 1 lần!";
        callBack.setTextTitleQuestionSupportDialog(title);
        callBack.setTextContentQuestionSupportDialog(content);
        callBack.showDialogQuestionSupport();
        callBack.startActivityBarChart();
        try {
            Thread.sleep(1000);
            hiddenButtonSupportAudiences();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onImageButtonCallPeopleClick() {
        String title = "Bạn có muốn sử dụng gọi điện thoại cho người thân?";
        callBack.setTitleDialogCallPeople(title);
        String content = "Bạn chỉ được sử dụng quyền trợ giúp 1 lần!";
        callBack.setContentDialogCallPeople(content);
        callBack.showDialogCallPeople();
    }

    @Override
    public void onImageButtonCreditClick() {
        String title = "Bạn có muốn sử dụng credit mua câu hỏi?";
        callBack.setTitleDialogBuyCredit(title);
        String content = "Bạn được sử dụng quyền trợ giúp này nhiều lần!";
        callBack.setContentDialogBuyCredit(content);
        callBack.showDialogBuyCredit();
    }

    @Override
    public void hiddenButtonUndoClick() {
        callBack.hiddenImageButtonSupportUndoQuestion();
    }

    @Override
    public void hiddenButtonFiftyPercentClick() {
        callBack.hiddenImageButtonFiftyPercentQuestion();
    }

    @Override
    public void hiddenButtonSupportAudiences() {
        callBack.hiddenImageButtonSupportSupportAudiencesQuestion();
    }

    @Override
    public void hiddenButtonCallPeople() {
        callBack.hiddenImageButtonSupportCallPeopleQuestion();
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

    @Override
    public void onButtonOkDialogRandomClick() { // random cau hoi khac
        callBack.hideDialogRandom();
        model.setCurrentQuestion(model.getRandomQuestion());
        model.setCurrentQuestionNumber(model.getCurrentQuestionNumber() + 1);
        callBack.setScore("Điểm: " + model.getCurrentScore());
        callBack.setQuestionNumber(String.valueOf(model.getCurrentQuestionNumber()));
        callBack.setTextQues(model.getCurrentQuestion().getQuestion());
        callBack.setQuesA(model.getCurrentQuestion().getAnswer_a());
        callBack.setQuesB(model.getCurrentQuestion().getAnswer_b());
        callBack.setQuesC(model.getCurrentQuestion().getAnswer_c());
        callBack.setQuesD(model.getCurrentQuestion().getAnswer_d());
    }

    @Override
    public void onButtonCancelDialogRandomClick() {
        callBack.hideDialogRandom();
    }

    @Override
    public void onButtonOkDialog5050Click() {
        // xử lý bỏ 2 câu đáp án sai
        if (callBack.getIdButton(model.getCurrentQuestion().getAnswer_correct()) > 1) {
            // disible button 0,1
            callBack.hiddenButtonAnswer(callBack.getListButton(0));
            callBack.hiddenButtonAnswer(callBack.getListButton(1));
        } else {
            // disible button 2,3
            callBack.hiddenButtonAnswer(callBack.getListButton(2));
            callBack.hiddenButtonAnswer(callBack.getListButton(3));
        }
        callBack.hideDialog5050();
        hiddenButtonFiftyPercentClick();
    }

    @Override
    public void onButtonCancelDialog5050Click() {
        callBack.hideDialog5050();
    }

    @Override
    public void onButtonOkDialogCallPeopleClick() {
        String title = "Thầy Tuấn bảo đáp án đúng là:";
        callBack.setTitleDialogCallPeople(title);
        String answerContent = model.getCurrentQuestion().getAnswer_correct();
        callBack.setContentDialogCallPeople(answerContent);
        callBack.showDialogCallPeople();
        hiddenButtonCallPeople();
        // cần xử lý đổi lại dialog thông báo
    }

    @Override
    public void onButtonCancelDialogCallPeopleClick() {
        callBack.hideDialogCallPeople();
    }

    @Override
    public void onButtonOkDialogBuyCreditClick() {
        String scr = callBack.getScoreButtonCredit();
        int result = 5000;
        if (result == 0) {
            callBack.showToastStringText("Bạn đã hết credit!. Vui lòng mua thêm credit rồi tiếp tục sử dụng quyền trợ giúp!");
        } else {
            result -= 100;
            callBack.setScoreButtonCredit(result + "");
            model.setCurrentQuestion(model.getRandomQuestion());
            model.setCurrentQuestionNumber(model.getCurrentQuestionNumber() + 1);
            callBack.setScore("Điểm: " + model.getCurrentScore());
            callBack.setQuestionNumber(String.valueOf(model.getCurrentQuestionNumber()));
            callBack.setTextQues(model.getCurrentQuestion().getQuestion());
            callBack.setQuesA(model.getCurrentQuestion().getAnswer_a());
            callBack.setQuesB(model.getCurrentQuestion().getAnswer_b());
            callBack.setQuesC(model.getCurrentQuestion().getAnswer_c());
            callBack.setQuesD(model.getCurrentQuestion().getAnswer_d());
        }
        // DANG LAM TOI DAY
    }

    @Override
    public void onButtonCancelDialogBuyCreditClick() {
        callBack.hideDialogBuyCredit();
    }
}
