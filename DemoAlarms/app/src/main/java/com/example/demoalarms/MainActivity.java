package com.example.demoalarms;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    //https://developer.android.com/training/scheduling/alarms
    private AlarmManager alarmMngr;
    private PendingIntent alarmIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alarmMngr = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
    }

    public void lnlo_onclick(View view)
    {
        if (alarmMngr != null && alarmIntent != null)
        {
            alarmMngr.cancel(alarmIntent);
            Toast.makeText(this, "Cancel alarm", Toast.LENGTH_SHORT).show();
        }
        else
            {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            alarmIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            alarmMngr.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + 10 * 1000, alarmIntent);
            Toast.makeText(this, "Set up alarm", Toast.LENGTH_SHORT).show();
        }
    }
}