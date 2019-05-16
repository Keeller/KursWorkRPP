package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.model.Question;
import com.example.myapplication.model.Test;
import com.example.myapplication.model.User;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableMaybeObserver;
import io.reactivex.schedulers.Schedulers;

public class Main2Activity extends AppCompatActivity {

    ListView listview;
    Model model;
    ArrayList<Test> list;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lister);
        list= (ArrayList<Test>) getIntent().getExtras().getSerializable("list");
        //Log.e("info",list.get(0).getName());

        listview = (ListView) findViewById(R.id.listview);
        model =new Model(this,list);
        if(Model.user!=null) {
            if (Model.user.getPremission() > 0) {
                Button btnk = (Button) findViewById(R.id.btOk);
                Button btnc = (Button) findViewById(R.id.btCancel);
                Button btnlog=(Button) findViewById(R.id.btlog) ;
                btnk.setVisibility(View.VISIBLE);
                btnc.setVisibility(View.VISIBLE);
                btnlog.setVisibility(View.INVISIBLE);

            }
        }

        listview.setAdapter(model);




    }

    public void login(View view)
    {
        Intent intent=new Intent(this,Main8Activity.class);
        intent.putExtra("list",(ArrayList)list);
        startActivity(intent);
        finish();

    }


    public void InsData(View view)
    {
        Intent intent=new Intent(this,Main4Activity.class);
        intent.putExtra("list",(ArrayList)list);
        startActivity(intent);
        finish();
    }

    public void DeleteData(View view)
    {
        Intent intent=new Intent(this,Main5Activity.class);
        intent.putExtra("list",(ArrayList)list);
        startActivity(intent);
        finish();
    }

    public void Search(View view)
    {
        Intent intent=new Intent(this,Main10Activity.class);
        intent.putExtra("list",(ArrayList)list);
        startActivity(intent);
        finish();
    }


}
