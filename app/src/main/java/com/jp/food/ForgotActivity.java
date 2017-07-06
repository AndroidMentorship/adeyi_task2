package com.jp.food;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ForgotActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        getSupportActionBar()
                .setTitle("Retrieve your password");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
