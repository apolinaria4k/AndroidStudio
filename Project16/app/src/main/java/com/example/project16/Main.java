package com.example.project16;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {
    EditText et1, et2;
    ToastHelper toasthelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
        toasthelper = new ToastHelper(this);
    }

    public void ShowToast(View view){
        Toast toast = Toast.makeText(getApplicationContext(), "Пора кормить кота!!!", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }

    public void ShowToast2(View view){
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(getApplicationContext(), R.string.catfood, duration);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
    }

    public void ShowToast3(View view){
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(getApplicationContext(), R.string.catfood, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        LinearLayout toastContainer = (LinearLayout)toast.getView();
        ImageView catImageView = new ImageView(getApplicationContext());
        catImageView.setImageResource(R.mipmap.rat);
        toastContainer.addView(catImageView, 0);
        //toastContainer.setBackgroundColor(Color.TRANSPARENT);
        toast.show();
    }

    public void ShowToast4(View view){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast, (ViewGroup) findViewById(R.id.toast1));

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    public void ShowToast5(View view){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast, (ViewGroup) findViewById(R.id.toast1));
        TextView tv1 = (TextView)layout.findViewById(R.id.tv1);
        tv1.setText("Вы покормили кота!");
        tv1.setBackgroundColor(getColor(R.color.cat1));
        tv1.setTextColor(getColor(R.color.black));
        TextView tv2 = (TextView)layout.findViewById(R.id.tv2);
        tv2.setText("Вы покормили кота!");
        tv2.setBackgroundColor(getColor(R.color.cat2));
        tv2.setTextColor(getColor(R.color.black));
        ImageView image = (ImageView)layout.findViewById(R.id.image);
        image.setImageResource(R.mipmap.cow);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    public void ShowToast6(View view){
        String str1 = et1.getText().toString();
        String str2 = et2.getText().toString();
        toasthelper.Show(str1, str2);
    }
}
