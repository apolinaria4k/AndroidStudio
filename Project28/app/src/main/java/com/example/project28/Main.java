package com.example.project28;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {

    ArrayAdapter arad;
    ListView listView;
    Spinner spinner1, spinner2;
    Button button1, button2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        button1 = (Button)findViewById(R.id.btn1);
        button2 = (Button)findViewById(R.id.btn2);
        listView = (ListView)findViewById(R.id.listView);
        button1.setOnClickListener(forBtn1);
        ArrayAdapter adapterSpinner = new ArrayAdapter<>(this, R.layout.spinner);
        adapterSpinner.addAll(getResources().getStringArray(R.array.array));
        spinner1.setAdapter(adapterSpinner);
        spinner2.setAdapter(adapterSpinner);
        spinner1.setSelection(0);
        spinner2.setSelection(0);
        arad = new ArrayAdapter<String>(this, R.layout.spinner);
        listView.setAdapter(arad);
        button2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        arad.add(spinner2.getSelectedItem());
                    }
                }
        );
    }
    private View.OnClickListener forBtn1 =
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    arad.add(spinner1.getSelectedItem());
                }
            };
}
