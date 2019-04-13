package com.aafs.hybrid.biddingapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FirstWin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_win);
    }

    public void next(View view) {
        Intent intent1=new Intent(getApplicationContext(),SecondWin.class);
        startActivity(intent1);
    }
}
