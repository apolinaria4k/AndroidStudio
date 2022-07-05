package com.example.project241;

import java.io.Serializable;
import java.sql.Time;

public class Note implements Serializable {
    String headText, mainText;
    Time time;

    public Note(String _headText, String _maintext, Time _time){
        headText = _headText;
        mainText = _maintext;
        time = _time;
    }

    public void setHeadText(String value){
        this.headText = value;
    }
    public void setMainText(String value){
        this.mainText = value;
    }
    public void setTime(Time value){
        this.time = value;
    }

    public String getHeadText(){
        return headText;
    }
    public String getMainText(){
        return mainText;
    }
    public Time getTime(){
        return time;
    }
}

