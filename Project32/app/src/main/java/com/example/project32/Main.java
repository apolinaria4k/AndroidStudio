package com.example.project32;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class Main extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        textView = (TextView)findViewById(R.id.textView);
    }
    public void btn1_Click(View view){
        FragmentManager manager = getSupportFragmentManager();
        MyDialogFragment myDialogFragment = new MyDialogFragment(textView);
        myDialogFragment.show(manager, "myDialog");
    }
    public void btn2_Click(View view){
        FragmentManager manager = getSupportFragmentManager();
        MyDialogFragment2 myDialogFragment2 = new MyDialogFragment2(textView);
        myDialogFragment2.show(manager, "myDialog");
    }
    public void btn3_Click(View view){
        FragmentManager manager = getSupportFragmentManager();
        MyDialogFragment3 myDialogFragment3 = new MyDialogFragment3(textView);
        myDialogFragment3.show(manager, "myDialog");
    }
    public void btn4_Click(View view){
        FragmentManager manager = getSupportFragmentManager();
        MyDialogFragment4 myDialogFragment4 = new MyDialogFragment4();
        myDialogFragment4.show(manager, "myDialog");
    }
    public void btn5_Click(View view){
        FragmentManager manager = getSupportFragmentManager();
        MyDialogFragment5 myDialogFragment5 = new MyDialogFragment5();
        myDialogFragment5.show(manager, "myDialog");
    }
    public void personokclicked(Person person){
        textView.setText(person.toString());
    }
    public void dateokclicked(int year, int month, int day){
        String text = String.valueOf(day) + "." +
                        String.valueOf(month) + "." +
                        String.valueOf(year);
        textView.setText("Выбранная дата:" + text);
    }
}
