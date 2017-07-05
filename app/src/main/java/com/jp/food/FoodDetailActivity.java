package com.jp.food;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FoodDetailActivity extends AppCompatActivity {
@BindView(R.id.idTextViewFoodDescription) TextView foodDescTV;
    @BindView(R.id.idTVfoodPrice) TextView foodPriceTV;
    @BindView(R.id.idImageFood) ImageView foodImageView;
    @BindView(R.id.idTextViewFoodName) TextView foodNameTV;
    @BindView(R.id.button2) Button btnAddtoCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        ButterKnife.bind(this);

        final Intent intent = getIntent();
        if (intent != null) {
            foodDescTV.setText(intent.getStringExtra("FOODDESC"));
            getSupportActionBar().setTitle(intent.getStringExtra("FOODNAME"));
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            foodPriceTV.setText("N: "+ String.valueOf(intent.getIntExtra("FOODPRICE",4)));
            foodNameTV.setText(intent.getStringExtra("FOODNAME"));
            foodImageView.setImageResource(intent.getIntExtra("FOODIMGRSC",R.drawable.pepsi));
            btnAddtoCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                     Food food = new Food(String.valueOf(intent.getStringExtra("FOODNAME")),
                             intent.getIntExtra("FOODPRICE",4),
                             intent.getIntExtra("FOODIMGRSC", R.drawable.pepsi),
                             intent.getStringExtra("FOODDESC"));
                    food.addToCart(food);
                    Toast.makeText(FoodDetailActivity.this,intent.getStringExtra("FOODNAME") +" added",
                            Toast.LENGTH_SHORT).show();
                }
            });

        }


    }

}
