package com.example.demomp3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = mediaPlayer.create(getBaseContext(), R.raw.song_abc);
    }

    public void btn_play_onclick(View view)
    {
        Button btn = (Button) view;
        if (mediaPlayer.isPlaying())
        {
            mediaPlayer.pause();
            btn.setBackgroundResource(android.R.drawable.ic_media_pause);
        }
        else
        {
            mediaPlayer.start();
            btn.setBackgroundResource(android.R.drawable.ic_media_play);
        }
    }
}