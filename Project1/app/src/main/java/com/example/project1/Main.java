package com.example.project1;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity
implements View.OnClickListener{
    Button button1, button2, button3, button4;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        button1 = (Button)findViewById(R.id.btn1);
        button2 = (Button)findViewById(R.id.btn2);
        button3 = (Button)findViewById(R.id.btn3);
        button4 = (Button)findViewById(R.id.btn4);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button b = (Button)v;

        b.setText(R.string.afterClick);
    }
}

