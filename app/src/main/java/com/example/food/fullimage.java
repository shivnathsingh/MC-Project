package com.example.food;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import com.example.food.R;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class fullimage extends AppCompatActivity {
    @SuppressLint({"NewApi", "WrongThread"})

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullimage);
        //  Bundle extras = getIntent().getExtras();
        //Bitmap bmp = (Bitmap) extras.getParcelable("imagebitmap");
        Intent intent = getIntent();
        String ss = intent.getStringExtra("name");
        ImageView imgDisplay;
        Button btnClose;


        imgDisplay = (ImageView) findViewById(R.id.imgDisplay);
        //  btnClose = (Button) findViewById(R.id.btnClose);


        //   btnClose.setOnClickListener(new View.OnClickListener() {
        //     public void onClick(View v) {
        //       fullimage.this.finish();
        // }
        //});

        if (ss.equals("Paneer Delight"))
            imgDisplay.setImageResource(R.mipmap.pdr);
        else if (ss.equals("Mishti Doi"))
            imgDisplay.setImageResource(R.mipmap.mdrr);
        else if (ss.equals("Burger"))
            imgDisplay.setImageResource(R.mipmap.br);
        else if (ss.equals("Pizza"))
            imgDisplay.setImageResource(R.mipmap.pr);
        else if (ss.equals("Bhelpuri"))
            imgDisplay.setImageResource(R.mipmap.bhelr);
        else if (ss.equals("Shahi Kheer"))
            imgDisplay.setImageResource(R.mipmap.kr);

    }

}