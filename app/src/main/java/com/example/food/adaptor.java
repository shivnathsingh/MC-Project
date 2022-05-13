package com.example.food;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adaptor extends RecyclerView.Adapter<recyclerviewholder> {
    Context context;
    ImageView im;
    String s1;
    ArrayList<usermodel> mylist;
    int field_num=0;
    public adaptor(Context context, ArrayList<usermodel> mylist) {
        this.context = context;
        this.mylist = mylist;
    }

    @NonNull
    @Override

    public recyclerviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_list,null);
        recyclerviewholder viewholder=new recyclerviewholder(v);

        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerviewholder holder, int position) {
        holder.i1.setImageResource(mylist.get(position).getImage());
        holder.t1.setText(mylist.get(position).getText1());
        holder.t2.setText(mylist.get(position).getText2());

        im = holder.i1;



        holder.t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=holder.t1.getText().toString();
                //declaring Intent
                //  Intent intent = new Intent(context, imageshow.class);
                Intent intent = new Intent(context, fullimage.class);

                // im.buildDrawingCache();
                //Bitmap image= im.getDrawingCache();

                //  Bundle extras = new Bundle();
                //extras.putParcelable("imagebitmap", image);
                intent.putExtra("name",s1);
                context.startActivity(intent);
                //making toast to show which news is opened


                //passing the filed_num through intent
                // intent.putExtra("field_num",field_num);

                //starting activity
                //  context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }
}

