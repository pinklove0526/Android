package com.example.midtermproject_beta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private LinearLayout lnlo, lnlo2, lnlo3, lnlo4;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        lnlo.setOnClickListener(this);
        lnlo2.setOnClickListener(this);
        lnlo3.setOnClickListener(this);
        lnlo4.setOnClickListener(this);
    }

    private void initViews()
    {
        lnlo = findViewById(R.id.lnlo);
        lnlo2 = findViewById(R.id.lnlo2);
        lnlo3 = findViewById(R.id.lnlo3);
        lnlo4 = findViewById(R.id.lnlo4);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.lnlo:
            {
                Intent intent = new Intent(MainActivity.this, AllBooksActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.lnlo2:
            {
                Intent intent = new Intent(MainActivity.this, AlreadyReadBookActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.lnlo3:
            {
                Intent intent = new Intent(MainActivity.this, WantToReadActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.lnlo4:
            {
                Intent intent = new Intent(MainActivity.this, FavoriteActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}