package com.jp.food;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by LENIOVO on 6/13/2017.
 */

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
  private Context context;
    private ArrayList<Food> foodArrayList ;
    ItemClickListener itemClickListener;

    public FoodAdapter(Context context, ArrayList<Food> foodArrayList, ItemClickListener onItemClick) {
        this.context = context;
        this.foodArrayList = foodArrayList;
      itemClickListener = onItemClick;

    }

    @Override
    public FoodAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View contactView = layoutInflater.inflate(R.layout.food_item_display, parent, false);
       ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FoodAdapter.ViewHolder holder, int position) {
     final Food food = foodArrayList.get(position);
    holder.foodPriceTV.setText("N:"+ food.getFoodPrice());
        holder.foodDescriptionTV.setText(food.getFoodName());
        holder.foodImageView.setImageResource(food.getFoodImageResouceId());
        holder.addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                food.addToCart(food);
                Toast.makeText(context, food.getFoodName().toString() + "  added", Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return foodArrayList.size();
    }

    public class ViewHolder  extends  RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView foodImageView;
        TextView foodPriceTV, foodDescriptionTV;
        Button addToCartButton;

        public ViewHolder(View itemView) {
            super(itemView);
foodImageView = (ImageView)itemView.findViewById(R.id.idFoodImageView);
            foodPriceTV = (TextView)itemView.findViewById(R.id.idTextViewPrice);
            foodDescriptionTV = (TextView)itemView.findViewById(R.id.idTextViewDescriptiion);
            addToCartButton = (Button)itemView.findViewById(R.id.idButtonAddToCart);
            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            itemClickListener.ListItemClick(position);

        }
    }
    public  interface  ItemClickListener{
         void ListItemClick(int position);

    }

}
