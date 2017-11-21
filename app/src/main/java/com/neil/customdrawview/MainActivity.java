package com.neil.customdrawview;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.viewPager)
    ViewPager mFragmentsViewPager;

    @BindView(R.id.tabLayout)
    TabLayout mFragmentTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mFragmentsViewPager.setAdapter(new FragmentsPagerAdapter(getSupportFragmentManager()));
    }

    @Override
    protected void onStart() {
        mFragmentTabs.setupWithViewPager(mFragmentsViewPager);
        super.onStart();
    }

    private static class FragmentsPagerAdapter extends FragmentPagerAdapter {

        private List<CustomViewFragment> mFragmentList = new ArrayList<>();

        private FragmentsPagerAdapter(FragmentManager fm) {
            super(fm);
            mFragmentList.add(CustomViewFragment.newInstance("Color"));
            mFragmentList.add(CustomViewFragment.newInstance("Circle"));
            mFragmentList.add(CustomViewFragment.newInstance("Rect"));
            mFragmentList.add(CustomViewFragment.newInstance("Point"));
            mFragmentList.add(CustomViewFragment.newInstance("Oval"));
            mFragmentList.add(CustomViewFragment.newInstance("Line"));
            mFragmentList.add(CustomViewFragment.newInstance("RoundRect"));
            mFragmentList.add(CustomViewFragment.newInstance("Arc"));
            mFragmentList.add(CustomViewFragment.newInstance("Path"));
            mFragmentList.add(CustomViewFragment.newInstance("Histogram"));
            mFragmentList.add(CustomViewFragment.newInstance("Pie"));
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentList.get(position).getArguments().getString(CustomViewFragment.KEY_LABEL);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
    }
}
