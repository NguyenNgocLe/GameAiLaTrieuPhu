package com.example.ailatrieuphu.View;

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
    void setAnswerTitleDialog(String text);
    void showDialogAnswer();
    void hideDialogAnswer();
    void hideDialogSupportAnswer();
    void showDialogQuestionSupport();
    void setQuestionNumber(String number);
    void showToastStringText(String text);
    void hiddenImageButtonSupportUndoQuestion();
    void hiddenImageButtonFiftyPercentQuestion();
    void hiddenImageButtonSupportSupportAudiencesQuestion();
    void hiddenImageButtonSupportCallPeopleQuestion();
    void hiddenImageButtonSupportBuyQuestionByCredit();
}
