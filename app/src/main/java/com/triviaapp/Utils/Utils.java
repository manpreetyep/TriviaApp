package com.triviaapp.Utils;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static String getCurrentDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        String date = sdf.format(new Date());
        return date;
    }

    public static String getDate(){
        String months[] = {"Jan","Feb","Mar","Apr","May","Jun","July","Aug","Sep","Oct","Nov","Dec"};
        String[] val ={"01","02","03","04","05","06","07","08","09","10","11","12"};

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
        String date = sdf.format(new Date());

        String month = date.substring(5,7);
        String year = date.substring(0,4);
        String day = date.substring(8,10);
        Log.e("date",""+date);
        Log.e("day",""+date.substring(8,10));
        Log.e("timee",""+date.substring(11,18));


        for(int j=0;j<months.length;j++){
            if(val[j].equalsIgnoreCase(month)){
                date = day +"th" +" "+ months[j]+ " "+date.substring(11,18) ;
            }
        }
        return date;
    }
}
