package com.triviaapp.database;

import com.triviaapp.model.DataModel;

import java.util.ArrayList;

public interface DatabaseInterface {
    void setData(DataModel model);
    ArrayList<DataModel> getData();

}
