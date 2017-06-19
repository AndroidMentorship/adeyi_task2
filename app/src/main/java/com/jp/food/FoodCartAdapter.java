package com.jp.food;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by LENIOVO on 6/17/2017.
 */

public class FoodCartAdapter  extends RecyclerView.Adapter<FoodCartAdapter.ViewHolder>{
  private Context context;
    private ArrayList<Food> foodCartArrayList;

    public FoodCartAdapter(Context context, ArrayList<Food> foodCartArrayList) {
        this.context = context;
        this.foodCartArrayList = foodCartArrayList;
    }

    @Override
    public FoodCartAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View contactView = layoutInflater.inflate(R.layout.layout_food_cart, parent, false);
        FoodCartAdapter.ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;


    }

    @Override
    public void onBindViewHolder(FoodCartAdapter.ViewHolder holder, int position) {
            Food cartFood = foodCartArrayList.get(position);
        holder.cartImage.setImageResource(cartFood.getFoodImageResouceId());
        holder.cartItemNameTv.setText(cartFood.getFoodName());
        holder.cartItemPriceTv.setText("N:"+ cartFood.getFoodPrice());
    }

    @Override
    public int getItemCount() {
        return foodCartArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
      ImageView cartImage;
        TextView cartItemNameTv, cartItemPriceTv;
        public ViewHolder(View itemView) {
            super(itemView);
            cartImage = (ImageView)itemView.findViewById(R.id.idImageCartImage);
            cartItemNameTv = (TextView)itemView.findViewById(R.id.idTVcartfoodName);
            cartItemPriceTv = (TextView)itemView.findViewById(R.id.idTVcartFoodPrice);


        }
    }
}
