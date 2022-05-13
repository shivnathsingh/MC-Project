package com.example.food;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ShareFragment extends Fragment {
    View myView;
    ImageView fb, inst, twitter;
    TextView tv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView= inflater.inflate(R.layout.fragment_share, container, false);
        fb = (ImageView) myView.findViewById(R.id.fb);
        inst = (ImageView) myView.findViewById(R.id.insta);
        twitter = (ImageView) myView.findViewById(R.id.twitter);
        tv=(TextView) myView.findViewById(R.id.tv);

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                thisUrl("https://www.facebook.com/login/");
            }
        });
        inst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thisUrl("https://www.instagram.com/accounts/login/");

            }
        });

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thisUrl("https://twitter.com/i/flow/login");

            }
        });

        return myView;
    }
    private void thisUrl(String s) {
        Uri uri= Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}