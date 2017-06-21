package com.jp.food;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FoodDetailActivity extends AppCompatActivity {
@BindView(R.id.idTextViewFoodDescription) TextView foodDescTV;
    @BindView(R.id.idTVfoodPrice) TextView foodPriceTV;
    @BindView(R.id.idImageFood) ImageView foodImageView;
    @BindView(R.id.idTextViewFoodName) TextView foodNameTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        if (intent != null) {
            foodDescTV.setText(intent.getStringExtra("FOODDESC"));
            getSupportActionBar().setTitle(intent.getStringExtra("FOODNAME"));
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            foodPriceTV.setText("N: "+ String.valueOf(intent.getIntExtra("FOODPRICE",4)));
            foodNameTV.setText(intent.getStringExtra("FOODNAME"));
            foodImageView.setImageResource(intent.getIntExtra("FOODIMGRSC",R.drawable.pepsi));

        }


    }

}
