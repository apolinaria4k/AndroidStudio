package com.example.project20;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;

import java.util.List;

public class Main extends MyBaseActivity
implements AdapterView.OnItemClickListener {

    Adapter adapter;
    protected MyApp myApp;
    ListView lv;
    List<String> notes;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        myApp = (MyApp)getApplicationContext();
        notes = myApp.GetList();
        lv = (ListView)findViewById(R.id.lv);
        adapter = new Adapter(this);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }


    public void Add(View view){
        Intent intent = new Intent(this, Second.class);
        intent.putExtra(EXTRA_TEXT, "");
        startActivityForResult(intent, CREATE_ACTION);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, Second.class);
        intent.putExtra(EXTRA_TEXT, notes.get(position));
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
//                    notes.add(str);
                    String str1 = getResources().getString(R.string.str1);
                    myApp.addInList(str, str1);
                    lv.invalidateViews();
                    break;
                case EDIT_ACTION:
                    int position = bundle.getInt(EXTRA_ID);
//                    notes.set(position, str);
                    String str2 = getResources().getString(R.string.str2);
                    myApp.setInList(position, str, str2);
                    lv.invalidateViews();
                    break;
            }
        }
    }
}
