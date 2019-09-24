package com.triviaapp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.triviaapp.R;

public class SummeryImpl implements ViewInterface {
    private View mView;

    public SummeryImpl(Context context, ViewGroup container) {
        mView = LayoutInflater.from(context).inflate(R.layout.summery_activity,container);
    }

    @Override
    public View getView() {
        return mView;
    }
}
