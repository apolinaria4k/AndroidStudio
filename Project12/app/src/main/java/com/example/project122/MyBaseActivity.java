package com.example.project122;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MyBaseActivity extends AppCompatActivity {

    SharedPreferences preferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preferences = getSharedPreferences("", MODE_PRIVATE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        int color = preferences.getInt("1", getResources().getColor(R.color.white));
        getWindow().getDecorView().setBackgroundColor(color);
    }
}
