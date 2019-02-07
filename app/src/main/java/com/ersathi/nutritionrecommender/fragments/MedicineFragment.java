package com.ersathi.nutritionrecommender.fragments;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ersathi.nutritionrecommender.R;
import com.ersathi.nutritionrecommender.adapter.MedicineAdapter;
import com.ersathi.nutritionrecommender.database.DBHelper;

public class MedicineFragment extends Fragment {

    RecyclerView mMedicineRecommendationList;
    MedicineAdapter mMedicineAdapter;
    SQLiteDatabase mLocalDatabase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_medicine, container, false);

        initializeViews(rootView);

        DBHelper dbHelper = new DBHelper(getContext());
        mLocalDatabase = dbHelper.getWritableDatabase();
        mMedicineAdapter = new MedicineAdapter(getContext(), mLocalDatabase);
        mMedicineRecommendationList.setAdapter(mMedicineAdapter);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    private void initializeViews(ViewGroup rootView) {
        mMedicineRecommendationList = rootView.findViewById(R.id.medicineRecommendationList);
        mMedicineRecommendationList.setLayoutManager(new LinearLayoutManager(getContext()));
    }



    private void deleteMedicine(){
        mLocalDatabase.execSQL("DELETE FROM medicinces WHERE ");
    }


}
