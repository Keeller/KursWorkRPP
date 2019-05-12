package com.example.myapplication;

import android.content.Intent;
import android.support.v4.util.Consumer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.model.Question;
import com.example.myapplication.model.Test;
import com.example.myapplication.model.User;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.*;


public class MainActivity extends AppCompatActivity {

    private  AsynTask as;
    static AppDatabase db;
    List<Integer> deb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        /*

        Completable.fromRunnable(new Runnable() {
            @Override
            public void run() {
                AppDatabase db=AppDatabase.getDatabace(MainActivity.this);
                User user=new User();
                user.setLogin("Login");
                user.setPassword("123456");
                user.setName("Vasya");
                user.setPremission(5);
                db.getUserDao().insertALL(user);
            }
        }).subscribeOn(Schedulers.io()).subscribe();
        */

        as =new AsynTask();
        as.execute(this);


    }

    public void CallMainAndDie(List<Test> l)
    {
        Intent intent=new Intent(this,Main2Activity.class);
        intent.putExtra("list",(ArrayList)l);
        startActivity(intent);
        finish();
    }
    @Override
    public void onBackPressed() {
        as.cancel(true);
        super.onBackPressed();
    }

}
