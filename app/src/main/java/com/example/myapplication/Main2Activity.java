package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.TextureView;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.model.Question;
import com.example.myapplication.model.Test;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableMaybeObserver;
import io.reactivex.schedulers.Schedulers;

public class Main2Activity extends AppCompatActivity {

    ListView listview;
    Model model;
    ArrayList<Test> list;
    public static final int IDM_OPEN = 101;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lister);
        list= (ArrayList<Test>) getIntent().getExtras().getSerializable("list");
        //Log.e("info",list.get(0).getName());
        listview = (ListView) findViewById(R.id.listview);
        model =new Model(this,list);
        listview.setAdapter(model);


    }


}
