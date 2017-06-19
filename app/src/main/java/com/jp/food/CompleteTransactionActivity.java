package com.jp.food;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CompleteTransactionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_transaction);

        getSupportFragmentManager().beginTransaction().replace(R.id.idcontainerframe, new EnterDetailsFragment()).commit();
    }
}
