package com.example.project241;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import java.sql.Time;

public class Second extends MyBaseActivity
implements TextWatcher {
    EditText et1, et2;
    Button btn;
    Note note;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
        btn = (Button)findViewById(R.id.btn1);
        et1.addTextChangedListener(this);
        et2.addTextChangedListener(this);
        btn.setEnabled(false);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            note = (Note) bundle.getSerializable(EXTRA_NOTE);
            if(note.getHeadText()!= null){
                et1.setText(note.getHeadText());
            }
            if(note.getMainText()!= null){
                et2.setText(note.getMainText());
            }
        }
    }

    public void OK(View view){
        Intent intent = getIntent();
        note.setHeadText(et1.getText().toString());
        note.setMainText(et2.getText().toString());
        note.setTime(new Time(System.currentTimeMillis()));
        intent.putExtra(EXTRA_NOTE, note);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void Cancel(View view){
        setResult(RESULT_CANCELED);
        finish();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if((et1.getText().toString().trim().length() != 0) && (et2.getText().toString().trim().length() != 0)){
            btn.setEnabled(true);
        }
        else {
            btn.setEnabled(false);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
