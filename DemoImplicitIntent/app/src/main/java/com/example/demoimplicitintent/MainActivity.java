package com.example.demoimplicitintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
{
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageview);
    }

    public void btn_dial_onclick(View view)
    {
        Uri uri = Uri.parse("tel:8005551234");
        Intent intent = new Intent(Intent.ACTION_CALL, uri);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
        {
            //TODO: Consider calling ActivityCompat#requestPermissions here to request the missing permissions, and then overriding public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) to handle the case where the user grants the permission. See the documentation for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(intent);
    }

    public void btn_dial_capture(View view)
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 123);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        if (requestCode == 123)
        {
            if (resultCode == RESULT_OK)
            {
                Bitmap bmp = (Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(bmp);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}