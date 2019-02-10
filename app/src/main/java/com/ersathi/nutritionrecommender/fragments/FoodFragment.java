package com.ersathi.nutritionrecommender.fragments;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ersathi.nutritionrecommender.R;
import com.ersathi.nutritionrecommender.adapter.FoodAdapter;
import com.ersathi.nutritionrecommender.database.DBHelper;

public class FoodFragment extends Fragment {

    RecyclerView mRecommendedFoodList;
    LinearLayout mRecommendedFoodContainerLayout;
    FoodAdapter mFoodAdapter;
    SQLiteDatabase mLocalDatabase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_foods, container, false);

        initializeViews(rootView);

        mRecommendedFoodList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        mLocalDatabase = new DBHelper(getContext()).getWritableDatabase();
        mFoodAdapter = new FoodAdapter(getContext(), mLocalDatabase);
        mRecommendedFoodList.setAdapter(mFoodAdapter);

        //addDummyData();



        return rootView;
    }

    private void addDummyData() {
        View myLayout1 = getLayoutInflater().inflate(R.layout.cardview_food_recommendation, null);
        TextView title1 = myLayout1.findViewById(R.id.cardview_title);
        title1.setText("Popcorn");
        TextView desc1 = myLayout1.findViewById(R.id.cardview_text);
        desc1.setText("200 Calories");
        ImageView img1 = myLayout1.findViewById(R.id.cardview_header_photo);
        img1.setImageDrawable(getResources().getDrawable(R.drawable.popcorn));
        setMargins(myLayout1, 8, 8, 8, 8);
        mRecommendedFoodContainerLayout.addView(myLayout1);

        View myLayout2 = getLayoutInflater().inflate(R.layout.cardview_food_recommendation, null);
        TextView title2 = myLayout2.findViewById(R.id.cardview_title);
        title1.setText("Meat");
        TextView desc2 = myLayout2.findViewById(R.id.cardview_text);
        desc1.setText("230 Calories");
        ImageView img2 = myLayout2.findViewById(R.id.cardview_header_photo);
        img1.setImageDrawable(getResources().getDrawable(R.drawable.meat));
        //setMargins(myLayout2, 8, 8, 8, 8);
        mRecommendedFoodContainerLayout.addView(myLayout2);

        View myLayout3 = getLayoutInflater().inflate(R.layout.cardview_food_recommendation, null);
        TextView title3 = myLayout3.findViewById(R.id.cardview_title);
        title1.setText("Butter");
        TextView desc3 = myLayout3.findViewById(R.id.cardview_text);
        desc1.setText("400 Calories");
        ImageView img3 = myLayout3.findViewById(R.id.cardview_header_photo);
        img1.setImageDrawable(getResources().getDrawable(R.drawable.butter));
        //setMargins(myLayout3, 8, 8, 8, 8);
        mRecommendedFoodContainerLayout.addView(myLayout3);
    }

    private void initializeViews(ViewGroup rootView) {
        mRecommendedFoodContainerLayout = rootView.findViewById(R.id.recommended_food_linear_layout);
        mRecommendedFoodList = rootView.findViewById(R.id.recommended_food_recyclerview);
    }

    private void setMargins (View view, int left, int top, int right, int bottom) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            p.setMargins(left, top, right, bottom);
            view.requestLayout();
        }
    }
}
