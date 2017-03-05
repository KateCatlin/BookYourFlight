package com.example.katecatlin.geoquiz;

/**
 * Created by katecatlin on 3/5/17.
 */

public class TrueFalse {
    private int Question;

    private boolean TrueQuestion;

    public TrueFalse(int question, boolean trueQuestion) {
        Question = question;
        trueQuestion = trueQuestion;
    }


    public int getQuestion() {
        return Question;
    }

    public void setQuestion(int question) {
        Question = question;
    }

    public boolean isTrueQuestion() {
        return TrueQuestion;
    }

    public void setTrueQuestion(boolean trueQuestion) {
        TrueQuestion = trueQuestion;
    }
}
