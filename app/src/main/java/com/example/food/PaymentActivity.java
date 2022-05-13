package com.example.food;



import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;



public class PaymentActivity extends AppCompatActivity implements PaymentResultListener {
    Button btnpay;
    Button superCoins;
    TextView tv;
    int myAmount = 0;
    int prevCoins = 0, newCoins = 0;
    static String name = LoginActivity.myUser;
    String prevVal = "";
    double val = 0.0;
    static double newVal = 0; // this new value should be gone into the integeration

    public void decreaseSupercoins(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference ref = db.getReference("user").child(name).child("supercoins");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String prevCoin= dataSnapshot.getValue(String.class);

                // updation of the new coins
                prevCoins=Integer.parseInt(prevCoin);
                if(prevCoins >=0) {
                    val = Math.round(myAmount * 0.7);
                    tv.setText(val + " Rupees (by super coins) ");
                    newCoins = prevCoins - 10;
                    ref.setValue(""+newCoins); // updating the new coins
                    newVal = val;
                    newVal=Math.round(Float.parseFloat(""+newVal)*100);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    public void updateSupercoins(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference ref = db.getReference("user").child(name).child("supercoins");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String prevCoin= dataSnapshot.getValue(String.class);
                Toast.makeText(PaymentActivity.this, ""+prevCoin, Toast.LENGTH_LONG).show();
                // updation of the new coins
                prevCoins=Integer.parseInt(prevCoin);


                // updation of supercoins

                if (myAmount >= 100 && myAmount <=500){
                    newCoins = prevCoins + 5;
                }

                else if (myAmount >500 && myAmount <= 700){
                    newCoins = prevCoins + 10;
                }

                else {
                    newCoins = prevCoins + 15;
                }
                ref.setValue(""+newCoins); // updating the new coins

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        btnpay=findViewById(R.id.btnpay);
        superCoins = findViewById(R.id.superCoin);
        tv = findViewById(R.id.amount);
        Intent intent=getIntent();
        int total=intent.getIntExtra("total",-1);
        int amount=Math.round(Float.parseFloat(""+total)*100);
        newVal = amount/1.0;
        myAmount = Math.round(amount/100);
        tv.setText(myAmount + " Rupees ");
        // super coins logic



        btnpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Checkout checkout=new Checkout();
                checkout.setKeyID("rzp_test_hWsjHYcXOd1TI5");
                checkout.setImage(R.drawable.rzp_logo);
                JSONObject object=new JSONObject();
                try {
                    object.put("name","Food private ltd.");
                    object.put("description","sample payment");
                    object.put("theme.color","#FF6600");
                    object.put("currency","INR");
                    object.put("amount",newVal);
                    object.put("prefill.contact","7869749225");
                    object.put("prefill.email","agarwalgaurav.student@gmail.com");
                    checkout.open(PaymentActivity.this,object);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });


        superCoins.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                if (myAmount >=500){

                    // updated the value

                    // now update the superCoins

                    decreaseSupercoins();

                    // pay now

                }

            }
        });
    }







    @Override
    public void onPaymentSuccess(String s) {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle("Payment ID");
        builder.setMessage(s);
        builder.show();
        updateSupercoins(); // updating the supercoins
        Intent intent=new Intent(PaymentActivity.this,TempActivity.class);
        startActivity(intent);
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(getApplicationContext(),s, Toast.LENGTH_SHORT).show();

    }
}
