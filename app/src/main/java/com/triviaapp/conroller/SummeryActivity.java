package com.triviaapp.conroller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.triviaapp.R;
import com.triviaapp.database.SessionManger;
import com.triviaapp.view.SummeryImpl;

public class SummeryActivity extends Activity implements View.OnClickListener {

    SummeryImpl viewImpl;
    TextView txt_user_name,txt_finish,question_one,answer_one,question_two,answer_two;
    SessionManger sessionManger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewImpl = new SummeryImpl(SummeryActivity.this,null);
        setContentView(viewImpl.getView());
        initView();
    }

    private void initView() {
        sessionManger = new SessionManger(SummeryActivity.this);
        txt_user_name = findViewById(R.id.txt_user_name);
        question_one = findViewById(R.id.question_one);
        answer_one = findViewById(R.id.answer_one);
        question_two = findViewById(R.id.question_two);
        answer_two = findViewById(R.id.answer_two);
        txt_finish = findViewById(R.id.txt_finish);

        txt_user_name.setText("Hello , "+sessionManger.getUserName());
        question_one.setText(sessionManger.getQuestionOne());
        question_two.setText(sessionManger.getQuestionTwo());
        answer_one.setText(sessionManger.getAnswerOne());
        answer_two.setText(sessionManger.getAnswerTwo());

        txt_finish.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view ==txt_finish){
            Intent intent = new Intent(SummeryActivity.this,EnterNameActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
