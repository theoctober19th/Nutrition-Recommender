package com.ersathi.nutritionrecommender.adapter;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ersathi.nutritionrecommender.R;
import com.ersathi.nutritionrecommender.models.Food;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class FoodAdapter extends FirebaseRecyclerAdapter<Food, FoodAdapter.FoodViewHolder> {


    public FoodAdapter(@NonNull FirebaseRecyclerOptions<Food> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull FoodViewHolder holder, int position, @NonNull Food model) {
        //TODO PULL DATA FROM FIREBASE AND POPULATE THE VIEW HOLDER
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview_food_recommendation, viewGroup, false);
        return new FoodViewHolder(view);
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


    }
}
