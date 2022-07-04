    package com.example.eightwork;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Second extends AppCompatActivity {
    ArrayAdapter<String> arrayAdapter1;
    ArrayAdapter<String> arrayAdapter2;
    ListView listView1, listView2;
    EditText editText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_act);
        editText = (EditText)findViewById(R.id.editText);
        listView1 = (ListView)findViewById(R.id.list1);
        listView2 = (ListView)findViewById(R.id.list2);
        arrayAdapter1 = new ArrayAdapter<String>(this, R.layout.le);
        arrayAdapter2 = new ArrayAdapter<String>(this, R.layout.le);
        listView1.setAdapter(arrayAdapter1);
        listView2.setAdapter(arrayAdapter2);
        String []array1 = getResources().getStringArray(R.array.array1);
        String []array2 = getResources().getStringArray(R.array.array2);
        arrayAdapter1.addAll(array1);
        arrayAdapter2.addAll(array2);
    }
    public void backClick(View view){
        this.onBackPressed();
    }

    public void addList1Click(View view){
        String str = editText.getText().toString();
        arrayAdapter1.add(str);
    }
    public void addList2Click(View view){
        String str = editText.getText().toString();
        arrayAdapter2.add(str);
    }
}
