package com.example.project21;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.List;
import java.util.Random;

public class Adapter extends BaseAdapter {
    private final Random random;
    Context context;
    MyApp myApp;
    List<String> notes;

    public Adapter(Context _context){
        random = new Random();
        context = _context;
        myApp = (MyApp)context.getApplicationContext();
        notes = myApp.GetList();
    }

    int color(){
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return Color.rgb(r, g, b);
    }


    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public Object getItem(int position) {
        return notes.get(position);
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
        ColoredView coloredView = (ColoredView)linearLayout.findViewById(R.id.color);
        coloredView.setColor(color());
        TextView textView = (TextView)linearLayout.findViewById(R.id.tv);
        textView.setText(notes.get(position));

        return convertView;
    }
}
