package com.example.fotywork2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter{
    List<Message> list;
    Context context;
    public Adapter(Context _context, List<Message> _list){
        context = _context;
        list = _list;
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
            convertView = layoutInflater.inflate(R.layout.le, parent, false);
        }
        LinearLayout linearLayout = (LinearLayout) convertView;
        TextView textID = (TextView)linearLayout.findViewById(R.id.textID);
        textID.setText(String.valueOf(list.get(position).getId()));
        TextView texttime = (TextView)linearLayout.findViewById(R.id.textTime);
        texttime.setText(String.valueOf(list.get(position).getTime()));
        return convertView;
    }

}
