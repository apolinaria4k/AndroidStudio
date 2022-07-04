package com.example.project4;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {
    private TextView tv;
    private EditText et1, et2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        tv = (TextView)findViewById(R.id.tv);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
    }
    public void Plus(View view){
        int a = Integer.valueOf(et1.getText().toString());
        int b =Integer.valueOf(et2.getText().toString());
        int sum = a + b;
        tv.setText(String.valueOf(a + "+" + b + "="+sum));
    }
    public void Minus(View view){
        int a = Integer.valueOf(et1.getText().toString());
        int b =Integer.valueOf(et2.getText().toString());
        int raz = a - b;
        tv.setText(String.valueOf(a + "-" + b + "="+raz));
    }
    public void Multiply(View view){
        int a = Integer.valueOf(et1.getText().toString());
        int b =Integer.valueOf(et2.getText().toString());
        int pr = a * b;
        tv.setText(String.valueOf(a + "*" + b + "="+pr));
    }
    public void Delete(View view){
        int a = Integer.valueOf(et1.getText().toString());
        int b =Integer.valueOf(et2.getText().toString());
        int del = a / b;
        tv.setText(String.valueOf(a + "/" + b + "="+del));
    }
}
