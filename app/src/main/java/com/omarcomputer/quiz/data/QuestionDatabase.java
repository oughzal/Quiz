package com.omarcomputer.quiz.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.omarcomputer.quiz.model.Question;

@Database(entities = {Question.class},version = 1,exportSchema = false)
public abstract class QuestionDatabase extends RoomDatabase {
    public abstract QuestionDao questionDao();
    private static volatile QuestionDatabase INSTANCE = null;
    public static QuestionDatabase getInstance(final Context context){
        if(INSTANCE == null){
            synchronized(QuestionDatabase.class) {
                INSTANCE = Room.databaseBuilder(context, QuestionDatabase.class, "quizz.db")
                        .createFromAsset("quizz.db")
                        .fallbackToDestructiveMigration()
                        .build();
            }
            }
        return INSTANCE;
    }
}
