package com.example.ailatrieuphu.BuyCredit.Model;

public class BuyModel {
    private String fiftyThousand, threeThousand, oneThousand, fiveHundred;

    public BuyModel(){

    }

    public BuyModel(String fiftyThousand, String threeThousand, String oneThousand, String fiveHundred){

        this.fiftyThousand = fiftyThousand;
        this.threeThousand = threeThousand;
        this.oneThousand = oneThousand;
        this.fiveHundred = fiveHundred;
    }

    public String getFiftyThousand() {
        return fiftyThousand;
    }

    public void setFiftyThousand(String fiftyThousand) {
        this.fiftyThousand = fiftyThousand;
    }

    public String getThreeThousand() {
        return threeThousand;
    }

    public void setThreeThousand(String threeThousand) {
        this.threeThousand = threeThousand;
    }

    public String getOneThousand() {
        return oneThousand;
    }

    public void setOneThousand(String oneThousand) {
        this.oneThousand = oneThousand;
    }

    public String getFiveHundred() {
        return fiveHundred;
    }

    public void setFiveHundred(String fiveHundred) {
        this.fiveHundred = fiveHundred;
    }
}
