package com.example.project5;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity
implements AdapterView.OnItemClickListener{
    private ArrayAdapter<String> arad;
    private ListView lw;
    private EditText et;
    int positionClick;
    Button editButton, delButton;
    private View curView = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        et = (EditText)findViewById(R.id.et);
        arad=new ArrayAdapter<String>(this,R.layout.textview);

        lw=(ListView)findViewById(R.id.lv);
        lw.setAdapter(arad);
        arad.add("first");
        arad.add("second");

        lw.setOnItemClickListener(this);
        editButton=(Button)findViewById(R.id.edit);
        delButton=(Button)findViewById(R.id.del);
        editButton.setEnabled(false);
        delButton.setEnabled(false);
    }
    public void Add(View view){
        String s = et.getText().toString();
        arad.add(s);
    }

    public void Clear(View view){
        arad.clear();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        editButton.setEnabled(true);
        delButton.setEnabled(true);
        view.setBackgroundColor(Color.MAGENTA);
        positionClick = position;
        String s=arad.getItem(position);
        et.setText(s);
        if(curView != null){
            curView.setBackgroundColor(getResources().getColor(R.color.lv));
        }
        curView = view;
    }

    public void Edit(View view){
        if(curView != null){
            String s= arad.getItem(positionClick);
            arad.remove(s);
            arad.insert(et.getText().toString(),positionClick);
        }
    }

    public void Del(View view){
        if(curView != null){
            String s= arad.getItem(positionClick);
            arad.remove(s);
            et.setText("");
            curView.setBackgroundColor(getResources().getColor(R.color.lv));
            curView = null;
            editButton.setEnabled(false);
            delButton.setEnabled(false);
        }
    }
}
