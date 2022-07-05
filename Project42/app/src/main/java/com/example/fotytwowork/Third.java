package com.example.fotytwowork;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import android.view.View;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Third extends AppCompatActivity {
    private final List<Valute> valute = new ArrayList<>();
    AdapterValute adapter;
    ListView listView;
    MyTask mt;
    String xmlString;
    String link = "https://www.cbr.ru/scripts/XML_daily.asp?date_req=";
    String date = "";
    Button btnDate;
    String mycoef = "";
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
        btnDate.setText(date);
        valute.clear();
        parse();
        listView.invalidateViews();
    }
    public void parse(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ayayay-ay.ru/wsr_banks/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        coefApi coefApi = retrofit.create(coefApi.class);

        Call<List<Coef>> coefs = coefApi.coefs();

        coefs.enqueue(new Callback<List<Coef>>() {
            @Override
            public void onResponse(Call<List<Coef>> call, Response<List<Coef>> response) {
                mycoef = response.body().get(0).getCoef();
                ParseWork(mycoef);
            }

            @Override
            public void onFailure(Call<List<Coef>> call, Throwable t) {
                Log.d("MYTAG",t.toString());
            }
        });
    }
    public void ParseWork(String mycoef){
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
        ParserValute parser = new ParserValute(xmlString, valute);
        listView = (ListView) findViewById(R.id.listView);
        adapter = new AdapterValute(this, valute, Double.valueOf(mycoef));
        listView.setAdapter(adapter);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_act);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        date =  dateFormat.format(cal.getTime());
        btnDate = (Button)findViewById(R.id.btndate);
        btnDate.setText(date);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Валюта");
        parse();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}