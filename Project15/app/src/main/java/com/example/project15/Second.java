package com.example.project15;

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
    EditText et;
    Button ok;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        et = (EditText)findViewById(R.id.et);
        ok = (Button)findViewById(R.id.ok);
        et.addTextChangedListener(this);
        ok.setEnabled(false);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            String txt = bundle.getString(EXTRA_TEXT);
            if(txt != null){
                et.setText(txt);
            }
        }
    }

    public void OK(View view){
        Intent intent = getIntent();
        intent.putExtra(EXTRA_TEXT, et.getText().toString());
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
        if(et.getText().toString().trim().length() != 0){
            ok.setEnabled(true);
        }else{
            ok.setEnabled(false);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
