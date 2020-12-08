package com.example.demointerface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

public class SecondActivity extends AppCompatActivity
{
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editText = findViewById(R.id.edt_input);
    }

    public void switch_onclick(View view)
    {
        Switch sw = (Switch) view;
        if (sw.isChecked())
            editText.setInputType(InputType.TYPE_CLASS_TEXT);
        else
            editText.setInputType(InputType.TYPE_CLASS_NUMBER);
    }
}