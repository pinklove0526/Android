package com.example.demofilestorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener
{
    private final String FILENAME = "mydata.txt";
    private EditText edt_content;
    private File myDataFile;
    private SharedPreferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_content = findViewById(R.id.edt_content);
        mPreferences = getSharedPreferences(getPackageName(), MODE_PRIVATE);
        String content = mPreferences.getString("content", "-1");
        edt_content.setText(content);
        if (isExternalStorageWritable())
        {
            File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
            Log.d("@@@@ path", path.toString());
            if (!path.exists())
                path.mkdirs();
            myDataFile = new File(path, FILENAME);
            if (!myDataFile.exists())
            {
                try
                {
                    myDataFile.createNewFile();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString("content", edt_content.getText().toString());
        editor.apply();
        mPreferences.unregisterOnSharedPreferenceChangeListener(this);
    }

    public void btn_onclick(View view)
    {
        String btn_text = ((Button) view).getText().toString();
        switch (btn_text)
        {
            case "Save":
                //save2File();
                try
                {
                    saveText2ExternalFile();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                break;
            case "Load":
                //loadFromFile();
                try
                {
                    loadTextFromExternalFile();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void save2File()
    {
        try
        {
            PrintStream output = new PrintStream(openFileOutput(FILENAME, MODE_PRIVATE));
            output.println(edt_content.getText());
            output.close();
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    private void loadFromFile()
    {
        Scanner scan = null;
        try
        {
            scan = new Scanner(openFileInput(FILENAME));
            String allText = "";
            while (scan.hasNextLine())
            {
                String line = scan.nextLine();
                allText += line;
            }
            scan.close();
            edt_content.setText(allText);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public boolean isExternalStorageWritable()
    {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state))
        {
            Toast.makeText(this, state.toString(), Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    public static String convertStreamToString(FileInputStream is) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null)
            sb.append(line).append("\n");
        reader.close();
        return sb.toString();
    }

    private void loadTextFromExternalFile() throws Exception
    {
        FileInputStream fileInputStream = new FileInputStream(myDataFile);
        String content = convertStreamToString(fileInputStream);
        edt_content.setText(content);
    }

    private void saveText2ExternalFile() throws IOException
    {
        FileOutputStream fileOutputStream = new FileOutputStream(myDataFile);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
        String content = edt_content.getText().toString();
        bufferedWriter.write(content);
        bufferedWriter.close();
        fileOutputStream.close();
    }

    @Override
    protected void onPostResume()
    {
        super.onPostResume();
        mPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key)
    {
        if (key.equals("content"))
            Toast.makeText(this, "Content changed", Toast.LENGTH_SHORT).show();
    }
}