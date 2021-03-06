package com.bignerdranch.android.geoquiz;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private Button mTrueButton, mFalseButton, mNextButton;
    private TextView mQuestionTextView;

    private Question[] mQuestionBank = new Question[]
            {
                    new Question(R.string.question_oceans, true),
                    new Question(R.string.question_mideast, true),
                    new Question(R.string.question_africa, true),
                    new Question(R.string.question_americas, true),
                    new Question(R.string.question_asia, true),
            };
    private int mCurrentIndex =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

/*        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        mQuestionTextView=(TextView)findViewById(R.id.quastion_text_view);
        /*final int quastion = mQuestionBank [mCurrentIndex].getTextResId();
        mQuestionTextView.setText(quastion);*/

        mTrueButton = (Button)findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
               /* Toast
                        .makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT)
                        .show();*/
                checkAnswer(true);

            }
        });
        mFalseButton = (Button)findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*                Toast
                        .makeText(QuizActivity.this, R.string.correct_toast,Toast.LENGTH_SHORT)
                        .show();*/
                checkAnswer(false);

            }
        });
        mNextButton = (Button)findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex+1)%mQuestionBank.length;
/*                int question = mQuestionBank[mCurrentIndex].getTextResId();
                mQuestionTextView.setText(question);*/
                updateQuestion();

            }
        });
        updateQuestion();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void updateQuestion()
    {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }
    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
        int messageResId=0;

        if (userPressedTrue == answerIsTrue)
            messageResId=R.string.correct_toast;
        else
            messageResId=R.string.incorrect_toast;

        Toast.makeText(this, messageResId,Toast.LENGTH_SHORT).show();


    }
}
