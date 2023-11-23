package com.omarcomputer.quiz.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.omarcomputer.quiz.data.QuestionDao;
import com.omarcomputer.quiz.data.QuestionDatabase;
import com.omarcomputer.quiz.model.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionViewModel extends AndroidViewModel {
    private Application application;
    QuestionDao questionDao;

    public MutableLiveData<List<Question>> quetionList = new MutableLiveData<>();
    public MutableLiveData<Integer> currentIndex = new MutableLiveData<>();

    public QuestionViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
        questionDao = QuestionDatabase.getInstance(application.getApplicationContext()).questionDao();
        List<Question> list = new ArrayList<>();
        quetionList.setValue(list);

    }

    public  void getQuestion() {
        //insertQuestion();
        new Thread(() -> {
            List<Question> list  = questionDao.getQuestion();
            quetionList.postValue(list);
            if(quetionList.getValue().size()>0) currentIndex.postValue(0);
            Log.i("Quzzz",""+ list.size());
        }).start();

    }

    public  void  insertQuestion(){

        new Thread(()->{
            Question question = new Question(1,"Question","A","B","C","D",0);
            questionDao.insertQuestion(question);
        }).start();

    }
}
