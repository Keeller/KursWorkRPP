package com.example.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.model.Question;
import com.example.myapplication.model.Test;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    List<Question> quest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        quest= (ArrayList<Question>) getIntent().getExtras().getSerializable("qlist");
        ViewPager pager=(ViewPager)findViewById(R.id.pager);
        pager.setAdapter(new Addapter(getSupportFragmentManager(),quest));

    }


    @Override
    public void onBackPressed() {
       finish();
       super.onBackPressed();
    }

    public void goodAnsw()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(Main3Activity.this);
        builder.setTitle("Результат")
                .setMessage("Верно")
                .setCancelable(false)
                .setNegativeButton("ОК",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }


    public void badAnsw()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(Main3Activity.this);
        builder.setTitle("Результат")
                .setMessage("Не Верно")
                .setCancelable(false)
                .setNegativeButton("ОК",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
