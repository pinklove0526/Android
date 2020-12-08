package com.example.demolistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private ListView lv_heroes;
    private ArrayList<Hero> heroes;
    private MyArrayAdapter adapter;
    private GridView gv_heroes;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadData();
        initComponents();
    }

    private void loadData()
    {
        String[] names = {"Ahri", "Ashe", "Brand", "Elise", "Hecarim", "Janna", "LeBlanc", "Master Yi", "Nasus", "Tryndamere"};
        String[] descs = {}; //todo at home
        int[] avatarIDs = {R.drawable.ahri, R.drawable.ashe, R.drawable.brand, R.drawable.elise, R.drawable.hecarim, R.drawable.janna, R.drawable.leblanc, R.drawable.masteryi, R.drawable.nasus, R.drawable.tryndamere};
        heroes = new ArrayList<>();
        for (int i = 0; i < names.length; i++)
        {
            Hero hh = new Hero(names[i], "This is " +  names[i], BitmapFactory.decodeResource(getResources(), avatarIDs[i]));
            heroes.add(hh);
        }
    }

    private void initComponents()
    {
        adapter = new MyArrayAdapter(this, R.layout.listview_item, heroes);
        lv_heroes = findViewById(R.id.lv_heroes);
        lv_heroes.setAdapter(adapter);

        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Hero hh = heroes.get(position);
                Toast.makeText(getApplicationContext(), hh.getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("name", hh.getName());
                startActivity(intent);
            }
        };

        lv_heroes.setOnItemClickListener(onItemClickListener);

        gv_heroes = findViewById(R.id.gv_heroes);
        gv_heroes.setAdapter(adapter);
        gv_heroes.setOnItemClickListener(onItemClickListener);
    }
}