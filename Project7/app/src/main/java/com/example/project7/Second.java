package com.example.project7;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;

public class Second extends Activity
implements AdapterView.OnItemClickListener{

    private ArrayAdapter<String> adapter1;
    private ArrayAdapter<String> adapter2;

    private ListView lv1, lv2;
    private EditText et;
    Button edit1, edit2, back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_act);

        adapter1 = new ArrayAdapter<String>(this, R.layout.textview);
        adapter2 = new ArrayAdapter<String>(this, R.layout.textview);

        lv1=(ListView)findViewById(R.id.lv1);
        lv1.setAdapter(adapter1);
        lv1.setOnItemClickListener(this);

        lv2=(ListView)findViewById(R.id.lv2);
        lv2.setAdapter(adapter2);
        lv2.setOnItemClickListener(this);

        et = (EditText)findViewById(R.id.et);
        edit1=(Button)findViewById(R.id.edit1);
        edit2=(Button)findViewById(R.id.edit2);
        back=(Button)findViewById(R.id.back);

        String []ar1 = getResources().getStringArray(R.array.ar1);
        adapter1.addAll(ar1);

        String []ar2 = getResources().getStringArray(R.array.ar2);
        adapter2.addAll(ar2);
    }


    public void Add1(View view){
        String s = et.getText().toString();
        adapter1.add(s);
//        et.setText("");
    }

    public void Add2(View view){
        String s = et.getText().toString();
        adapter2.add(s);
//        et.setText("");
    }

    public void Back(View view){
        super.onBackPressed();
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
