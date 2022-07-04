package com.example.project31;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Second extends AppCompatActivity {
    TextView textView1, textView2;
    DatePicker datePicker;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        textView1 = (TextView)findViewById(R.id.textviewdategive);
        textView2 = (TextView)findViewById(R.id.textviewdateout);
        datePicker = (DatePicker)findViewById(R.id.datething);
    }
    public void bookgive_Click(View view){
        int date = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();
        textView1.setText(getResources().getText(R.string.bookgive) + "\n" +
                String.valueOf(date) + "." +String.valueOf(month) + "." +String.valueOf(year));
    }
    public void bookout_Click(View view){
        int date = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();
        textView2.setText(getResources().getText(R.string.bookback) + "\n" +
                String.valueOf(date) + "." +String.valueOf(month) + "." +String.valueOf(year));
    }
    public void date_Click(View view){
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(calendar.DAY_OF_MONTH);
        int month = calendar.get(calendar.MONTH);
        int year = calendar.get(calendar.YEAR);
        datePicker.init(year, month, day, null);
    }
}
