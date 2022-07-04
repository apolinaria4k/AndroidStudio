package com.example.project122;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;

public class ColorSelector extends MyBaseActivity
implements AdapterView.OnItemClickListener {
    Adapter adapter;
    int colorValue;
    ListView lv;
    SharedPreferences preferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.colorselector);

        lv = (ListView)findViewById(R.id.lv);

        String[]names = getResources().getStringArray(R.array.names);
        int[]colors = getResources().getIntArray(R.array.color_values);

        adapter = new Adapter(names, colors);
        lv.setAdapter(adapter);
        preferences = getSharedPreferences("", MODE_PRIVATE);
        lv.setOnItemClickListener(this);
    }

    public void Back1(View view){
        super.onBackPressed();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        colorValue = (int)adapter.getItem(position);
        getWindow().getDecorView().setBackgroundColor(colorValue);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("1", colorValue);
        editor.commit();
    }
}
