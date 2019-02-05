package com.ersathi.nutritionrecommender.fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ersathi.nutritionrecommender.R;

public class WaterFragment extends Fragment {

    TextView waterCounterTextView;
    FloatingActionButton addWaterButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_water, container, false);

        initializeViews(rootView);

        addWaterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                waterCounterTextView.setText(String.valueOf(Integer.parseInt(waterCounterTextView.getText().toString())+1));
            }
        });

        return rootView;
    }

    private void initializeViews(ViewGroup rootView) {

        waterCounterTextView = rootView.findViewById(R.id.water_counter);
        addWaterButton = rootView.findViewById(R.id.water_add_button);
    }
}
