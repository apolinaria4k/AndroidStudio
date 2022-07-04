package com.example.project17;

import android.app.Application;

public class MyApp extends Application {
    String str1;
    String str2;
    public MyApp(){
        str1 = "dfva";
        str2 = "avae";
    }

    public void setStr1(String value) {
        this.str1 = value;
    }
    public void setStr2(String value) {
        this.str2 = value;
    }
    public String getStr1(){
        return str1;
    }
    public String getStr2(){
        return str2;
    }
}
