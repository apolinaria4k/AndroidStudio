package com.example.project122;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class Main extends MyBaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void openSelector(View view){
        Intent intent = new Intent(this, ColorSelector.class);
        startActivity(intent);
    }

    public void openThird(View view){
        Intent intent = new Intent(this, Third.class);
        startActivity(intent);
    }
}
