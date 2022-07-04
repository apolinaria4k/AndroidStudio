package com.example.project241;

import android.app.Application;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class MyApp extends Application {
    public static final int ID = 1;
    public static final String CHANNEL_ID = "CHANNEL_ID";
    private final List<Note> notes = new ArrayList<>();
    ToastHelper toastHelper;
    Notification notification;

    public MyApp(){
        super();
        notes.add(new Note("1", "Record1",new Time(System.currentTimeMillis())));
        notes.add(new Note("2", "Record2",new Time(System.currentTimeMillis())));
        toastHelper = new ToastHelper(this);
        notification = new Notification(this);
    }
    public List<Note> getList(){
        return notes;
    }
    public void addInList(Note str){
        notes.add(str);
        toastHelper.Show("Запись добавлена");
        notification.showNotification(ID,str.getMainText(), "Добавление записи");
    }
    public void setInList(int position, Note str){
        notes.set(position, str);
        toastHelper.Show("Запись изменена");
        notification.showNotification(ID,str.getMainText(), "Изменение записи");
    }
}
