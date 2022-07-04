package com.example.fotywork2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Second extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sec_act);
        TextView textView = (TextView)findViewById(R.id.textView);
        Bundle bundle = getIntent().getExtras();
        textView.setText(bundle.getString("text"));
    }
}