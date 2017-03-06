package com.example.katecatlin.geoquiz;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class QuizActivity extends AppCompatActivity {
    private static final String TAG = "QuizActivity";

    private Button TrueButton;
    private Button FalseButton;
    private Button NextButton;
    private TextView QuestionTextView;

    private TrueFalse[] QuestionBank = new TrueFalse[]{
            new TrueFalse(R.string.question_GCC, true),
            new TrueFalse(R.string.question_weather, false),
            new TrueFalse(R.string.question_free, true),
            new TrueFalse(R.string.question_flights, true),
            new TrueFalse(R.string.question_flights, true),
    };

    private int CurrentIndex = 0;

    private void updateQuestion() {
        int question = QuestionBank[CurrentIndex].getQuestion();
        QuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue) {

        boolean answerIsTrue = QuestionBank[CurrentIndex].isTrueQuestion();

        int messageResId = 0;

        if (userPressedTrue == answerIsTrue) {
            Log.d(TAG, "answerIsTrue is registered as true");
        } else {
            Log.d(TAG, "answerIsTrue is registered as false");
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        QuestionTextView = (TextView)findViewById(R.id.question_text_view);

        TrueButton = (Button)findViewById(R.id.true_button);
        TrueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });

        FalseButton = (Button)findViewById(R.id.false_button);
        FalseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });

        NextButton = (Button)findViewById(R.id.next_button);
        NextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                CurrentIndex = (CurrentIndex + 1) % QuestionBank.length;
                updateQuestion();
            }

        });

        updateQuestion();
    }

}
