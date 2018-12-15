package com.example.week03_04.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.week03_04.fragment.ShowFragment;


public class MYFragmentAdapter extends FragmentPagerAdapter {
    String[] meuns = new String[]{"首页","购物车","动态","我的"};
    public MYFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                return new ShowFragment();
                default:
                    return new Fragment();
        }

    }

    @Override
    public int getCount() {
        return meuns.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return meuns[position];
    }
}
