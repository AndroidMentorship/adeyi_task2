package com.jp.food;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CartActivity extends AppCompatActivity implements FoodAdapter.ItemClickListener, View.OnClickListener{
    @BindView(R.id.idRecyclerViewCart) RecyclerView cartRecyclerView;
    @BindView(R.id.TVcontinueShopipng) TextView TVcontinueShop;
    @BindView(R.id.idButtonProceed) Button btnProceed;
    private LinearLayoutManager  linearLayoutManager;
    private FoodCartAdapter foodCartAdapter;
    private ArrayList<Food> cartArrayList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle(getString(R.string.cart_Title));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        cartArrayList = Food.getFoodCartList();
        linearLayoutManager = new LinearLayoutManager(this);
        foodCartAdapter = new FoodCartAdapter(getApplicationContext(), cartArrayList);
        cartRecyclerView.setLayoutManager(linearLayoutManager);
        cartRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        cartRecyclerView.setAdapter(foodCartAdapter);
        cartRecyclerView.setHasFixedSize(true);
        btnProceed.setOnClickListener(this);
        TVcontinueShop.setOnClickListener(this);


    }

    @Override
    public void ListItemClick(int position) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.idButtonProceed:
                startActivity(new Intent(getApplicationContext(),CompleteTransactionActivity.class));
                break;
            case R.id.TVcontinueShopipng:
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                break;
            default:
                break;

        }
    }
}
