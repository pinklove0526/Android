package com.example.demomultipleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt = findViewById(R.id.edt_name);
    }

    public void btnOK_onclick(View view)
    {
        String name = edt.getText().toString();
        Toast.makeText(getApplicationContext(), "Hello " + name, Toast.LENGTH_SHORT).show();
    }

    public void lnlo_onclick(View view)
    {
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        intent.putExtra("name", edt.getText().toString());
        startActivity(intent);
    }
}