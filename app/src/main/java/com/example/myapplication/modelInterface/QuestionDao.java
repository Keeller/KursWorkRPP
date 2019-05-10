package com.example.myapplication.modelInterface;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.myapplication.model.Question;

import java.util.List;

@Dao
public interface QuestionDao {

    @Insert
    void insertAll(Question... questions);
    @Delete
    void Delete(Question question);
    @Query("SELECT * FROM question")
    List<Question> getALLQuestions();
    @Query("SELECT * FROM question WHERE testId=:ident")
    List<Question> getQuestionByTest(int ident);
}
