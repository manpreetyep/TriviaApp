package com.triviaapp.conroller;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.triviaapp.R;
import com.triviaapp.conroller.adapter.HistoryAdapter;
import com.triviaapp.database.Databasehandler;
import com.triviaapp.database.SessionManger;
import com.triviaapp.model.DataModel;
import com.triviaapp.view.EnterNameViewImpl;
import com.triviaapp.view.HistoryImpl;

import java.util.ArrayList;

public class HistoryActivity extends Activity {

    RecyclerView history_recyler_view;
    HistoryImpl viewImpl;
    Databasehandler databasehandler;
    ArrayList<DataModel> list = new ArrayList<>();
    LinearLayoutManager layoutManager;
    HistoryAdapter historyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewImpl = new HistoryImpl(HistoryActivity.this,null);
        setContentView(viewImpl.getView());

        initView();

    }

    private void initView() {
        list.clear();
        databasehandler = new Databasehandler(HistoryActivity.this);
        list = databasehandler.getData();


        for(int j=0;j<list.size();j++){
            Log.e("count",""+list.get(j).date);
            Log.e("questionone ",""+list.get(j).questionone);
        }

        history_recyler_view =findViewById(R.id.history_recyler_view);
        layoutManager = new LinearLayoutManager(HistoryActivity.this);
        history_recyler_view.setLayoutManager(layoutManager);
        historyAdapter = new HistoryAdapter(HistoryActivity.this,list);
        history_recyler_view.setAdapter(historyAdapter);
        historyAdapter.notifyDataSetChanged();
    }
}
