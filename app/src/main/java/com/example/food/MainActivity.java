package com.example.food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.makeramen.roundedimageview.RoundedImageView;

public class MainActivity extends AppCompatActivity {
      Button health,recipe;
      RoundedImageView riv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        health=findViewById(R.id.health);
        riv=findViewById(R.id.roundedImageView);
        recipe=findViewById(R.id.button);
        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),fitness_page.class);
                startActivity(intent);
            }
        });
        recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MainActivity1.class);
                startActivity(intent);
            }
        });
       riv.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(getApplicationContext(),order_food.class);
               startActivity(intent);
           }
       });
    }
}