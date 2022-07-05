package com.example.project14;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Second extends AppCompatActivity {
    EditText et1, et2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        et1=(EditText)findViewById(R.id.et3);
        et2 = (EditText)findViewById(R.id.et4);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String txt1 = bundle.getString(getResources().getString(R.string.EditText1));
            String txt2 = bundle.getString(getResources().getString(R.string.EditText2));
            if(txt1 != null){
                et1.setText(txt1);
            }
            if (txt2 != null) {
                et2.setText(txt2);
            }
        }

    }

    public void OK(View view){
        Intent intent = getIntent();
        intent.putExtra(getResources().getString(R.string.EditText1),et1.getText().toString());
        intent.putExtra(getResources().getString(R.string.EditText2),et2.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
    public void Cancel(View view){
        setResult(RESULT_CANCELED);
        finish();
    }
}
