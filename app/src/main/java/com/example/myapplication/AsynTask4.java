package com.example.myapplication;

import android.os.AsyncTask;

import com.example.myapplication.model.Test;

import java.util.List;

public class AsynTask4 extends AsyncTask<Main5Activity,Void, Void> {

    protected Void doInBackground(Main5Activity... splasches) {

        //Keys[] k =JsonLoader.getData();
        Main5Activity m = splasches[0];
        //m.CallMainAndDie(k.clone());
        AppDatabase db = AppDatabase.getDatabace(m);
        db.getTestDao().Delete(m.getCurr());
        List<Test> l=MainActivity.db.getTestDao().getAllTest();
        m.finisher(l);

        return null;


    }

}
