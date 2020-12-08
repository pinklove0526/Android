package com.example.demolifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("@@@@@", "Create main");
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d("@@@@@", "Start main");
    }

    @Override
    protected void onPostResume()
    {
        super.onPostResume();
        Log.d("@@@@@", "Resume main");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.d("@@@@@", "Pause main");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d("@@@@@", "Stop main");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d("@@@@@", "Destroy main");
    }

    public void cslo_click(View view)
    {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}