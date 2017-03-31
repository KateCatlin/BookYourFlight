package com.example.katecatlin.geoquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MoreMotivation extends AppCompatActivity {
    public static final String EXTRA_ANSWER_TRUE = "com.example.katecatlin.geoquiz.answer_is_true";
    public static final String EXTRA_PIC_SHOWN = "com.example.katecatlin.geoquiz.pic_shown";

    private boolean mAnswerIsTrue;
    private TextView mAnswerTextView;
    private Button mShowPic;

    private void setAnswerShownPic(boolean isPicShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_PIC_SHOWN, isPicShown);
        setResult(RESULT_OK, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_motivation);
        setAnswerShownPic(false);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_TRUE, false);

        mAnswerTextView = (TextView)findViewById(R.id.answerTextView);

        mShowPic = (Button)findViewById(R.id.showPicButton);
        mShowPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAnswerTextView.setText("(By the way, the answer is " + mAnswerIsTrue + ")");
                setAnswerShownPic(true);
            }
        });

    }

}