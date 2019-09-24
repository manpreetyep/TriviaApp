package com.triviaapp.conroller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.triviaapp.R;
import com.triviaapp.database.Databasehandler;
import com.triviaapp.database.SessionManger;
import com.triviaapp.view.EnterNameViewImpl;

public class EnterNameActivity extends Activity implements View.OnClickListener {

    EnterNameViewImpl viewImpl;
    TextView txt_next,title,txt_history,txt_clear_history;
    EditText ed_enter_name;
    SessionManger manger;
    Databasehandler databasehandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewImpl = new EnterNameViewImpl(EnterNameActivity.this,null);
        setContentView(viewImpl.getView());

        //Shared Preferences
        manger  = new SessionManger(EnterNameActivity.this);

        //Database
        databasehandler = new Databasehandler(this);

        //get Views
        txt_next = findViewById(R.id.txt_next);
        ed_enter_name = findViewById(R.id.ed_enter_name);
        title = findViewById(R.id.title);
        txt_history = findViewById(R.id.txt_history);
        txt_clear_history = findViewById(R.id.txt_clear_history);
        title.setText("Home");
        txt_next.setOnClickListener(this);
        txt_history.setOnClickListener(this);
        txt_clear_history.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == txt_next){
              if(ed_enter_name.getText().toString().isEmpty()){
                  Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
              }else{
                  manger.setCount(manger.getCount()+1);
                  manger.setUserName(ed_enter_name.getText().toString());
                  Intent intent = new Intent(EnterNameActivity.this,FirstQuestionActivity.class);
                  startActivity(intent);
                  finish();
              }
        }else if(view ==txt_history){
            Intent intent = new Intent(EnterNameActivity.this,HistoryActivity.class);
            startActivity(intent);

        }else if(view ==txt_clear_history){
            databasehandler.deleteTable();
            manger.setCount(0);
            Toast.makeText(this, "History Deleted", Toast.LENGTH_SHORT).show();
        }
    }
}
