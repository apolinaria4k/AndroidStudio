package com.example.project11.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.project11.R;

public class ColorsAdapter extends BaseAdapter {

    private String[]names;
    private int[]values;

    public ColorsAdapter(int[] values, String[]names){
        this.values = values;
        this.names = names;
    }

    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Object getItem(int position) {
        return values[position];
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
        textView.setBackgroundColor(values[position]);
        if(position == 0){
            textView.setTextColor(values[1]);
        }
        return convertView;
    }
}
