package com.ersathi.nutritionrecommender.fragments.form;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.ersathi.nutritionrecommender.R;

public class HealthInfoFragment extends Fragment {

    private Spinner diseaseSpinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_health_info, container, false);

        initializeViews(rootView);

        return rootView;
    }

    private void initializeViews(ViewGroup rootView) {
        diseaseSpinner = (Spinner)  rootView.findViewById(R.id.spinnerDisease);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.diseases_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        diseaseSpinner.setAdapter(adapter);
    }
}
