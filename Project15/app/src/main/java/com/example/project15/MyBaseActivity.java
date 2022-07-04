package com.example.project15;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MyBaseActivity extends AppCompatActivity {
    protected static final int CREATE_ACTION = 0x000312;
    protected static final int EDIT_ACTION = 0x000313;
    protected static final String EXTRA_TEXT = "text";
    protected static final String EXTRA_ID = "id";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
