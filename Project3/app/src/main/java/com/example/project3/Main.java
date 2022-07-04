package com.example.project3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Main extends AppCompatActivity {
    private LinearLayout linearLayout;
    private TextView textView1, textView2;
    Button button1, button2, button3, button4, button5, button6;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        linearLayout=(LinearLayout)findViewById(R.id.mLL);
        textView1=(TextView)findViewById(R.id.tv1);
        textView2=(TextView)findViewById(R.id.tv2);
        button1=(Button)findViewById(R.id.btn1);
        button2=(Button)findViewById(R.id.btn2);
        button3=(Button)findViewById(R.id.btn3);
        button4=(Button)findViewById(R.id.btn4);
        button5=(Button)findViewById(R.id.btn5);
        button6=(Button)findViewById(R.id.btn6);
    }
    public void toRedGreen(View view){
        textView1.setBackgroundColor(ContextCompat.getColor(this,R.color.btnRed));
        textView1.setTextColor(ContextCompat.getColor(this,R.color.txtGreen));
        textView2.setBackgroundColor(ContextCompat.getColor(this,R.color.btnRed));
        textView2.setTextColor(ContextCompat.getColor(this,R.color.txtGreen));
    }
    public void toYellowBlue(View view){
        textView1.setBackgroundColor(ContextCompat.getColor(this,R.color.btnYel));
        textView1.setTextColor(ContextCompat.getColor(this,R.color.btnBlue));
        textView2.setBackgroundColor(ContextCompat.getColor(this,R.color.btnYel));
        textView2.setTextColor(ContextCompat.getColor(this,R.color.btnBlue));
    }
    public void toBlackWhite(View view){
        textView1.setBackgroundColor(ContextCompat.getColor(this,R.color.black));
        textView1.setTextColor(ContextCompat.getColor(this,R.color.white));
        textView2.setBackgroundColor(ContextCompat.getColor(this,R.color.black));
        textView2.setTextColor(ContextCompat.getColor(this,R.color.white));
    }

    public void toRed(View view){
        linearLayout.setBackgroundColor(ContextCompat.getColor(this,R.color.btnRed));
    }
    public void toBlue(View view){
        linearLayout.setBackgroundColor(ContextCompat.getColor(this,R.color.btnBlue));
    }
    public void toBlack(View view){
        linearLayout.setBackgroundColor(ContextCompat.getColor(this,R.color.black));
    }
}
