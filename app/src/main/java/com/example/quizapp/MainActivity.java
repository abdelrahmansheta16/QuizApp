package com.example.quizapp;


import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;



public class MainActivity extends Activity {

    int Score = 0, a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, g = 0, h = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Question1(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.A1:
                if (checked)
                    a = 0;
                    break;
            case R.id.B1:
                if (checked)
                    a = 1;
                    break;
            case R.id.C1:
                if (checked)
                    a = 0;
                    break;
        }
    }

    public void Question2(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.A2:
                if (checked)
                    b = 1;
                break;
            case R.id.B2:
                if (checked)
                    b = 0;
                break;
            case R.id.C2:
                if (checked)
                    b = 0;
                break;
        }
    }

    public void Question3(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.A3:
                if (checked)
                    c = 0;
                break;
            case R.id.B3:
                if (checked)
                    c = 0;
                break;
            case R.id.C3:
                if (checked)
                    c = 1;
                break;
        }
    }

    public void Question5(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.A5:
                if (checked)
                    e = 1;
            else
                e = 0;
                break;
            case R.id.B5:
                if (checked)
                    f = 1;
            else
                f = 0;
                break;
            // TODO: Veggie sandwich
            case R.id.C5:
                if (checked)
                    g = 1;
            else
                g = 0;
                break;
        }
        if(e == 1 && f == 1 && g == 0){
                h = 1;
        }
        else{
            h = 0;
        }
    }

    public void SubmitQuiz(View view) {
        // Get user's name
        EditText nameField = (EditText) findViewById(R.id.name_field);
        Editable nameEditable = nameField.getText();
        String name = nameEditable.toString();
        EditText Question = (EditText) findViewById(R.id.Question4);
        Editable questionEditable = Question.getText();
        String question4 = questionEditable.toString();
        if (question4.compareToIgnoreCase("9") == 0){
            d = 1;
        }
        else {
            d = 0;
        }
        Score = a+b+c+d+h;
        // Display the order summary on the screen
        String message = createQuizSummary(name, Score);
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();

    }

    private String createQuizSummary(String name, int score) {
        String priceMessage = getString(R.string.submit_quiz_name, name);
        priceMessage += "\n" + getString(R.string.quiz_score, score);
        return priceMessage;
    }
}