package com.example.project10;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {
    ListView lv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        lv = (ListView)findViewById(R.id.lv);

        String []ar = getResources().getStringArray(R.array.ar);
        ColorsAdapter colorsAdapter = new ColorsAdapter(ar);
        lv.setAdapter(colorsAdapter);
    }
}
