package com.omarcomputer.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.omarcomputer.quiz.databinding.ActivityMainBinding;
import com.omarcomputer.quiz.model.Question;
import com.omarcomputer.quiz.viewmodel.QuestionViewModel;

import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    QuestionViewModel questionViewModel;
    TextView[] answers;

    Question question = new Question();
    int currentIndex;
    int scoreCorrect=0;
    int scoreIncorrect=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        answers = new TextView[] {binding.answer1, binding.answer2, binding.answer3, binding.answer4};
        questionViewModel = new ViewModelProvider(this).get(QuestionViewModel.class);
        questionViewModel.currentIndex.observe(this, index -> {
            currentIndex = questionViewModel.currentIndex.getValue();
            question =questionViewModel.quetionList.getValue().get(index);
            if(questionViewModel.quetionList.getValue().size()==0) return;
            question = questionViewModel.quetionList.getValue().get(index);
            binding.question.setText(question.getQuestion());
            binding.answer1.setText(question.getReponse1());
            binding.answer2.setText(question.getReponse2());
            binding.answer3.setText(question.getReponse3());
            binding.answer4.setText(question.getReponse4());


        });
        questionViewModel.getQuestion();
        TextView[] answers = {binding.answer1, binding.answer2, binding.answer3, binding.answer4};
        for (int i = 0; i < 4; i++) {
            TextView answer = answers[i];
            Log.i("Quizzzz",""+question.correct);
            int finalI = i;
            answer.setOnClickListener(view -> {
                lockAnswers();
                if (finalI == question.correct) {
                    scoreCorrect++;
                    answer.setBackgroundResource(R.drawable.correct_answer);
                } else {
                    scoreIncorrect++;
                    answer.setBackgroundResource(R.drawable.incorrect_answer);
                }
                if(currentIndex < questionViewModel.quetionList.getValue().size() -1){
                    questionViewModel.currentIndex.setValue(currentIndex +1);
                    resetAnswers();
                }

            });

        }


    }


    void lockAnswers (){
        TextView[] answers = {binding.answer1, binding.answer2, binding.answer3, binding.answer4};

        for (int i = 0; i < 4; i++) {
            TextView answer = answers[i];
            answer.setEnabled(false);
        }
    }



    void resetAnswers (){
        binding.scoreCorrect.setText(""+ scoreCorrect);
        binding.scoreIncorrect.setText(""+ scoreIncorrect);
         for (int i = 0; i < 4; i++) {
            TextView answer = answers[i];
            answer.setEnabled(true);
            answer.setBackgroundResource(R.drawable.rectangle2);
        }
    }
    void setEvents(){


    }
}