package com.example.fotyonework;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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

    public String startStr(int i){
        return list.get(i).getStrt();
    }
    public String finStr(int i){
        return list.get(i).getFin();
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
        TextView addr = (TextView)linearLayout.findViewById(R.id.addr);
        addr.setText(list.get(position).getAddr());
        TextView t = (TextView)linearLayout.findViewById(R.id.t);
        String type = list.get(position).getT();
        if(type.equals("1")){
            t.setText("Отделение");
        } else if(type.equals("2")){
            t.setText("Банкомат");
        }
        int color;
        String working = "";
        Calendar c=Calendar.getInstance();
        SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm");
        String dateTime=dateFormat.format(c.getTime());
        if(dateTime.compareTo(startStr(position))>=0 && dateTime.compareTo(finStr(position))<=0){
            color = ContextCompat.getColor(context, R.color.work);
            working = "Работает";
        } else{
            color = ContextCompat.getColor(context, R.color.notwork);
            working = "Закрыто";
        }
        TextView workBank = (TextView)linearLayout.findViewById(R.id.workBank);
        workBank.setText(working);
        workBank.setTextColor(color);
        TextView strtfin = (TextView)linearLayout.findViewById(R.id.strtfin);
        strtfin.setText(startStr(position) + " - " + finStr(position));
        return convertView;
    }

}