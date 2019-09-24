package com.triviaapp.database;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManger {
    Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private static final String PREF_NAME = "trivia";

    private static final String COUNT= "count";
    private static final String USER_NAME= "user_name";
    private static final String QUESTION_ONE= "question_one";
    private static final String QUESTION_TWO= "question_two";
    private static final String ANSWER_ONE= "answer_one";
    private static final String ANSWER_TWO= "answer_two";

    public SessionManger(Context context) {
        this.context=context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }

    public void setCount(int params){
        editor.putInt(COUNT,params);
        editor.apply();
    }

    public int getCount(){
        return sharedPreferences.getInt(COUNT,0);
    }

    public void setUserName(String username){
        editor.putString(USER_NAME,username);
        editor.apply();
    }

    public String getUserName(){
        return sharedPreferences.getString(USER_NAME,"");
    }

    public void setQuestionOne(String parmas){
        editor.putString(QUESTION_ONE,parmas);
        editor.apply();
    }

    public String getQuestionOne(){
        return sharedPreferences.getString(QUESTION_ONE,"");
    }

    public void setQuestionTwo(String parmas){
        editor.putString(QUESTION_TWO,parmas);
        editor.apply();
    }

    public String getQuestionTwo(){
        return sharedPreferences.getString(QUESTION_TWO,"");
    }



    public void setAnswerOne(String parmas){
        editor.putString(ANSWER_ONE,parmas);
        editor.apply();
    }

    public String getAnswerOne(){
        return sharedPreferences.getString(ANSWER_ONE,"");
    }

    public void setAnswerTwo(String parmas){
        editor.putString(ANSWER_TWO,parmas);
        editor.apply();
    }

    public String getAnswerTwo(){
        return sharedPreferences.getString(ANSWER_TWO,"");
    }
}
