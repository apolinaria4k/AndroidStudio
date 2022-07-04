package com.example.project30;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;

public class Main extends MyBaseActivity
        implements AdapterView.OnItemClickListener {
    protected MyApp myApp;
    MyAdapter myAdapter;
    ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        myApp = (MyApp)getApplicationContext();
        myAdapter = new MyAdapter(this);
        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(this);
        myApp.loadNotes();
    }

    public void buttonAdd_Click(View view){
        Intent intent = new Intent(this, Second.class);
        intent.putExtra(EXTRA_HEADTEXT, "");
        intent.putExtra(EXTRA_TEXT, "");
        intent.putExtra(EXTRA_PRIORITY, "");
        startActivityForResult(intent, CREATE_ACTION);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, Second.class);
        intent.putExtra(EXTRA_HEADTEXT, myApp.getNote(position)[0]);
        intent.putExtra(EXTRA_TEXT, myApp.getNote(position)[1]);
        intent.putExtra(EXTRA_ID,position + 1 );
        intent.putExtra(EXTRA_PRIORITY, myApp.getNote(position)[3]);
        startActivityForResult(intent, EDIT_ACTION);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Bundle bundle = data.getExtras();
            String headtext = bundle.getString(EXTRA_HEADTEXT);
            String text = bundle.getString(EXTRA_TEXT);
            String priority = bundle.getString(EXTRA_PRIORITY);
            switch (requestCode){
                case CREATE_ACTION:
                    myApp.addInList(headtext, text, priority);
                    break;
                case EDIT_ACTION:
                    int position = bundle.getInt(EXTRA_ID);
                    myApp.setInList(position, headtext, text, priority);
                    break;
            }
            myApp.loadNotes();
            listView.invalidateViews();
        }
    }
}