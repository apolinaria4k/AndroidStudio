package com.example.project35;

import android.os.Bundle;
import android.view.Menu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mennu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
