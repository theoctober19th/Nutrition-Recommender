package com.ersathi.nutritionrecommender;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ersathi.nutritionrecommender.fragments.home.HomePageFragment;
import com.ersathi.nutritionrecommender.fragments.home.RecommendationFragment;

public class MainActivity extends AppCompatActivity {

    private static final int NUM_PAGES = 2;
    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;

    Button inputButton;

//    protected void navigateForm(View view){
//        Intent intent = new Intent(MainActivity.this, FormActivity.class);
//        startActivity(intent);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.slide_pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);

        intializeViews();
    }

    private void intializeViews() {
        inputButton = findViewById(R.id.input_button);
        inputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FormActivity.class);
                startActivity(intent);
            }
        });
        }

    @Override
    public void onBackPressed() {
        if(mViewPager.getCurrentItem() == 0){
            super.onBackPressed();
        }else{
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);
        }
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter{

        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            switch(i){
                case 0:
                    return new HomePageFragment();
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
