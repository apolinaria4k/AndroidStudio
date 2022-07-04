package com.example.project18;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class Main extends AppCompatActivity {
    LinearLayout linearLayout;
    EditText et1, et2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
        linearLayout = (LinearLayout)findViewById(R.id.linear);

    }

    public void frstBtn(View view){
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        TextView textView = (TextView)inflater.inflate(R.layout.textview, null);
        textView.setText(et1.getText().toString());
        linearLayout.addView(textView);
    }

    public void secBtn(View view){
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout root = (LinearLayout)inflater.inflate(R.layout.second, null);
        TextView textView1 = (TextView)root.findViewById(R.id.tv1);
        TextView textView2 = (TextView)root.findViewById(R.id.tv2);

        textView1.setText(et1.getText().toString());
        textView2.setText(et2.getText().toString());
        linearLayout.addView(root);

    }
}
