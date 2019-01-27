package com.ersathi.nutritionrecommender.fragments.form;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.ersathi.nutritionrecommender.R;

public class PersonalInfoFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_personal_info, container, false);

        initializeViews(rootView);

        return rootView;
    }

    private void initializeViews(ViewGroup rootView) {

    }
}
