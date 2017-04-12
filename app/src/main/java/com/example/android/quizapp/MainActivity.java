package com.example.android.quizapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int points = 0;
    int maxPoints = 5;
    boolean correctAnswer = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void checkAnswers(View v) {

        if (checkFirstQuestion()) ++points;
        if (checkSecondQuestion()) ++ points;
        points += checkThirdQuestion();
        if (checkFourthQuestion()) ++points;
        if (points == maxPoints)setContentView(R.layout.testuestion);
        else {

            Context context = getApplicationContext();
            CharSequence text = " You have won " + String.valueOf(points) + " points! :)";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    public boolean checkFirstQuestion () {
        RadioButton firstOption =  (RadioButton) findViewById(R.id.answer1_a);
        correctAnswer= firstOption.isChecked();
        return correctAnswer;
    }

    public boolean checkSecondQuestion () {
        EditText secondQuestion = (EditText) findViewById(R.id.secondQuestion);
        String capitalOfAustria = secondQuestion.getText().toString();
        String usersAnswer = capitalOfAustria.toLowerCase();
        if(usersAnswer.equals("vienna")) correctAnswer = true;
        else correctAnswer = false;
        return correctAnswer;
    }

    public int checkThirdQuestion () {
        CheckBox firstCheckbox = (CheckBox) findViewById(R.id.YouTube);
        CheckBox secondCheckbox = (CheckBox) findViewById(R.id.GooglePlus);
        CheckBox thirdCheckbox = (CheckBox) findViewById(R.id.Reddit);
        boolean firstChecked = firstCheckbox.isChecked();
        boolean secondChecked = secondCheckbox.isChecked();
        boolean thirdChecked = thirdCheckbox.isChecked();
        if (!thirdChecked) {
            if (firstChecked && secondChecked) return 2;
            else if (!firstChecked && !secondChecked) return 0;
            else return 1;
        } else return 0;
    }

    public boolean checkFourthQuestion () {
        EditText fourthQuestion = (EditText) findViewById(R.id.fourthQuestion);
        String capitalOfBritain = fourthQuestion.getText().toString();
        String usersAnswer = capitalOfBritain.toLowerCase();
        if(usersAnswer.equals("london")) correctAnswer = true;
        else correctAnswer = false;
        return correctAnswer;
    }




/***
 * String abc    = "Abc".toLowerCase();
 boolean isAbc = "Abc".equalsIgnoreCase("ABC");
 */
}
