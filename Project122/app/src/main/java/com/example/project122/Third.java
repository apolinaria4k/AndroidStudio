package com.example.project122;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class Third extends MyBaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);
    }

    public void Back2(View view){
        super.onBackPressed();
    }
}
