package com.example.demomultipleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity
{
    private EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        edt = findViewById(R.id.edt_text);
        String name = getIntent().getStringExtra("name");
        edt.setText("Xin chao " + name);
    }
}