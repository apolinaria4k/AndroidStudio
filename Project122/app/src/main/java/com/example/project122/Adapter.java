   package com.example.project122;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Adapter extends BaseAdapter {

    private String[]names;
    private int[]colors;

    public Adapter(String[] names, int[] colors) {
        this.names = names;
        this.colors = colors;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return colors[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter, parent, false);
        }

        TextView textView = (TextView) convertView;
        textView.setText(names[position]);
        textView.setBackgroundColor(colors[position]);
        if(position == 0){
            textView.setTextColor(colors[1]);
        }
        return convertView;
    }
}
