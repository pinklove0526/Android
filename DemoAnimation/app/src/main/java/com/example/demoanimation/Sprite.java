package com.example.demoanimation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class Sprite extends View
{
    private int[] sprite_dead = {R.drawable.dead_1, R.drawable.dead_2, R.drawable.dead_3, R.drawable.dead_4, R.drawable.dead_5, R.drawable.dead_6, R.drawable.dead_7, R.drawable.dead_8, R.drawable.dead_9, R.drawable.dead_10};
    private int[] sprite_fall = {R.drawable.fall_1, R.drawable.fall_2, R.drawable.fall_3, R.drawable.fall_4, R.drawable.fall_5, R.drawable.fall_6, R.drawable.fall_7, R.drawable.fall_8};
    private int[] sprite_hurt = {R.drawable.hurt_1, R.drawable.hurt_2, R.drawable.hurt_3, R.drawable.hurt_4, R.drawable.hurt_5, R.drawable.hurt_6, R.drawable.hurt_7, R.drawable.hurt_8, R.drawable.hurt_9, R.drawable.hurt_10};
    private int[] sprite_idle = {R.drawable.idle_1, R.drawable.idle_2, R.drawable.idle_3, R.drawable.idle_4, R.drawable.idle_5, R.drawable.idle_6, R.drawable.idle_7, R.drawable.idle_8, R.drawable.idle_9, R.drawable.idle_10};
    private int[] sprite_jump = {R.drawable.jump_1, R.drawable.jump_2, R.drawable.jump_3, R.drawable.jump_4, R.drawable.jump_5, R.drawable.jump_6, R.drawable.jump_7, R.drawable.jump_8};
    private int[] sprite_run = {R.drawable.run_1, R.drawable.run_2, R.drawable.run_3, R.drawable.run_4, R.drawable.run_5, R.drawable.run_6, R.drawable.run_7, R.drawable.run_8};
    private int[] sprite_slide = {R.drawable.slide_1, R.drawable.slide_2, R.drawable.slide_3, R.drawable.slide_4, R.drawable.slide_5, R.drawable.slide_6, R.drawable.slide_7, R.drawable.slide_8, R.drawable.slide_9, R.drawable.slide_10};
    private int[] sprite_walk = {R.drawable.walk_1, R.drawable.walk_2, R.drawable.walk_3, R.drawable.walk_4, R.drawable.walk_5, R.drawable.walk_6, R.drawable.walk_7, R.drawable.walk_8, R.drawable.walk_9, R.drawable.walk_10};

    private int[][] sprites = {sprite_idle, sprite_walk, sprite_run, sprite_jump, sprite_fall, sprite_slide, sprite_hurt, sprite_dead};

    private int current_seq_index = 0;
    private int[] current_seq = sprites[current_seq_index];
    private int current_index = 0;

    private float screen_width, screen_height;
    private float dx = 10, dy = 10;

    private CountDownTimer countDownTimer = new CountDownTimer(5000, 10)
    {
        @Override
        public void onTick(long millisUntilFinished)
        {
            invalidate();
            move(10, 00);
        }

        @Override
        public void onFinish()
        {
            this.start();
        }
    };

    private void move(float dx, float dy)
    {
        float x = getX(), y = getY();
        //todo
        if (y <= 0 && x > 1000)
            dx = -10;
        if (x <= 0 && y >= 500)
            dx = 10;
        x = x + dx;
        y = -x * x / 1000 + 2 * x;
        setX(x);
        setY(y);
        Log.d("@@@@ x", String.valueOf(x));
        Log.d("@@@@ y", String.valueOf(y));
    }

    public Sprite(Context context)
    {
        super(context);
        startAnimation();
        initArea();
    }

    public Sprite(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        startAnimation();
        initArea();
    }

    private void initArea()
    {
        DisplayMetrics displayMetrics =  getContext().getResources().getDisplayMetrics();
        screen_height = displayMetrics.heightPixels;
        screen_width = displayMetrics.widthPixels;
        Log.d("@@@@ width", String.valueOf(screen_width));
        Log.d("@@@@ height", String.valueOf(screen_height));
    }

    private void startAnimation()
    {
        countDownTimer.start();
    }

    private void stopAnimation()
    {
        countDownTimer.cancel();
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        if (current_index >= current_seq.length)
        {
            current_index = 0;
            current_seq_index = (current_seq_index + 1) % sprites.length;
            current_seq = sprites[current_seq_index];
        }

        Bitmap bmp = BitmapFactory.decodeResource(getResources(), current_seq[current_index]);
        bmp = Bitmap.createScaledBitmap(bmp, canvas.getWidth(), canvas.getHeight(), false);
        canvas.drawBitmap(bmp, 0, 0, null);
        current_index++;
    }
}
