package com.example.demolifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class Main2Activity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d("@@@@@", "Create sec");
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d("@@@@@", "Start sec");
    }

    @Override
    protected void onPostResume()
    {
        super.onPostResume();
        Log.d("@@@@@", "Resume sec");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.d("@@@@@", "Pause sec");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d("@@@@@", "Stop sec");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d("@@@@@", "Destroy sec");
    }
}