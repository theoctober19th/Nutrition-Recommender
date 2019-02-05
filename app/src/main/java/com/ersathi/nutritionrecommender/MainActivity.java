package com.ersathi.nutritionrecommender;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;

import com.ersathi.nutritionrecommender.fragments.HomePageFragment;
import com.ersathi.nutritionrecommender.fragments.FoodFragment;
import com.ersathi.nutritionrecommender.fragments.MedicineFragment;
import com.ersathi.nutritionrecommender.fragments.NutritionFragment;
import com.ersathi.nutritionrecommender.fragments.WaterFragment;

public class MainActivity extends AppCompatActivity {

    private static final int NUM_PAGES = 5;
    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private TabLayout mSlidingPageTabLayout;

    private int[] iconImageResId = {
            R.drawable.ic_home_black_24dp,
            R.drawable.ic_diet_24_dp,
            R.drawable.ic_chart_24_dp,
            R.drawable.ic_water_drop_24_dp,
            R.drawable.ic_access_alarms_black_24dp
    };


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

        mSlidingPageTabLayout = findViewById(R.id.sliding_tabs);
        mSlidingPageTabLayout.setupWithViewPager(mViewPager);

        for (int i = 0; i < iconImageResId.length; i++) {
            mSlidingPageTabLayout.getTabAt(i).setIcon(iconImageResId[i]);
//            mSlidingPageTabLayout.getTabAt(i).getCustomView().setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                }
//            });
        }

        intializeViews();
    }

    private void intializeViews() {
    }


    @Override
    public void onBackPressed() {
        if(mViewPager.getCurrentItem() == 0){
            super.onBackPressed();
        }else{
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);
        }
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

        private String[] pageTitles = {"Home", "Food", "Nutrition", "Water", "Medicine"};

        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            switch(i){
                case 0:
                    return new HomePageFragment();
                case 1:
                    return new FoodFragment();
                case 2:
                    return new NutritionFragment();
                case 3:
                    return new WaterFragment();
                case 4:
                    return new MedicineFragment();
                default:
                    return new HomePageFragment();
            }
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }
    }
}
