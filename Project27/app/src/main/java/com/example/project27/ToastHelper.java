package com.example.project27;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ToastHelper {
    Context context;
    public ToastHelper(Context _context){
        context = _context;
    }
    public void Show(String message1){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.toast,null);
        Toast toast = new Toast(context);
        TextView tv1 = (TextView)layout.findViewById(R.id.textView1);
        tv1.setText(message1);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}