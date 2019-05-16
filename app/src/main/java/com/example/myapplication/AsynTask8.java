package com.example.myapplication;

import android.os.AsyncTask;

import com.example.myapplication.model.Question;

import java.util.List;

public class AsynTask8 extends AsyncTask<Main9Activity,Void, Void> {

    protected Void doInBackground(Main9Activity... splasches) {

        //Keys[] k =JsonLoader.getData();
        Main9Activity m = splasches[0];
        //m.CallMainAndDie(k.clone());
        AppDatabase db = AppDatabase.getDatabace(m);
        Question q=m.getCurr_q();
        q.setQuest(m.getQquest());
        q.setAnswer(m.getQansw());
        db.getQuestionDao().Update(q);
        List<Question> l=MainActivity.db.getQuestionDao().getQuestionByTest(Model.current_position);
        m.finisher(l);

        return null;


    }
}
