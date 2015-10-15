package com.bignerdranch.android.geoquiz;

/**
 * Created by Black on 11.10.2015.
 */
public class Question {

    public int getTextResId() {
        return mTextResId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }

    private int mTextResId;
    private boolean mAnswerTrue;

    public Question(int TextResId, boolean AnswerTrue)
    {
        mAnswerTrue = AnswerTrue;
        mTextResId = TextResId;
    }
}
