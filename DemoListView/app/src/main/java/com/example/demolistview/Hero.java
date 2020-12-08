package com.example.demolistview;

import android.graphics.Bitmap;

public class Hero
{
    private String name;
    private String description;
    private Bitmap avatar;

    public Hero(String _name, String _description, Bitmap _avatar)
    {
        this.name = _name;
        this.description = _description;
        this.avatar = _avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Bitmap getAvatar() {
        return avatar;
    }

    public void setAvatar(Bitmap avatar) {
        this.avatar = avatar;
    }
}
