package com.example.demoservicebroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
    EditText edt_a, edt_b, edt_c, edt_op;
    MathOpBroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_a = findViewById(R.id.edt_a);
        edt_b = findViewById(R.id.edt_b);
        edt_c = findViewById(R.id.edt_c);
        edt_op = findViewById(R.id.edt_op);
    }

    @Override
    protected void onPostResume()
    {
        super.onPostResume();
        receiver = new MathOpBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("math-op");
        registerReceiver(receiver, intentFilter);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        unregisterReceiver(receiver);
    }

    public void btn_cal_onclick(View view)
    {
        double a = Double.parseDouble(edt_a.getText().toString());
        double b = Double.parseDouble(edt_b.getText().toString());
        String op = edt_op.getText().toString();
        Intent intent = new Intent(this, MathOpService.class); //Context, service
        intent.putExtra("a", a);
        intent.putExtra("b", b);
        intent.putExtra("op", op);
        startService(intent);
    }

    private class MathOpBroadcastReceiver extends BroadcastReceiver
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            double c = intent.getDoubleExtra("c", 0);
            edt_c.setText(String.valueOf(c));
        }
    }

}