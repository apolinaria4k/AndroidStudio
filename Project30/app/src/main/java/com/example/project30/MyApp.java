package com.example.project30;

import android.app.Application;
import android.database.Cursor;

import java.sql.Time;

public class MyApp extends Application {
    public static final int ID = 1;
    public static final String CHANNEL_ID = "CHANNEL_ID";
    ToastHelper toastHelper;
    Notification notification;
    private MyDataBase dbHelper;
    private Cursor cursor;
    public MyApp(){
        super();
        toastHelper = new ToastHelper(this);
        notification = new Notification(this);
        dbHelper = new MyDataBase(this);
    }
    public void addInList(String headtext, String text, String priority){
        addInTable(headtext,text, priority);
        toastHelper.Show(text);
        notification.showNotification(ID,text, "Добавление записи");
    }
    public void setInList(int position, String headtext, String text, String priority){
        editInTable(position, headtext, text, priority);
        toastHelper.Show(text);
        notification.showNotification(ID,text, "Изменение записи");
    }
    public void addInTable(String headtext, String text, String priority){
        String time = String.valueOf(new Time(System.currentTimeMillis()));
        MyDataBase.WorkDB.insertNote(dbHelper.getWritableDatabase(),headtext, text,time, priority);
        loadNotes();
    }
    public void editInTable(int id, String headtext, String text, String priority){
        MyDataBase.WorkDB.editNote(dbHelper.getWritableDatabase(),String.valueOf(id), headtext, text, priority);
        loadNotes();
    }
    public void loadNotes(){
        cursor = dbHelper.getReadableDatabase().rawQuery(
                String.format(
                        "SELECT * FROM %s",
                        MyDataBase.WorkDB.TABLE_NAME
                ), null);
    }
    public int getNotesCount(){
        if(cursor != null){
            return cursor.getCount();
        }
        return 0;
    }
    public String[] getNote(int id){
        cursor.moveToPosition(id);
        return MyDataBase.WorkDB.getNote(cursor);
    }
    public int getindex(int id){
        return Integer.valueOf(getNote(id)[3]);
    }
}