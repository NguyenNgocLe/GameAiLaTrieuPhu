package com.example.ailatrieuphu.PresenterImp.ChoosePresenter;

public interface ChoosePresenter {
    void handlingGetQuestionByCategoryField();
    void onButtonAClick();
    void onButtonBClick();
    void onButtonCClick();
    void onButtonDClick();
    void onButtonOkDialogAnswerClick();
    void onImageButtonUndoClick();
    void onImageButton5050Click();
    void onImageButtonSupportAudiencesClick();
    void onImageButtonCallPeopleClick();
    void onImageButtonCreditClick();
    //
    void hiddenButtonUndoClick();
    void hiddenButtonFiftyPercentClick();
    void hiddenButtonSupportAudiences();
    void hiddenButtonCallPeople();
    void showButtonUndoClick();
    void showButtonFiftyPercentClick();
    void showButtonSupportAudiences();
    void showButtonCallPeople();
    void onButtonOkSupportClick();
    void onButtonCancelSupportClick();

    //dialog random
    void onButtonOkDialogRandomClick();
    void onButtonCancelDialogRandomClick();

    //dialog 5050
    void onButtonOkDialog5050Click();
    void onButtonCancelDialog5050Click();

    //dialog call people
    void onButtonOkDialogCallPeopleClick();
    void onButtonCancelDialogCallPeopleClick();

    //dialog BuyCredit
    void onButtonOkDialogBuyCreditClick();
    void onButtonCancelDialogBuyCreditClick();
    //
}
