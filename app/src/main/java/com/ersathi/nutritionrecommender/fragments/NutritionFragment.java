package com.ersathi.nutritionrecommender.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ersathi.nutritionrecommender.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

public class NutritionFragment extends Fragment {

    LineChart proteinChart;
    PieChart carbohydrateChart;
    List<Entry> lineEntries = new ArrayList<>();
    List<PieEntry> pieEntries = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_nutrition, container, false);

        initializeViews(rootView);

        populateData();

        prepareChart();

        return rootView;
    }

    private void prepareChart() {
        LineDataSet lineDataSet = new LineDataSet(lineEntries, "Protein");
        LineData lineData = new LineData(lineDataSet);
        proteinChart.setData(lineData);
        proteinChart.invalidate();

        PieDataSet pieDataSet= new PieDataSet(pieEntries, "Carbohydrate");
        PieData pieData = new PieData(pieDataSet);
        carbohydrateChart.setData(pieData);
        carbohydrateChart.invalidate();
    }

    private void populateData() {
        for(int i=0; i<10; i++){
            lineEntries.add(new Entry(i*10, i*10));
        }

        for(int i=0; i<5; i++){
            pieEntries.add(new PieEntry(i*10, i));
        }
    }

    private void initializeViews(ViewGroup rootView) {
        proteinChart = (LineChart) rootView.findViewById(R.id.protein_chart);
        carbohydrateChart = (PieChart) rootView.findViewById(R.id.carbohydrate_chart);
    }
}
