package com.example.surveyapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SurveyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        Button btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Process survey answers
                processSurvey();
            }
        });
    }

    private void processSurvey() {
        EditText editProgram = findViewById(R.id.editProgram);
        RatingBar ratingCourses = findViewById(R.id.ratingCourses);
        EditText editContentImprovement = findViewById(R.id.editContentImprovement);
        RadioGroup radioGroupField = findViewById(R.id.radioGroupField);
        RadioGroup radioGroupCourses = findViewById(R.id.radioGroupCourses);

        String program = editProgram.getText().toString();
        float coursesRating = ratingCourses.getRating();
        String contentImprovement = editContentImprovement.getText().toString();

        int selectedFieldId = radioGroupField.getCheckedRadioButtonId();
        RadioButton selectedFieldRadioButton = findViewById(selectedFieldId);
        String fieldStudySatisfaction = selectedFieldRadioButton.getText().toString();

        int selectedCoursesId = radioGroupCourses.getCheckedRadioButtonId();
        RadioButton selectedCoursesRadioButton = findViewById(selectedCoursesId);
        String preferredCourses = selectedCoursesRadioButton.getText().toString();

        // TODO: Implement further processing (e.g., sending data to a server)

        // Show thank you page
        startActivity(new Intent(SurveyActivity.this, ThankYouActivity.class));
        finish(); // Optional: Close the survey activity
    }
}

