package com.aafs.hybrid.biddingapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class PlacingBidActivity extends AppCompatActivity {
    private EditText product_name;
    private EditText product_price;
    private EditText product_description;
    private EditText bid_time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placing_bid);

        product_name=findViewById(R.id.prdName);
        product_price=findViewById(R.id.prdPrice);
        product_description=findViewById(R.id.prdDesp);
        bid_time=findViewById(R.id.bidtime);
    }
}
