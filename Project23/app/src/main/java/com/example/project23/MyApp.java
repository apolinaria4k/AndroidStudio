package com.example.project23;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class MyApp extends Application {
    public static final int ID = 1;
    public static final String CHANNEL_ID = "CHANNEL_ID";
    private final List<String> notes = new ArrayList<>();
    ToastHelper toastHelper;
    Notification notification;

    public MyApp(){
        super();
        notes.add("Record 1");
        notes.add("Record 2");
        toastHelper = new ToastHelper(this);
        notification = new Notification(this);
    }

    public List<String> getList(){
        return notes;
    }
    public void  addInList(String str){
        notes.add(str);
        toastHelper.Show("Запись "+ str + " добавлена");
        notification.ShowNotification(ID, str, "Добавление записи");
    }

    public void setInList(int position, String str){
        notes.set(position, str);
        toastHelper.Show("Запись "+ str+ " изменена");
        notification.ShowNotification(ID, str, "Изменение записи");
    }
}
