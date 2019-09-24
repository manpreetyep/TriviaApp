package com.triviaapp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.triviaapp.R;
import com.triviaapp.database.Databasehandler;
import com.triviaapp.database.SessionManger;

public class SecondQuestionImpl implements ViewInterface {
    Context context;
    private View mView;


    public SecondQuestionImpl(Context context, ViewGroup container) {
        mView = LayoutInflater.from(context).inflate(R.layout.second_question,container);
    }

    @Override
    public View getView() {
        return mView;
    }
}
