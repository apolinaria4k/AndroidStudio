package com.example.project27;

import java.io.Serializable;
import java.sql.Time;

public class Note implements Serializable {
    String headText, mainText;
    Time time;
    public Note(String _headText, String _mainText, Time _time){
        headText = _headText;
        mainText = _mainText;
        time = _time;
    }
    public void set_headText(String newValue){
        this.headText = newValue;
    }
    public void set_mainText(String newValue){
        this.mainText = newValue;
    }
    public void set_Time(Time newValue){
        this.time = newValue;
    }
    public String getHeadText(){return headText;}
    public String getMainText(){return mainText;}
    public Time getTime(){return time;}
}