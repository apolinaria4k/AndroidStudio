package com.example.project13;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity
implements TextWatcher{

    Button btn;
    EditText et;
    TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btn = (Button)findViewById(R.id.btn);
        et= (EditText)findViewById(R.id.et);
        tv = (TextView)findViewById(R.id.tv);

        btn.setEnabled(false);
        et.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if(et.getText().toString().trim().length() != 0){
            btn.setEnabled(true);
        }
        else{
            btn.setEnabled(false);
        }

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    public void Button(View view){
        String s = et.getText().toString();
        tv.setText(s);
    }

}
