package com.example.project11.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project11.R;

public class Second extends AppCompatActivity
implements AdapterView.OnItemClickListener {
    ColorsAdapter colorsAdapter;
    int colorValue;
    Button back;
    ListView lv;
    SharedPreferences preferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        preferences = getSharedPreferences("", MODE_PRIVATE);
        back=(Button)findViewById(R.id.back);
        lv=(ListView)findViewById(R.id.lv);

        String[] names = getResources().getStringArray(R.array.names);
        int[] values = getResources().getIntArray(R.array.color_values);

        colorsAdapter = new ColorsAdapter(values, names);

        lv.setAdapter(colorsAdapter);
        lv.setOnItemClickListener(this);
    }

    public void Back(View view){
        super.onBackPressed();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        colorValue = (int)colorsAdapter.getItem(position);
        getWindow().getDecorView().setBackgroundColor(colorValue);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("1", colorValue);
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        int color = preferences.getInt("1", colorValue);
        getWindow().getDecorView().setBackgroundColor(color);
    }
}
