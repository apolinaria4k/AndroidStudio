package com.example.project6;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Third extends Activity {
    Button btn2;
    TextView tv2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_act);
        btn2=(Button)findViewById(R.id.btn2);
        tv2=(TextView)findViewById(R.id.tv2);
    }

    public void Back1(View view){
        super.onBackPressed();
    }
}
