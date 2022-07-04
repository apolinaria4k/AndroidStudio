package com.example.project22;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class Second2 extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second2);
        textView = (TextView)findViewById(R.id.textView);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String txt = bundle.getString(getResources().getString(R.string.newintent));
            if(txt != null){
                textView.setText(txt);
            }
        }
    }
}
