package com.example.food;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RateFragment extends Fragment {
View myView;
TextView name,address,rating,time;
ImageView image;
RatingBar ratingbar;
Button rate;
//RecyclerView rcView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView= inflater.inflate(R.layout.fragment_rate, container, false);
        name=myView.findViewById(R.id.rate_name);
        address=myView.findViewById(R.id.rate_address);
        rating=myView.findViewById(R.id.rate_rating);
        time=myView.findViewById(R.id.rate_time);
        image=myView.findViewById(R.id.rate_image);
        ratingbar= myView.findViewById(R.id.ratingBar);
        rate= myView.findViewById(R.id.rate);

        name.setText(Restro_Adapter.datamodelTORate.getName());
        address.setText(Restro_Adapter.datamodelTORate.getAddress());
        rating.setText(Restro_Adapter.datamodelTORate.getRating());
        time.setText(Restro_Adapter.datamodelTORate.getTime());
        Glide.with(image).load(Restro_Adapter.datamodelTORate.getUrl()).into(image);

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rated=String.valueOf(ratingbar.getRating());
                DatabaseReference db= FirebaseDatabase.getInstance().getReference().child("user").child("user_1");
                db.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                          DatabaseReference ref=snapshot.child(""+Restro_Adapter.datamodelTORate.getName()).child("rating").getRef();
                             ref.setValue(rated);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });


        return myView;
    }
}