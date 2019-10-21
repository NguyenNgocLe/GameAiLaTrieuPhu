package com.example.ailatrieuphu.MainActivity.Model;

import android.widget.Button;

public class MainModel {
    private Button ManageAccount, NewGame, HistoryPlay, RankScore, BuyCredit;

    public MainModel(){

    }

    public Button getNewGame() {
        return NewGame;
    }

    public void setNewGame(Button newGame) {
        NewGame = newGame;
    }

    public Button getManageAccount() {
        return ManageAccount;
    }

    public void setManageAccount(Button manageAccount) {
        ManageAccount = manageAccount;
    }

    public Button getHistoryPlay() {
        return HistoryPlay;
    }

    public void setHistoryPlay(Button historyPlay) {
        HistoryPlay = historyPlay;
    }

    public Button getRankScore() {
        return RankScore;
    }

    public void setRankScore(Button rankScore) {
        RankScore = rankScore;
    }

    public Button getBuyCredit() {
        return BuyCredit;
    }

    public void setBuyCredit(Button buyCredit) {
        BuyCredit = buyCredit;
    }
}
