package com.example.project15;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;

public class Main extends MyBaseActivity
implements AdapterView.OnItemClickListener {
    ArrayAdapter<String> adapter;
    ListView lv;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        adapter = new ArrayAdapter<String>(this, R.layout.adapter);
        lv = (ListView)findViewById(R.id.lv);
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
        intent.putExtra(EXTRA_TEXT, adapter.getItem(position));
        intent.putExtra(EXTRA_ID, position);
        startActivityForResult(intent, EDIT_ACTION);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Bundle bundle = data.getExtras();
            String str = bundle.getString(EXTRA_TEXT);
            switch(requestCode){
                case CREATE_ACTION:
                    adapter.add(str);
                    break;
                case EDIT_ACTION:
                    int position = bundle.getInt(EXTRA_ID);
                    adapter.remove(adapter.getItem(position));
                    adapter.insert(str, position);
                    break;
            }
        }
    }
}
