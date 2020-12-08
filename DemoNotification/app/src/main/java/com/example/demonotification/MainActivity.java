package com.example.demonotification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    //https://developer.android.com/training/notify-user/build-notification#java
    private NotificationManager notifyMngr;
    private Notification.Builder notifyBuilder;
    private int ntf_id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notifyMngr = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        notifyBuilder = new Notification.Builder(this).setSmallIcon(R.mipmap.ic_launcher).setContentTitle("Notification").setContentText("This is a simple notification").setStyle(new Notification.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher)).setBigContentTitle("This is a big picture")).setContentIntent(pendingIntent);
    }

    public void lnlo_onclick(View view)
    {
        Toast.makeText(this, String.valueOf(Build.VERSION.SDK_INT), Toast.LENGTH_SHORT).show();
        if (ntf_id > 0)
            notifyMngr.cancel(ntf_id - 1);
        Notification ntf = notifyBuilder.build();
        notifyMngr.notify(ntf_id++, ntf);
    }
}