package com.ersathi.nutritionrecommender.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ersathi.nutritionrecommender.FoodIntakeActivity;
import com.ersathi.nutritionrecommender.FormActivity;
import com.ersathi.nutritionrecommender.MainActivity;
import com.ersathi.nutritionrecommender.R;

public class HomePageFragment extends Fragment {

    Button inputButton;
    Button foodIntakeButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);

        initializeViews(rootView);

        return rootView;
    }

    private void initializeViews(ViewGroup viewGroup) {
        inputButton = viewGroup.findViewById(R.id.input_button);
        inputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), FormActivity.class);
                startActivity(intent);
            }
        });

        foodIntakeButton = viewGroup.findViewById(R.id.food_intake_button);
        foodIntakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), FoodIntakeActivity.class);
                startActivity(intent);
            }
        });
    }

}
