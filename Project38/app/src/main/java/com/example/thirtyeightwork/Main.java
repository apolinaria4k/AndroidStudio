package com.example.thirtyeightwork;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import android.view.View;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main extends AppCompatActivity {
    private final List<Valute> valute = new ArrayList<>();
    private final double coef = 0.1f;
    Adapter adapter;
    ListView listView;
    MyTask mt;
    String xmlString;
    String link = "https://www.cbr.ru/scripts/XML_daily.asp?date_req=";
    String date = "23/03/2021";
    public void datepick_Click(View view){
        FragmentManager manager = getSupportFragmentManager();
        DialogDate dialogDate = new DialogDate();
        dialogDate.show(manager, "myDialog");
    }
    public void dateokclicked(int year , int month, int day){
        String daystr = String.valueOf(day);
        if(day < 10){
            daystr = "0" + String.valueOf(day);
        }
        month++;
        String monthstr = String.valueOf(month);
        if(month < 10){
            monthstr = "0" + String.valueOf(month);
        }
        date =  daystr + "/" + monthstr + "/" + String.valueOf(year);
        Button btn = (Button)findViewById(R.id.btndate);
        btn.setText(date);
        valute.clear();
        ParseWork();
        listView.invalidateViews();
    }
    public void ParseWork(){
        mt = new MyTask();
        mt.execute(link.concat(date));
        try {
            xmlString = mt.get(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        Parser parser = new Parser(xmlString, valute);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);
        listView = (ListView) findViewById(R.id.listView);
        adapter = new Adapter(this, valute, coef);
        listView.setAdapter(adapter);
        ParseWork();
    }
}
