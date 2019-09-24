package com.triviaapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

import com.triviaapp.model.DataModel;

import java.util.ArrayList;
import java.util.HashMap;

public class Databasehandler extends SQLiteOpenHelper implements DatabaseInterface {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "trivia";

    // table keys
    private static final String ID="id";
    private static final String GAME="game";
    private static final String NAME="user_name";
    private static final String DATE="date";
    private static final String QUESTIONONE="questionone";
    private static final String ANSWERONE="anwserone";
    private static final String QUESTIONTWO="questiontwo";
    private static final String ANSWERTWO="anwsertwo";

    //table names
    private static final String TABLE_HISTORY="table_history";

    public Databasehandler(Context context) {
        super(context, Environment.getExternalStorageDirectory()
              + "/triviaapp" +DATABASE_NAME ,null,DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
       String CREATE_TABLE_HISTORY = " CREATE TABLE " + TABLE_HISTORY + "("
                + ID + " TEXT, "
                + GAME + " TEXT,"
                + NAME + " TEXT,"
                + DATE + " TEXT,"
                + QUESTIONTWO + " TEXT,"
                + ANSWERTWO + " TEXT,"
                + QUESTIONONE + " TEXT,"
                + ANSWERONE + " TEXT" +")";

        sqLiteDatabase.execSQL(CREATE_TABLE_HISTORY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_HISTORY);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void setData(DataModel model) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ID,model.id);
        cv.put(GAME,model.game);
        cv.put(DATE,model.date);
        cv.put(NAME,model.name);
        cv.put(QUESTIONONE,model.questionone);
        cv.put(ANSWERONE,model.answerone);
        cv.put(QUESTIONTWO,model.questiontwo);
        cv.put(ANSWERTWO,model.answertwo);
        sqLiteDatabase.insert(TABLE_HISTORY,null,cv);
        sqLiteDatabase.close();
    }

    @Override
    public ArrayList<DataModel> getData() {
        ArrayList<DataModel> list1 = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_HISTORY;
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                DataModel dataModel = new DataModel();

                dataModel.game =cursor.getString(cursor.getColumnIndex(GAME));
                dataModel.date =cursor.getString(cursor.getColumnIndex(DATE)) ;
                dataModel.name =cursor.getString(cursor.getColumnIndex(NAME)) ;
                dataModel.questionone =cursor.getString(cursor.getColumnIndex(QUESTIONONE)) ;
                dataModel.answerone =cursor.getString(cursor.getColumnIndex(ANSWERONE)) ;
                dataModel.questiontwo =cursor.getString(cursor.getColumnIndex(QUESTIONTWO)) ;
                dataModel.answertwo =cursor.getString(cursor.getColumnIndex(ANSWERTWO)) ;
                list1.add(dataModel);
            } while (cursor.moveToNext());
        }
        cursor.close();
        sqLiteDatabase.close();
        return list1;
    }


    public void deleteTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_HISTORY, null, null);
        db.close();
    }
}
