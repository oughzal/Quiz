package com.omarcomputer.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.omarcomputer.quiz.databinding.ActivityMainBinding;
import com.omarcomputer.quiz.model.Question;
import com.omarcomputer.quiz.viewmodel.QuestionViewModel;

import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    QuestionViewModel questionViewModel;

    Question question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        questionViewModel = new ViewModelProvider(this).get(QuestionViewModel.class);
        questionViewModel.currentIndex.observe(this, index -> {
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

            int finalI = i;
            answer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    lockAnswers();
                    int id = answer.getId();
                    if (finalI == 1) {

                        answer.setBackgroundResource(R.drawable.correct_answer);
                    } else {
                        answer.setBackgroundResource(R.drawable.incorrect_answer);
                    }
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



    void rsetAnswers (){
        TextView[] answers = {binding.answer1, binding.answer2, binding.answer3, binding.answer4};

        for (int i = 0; i < 4; i++) {
            TextView answer = answers[i];
            answer.setEnabled(true);
            answer.setBackgroundResource(R.drawable.rectangle2);
        }
    }
}