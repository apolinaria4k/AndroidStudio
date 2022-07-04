package com.example.project34;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity
        implements AdapterView.OnItemClickListener{
    ArrayAdapter<String> arad;
    EditText editText;
    ListView listView;
    Button editBtn, delBtn, addBtn, clearBtn;
    View curView=null;
    int positionClick;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        editText = (EditText)findViewById(R.id.EditText);
        listView = (ListView)findViewById(R.id.listView);
        editBtn  = (Button)findViewById(R.id.editBtn);
        delBtn = (Button)findViewById(R.id.delBtn);
        addBtn  = (Button)findViewById(R.id.addBtn);
        clearBtn = (Button)findViewById(R.id.clearBtn);
        editBtn.setEnabled(false);
        delBtn.setEnabled(false);
        arad = new ArrayAdapter<String>(this, R.layout.spisok);
        listView.setAdapter(arad);
        arad.add("first");
        arad.add("second");
        listView.setOnItemClickListener(this);
    }
    public void add(){
        String str = editText.getText().toString();
        if(!str.isEmpty()){
            arad.add(str);
        }
        editText.setText("");
        if(curView!=null){
            curView.setBackgroundColor(getResources().getColor(R.color.background));
            curView=null;
        }
        editBtn.setEnabled(false);
        delBtn.setEnabled(false);
        menuItem1.setEnabled(false);
        menuItem2.setEnabled(false);
    }
    public void addClick(View view){
        add();
    }
    public void clear(){
        arad.clear();
        curView=null;
        editBtn.setEnabled(false);
        delBtn.setEnabled(false);
        menuItem1.setEnabled(false);
        menuItem2.setEnabled(false);
        editText.setText("");
    }
    public void clearClick(View view){
        clear();
    }
    public void edit(){
        if(curView!=null){
            String str = arad.getItem(positionClick);
            arad.remove(str);
            arad.insert(editText.getText().toString(), positionClick);
        }
    }
    public void editClick(View view){
        edit();
    }
    public void delete(){
        if(curView!=null){
            String str = arad.getItem(positionClick);
            arad.remove(str);
            editText.setText("");
            curView.setBackgroundColor(getResources().getColor(R.color.background));
            curView=null;
            editBtn.setEnabled(false);
            delBtn.setEnabled(false);
            menuItem1.setEnabled(false);
            menuItem2.setEnabled(false);
        }
    }
    public void delClick(View view){
        delete();
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        editBtn.setEnabled(true);
        delBtn.setEnabled(true);
        menuItem1.setEnabled(true);
        menuItem2.setEnabled(true);
        view.setBackgroundColor(Color.WHITE);
        positionClick = position;
        String s=arad.getItem(position);
        editText.setText(s);
        if(curView!=null){
            curView.setBackgroundColor(getResources().getColor(R.color.background));
        }
        curView = view;
    }
    MenuItem menuItem1, menuItem2;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        menuItem1 = menu.getItem(1);
        menuItem2 = menu.getItem(2);
        menuItem1.setEnabled(false);
        menuItem2.setEnabled(false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getTitle().toString()){
            case "add":{
                add();
                break;
            }
            case "edit":{
                edit();
                break;
            }
            case "delete":{
                delete();
                break;
            }
            case "clear":{
                clear();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

}
