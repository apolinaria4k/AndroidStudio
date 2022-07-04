package com.example.project17;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Second extends AppCompatActivity {
    MyApp myApp;
    EditText et1, et2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        myApp = (MyApp)getApplicationContext();
        et1 = (EditText)findViewById(R.id.et3);
        et2 = (EditText)findViewById(R.id.et4);
    }

    public void OK(View view){
        myApp.setStr1(et1.getText().toString());
        myApp.setStr2(et2.getText().toString());
        onBackPressed();
    }

    public void Cancel(View view){
        onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
        et1.setText(myApp.getStr1());
        et2.setText(myApp.getStr2());
    }
}
