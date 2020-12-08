package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private EditText editText;
    private LinearLayout lnlo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edtName);
        lnlo = findViewById(R.id.lnlo);
    }

    public void btn_onclick(View view)
    {
        //String name = editText.getText().toString();
        //TextView textView = new TextView(this);
        //textView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        //textView.setText(name);
        //lnlo.addView(textView);

        String text = editText.getText().toString();
        switch (text)
        {
            case "button":
                Button btn = new Button(this);
                btn.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                btn.setText("OK");
                lnlo.addView(btn);
                break;
            case "textview":
                TextView txt = new TextView(this);
                txt.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                txt.setText("Hello");
                lnlo.addView(txt);
                break;
            default:
                break;
        }
    }
}