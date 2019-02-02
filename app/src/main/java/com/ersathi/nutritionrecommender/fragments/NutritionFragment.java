package com.ersathi.nutritionrecommender.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ersathi.nutritionrecommender.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class NutritionFragment extends Fragment {

    LineChart proteinChart;
    List<Entry> entries = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_nutrition, container, false);

        initializeViews(rootView);

        populateData();

        prepareChart();

        return rootView;
    }

    private void prepareChart() {
        LineDataSet dataSet = new LineDataSet(entries, "Protein");
        LineData lineData = new LineData(dataSet);
        proteinChart.setData(lineData);
        proteinChart.invalidate();
    }

    private void populateData() {
        for(int i=0; i<10; i++){
            entries.add(new Entry(i*10, i*10));
        }
    }

    private void initializeViews(ViewGroup rootView) {
        proteinChart = (LineChart) rootView.findViewById(R.id.protein_chart);
    }
}
