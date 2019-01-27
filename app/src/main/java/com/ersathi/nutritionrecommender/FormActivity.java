package com.ersathi.nutritionrecommender;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.ersathi.nutritionrecommender.fragments.form.PersonalInfoFragment;
import com.ersathi.nutritionrecommender.fragments.home.HomePageFragment;
import com.ersathi.nutritionrecommender.fragments.home.RecommendationFragment;
import com.ersathi.nutritionrecommender.views.NonSwipeableViewPager;

public class FormActivity extends AppCompatActivity {

    private static final int NUM_PAGES = 3;
    private NonSwipeableViewPager mViewPager;
    private PagerAdapter mPagerAdapter;

    private ImageButton nextButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        initalizeViews();

        mViewPager = (NonSwipeableViewPager) findViewById(R.id.slide_pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go to new page
            }
        });
    }

    private void initalizeViews() {
        nextButton = findViewById(R.id.nextButton);
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            switch(i){
                case 0:
                    return new PersonalInfoFragment();
                case 1:
                    return new RecommendationFragment();
                default:
                    return new HomePageFragment();
            }
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

}
