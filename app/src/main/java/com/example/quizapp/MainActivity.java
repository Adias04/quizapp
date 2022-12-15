package com.example.quizapp;

import static com.example.quizapp.R.id.idTVScore;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
private TextView questionTV,questionNumberTV;
private Button option1Btn;
    private Button option2Btn;
    private Button option3Btn;
    private Button option4Btn;
    private ArrayList<QuizModal> quizModalArrayList;
    Random random;
    int currentScore=0;
    int questionAttempted=1;
    int currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionTV=findViewById(R.id.idTVQuestion);
        questionNumberTV =findViewById(R.id.idTVQuestionAttempted);
        option1Btn=findViewById(R.id.idBtnOption1);
        option2Btn=findViewById(R.id.idBtnOption2);
        option3Btn=findViewById(R.id.idBtnOption3);
        option4Btn=findViewById(R.id.idBtnOption4);
        quizModalArrayList =new ArrayList<>();
        random=new Random();
        getQuizQuestion(quizModalArrayList);
        currentPos=random.nextInt(quizModalArrayList.size());
        setDataToViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase()));
                {
                    currentScore++;
                }
                    questionAttempted++;
                    currentPos=random.nextInt(quizModalArrayList.size());
                    setDataToViews(currentPos);


            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase()));
                {
                    currentScore++;
                }
                questionAttempted++;
                currentPos=random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);


            }
        });
        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase()));
                {
                    currentScore++;
                }
                questionAttempted++;
                currentPos=random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);


            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase()));
                {
                    currentScore++;
                }
                questionAttempted++;
                currentPos=random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);


            }
        });
    }

    private void showBottomSheet()
    {
        BottomSheetDialog bottomSheetDialog=new BottomSheetDialog((MainActivity.this));
        View bottomSheetView= LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
         TextView scoreTV=bottomSheetView.findViewById(idTVScore);
         Button restartQuizBtn =bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is \n "+currentScore +" /10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos=random.nextInt();
                setDataToViews(currentPos);
                questionAttempted=1;
                currentScore=0;
                bottomSheetDialog.dismiss();

            }
        });
        bottomSheetDialog.setCancelable((false));
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

    }
    private void setDataToViews(int currentPos) {

        questionNumberTV.setText("Question Attepted: " + questionAttempted + "/10");
        if (questionAttempted == 10) {
            showBottomSheet();
        } else {


            questionTV.setText(quizModalArrayList.get(currentPos).getQuestion());
            option1Btn.setText((quizModalArrayList.get(currentPos).getOption1()));
            option2Btn.setText((quizModalArrayList.get(currentPos).getOption2()));
            option3Btn.setText((quizModalArrayList.get(currentPos).getOption3()));
            option4Btn.setText((quizModalArrayList.get(currentPos).getOption4()));
        }
    }
    private void getQuizQuestion(ArrayList<QuizModal> quizModalArrayList) {
        quizModalArrayList.add(new QuizModal("How GFG is used ?","To solve DSA Problem",
                "To learn new language", "To learn Android","All of the above","All of the above"));
        quizModalArrayList.add(new QuizModal("How to pass the data between activities in Android ?","Intent",
                "Content Provider", " Broadcast receiver","None of the above","Intent"));
        quizModalArrayList.add(new QuizModal(" On which thread broadcast receivers will work in android ?","Worker Thread",
                "Main Thread", "Activity Thread","None of the above","Main Thread"));
        quizModalArrayList.add(new QuizModal("What is the use of content provider in android ?","To send the data from an application to another application",
                "To store the data in a database", "To share the data between applications","None of the above","To share the data between applications"));
        quizModalArrayList.add(new QuizModal("Persist data can be stored in Android through ?","Shared Preferences",
                "Internal/External storage", "SQlite","All of above","All of above"));
        quizModalArrayList.add(new QuizModal(" How to fix crash using log cat in android ?","Gmail",
                "log cat contains the exception name along with the line number", "Google search","None of the above"," log cat contains the exception name along with the line number"));

        quizModalArrayList.add(new QuizModal("How to find the JSON element length in android JSON ?","count()",
                "sum()", "add()","length()","length()"));

        quizModalArrayList.add(new QuizModal(" What is an interface in android ?","Interface acts as a bridge between class and the outside world",
                "Interface is a class", "Interface is a layout file","None of the above","Interface acts as a bridge between class and the outside world"));

        quizModalArrayList.add(new QuizModal("Which method is used to find GPS enabled or disabled pro-grammatically in android ?","finish()",
                "getGPSStatus()", "onProviderDisable()","getGPS()","getGPS()"));

        quizModalArrayList.add(new QuizModal(" How to fix crash using log cat in android ?","Gmail",
                "log cat contains the exception name along with the line number", "Google search","None of the above"," log cat contains the exception name along with the line number"));
    }
}