package com.example.project26;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class TestsHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "testDB";

    public TestsHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Tests.getCreateStatement());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public static final class Tests {
        public static final String TABLE_NAME = "mytable";
        public static final String COLUMN_LASTNAME = "lastname";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_AGE = "age";
        public static String getCreateStatement(){
            return String.format(
                    "CREATE TABLE %s(" +
                            "%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "%s TEXT," +
                            "%s TEXT," +
                            "%s INTEGER" +
                            ")",
                    TABLE_NAME,
                    BaseColumns._ID,
                    COLUMN_LASTNAME,
                    COLUMN_NAME,
                    COLUMN_AGE
            );
        }
        public static String getTest(Cursor cursor){
            int secondnameID = cursor.getColumnIndex(COLUMN_LASTNAME),
                    nameID = cursor.getColumnIndex(COLUMN_NAME),
                    ageID = cursor.getColumnIndex(COLUMN_AGE);
            String lastName=cursor.getString(secondnameID);
            String Name=cursor.getString(nameID);
            String Age=cursor.getString(ageID);
            return(lastName + " | " + Name + " | " + Age);
        }
        public static long insertTest(SQLiteDatabase db, String Name,String lastName, int Age){
            ContentValues values = new ContentValues();
            values.put(COLUMN_LASTNAME,lastName);
            values.put(COLUMN_NAME,Name);
            values.put(COLUMN_AGE, Age);
            return db.insert(TABLE_NAME, null, values);
        }
        public static long editTest(SQLiteDatabase db,String id, String name, String lastname, int age){
            ContentValues values = new ContentValues();
            values.put(COLUMN_LASTNAME,lastname);
            values.put(COLUMN_NAME,name);
            values.put(COLUMN_AGE, age);
            return db.update(TABLE_NAME, values,
                    "_id = ?",
                    new String[]{id});
        }
        public static Cursor searchTest(SQLiteDatabase db, String name, String lastname, int age){
            return db.query(TABLE_NAME,
                    null,
                    "lastname = ? and name = ? and age = ?",
                    new String[]{lastname, name, String.valueOf(age)},
                    null,null,null);
        }
        public static long deleteTest(SQLiteDatabase db,String id){
            return db.delete (TABLE_NAME,
                    "_id = ?",
                    new String[]{id});
        }
    }
}
