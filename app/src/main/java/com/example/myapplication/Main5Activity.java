package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.model.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main5Activity extends AppCompatActivity {

    ArrayList<Test> list;
    private Test curr;

    public Test getCurr() {
        return curr;
    }

    public void setCurr(Test curr) {
        this.curr = curr;
    }

    private  AsynTask4 as;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        list= (ArrayList<Test>) getIntent().getExtras().getSerializable("list");
    }


    public void d_str(View view)
    {
        EditText et=(EditText)findViewById(R.id.dname);
        if(et.getText()!=null)
        {
            int x=this.search(et.getText().toString());
            if(x!=-1) {
                curr = list.get(x);
                as=new AsynTask4();
                as.execute(this);
            }
            else
            {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Not found test with this name", Toast.LENGTH_SHORT);
                toast.show();
            }

        }
        else
            {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Tedit is Empty!", Toast.LENGTH_SHORT);
                toast.show();
            }


    }

    private int search(String finder)
    {
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).getName().toString().equals(finder))
            {
                return i;
            }


        }
        return -1;
    }

    public void finisher(List<Test> list)
    {
        Intent intent=new Intent(this,Main2Activity.class);
        intent.putExtra("list",(ArrayList)list);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        if(as!=null)
            as.cancel(true);
        Intent intent=new Intent(this,Main2Activity.class);
        intent.putExtra("list",(ArrayList)list);
        startActivity(intent);
        finish();
    }
}