package com.example.fotytwowork;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
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

public class Main extends AppCompatActivity {
    TextView textViewDate, textViewDollar, textViewEuro;
    private final List<Valute> valute = new ArrayList<>();
    String date = "";
    MyTask mt;
    String xmlString;
    String link = "https://www.cbr.ru/scripts/XML_daily.asp?date_req=";
    String mycoef = "";
    Context context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);
        textViewDate = (TextView) findViewById(R.id.dateonbtn);
        textViewDollar = (TextView) findViewById(R.id.usd);
        textViewEuro = (TextView) findViewById(R.id.eur);
        context = this;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        date = dateFormat.format(cal.getTime());
        textViewDate.setText(date);
        parse();
    }

    public void ParseWork() {
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
        double mycoef2 =Double.valueOf(mycoef);
        ParserValute parser = new ParserValute(xmlString, valute);
        for (int i = 0; i < valute.size(); i++) {
            if (valute.get(i).getValuteCharCode().equals("USD")) {
                textViewDollar.setText(
                        String.format(
                                "%.2f",
                                mycoef2 * valute.get(i).getValuteValue() +
                                        valute.get(i).getValuteValue()));
            }
            if (valute.get(i).getValuteCharCode().equals("EUR")) {
                textViewEuro.setText(
                        String.format(
                                "%.2f",
                                mycoef2 * valute.get(i).getValuteValue() +
                                        valute.get(i).getValuteValue()));
            }
        }
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
                ParseWork();
            }

            @Override
            public void onFailure(Call<List<Coef>> call, Throwable t) {
                Log.d("MYTAG",t.toString());
            }
        });
    }
    public void enter_Click(View view){
        FragmentManager manager = getSupportFragmentManager();
        EnterDialog enterDialog = new EnterDialog();
        enterDialog.show(manager, "myDialog");
    }
    public void btnforBank_Click(View view){
        Intent intent = new Intent(this, Second.class);
        startActivity(intent);
    }
    public void valute_Click(View view){
        Intent intent2 = new Intent(this, Third.class);
        startActivity(intent2);
    }
}
