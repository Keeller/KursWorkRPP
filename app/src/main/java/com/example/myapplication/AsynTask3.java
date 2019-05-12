package com.example.myapplication;

import android.os.AsyncTask;

import com.example.myapplication.model.Test;

import java.util.List;

public class AsynTask3 extends AsyncTask<Main4Activity,Void, Void> {
    protected Void doInBackground(Main4Activity... splasches) {

        //Keys[] k =JsonLoader.getData();
        Main4Activity m = splasches[0];
        //m.CallMainAndDie(k.clone());
        AppDatabase db = AppDatabase.getDatabace(m);
        Test test=new Test();
        test.setName(Main4Activity.input_name);
        db.getTestDao().insertAll(test);
        List<Test> l=MainActivity.db.getTestDao().getAllTest();
        m.finisher(l);

        return null;


    }

}
