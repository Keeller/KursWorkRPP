package com.example.myapplication;

import android.os.AsyncTask;

import com.example.myapplication.model.Test;

import java.util.List;

public class AsynTask extends AsyncTask<MainActivity,Void, Void>
{


    @Override
    protected Void doInBackground(MainActivity... splasches) {

        //Keys[] k =JsonLoader.getData();
        MainActivity m=splasches[0];
        //m.CallMainAndDie(k.clone());
        MainActivity.db=AppDatabase.getDatabace(m);
        List<Test> l=MainActivity.db.getTestDao().getAllTest();
        if(l!=null)
            m.CallMainAndDie(l);
        else
            m.deb.add(1);

        return null;


    }

    @Override
    protected void onPostExecute(Void v)
    {

    }
}
