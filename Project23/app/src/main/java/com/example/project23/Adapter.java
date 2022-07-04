package com.example.project23;

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
    Context context;
    MyApp myApp;
    List<String> list;
    private final Random random;

    public Adapter(Context _context){
        context = _context;
        myApp = (MyApp)context.getApplicationContext();
        list = myApp.getList();
        random = new Random();
    }

    int randomColor(){
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        return Color.rgb(red, green, blue);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
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
        TextView textView = (TextView)linearLayout.findViewById(R.id.tv);
        textView.setText(list.get(position));
        ColoredView colorsquare = (ColoredView)linearLayout.findViewById(R.id.colorsquare);
        colorsquare.setColor(randomColor());
        return convertView;
    }
}
