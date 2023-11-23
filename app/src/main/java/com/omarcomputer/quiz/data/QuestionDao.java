package com.omarcomputer.quiz.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.omarcomputer.quiz.model.Question;

import java.util.List;

@Dao
public interface QuestionDao {
    @Query("SELECT * FROM QUESTION order by Random()")
    public List<Question> getQuestion();

    @Insert
    public void insertQuestion(Question question);
}
