package com.example.project9;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {
    private SharedPreferences preferences;
    EditText et1;
        EditText et2;
        EditText et3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        preferences = getSharedPreferences(getResources().getString(R.string.preferences),MODE_PRIVATE);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        et3=(EditText)findViewById(R.id.et3);
    }

    @Override
    protected void onResume() {
        super.onResume();

        String intElKey = getResources().getString(R.string.int_element);
        int intEl = preferences.getInt(intElKey, 8);

        String stringElKey1 = getResources().getString(R.string.string_element1);
        String stringEl1 = preferences.getString(stringElKey1, String.valueOf(5));

        String stringElKey2 = getResources().getString(R.string.string_element2);
        String stringEl2 = preferences.getString(stringElKey2, String.valueOf(5));

        et1.setText(String.valueOf( intEl));
        et2.setText(stringEl1);
        et3.setText(stringEl2);
    }

    @Override
    protected void onPause() {
        super.onPause();

        int value1 = Integer.parseInt(et1.getText().toString());
        String value2 = et2.getText().toString();
        String value3 = et3.getText().toString();

        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(getResources().getString(R.string.int_element), value1);
        editor.putString(getResources().getString(R.string.string_element1), value2);
        editor.putString(getResources().getString(R.string.string_element2), value3);

        editor.commit();
    }
}
