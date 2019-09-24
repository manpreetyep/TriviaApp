package com.triviaapp.conroller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.triviaapp.R;
import com.triviaapp.Utils.Utils;
import com.triviaapp.database.Databasehandler;
import com.triviaapp.database.SessionManger;
import com.triviaapp.model.DataModel;
import com.triviaapp.view.FirstQuestionImpl;
import com.triviaapp.view.SecondQuestionImpl;

import java.util.ArrayList;
import java.util.UUID;

public class SecondQuestionActivity extends Activity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    SecondQuestionImpl viewImpl;
    TextView ans1,ans2,ans3,ans4,txt_next,txt_quesion;
    CheckBox check1,check2,check3,check4;
    String chooseAnswer="",userName="";
    SessionManger manger;
    Databasehandler databasehandler;
    ArrayList<String> selectAnswer = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewImpl = new SecondQuestionImpl(SecondQuestionActivity.this,null);
        setContentView(viewImpl.getView());
        initView();
    }

    private void initView() {
        manger = new SessionManger(SecondQuestionActivity.this);
        databasehandler = new Databasehandler(SecondQuestionActivity.this);
        userName = manger.getUserName();
        selectAnswer.clear();
        //get views

        ans1 = findViewById(R.id.ans1);
        ans2 = findViewById(R.id.ans2);
        ans3 = findViewById(R.id.ans3);
        ans4 = findViewById(R.id.ans4);

        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
        check3 = findViewById(R.id.check3);
        check4 = findViewById(R.id.check4);

        txt_next = findViewById(R.id.txt_next);
        txt_quesion = findViewById(R.id.txt_quesion);
        ans1.setOnClickListener(this);
        ans2.setOnClickListener(this);
        ans3.setOnClickListener(this);
        ans4.setOnClickListener(this);
        txt_next.setOnClickListener(this);
        check1.setOnCheckedChangeListener(this);
        check2.setOnCheckedChangeListener(this);
        check3.setOnCheckedChangeListener(this);
        check4.setOnCheckedChangeListener(this);


    }

    @Override
    public void onClick(View view) {
      if(view == ans1){
          if(check1.isChecked()) {
              check1.setChecked(false);
              selected(false,ans1.getText().toString());
          } else {
              check1.setChecked(true);
              selected(true,ans1.getText().toString());
          }
      }else if(view == ans2){
          if(check2.isChecked()) {
              check2.setChecked(false);
              selected(false,ans2.getText().toString());
          } else {
              check2.setChecked(true);
              selected(true,ans2.getText().toString());
          }
      }else if(view == ans3){
          if(check3.isChecked()) {
              check3.setChecked(false);
              selected(false,ans3.getText().toString());
          } else {
              check3.setChecked(true);
              selected(true,ans3.getText().toString());
          }
      }else if(view == ans4){
          if(check4.isChecked()) {
              check4.setChecked(false);
              selected(false,ans4.getText().toString());
          } else {
              check4.setChecked(true);
              selected(true,ans4.getText().toString());
          }
      }else if(view == txt_next) {
          if(selectAnswer.size()==1){
              Toast.makeText(this, "Please select more than one value", Toast.LENGTH_SHORT).show();
          }else{

              String id = UUID.randomUUID().toString();
              String answwer = selectAnswer.toString().replace("[","").replace("]","");

              DataModel dataModel = new DataModel();
              dataModel.id = 0;
              dataModel.game = ""+manger.getCount();
              dataModel.name = userName;
              dataModel.date = Utils.getDate();
              dataModel.questionone = getIntent().getStringExtra("question");
              dataModel.answerone = getIntent().getStringExtra("answer");
              dataModel.questiontwo = txt_quesion.getText().toString();
              dataModel.answertwo = answwer;
              databasehandler.setData(dataModel);

              manger.setQuestionTwo(txt_quesion.getText().toString());
              manger.setAnswerTwo(answwer);
              Intent intent = new Intent(SecondQuestionActivity.this,SummeryActivity.class);
              startActivity(intent);
              finish();
          }

      }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(compoundButton == check1){
            selected(b,ans1.getText().toString());
        }else if(compoundButton == check2){
            selected(b,ans2.getText().toString());
        }else if(compoundButton == check3){
            selected(b,ans3.getText().toString());
        }else if(compoundButton == check4){
            selected(b,ans4.getText().toString());
        }
    }

    public void selected(boolean b ,String ans){
        if(b) {
            if(!selectAnswer.contains(ans))
               selectAnswer.add(ans);

        }else {
            if(selectAnswer.contains(ans))
               selectAnswer.remove(ans);
        }
    }
}
