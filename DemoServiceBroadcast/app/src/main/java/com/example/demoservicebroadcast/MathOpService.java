package com.example.demoservicebroadcast;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MathOpService extends Service
{
    public MathOpService()
    {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        double a = intent.getDoubleExtra("a", 0);
        double b = intent.getDoubleExtra("b", 0);
        String op = intent.getStringExtra("op");
        double c = 0;
        switch (op)
        {
            case "+":
                c = a + b;
                break;
            case "-":
                c = a - b;
                break;
            case "*":
                c = a * b;
                break;
            case "/":
                c = a / b;
                break;
        }
        Intent result = new Intent();
        result.putExtra("c", c);
        result.setAction("math-op");
        sendBroadcast(result);
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }
}
