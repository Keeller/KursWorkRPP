package com.example.myapplication;

import android.os.AsyncTask;

import com.example.myapplication.model.Question;
import com.example.myapplication.model.User;

import java.util.List;

public class AsynTask7 extends AsyncTask<Main8Activity,Void, Void> {

    protected Void doInBackground(Main8Activity... splasches) {

        //Keys[] k =JsonLoader.getData();
        Main8Activity m = splasches[0];
        //m.CallMainAndDie(k.clone());
        AppDatabase db = AppDatabase.getDatabace(m);
        List<User> l=MainActivity.db.getUserDao().getUserByLoginAndPassword(m.getLogin(),m.getPassword());
        m.finisher(l);

        return null;


    }
}
