package com.example.project27;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class Second extends MyBaseActivity
        implements TextWatcher {
    EditText editText, editText2;
    Button buttonOk;
    Note note;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
        buttonOk = (Button)findViewById(R.id.buttonOK);
        editText.addTextChangedListener(this);
        editText2.addTextChangedListener(this);
        buttonOk.setEnabled(false);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String headtext = bundle.getString(EXTRA_HEADTEXT);
            String text = bundle.getString(EXTRA_TEXT);
            if(headtext != null){
                editText.setText(headtext);
            }
            if(text != null){
                editText2.setText(text);
            }
        }
    }

    public void buttonOK_Click(View view){
        Intent intent = getIntent();
        intent.putExtra(EXTRA_HEADTEXT, editText.getText().toString());
        intent.putExtra(EXTRA_TEXT, editText2.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
    public void buttonCancel_Click(View view){
        setResult(RESULT_CANCELED);
        finish();
    }
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if((editText.getText().toString().trim().length() != 0) && (editText2.getText().toString().trim().length() != 0)){
            buttonOk.setEnabled(true);
        } else{
            buttonOk.setEnabled(false);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
