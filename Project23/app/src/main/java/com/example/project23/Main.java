package com.example.project23;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearSmoothScroller;

import java.util.List;

public class Main extends MyBaseActivity
implements AdapterView.OnItemClickListener {

    protected MyApp myApp;
    List<String> list;
    Adapter adapter;
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        myApp = (MyApp)getApplicationContext();
        list = myApp.getList();
        adapter = new Adapter(this);
        listView = (ListView)findViewById(R.id.lv);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    public void Add(View view){
        Intent intent = new Intent(this, Second.class);
        intent.putExtra(EXTRA_TEXT, "");
        startActivityForResult(intent, CREATE_ACTION);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, Second.class);
        intent.putExtra(EXTRA_TEXT, list.get(position));
        intent.putExtra(EXTRA_ID, position);
        startActivityForResult(intent, EDIT_ACTION);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Bundle bundle = data.getExtras();
            String str = bundle.getString(EXTRA_TEXT);
            switch (requestCode){
                case CREATE_ACTION:
                    myApp.addInList(str);
                    listView.invalidateViews();
                    break;
                case EDIT_ACTION:
                    int position = bundle.getInt(EXTRA_ID);
                    myApp.setInList(position, str);
                    listView.invalidateViews();
                    break;
            }
        }
    }
}
