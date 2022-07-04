package com.example.project26;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity{
    ArrayAdapter<String> arad;
    EditText editText1, editText2, editText3;
    ListView listView;
    private TestsHelper dbHelper;
    private Cursor cursor;
    String id = "";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);
        listView = (ListView)findViewById(R.id.listView);
        arad = new ArrayAdapter<String>(this, R.layout.spisok);
        listView.setAdapter(arad);
        dbHelper = new TestsHelper(this);
        loadTests();

    }
    public void add_Click(View view){
        String  name = editText1.getText().toString(),
                lastname = editText2.getText().toString();
        int age = Integer.valueOf(editText3.getText().toString());
        addTest(name, lastname, age);
        editText1.setText("");
        editText2.setText("");
        editText3.setText("");
    }
    public void edit_Click(View view){
            String  name = editText1.getText().toString(),
                    lastname = editText2.getText().toString();
            int age = Integer.valueOf(editText3.getText().toString());
            TestsHelper.Tests.editTest(dbHelper.getWritableDatabase(),id,name, lastname, age);
    }
    public void delete_Click(View view){
        String  name = editText1.getText().toString(),
                lastname = editText2.getText().toString();
        int age = Integer.valueOf(editText3.getText().toString());
        TestsHelper.Tests.deleteTest(dbHelper.getWritableDatabase(),id);
    }
    public void search_Click(View view){
        String  name = editText1.getText().toString(),
                lastname = editText2.getText().toString();
        int age = Integer.valueOf(editText3.getText().toString());
        Cursor c =  TestsHelper.Tests.searchTest(dbHelper.getWritableDatabase(),name, lastname, age);
        if (c != null){
            if (c.moveToFirst()){
                id = c.getString(0);
            }
        }
    }
    public void watch_Click(View view){
        arad.clear();
        arad.notifyDataSetChanged();
        loadTests();
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

    public void addTest(String Name, String lastName, int Age){
        TestsHelper.Tests.insertTest(
                dbHelper.getWritableDatabase(),
                Name, lastName, Age
        );
        loadTests();
    }

}