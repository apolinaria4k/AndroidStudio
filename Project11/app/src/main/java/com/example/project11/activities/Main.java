package com.example.project11.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project11.R;
import com.example.project11.activities.Second;


public class Main extends AppCompatActivity {
    Button btn;
    SharedPreferences preferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        preferences = getSharedPreferences("", MODE_PRIVATE);
        btn =(Button)findViewById(R.id.btn);
    }

    public void openActivity(View view){
        Intent intent = new Intent(this, Second.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        int color = preferences.getInt("1", getResources().getColor(R.color.white));
        getWindow().getDecorView().setBackgroundColor(color);
    }
}
