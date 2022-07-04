package com.example.project39;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Adapter extends BaseAdapter {
    List<MyBank> list;
    Context context;
    public Adapter(List<MyBank> _list, Context _context){
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
        return list.get(i).getStart();
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
            convertView = layoutInflater.inflate(R.layout.spisok, parent, false);
        }
        LinearLayout linearLayout = (LinearLayout) convertView;
        TextView nameBank = (TextView)linearLayout.findViewById(R.id.nameBank);
        nameBank.setText(list.get(position).getAdr());
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
        TextView workTime = (TextView)linearLayout.findViewById(R.id.workTime);
        workTime.setText(startStr(position) + " - " + finStr(position));
        return convertView;
    }
}
