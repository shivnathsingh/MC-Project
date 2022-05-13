package com.example.food;



import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class recyclerviewholder extends RecyclerView.ViewHolder {
    //declaring image views
    ImageView i1;
    //declaring text views
    TextView t1,t2;
    public recyclerviewholder(@NonNull View itemView) {
        //setting the values
        super(itemView);
        i1=itemView.findViewById(R.id.i1);
        t1=itemView.findViewById(R.id.t1);
        t2=itemView.findViewById(R.id.t2);

    }
}
