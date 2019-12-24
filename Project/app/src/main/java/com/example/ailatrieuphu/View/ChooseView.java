package com.example.ailatrieuphu.View;

public interface ChooseView {
    void setQuesA(String text);
    void setQuesB(String text);
    void setQuesC(String text);
    void setQuesD(String text);
    void setTextQues(String text);
    String getTextA();
    String getTextB();
    String getTextC();
    String getTextD();
    void setQuesId(int id);
    void setScore(String score);
    void showProcessLoadData();
    void hideProcessLoadData();
    void showLayoutContent();
    void hideLayoutContent();
    void setTextTitleDialog(String text);
    void setAnswerTitleDialog(String text);
    void showDialogAnswer();
    void hideDialogAnswer();
    void setQuestionNumber(String number);
}
