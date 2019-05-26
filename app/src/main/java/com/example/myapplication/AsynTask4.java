package com.example.myapplication;

import android.os.AsyncTask;

import com.example.myapplication.model.Test;

import java.util.List;

public class AsynTask4 extends AsyncTask<Model,Void, Void> {

    protected Void doInBackground(Model... splasches) {

        //Keys[] k =JsonLoader.getData();
        Model m = splasches[0];
        //m.CallMainAndDie(k.clone());
        AppDatabase db = AppDatabase.getDatabace(m.context);
        db.getTestDao().Delete(m.getCurr());
        List<Test> l=MainActivity.db.getTestDao().getAllTest();
        m.Reload_activity(l);

        return null;


    }

}
