package com.example.project17;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {
    protected MyApp myApp;
    EditText et1, et2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        myApp = (MyApp)getApplicationContext();
        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
        String str1 = getResources().getString(R.string.str1);
        String str2 = getResources().getString(R.string.str2);
        myApp.setStr1(str1);
        myApp.setStr2(str2);
        et1.setText(str1);
        et2.setText(str2);
    }

    public void secondAct(View view){
        myApp.setStr1(et1.getText().toString());
        myApp.setStr2(et2.getText().toString());

        Intent intent = new Intent(this, Second.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        et1.setText(myApp.getStr1());
        et2.setText(myApp.getStr2());
    }
}
