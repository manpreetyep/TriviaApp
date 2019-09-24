package com.triviaapp.conroller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.triviaapp.R;
import com.triviaapp.Utils.Utils;
import com.triviaapp.database.Databasehandler;
import com.triviaapp.database.SessionManger;
import com.triviaapp.model.DataModel;
import com.triviaapp.view.FirstQuestionImpl;

import java.util.UUID;

public class FirstQuestionActivity extends Activity implements View.OnClickListener {


    TextView ans1,ans2,ans3,ans4,txt_next,txt_quesion;
    FirstQuestionImpl viewImpl;
    String chooseAnswer="",userName="";
    SessionManger manger;
    Databasehandler databasehandler;
    boolean select=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewImpl = new FirstQuestionImpl(FirstQuestionActivity.this,null);
        setContentView(viewImpl.getView());
        initView();
    }

    private void initView() {
        manger = new SessionManger(FirstQuestionActivity.this);
        databasehandler = new Databasehandler(FirstQuestionActivity.this);
        userName = manger.getUserName();

        ans1 = findViewById(R.id.ans1);
        ans2 = findViewById(R.id.ans2);
        ans3 = findViewById(R.id.ans3);
        ans4 = findViewById(R.id.ans4);
        txt_next = findViewById(R.id.txt_next);
        txt_quesion = findViewById(R.id.txt_quesion);

        ans1.setOnClickListener(this);
        ans2.setOnClickListener(this);
        ans3.setOnClickListener(this);
        ans4.setOnClickListener(this);
        txt_next.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view ==ans1){
            chooseAnswer = ans1.getText().toString();
            ans1.setBackgroundResource(R.drawable.option_select_back);
            ans2.setBackgroundResource(R.drawable.option_back);
            ans3.setBackgroundResource(R.drawable.option_back);
            ans4.setBackgroundResource(R.drawable.option_back);
        }else if(view ==ans2){
            chooseAnswer = ans2.getText().toString();
            ans1.setBackgroundResource(R.drawable.option_back);
            ans2.setBackgroundResource(R.drawable.option_select_back);
            ans3.setBackgroundResource(R.drawable.option_back);
            ans4.setBackgroundResource(R.drawable.option_back);
        }else if(view ==ans3){
            chooseAnswer = ans3.getText().toString();
            ans1.setBackgroundResource(R.drawable.option_back);
            ans2.setBackgroundResource(R.drawable.option_back);
            ans3.setBackgroundResource(R.drawable.option_select_back);
            ans4.setBackgroundResource(R.drawable.option_back);
        }else if(view ==ans4){
            chooseAnswer = ans4.getText().toString();
            ans1.setBackgroundResource(R.drawable.option_back);
            ans2.setBackgroundResource(R.drawable.option_back);
            ans3.setBackgroundResource(R.drawable.option_back);
            ans4.setBackgroundResource(R.drawable.option_select_back);
        }else if(view ==txt_next){

            manger.setQuestionOne(txt_quesion.getText().toString());
            manger.setAnswerOne(chooseAnswer);
            Intent intent = new Intent(FirstQuestionActivity.this,SecondQuestionActivity.class);
            intent.putExtra("question",txt_quesion.getText().toString());
            intent.putExtra("answer",chooseAnswer);
            startActivity(intent);
            finish();

        }
    }
}
