package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.service.autofill.UserData;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.model.Question;
import com.example.myapplication.model.Test;
import com.example.myapplication.model.User;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableMaybeObserver;
import io.reactivex.schedulers.*;
import io.reactivex.schedulers.Schedulers;


public class Model extends BaseAdapter
{



    Context context;
    LayoutInflater inflater;
    List<Test> list;
    int current_position=0;
    private Asyn2Task as;



    public Model(Context context,List<Test> l) {

        this.context = context;
        this.list=l;






    }




    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        TextView name;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.list, parent, false);


        name = (TextView) itemView.findViewById(R.id.txt);
        name.setText(this.list.get(position).getName());



        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                current_position=position;
                as=new Asyn2Task();
                as.execute(Model.this);


            }
        });

        return itemView;
    }

    void Load_test(List<Question> ql)
    {
        Intent intent = new Intent(context, Main3Activity.class);
        intent.putExtra("qlist", (ArrayList)ql);
        context.startActivity(intent);
    }
}
