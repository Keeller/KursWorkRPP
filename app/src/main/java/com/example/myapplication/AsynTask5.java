package com.example.myapplication;

import android.os.AsyncTask;

import com.example.myapplication.model.Question;
import com.example.myapplication.model.Test;

import java.util.List;

public class AsynTask5 extends AsyncTask<Main3Activity,Void, Void> {

    protected Void doInBackground(Main3Activity... splasches) {

        //Keys[] k =JsonLoader.getData();
        Main3Activity m = splasches[0];
        //m.CallMainAndDie(k.clone());
        AppDatabase db = AppDatabase.getDatabace(m);
        db.getQuestionDao().Delete(m.getQ());
        List<Question> l=MainActivity.db.getQuestionDao().getQuestionByTest(Model.current_position);
        m.finisher(l);

        return null;


    }
}
