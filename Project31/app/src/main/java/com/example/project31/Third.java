package com.example.project31;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Third extends AppCompatActivity {
    TextView textView1, textView2;
    TimePicker timePicker;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);
        textView1 = (TextView)findViewById(R.id.textviewcame);
        textView2 = (TextView)findViewById(R.id.textviewout);
        timePicker = (TimePicker)findViewById(R.id.timething);
        timePicker.setIs24HourView(true);
    }
    public void timecame_Click(View view){
        int hour = timePicker.getHour();
        int minute = timePicker.getMinute();
        textView1.setText(getResources().getText(R.string.timecame) + "\n" +
                String.valueOf(hour) + "." + String.valueOf(minute));
    }
    public void timeout_Click(View view){
        int hour = timePicker.getHour();
        int minute = timePicker.getMinute();
        textView2.setText(getResources().getText(R.string.timeout) + "\n" +
                String.valueOf(hour) + "." + String.valueOf(minute));
    }
    public void time_Click(View view){
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(calendar.HOUR_OF_DAY);
        int minute = calendar.get(calendar.MINUTE);
        timePicker.setHour(hour);
        timePicker.setMinute(minute);
    }
}
