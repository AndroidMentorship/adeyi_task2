package com.jp.food;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by LENIOVO on 6/13/2017.
 */

public class Food implements Parcelable {

    private String foodName;

    private String foodDescription;
    private int foodPrice, foodImageResouceId;
    public static ArrayList<Food> foodCartList  = new ArrayList<Food>();

    protected Food(Parcel in) {
        foodName = in.readString();
        foodDescription = in.readString();
        foodPrice = in.readInt();
        foodImageResouceId = in.readInt();
    }

    public static final Creator<Food> CREATOR = new Creator<Food>() {
        @Override
        public Food createFromParcel(Parcel in) {
            return new Food(in);
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };

    public String getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }



    public Food(String foodName, int foodPrice, int foodImageResouceId, String foodDescription) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodImageResouceId = foodImageResouceId;
        this.foodDescription = foodDescription;
    }


    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }

    public int getFoodImageResouceId() {
        return foodImageResouceId;
    }

    public void setFoodImageResouceId(int foodImageResouceId) {
        this.foodImageResouceId = foodImageResouceId;
    }
public static ArrayList<Food> getFoodList(){
   ArrayList<Food> foods = new ArrayList<Food>();
    Food amala = new Food("Amala", 1000, R.drawable.amala_image,
            "Hot Amala with vegetable soup and pepper saucee, the Vegetable soup, very sweet, you would love it ");
    Food poundedYam = new Food("Pounded Yam ", 1500, R.drawable.pounded_yam,
            "Pounded yam and egusi soup filled with a lot of cow skin(ponmo) and fish");
    Food pepsi = new Food("Pepsi 60cl", 200, R.drawable.pepsi, "Chilled plastic of pepsi 60CL");
    Food friedRice = new Food("Fried rice", 1500, R.drawable.fried_rice,
            "Fried rice garnished with dodo and chicken, made with the best sauce ");
    Food hollandia = new Food("Hollandia", 800, R.drawable.hollandia_youghurt, "Big bottle of hollandia yoghurt ");
    foods.add(amala);
    foods.add(poundedYam);
    foods.add(pepsi);
    foods.add(friedRice);
    foods.add(hollandia);
    foods.add(new Food("sample food", 500, R.drawable.pepsi,
            "sample food, it is dummy data, i cant find alot of food pictures "));
    foods.add(new Food("sample food", 500, R.drawable.pepsi,
            "sample food, it is dummy data, i cant find alot of food pictures "));
    foods.add(new Food("sample food", 500, R.drawable.pepsi,
            "sample food, it is dummy data, i cant find alot of food pictures "));
    foods.add(new Food("sample food", 500, R.drawable.pepsi,
            "sample food, it is dummy data, i cant find alot of food pictures "));
    foods.add(new Food("sample food", 500, R.drawable.pepsi,
            "sample food, it is dummy data, i cant find alot of food pictures "));
    foods.add(new Food("sample food", 500, R.drawable.pepsi,
            "sample food, it is dummy data, i cant find alot of food pictures "));
    foods.add(new Food("sample food", 500, R.drawable.pepsi,
            "sample food, it is dummy data, i cant find alot of food pictures "));
    foods.add(new Food("sample food", 500, R.drawable.pepsi,
            "sample food, it is dummy data, i cant find alot of food pictures "));
    foods.add(new Food("sample food", 500, R.drawable.pepsi,
            "sample food, it is dummy data, i cant find alot of food pictures "));
    foods.add(new Food("sample food", 500, R.drawable.pepsi,
            "sample food, it is dummy data, i cant find alot of food pictures "));
    foods.add(new Food("sample food", 500, R.drawable.pepsi,
            "sample food, it is dummy data, i cant find alot of food pictures "));
    foods.add(new Food("sample food", 500, R.drawable.pepsi,
            "sample food, it is dummy data, i cant find alot of food pictures "));
    foods.add(new Food("sample food", 500, R.drawable.pepsi,
            "sample food, it is dummy data, i cant find alot of food pictures "));
    foods.add(new Food("sample food", 500, R.drawable.pepsi,
            "sample food, it is dummy data, i cant find alot of food pictures "));













    return foods;
}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(foodName);
        dest.writeString(foodDescription);
        dest.writeInt(foodPrice);
        dest.writeInt(foodImageResouceId);
    }

    public  void addToCart(Food food){
        foodCartList.add(food);

    }

    public static ArrayList<Food> getFoodCartList(){
        return foodCartList;
    }

    public  static String cartListToString(){
       StringBuilder builder = new StringBuilder("");
        for(Food food : foodCartList){
            builder.append(food.getFoodName());
        }
        return  new String(builder);

    }
    public  static int getCartPrice(){
        int price = 0;
        for (Food food: foodCartList) {
            price+= food.getFoodPrice();
        }
    return  price;
    }
}
