package com.example.project33;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

public class Second extends MyBaseActivity
        implements TextWatcher {
    EditText editText, editText2;
    Spinner spinner;
    Button buttonOk;
    TextView textView;
    String setttingTime = "";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
        buttonOk = (Button)findViewById(R.id.buttonOK);
        spinner = (Spinner)findViewById(R.id.spinfield);
        textView = (TextView)findViewById(R.id.textViewTime);
        ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.spinner);
        adapter.addAll(Priority.values());
        spinner.setAdapter(adapter);
        spinner.setSelection(1);
        editText.addTextChangedListener(this);
        editText2.addTextChangedListener(this);
        buttonOk.setEnabled(false);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String headtext = bundle.getString(EXTRA_HEADTEXT);
            String text = bundle.getString(EXTRA_TEXT);
            String priority = bundle.getString(EXTRA_PRIORITY);
            String time = bundle.getString(EXTRA_TIME);
            if(headtext != null){
                editText.setText(headtext);
            }
            if(text != null){
                editText2.setText(text);
            }
            if(priority != null && !priority.isEmpty()){
                int priorityint = Integer.valueOf(priority);
                spinner.setSelection(priorityint);
            }
            if(time != null && !time.isEmpty()){
                textView.setText(time);
                setttingTime = time;
            }
        }
    }

    public void btnopentime_Click(View view){
        FragmentManager manager = getSupportFragmentManager();
        MyDialogFragment myDialogFragment = new MyDialogFragment();
        myDialogFragment.show(manager, "myDialog");
    }
    public void timeokclicked(int hour, int minute){
        String strhour = String.valueOf(hour),
                strminute = String.valueOf(minute);
        setttingTime = strhour + ":" + strminute;
        textView.setText(setttingTime);
    }

    public void buttonOK_Click(View view){
        Intent intent = getIntent();
        intent.putExtra(EXTRA_HEADTEXT, editText.getText().toString());
        intent.putExtra(EXTRA_TEXT, editText2.getText().toString());
        intent.putExtra(EXTRA_TIME, setttingTime);
        intent.putExtra(EXTRA_PRIORITY, String.valueOf(spinner.getSelectedItemId()));
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
        if((editText.getText().toString().trim().length() != 0)
                && (editText2.getText().toString().trim().length() != 0)){
            buttonOk.setEnabled(true);
        } else{
            buttonOk.setEnabled(false);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}