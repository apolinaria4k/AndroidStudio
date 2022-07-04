package com.example.project7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class Main extends Activity {
    Button act;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        act=(Button)findViewById(R.id.act);
    }

    public void openActivity(View view){
        Intent intent = new Intent(this, Second.class);
        startActivity(intent);
    }
}
