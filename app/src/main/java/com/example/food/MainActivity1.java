package com.example.food;



import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity1 extends AppCompatActivity {
    RecyclerView rl;
    adaptor a;
    Context context;
    ArrayList<usermodel> mylist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        rl=findViewById(R.id.rl);
        mylist=new ArrayList<>();
        usermodel model =new usermodel("Paneer Delight","\"A Quick Ready Indian Dessert\"",R.mipmap.ia);
        usermodel model1 =new usermodel("Mishti Doi","\"Sweet Bengali dessert\"",R.mipmap.ib);
        usermodel model2 =new usermodel("Burger","\"A Healthy Snack For Kids\"",R.mipmap.ic);
        usermodel model3 =new usermodel("Pizza","\"An italian Stuffed bread\"",R.mipmap.id);
        usermodel model4=new usermodel("Bhelpuri","\"Healthy Light Indian snack\"",R.mipmap.ie);
        usermodel model5 =new usermodel("Shahi Kheer","\"An traditional indian desert\"",R.mipmap.kheer);

        mylist.add(model);
        mylist.add(model1);
        mylist.add(model2);
        mylist.add(model3);
        mylist.add(model4);
        mylist.add(model5);

        RecyclerView.LayoutManager manager=new LinearLayoutManager(context,RecyclerView.VERTICAL,false);
        rl.setLayoutManager(manager);
        a=new adaptor(this,mylist);
        rl.setAdapter(a);
        a.notifyDataSetChanged();


    }

}