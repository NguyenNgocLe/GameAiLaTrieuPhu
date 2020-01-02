package com.example.ailatrieuphu.View;

import android.widget.Button;

import com.github.mikephil.charting.charts.BarChart;

import java.util.ArrayList;

public interface ChooseView {
    void setQuesA(String text);
    void setQuesB(String text);
    void setQuesC(String text);
    void setQuesD(String text);
    void setTextQues(String text);
    void setTextCredit(String text);
    String getTextA();
    String getTextB();
    String getTextC();
    String getTextD();
    String getTextCredit();
    void setQuesId(int id);
    void setScore(String score);
    void showProcessLoadData();
    void hideProcessLoadData();
    void showLayoutContent();
    void hideLayoutContent();
    void setTextTitleDialog(String text);
    void setTextTitleQuestionSupportDialog(String text);
    void setTextContentQuestionSupportDialog(String text);
    void setTextTitleFiftyPercentSupportDialog(String text);
    void setTextContentFiftyPercentSupportDialog(String text);
    void setAnswerTitleDialog(String text);
    void hideDialogSupportAnswer();
    void showDialogQuestionSupport();
    void setQuestionNumber(String number);
    void showToastStringText(String text);
    void hiddenImageButtonSupportUndoQuestion();
    void hiddenImageButtonFiftyPercentQuestion();
    void hiddenImageButtonSupportSupportAudiencesQuestion();
    void hiddenImageButtonSupportCallPeopleQuestion();
    void hiddenImageButtonSupportBuyQuestionByCredit();
    void startActivityBarChart();
    void setBarChart(BarChart barchart);
    BarChart getBarChart();
    void setListButton(ArrayList<Button>button);
    Button getListButton(int index);
    int getIdButton(String string);
    void hiddenButtonAnswer(Button button);
    void showButtonAnswer(Button button);

    //dialog answer
    void showDialogAnswer();
    void hideDialogAnswer();
    void setTitleDialogAnswer(String text);
    void setCorrectDialogAnswer(String text);

    //dialog random
    void showDialogRandom();
    void hideDialogRandom();
    void setTitleDialogRandom(String text);
    void setContentDialogRandom(String text);

    //dialog 5050
    void showDialog5050();
    void hideDialog5050();
    void setTitleDialog5050(String text);
    void setContentDialog5050(String text);

    //dialog call people
    void showDialogCallPeople();
    void hideDialogCallPeople();
    void setTitleDialogCallPeople(String text);
    void setContentDialogCallPeople(String text);

    //dialog Buy credit
    void showDialogBuyCredit();
    void hideDialogBuyCredit();
    void setTitleDialogBuyCredit(String text);
    void setContentDialogBuyCredit(String text);

    // button score credit
    void setScoreButtonCredit(String text);
    String getScoreButtonCredit();
    int convertStringToIntCredit(String text);
}
