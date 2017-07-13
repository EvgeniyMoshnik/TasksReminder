package com.test.evgeniy.tasksreminder.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class PagerTabAdapter extends FragmentPagerAdapter {
    private List<String> mFragmentTittleList = new ArrayList<>();
    private List<Fragment> mFragmentList = new ArrayList<>();

    public PagerTabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTittleList.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentTittleList.size();
    }

    public void addFragment(Fragment fragment, String tittle) {

        mFragmentList.add(fragment);
        mFragmentTittleList.add(tittle);
        notifyDataSetChanged();
    }
}
