package com.example.myapplication;

import android.content.Context;
import android.os.AsyncTask;

import com.example.myapplication.model.Question;
import com.example.myapplication.model.Test;

import java.util.List;

public class AsynTask6 extends AsyncTask<Main7Activity,Void, Void> {

    protected Void doInBackground(Main7Activity... splasches) {

        //Keys[] k =JsonLoader.getData();
        Main7Activity m = splasches[0];
        //m.CallMainAndDie(k.clone());
        AppDatabase db = AppDatabase.getDatabace(m);
        Question question=new Question();
        question.setQuest(m.getQquest());
        question.setAnswer(m.getQansw());
        question.setTestId(Model.current_position);
        db.getQuestionDao().insertAll(question);
        List<Question> l=MainActivity.db.getQuestionDao().getQuestionByTest(Model.current_position);
        m.finisher(l);

        return null;


    }
}
