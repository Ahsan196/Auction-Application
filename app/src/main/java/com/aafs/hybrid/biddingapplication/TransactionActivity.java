package com.aafs.hybrid.biddingapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TransactionActivity extends AppCompatActivity {

    private DatabaseReference database_Reference;


    private DatabaseReference database_Reference1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        database_Reference=FirebaseDatabase.getInstance().getReference().child("Transactions").child("My Transactions");
      database_Reference1= FirebaseDatabase.getInstance().getReference().child("Transactions").child("Received Transactions");


    }
}
