package com.triviaapp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.triviaapp.R;

public class EnterNameViewImpl implements ViewInterface {

    Context context;
    private View mView;

    public EnterNameViewImpl(Context context, ViewGroup container) {
        mView = LayoutInflater.from(context).inflate(R.layout.enter_name,container);
    }

    @Override
    public View getView() {
        return mView;
    }
}
