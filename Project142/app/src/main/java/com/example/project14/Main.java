package com.example.project14;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {
    protected static final int MY_ACTION = 0x000314;
    EditText et1, et2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
    }

    public void openSecond(View view){
        Intent intent = new Intent(this, Second.class);
        intent.putExtra(getResources().getString(R.string.EditText1), et1.getText().toString());
        intent.putExtra(getResources().getString(R.string.EditText2), et2.getText().toString());
        startActivityForResult(intent, MY_ACTION);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            Bundle bundle = data.getExtras();
            String s1 = bundle.getString(getResources().getString(R.string.EditText1));
            String s2 = bundle.getString(getResources().getString(R.string.EditText2));
            et1.setText(s1);
            et2.setText(s2);
        }
    }
}
