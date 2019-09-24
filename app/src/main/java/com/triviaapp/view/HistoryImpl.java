package com.triviaapp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.triviaapp.R;

public class HistoryImpl implements ViewInterface {
    private View mView;

    public HistoryImpl(Context context, ViewGroup container) {
        mView = LayoutInflater.from(context).inflate(R.layout.history,container);
    }

    @Override
    public View getView() {
        return mView;
    }
}
