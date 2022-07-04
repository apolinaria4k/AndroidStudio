package com.example.project33;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class MyDataBase extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "DBnote4";

    public MyDataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(WorkDB.getCreateStatement());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public static final class WorkDB {
        public static final String TABLE_NAME = "mytable";
        public static final String COLUMN_HEADTEXT = "headtext";
        public static final String COLUMN_TEXT = "text";
        public static final String COLUMN_TIME = "time";
        public static final String COLUMN_PRIORITY = "priority";
        public static String getCreateStatement(){
            return String.format(
                    "CREATE TABLE %s(" +
                            "%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "%s TEXT," +
                            "%s TEXT," +
                            "%s TEXT," +
                            "%s TEXT" +
                            ")",
                    TABLE_NAME,
                    BaseColumns._ID,
                    COLUMN_HEADTEXT,
                    COLUMN_TEXT,
                    COLUMN_TIME,
                    COLUMN_PRIORITY
            );
        }
        public static String[] getNote(Cursor cursor){
            int headtextID = cursor.getColumnIndex(COLUMN_HEADTEXT),
                    textID = cursor.getColumnIndex(COLUMN_TEXT),
                    timeID = cursor.getColumnIndex(COLUMN_TIME),
                    priorityID = cursor.getColumnIndex(COLUMN_PRIORITY);
            String id = cursor.getString(headtextID);
            String text = cursor.getString(textID);
            String time = cursor.getString(timeID);
            String priority = cursor.getString(priorityID);
            String[] note = new String[] {id, text, time, priority};
            return note;
        }
        public static long insertNote(SQLiteDatabase db, String headtext, String text, String time, String priority){
            ContentValues values = new ContentValues();
            values.put(COLUMN_HEADTEXT, headtext);
            values.put(COLUMN_TEXT, text);
            values.put(COLUMN_TIME, time);
            values.put(COLUMN_PRIORITY, priority);
            return db.insert(TABLE_NAME, null, values);
        }
        public static long editNote(SQLiteDatabase db,String id, String headtext, String text, String priority, String time){
            ContentValues values = new ContentValues();
            values.put(COLUMN_HEADTEXT, headtext);
            values.put(COLUMN_TEXT, text);
            values.put(COLUMN_TIME, time);
            values.put(COLUMN_PRIORITY, priority);
            return db.update(TABLE_NAME, values,
                    "_id = ?",
                    new String[]{id});
        }
    }
}