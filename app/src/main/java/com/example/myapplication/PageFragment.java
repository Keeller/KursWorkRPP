package com.example.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.myapplication.model.Question;

public class PageFragment extends Fragment {


    private Question quest;

    public PageFragment() {}


    public static PageFragment newInstance(Question question) {
        PageFragment pr=new PageFragment();
        Bundle arguments = new Bundle();
        arguments.putSerializable("quest",question);
        pr.setArguments(arguments);
        return  pr;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        quest=(Question) getArguments().getSerializable("quest");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);



        TextView txt = (TextView) view.findViewById(R.id.displayText);
        EditText etxt=(EditText) view.findViewById(R.id.Tedit);
        if(this.quest.getQuest() != null)
            txt.setText(this.quest.getQuest());
        else
            txt.setText("Not found");



        return view;
    }


}
