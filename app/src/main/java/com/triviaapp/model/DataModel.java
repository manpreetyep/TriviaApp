package com.triviaapp.model;

public class DataModel {
    public int id = 0;
    public String game="";
    public String name="";
    public String date="";
    public String questionone="";
    public String answerone="";
    public String questiontwo="";
    public String answertwo="";

//    public DataModel(int id, String name, String date, String question, String answer) {
//        this.id = id;
//        this.name = name;
//        this.date = date;
//        this.question = question;
//        this.answer = answer;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
