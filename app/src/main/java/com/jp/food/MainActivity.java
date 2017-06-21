package com.jp.food;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements FoodAdapter.ItemClickListener {
    @BindView(R.id.idRecyclerViewMain) RecyclerView recyclerView;
    FoodAdapter foodAdapter;
    LinearLayoutManager linearLayoutManager;
    private ArrayList<Food> foodArrayList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle(getString(R.string.main_activity_title));
        foodArrayList = Food.getFoodList();
        linearLayoutManager = new LinearLayoutManager(this);
        foodAdapter = new FoodAdapter(this, foodArrayList,this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(foodAdapter);
        recyclerView.setHasFixedSize(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
     switch (item.getItemId()){
         case R.id.cart:
             startActivity(new Intent(getApplicationContext(), CartActivity.class));
             return  true;


           default:
               return super.onOptionsItemSelected(item);


     }

     }

    @Override
    public void ListItemClick(int position) {
        Food food = foodArrayList.get(position);
        Bundle bundle = new Bundle();
        bundle.putParcelable("Food", food);
        Intent intent = new Intent(MainActivity.this, FoodDetailActivity.class);
            intent.putExtra("FOODNAME", food.getFoodName());
         intent.putExtra("FOODPRICE", food.getFoodPrice());
        intent.putExtra("FOODDESC", food.getFoodDescription());
        intent.putExtra("FOODIMGRSC", food.getFoodImageResouceId());
        startActivity(intent);

    }
}

