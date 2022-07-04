package com.example.project6;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Second extends Activity {
    Button btn1;
    TextView tv1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_act);

        btn1=(Button)findViewById(R.id.btn1);
        tv1=(TextView)findViewById(R.id.tv1);
    }
    public void Back(View view){
        super.onBackPressed();
    }
}
