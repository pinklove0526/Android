package com.example.demoasynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private TextView txtNo;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNo = findViewById(R.id.txtNo);

    }

    public void txtview_onclick(View view)
    {
        new CountDownAsyncTask().execute(10);
    }

    private class CountDownAsyncTask extends AsyncTask<Integer, Integer, Integer>
    {
        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            Toast.makeText(getApplicationContext(), "Start the background job", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected Integer doInBackground(Integer... integers)
        {
            int num = integers[0];
            for (int i = num; i >= 0; i--)
            {
                publishProgress(i);
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values)
        {
            super.onProgressUpdate(values);
            int num = values[0];
            txtNo.setText(String.valueOf(num));
        }

        @Override
        protected void onPostExecute(Integer integer)
        {
            super.onPostExecute(integer);
            Toast.makeText(getApplicationContext(),"Finish background job", Toast.LENGTH_SHORT).show();
        }
    }

}