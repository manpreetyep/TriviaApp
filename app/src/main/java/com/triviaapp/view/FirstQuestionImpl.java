package com.triviaapp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.triviaapp.R;

public class FirstQuestionImpl implements ViewInterface {
    Context context;
    private View mView;

    public FirstQuestionImpl(Context context, ViewGroup container) {
        mView = LayoutInflater.from(context).inflate(R.layout.first_question,container);
    }

    @Override
    public View getView() {
        return mView;
    }
}
