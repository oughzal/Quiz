package com.omarcomputer.quiz.model;

import android.content.Intent;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Question")
public class Question {
    @PrimaryKey
    public int id ;
    @ColumnInfo(name = "Question")
    public String question;
    @ColumnInfo(name = "Reponse1")
    public String reponse1;
    @ColumnInfo(name = "Reponse2")
    public String reponse2;
    @ColumnInfo(name = "Reponse3")
    public String reponse3;
    @ColumnInfo(name = "Reponse4")
    public String reponse4;
    @ColumnInfo(name = "Correct")
    public int correct;

    public Question(int id, String question, String reponse1, String reponse2, String reponse3, String reponse4, int correct) {
        this.id = id;
        this.question = question;
        this.reponse1 = reponse1;
        this.reponse2 = reponse2;
        this.reponse3 = reponse3;
        this.reponse4 = reponse4;
        this.correct = correct;
    }

    public Question() {

    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponse1() {
        return reponse1;
    }

    public void setReponse1(String reponse1) {
        this.reponse1 = reponse1;
    }

    public String getReponse2() {
        return reponse2;
    }

    public void setReponse2(String reponse2) {
        this.reponse2 = reponse2;
    }

    public String getReponse3() {
        return reponse3;
    }

    public void setReponse3(String reponse3) {
        this.reponse3 = reponse3;
    }

    public String getReponse4() {
        return reponse4;
    }

    public void setReponse4(String reponse4) {
        this.reponse4 = reponse4;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }
}
