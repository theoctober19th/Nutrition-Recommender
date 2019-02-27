package com.ersathi.nutritionrecommender.adapter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ersathi.nutritionrecommender.R;
import com.ersathi.nutritionrecommender.models.Food;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

public class FoodAdapter extends /*FirebaseRecyclerAdapter<Food, FoodAdapter.FoodViewHolder>*/ RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private Context mContext;
    private Cursor mCursor;
    private SQLiteDatabase mDatabase;

//    public FoodAdapter(@NonNull FirebaseRecyclerOptions<Food> options) {
//        super(options);
//    }

    public FoodAdapter(Context context, SQLiteDatabase database, String order){
        this.mContext = context;
        this.mDatabase = database;
        mCursor = getFoodList(order);
    }

    private Cursor getFoodList(String order){
        if(order.equals("asc")){
            return mDatabase.rawQuery(
                    "SELECT * FROM dummy_foods;",
                    null
            );
        }else if(order.equals("desc")){
            return mDatabase.rawQuery(
                    "SELECT * FROM dummy_foods ORDER BY (name) DESC;",
                    null
            );
        }else if(order.equals("organic")){
            return mDatabase.rawQuery(
                    "SELECT * FROM organic_foods;",
                    null
            );
        }else if(order.equals("marketing")){
            return mDatabase.rawQuery(
                    "SELECT * FROM marketing_products;",
                    null
            );
        }else{
            return mDatabase.rawQuery(
                    "SELECT * FROM dummy_foods;",
                    null
            );
        }
    }

//
//    @Override
//    protected void onBindViewHolder(@NonNull FoodViewHolder holder, int position, @NonNull Food model) {
//        //TODO PULL DATA FROM FIREBASE AND POPULATE THE VIEW HOLDER
//    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview_food_recommendation, viewGroup, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder foodViewHolder, int i) {
        if(!mCursor.moveToPosition(i)){
            return;
        }
        String name = mCursor.getString(mCursor.getColumnIndex("name"));
        String thumbImageURI = mCursor.getString(mCursor.getColumnIndex("thumbImageURI"));
        String description = mCursor.getString(mCursor.getColumnIndex("description"));
        double calories = mCursor.getInt(mCursor.getColumnIndex("calories"));
        foodViewHolder.bind(name, thumbImageURI, description, calories);
    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder{

        ImageView foodImageThumb;
        TextView titleTextView;
        TextView descpritionTextView;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImageThumb  = (ImageView) itemView.findViewById(R.id.cardview_header_photo);
            titleTextView = itemView.findViewById(R.id.cardview_title);
            descpritionTextView = itemView.findViewById(R.id.cardview_text);
        }

        public void bind(String name, String thumbImageURI, String description, double calories){
            titleTextView.setText(name);
            descpritionTextView.setText(String.valueOf(calories) + " calories");

            Log.d("URLS", thumbImageURI);
//            Picasso.get().load(thumbImageURI).into(foodImageThumb);
            Picasso.with(mContext)
                    .load(thumbImageURI)
                    .into(foodImageThumb);
        }

    }
}
