package com.example.project36;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {
    List<Valute> list;
    Context context;
    double coef;
    public Adapter(Context _context, List<Valute> _list, double _coef){
        context = _context;
        list = _list;
        coef = _coef;
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
        TextView charCode = (TextView)linearLayout.findViewById(R.id.charCode);
        charCode.setText(list.get(position).getValuteCharCode());
        TextView name = (TextView)linearLayout.findViewById(R.id.name);
        name.setText(list.get(position).getValuteName());
        TextView valueValute = (TextView)linearLayout.findViewById(R.id.valueValute);
        valueValute.setText(String.format("%.2f",
                list.get(position).getValuteValue()));
        TextView valueValute2 = (TextView)linearLayout.findViewById(R.id.valueValute2);
        valueValute2.setText(
                String.format("%.2f",
                        list.get(position).getValuteValue() +
                                coef * list.get(position).getValuteValue()
                ));
        if(position % 2 ==0) {
            valueValute.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ar_green, 0);
            valueValute2.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ar_red, 0);
        } else {
            valueValute.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ar_red, 0);
            valueValute2.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ar_green, 0);
        }

        return convertView;
    }
}
