package com.example.project25;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class Main extends AppCompatActivity {

    ArrayAdapter<String> arad;
    EditText et1, et2, et3;
    ListView listView;
    private TestsHelper dbHelper;
    private Cursor cursor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        et1 = (EditText)findViewById(R.id.et1);
        et2 =(EditText)findViewById(R.id.et2);
        et3 = (EditText)findViewById(R.id.et3);
        listView = (ListView)findViewById(R.id.lv);
        arad = new ArrayAdapter<String>(this, R.layout.spisok);
        listView.setAdapter(arad);
        dbHelper = new TestsHelper(this);
        loadTests();
    }

    public void Add(View view){
        String lastname = et1.getText().toString(),
                name = et2.getText().toString();
        int age = Integer.valueOf(et3.getText().toString());
        addTest(lastname, name, age);
        et1.setText("");
        et2.setText("");
        et3.setText("");
    }

    public void Table(View view){
        arad.clear();
        arad.notifyDataSetChanged();
        for(int i = 0; i < getNotesCount(); i++){
            arad.add(getTest(i));
        }
    }

    public int getNotesCount(){
        return cursor.getCount();
    }
    public void loadTests(){
        cursor = dbHelper.getReadableDatabase().rawQuery(
                String.format(
                        "SELECT * FROM %s",
                        TestsHelper.Tests.TABLE_NAME
                ), null);
    }

    public String getTest(int id){
        cursor.moveToPosition(id);
        return TestsHelper.Tests.getTest(cursor);
    }

    public void addTest(String Lastname, String name, int age){
        TestsHelper.Tests.insertTest(
                dbHelper.getWritableDatabase(),
                Lastname, name, age
        );
        loadTests();
    }
}
