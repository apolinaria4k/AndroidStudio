package com.example.project29;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {
    ArrayAdapter arad;
    EditText name, age;
    ListView listView;
    Spinner spinner1, spinner2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        name = (EditText)findViewById(R.id.nameEdit);
        age = (EditText)findViewById(R.id.ageEdit);
        listView = (ListView)findViewById(R.id.listView);
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        arad = new ArrayAdapter<String>(this, R.layout.spisol);
        listView.setAdapter(arad);
        ArrayAdapter adapter1 = new ArrayAdapter<>(this, R.layout.spisol);
        adapter1.addAll(Sex.values());
        ArrayAdapter adapter2 = new ArrayAdapter<>(this, R.layout.spisol);
        adapter2.addAll(Status.values());
        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);
        spinner1.setSelection(0);
        spinner2.setSelection(0);
    }

    public void btn1(View view){
        arad.add(spinner2.getSelectedItemPosition());
    }
    public void btn2(View view){
        arad.add(Status.valueOf(spinner2.getSelectedItemPosition()));
    }
    public void btn3(View view){
        arad.addAll(Sex.values());
    }
    public void btn4(View view){
        arad.addAll(Status.values());
    }
    public void btn5(View view){
        Person person = new Person(
                name.getText().toString(),
                Integer.valueOf(age.getText().toString()),
                Sex.valueOf(spinner1.getSelectedItemPosition()),
                Status.valueOf(spinner2.getSelectedItemPosition())
        );
        arad.add(person.toString());
    }
    public void btn6(View view){
        arad.clear();
    }
}
