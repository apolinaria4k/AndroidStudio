package com.example.project6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class Main extends Activity {
    Button btn1, btn2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btn1=(Button)findViewById(R.id.secAct);
        btn2=(Button)findViewById(R.id.thirdAct);
    }

    public void openSecondActivity(View view){
        Intent intent = new Intent(this, Second.class);
        startActivity(intent);
    }

    public void openThirdActivity(View view){
        Intent intent = new Intent(this, Third.class);
        startActivity(intent);
    }
}
