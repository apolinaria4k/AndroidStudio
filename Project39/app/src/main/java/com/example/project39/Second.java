package com.example.project39;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Second extends AppCompatActivity {
    List<MyBank> bankNotes = new ArrayList<>();
    ListView listView;
    Adapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        listView = (ListView)findViewById(R.id.listView);
        adapter = new Adapter(bankNotes,this);
        listView.setAdapter(adapter);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        ParseJson();
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
    public void ParseJson(){
        String jsonText="";
        JSONObject jsonRoot;  //здесь хранится json-объект
        JSONArray jsonArray;  //здесь хранится json-массив

        try {
            jsonText = readText(this, R.raw.banki);  //читаем json-файл, readText приведен ниже
            jsonRoot = new JSONObject(jsonText);  //из строки — содержимого файла создаем программный json-объект
            jsonArray = jsonRoot.getJSONArray("banks"); //извлекаем из json-объекта массив, хранящийся под ключом «banks»
            JSONObject[] banks = new JSONObject[jsonArray.length()];//создаем массив для хранения json-объектов
            for(int i=0;i < jsonArray.length();i++) {  //цикл для заполнения массива json-объектов
                banks[i] = jsonArray.getJSONObject(i);  //извлекаем очередной json-объект
                String adr=banks[i].getString("adr");  // извлекаем из json-объекта строковое поле с ключом «adr»
                //извлеките из json-объекта остальные поля
                JSONArray tt = banks[i].getJSONArray("t");
                int[] tInt = new int[tt.length()];
                for(int j = 0; j < tt.length(); j++){
                    tInt[j] = tt.getInt(j);
                }
                String start = banks[i].getString("start");
                String fin = banks[i].getString("fin");
                //добавьте извлеченные поля в список отделений/банкоматов
                bankNotes.add(new MyBank(adr, start, fin, tInt));
            }
        } catch(Exception e)  {
            e.printStackTrace();
        }

    }
    private static String readText(Context context, int resId) throws IOException {
        InputStream is = context.getResources().openRawResource(resId);
        BufferedReader br= new BufferedReader(new InputStreamReader(is));
        StringBuilder sb= new StringBuilder();
        String s= null;
        while((  s = br.readLine())!=null) {
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }

}