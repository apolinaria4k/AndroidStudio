package com.example.project20;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class MyApp extends Application {
    private final List<String> notes = new ArrayList<>();
    ToastHelper toastHelper;

    public MyApp(){
        super();
        notes.add("Record 1");
        notes.add("Record 2");
        toastHelper = new ToastHelper(this);
    }

    public List<String> GetList(){
        return notes;
    }

    public void addInList(String str, String str1){
        notes.add(str);
        toastHelper.Show(str1);
    }
    public void setInList(int position, String str, String str2){
        notes.set(position, str);
        toastHelper.Show(str2);
    }
}

