package com.example.project27;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MyAdapter extends BaseAdapter {
    Context context;
    MyApp myApp;
    private final Random random;
    public MyAdapter(Context _context){
        context = _context;
        myApp = (MyApp)context.getApplicationContext();
        random = new Random();
    }
    int getRandomColor(){
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        return Color.rgb(red, green, blue);
    }
    @Override
    public int getCount() {
        return myApp.getNotesCount();
    }

    @Override
    public String[] getItem(int position) {
        return myApp.getNote(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.spisok, parent, false);
        }
        LinearLayout linearLayout = (LinearLayout) convertView;
        TextView textView1 = (TextView)linearLayout.findViewById(R.id.mytext1);
        textView1.setText(getItem(position)[0]);
        TextView textView2 = (TextView)linearLayout.findViewById(R.id.mytext2);
        textView2.setText(getItem(position)[1]);
        TextView textView3 = (TextView)linearLayout.findViewById(R.id.mytext3);
        textView3.setText(getItem(position)[2]);
        ColoredView colorsquare = (ColoredView)linearLayout.findViewById(R.id.colorsquare);
        colorsquare.setColor(getRandomColor());
        return convertView;
    }
}