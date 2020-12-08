package com.example.demolistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyArrayAdapter extends ArrayAdapter<Hero>
{
    private Context context;
    private int layoutID;
    private ArrayList<Hero> heroes;

    public MyArrayAdapter(@NonNull Context context, int resource, @NonNull List<Hero> objects)
    {
        super(context, resource, objects);
        this.context = context;
        this.layoutID = resource;
        this.heroes = (ArrayList<Hero>) objects;
    }

    @Override
    public int getCount()
    {
        return heroes.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        if (convertView == null)
        {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(layoutID, null, false);
        }
        ImageView imageView = convertView.findViewById(R.id.iv_avatar);
        TextView txt_name = convertView.findViewById(R.id.txt_name);
        TextView txt_desc = convertView.findViewById(R.id.txt_desc);

        Hero hh = heroes.get(position);
        imageView.setImageBitmap(hh.getAvatar());
        txt_name.setText(hh.getName());
        txt_desc.setText(hh.getDescription());
        return convertView;
    }
}
