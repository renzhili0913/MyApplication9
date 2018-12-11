package com.bwie.renzhili.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyFragmentAdapter extends FragmentPagerAdapter {
    private String[] meuns = new String[]{"首页","分类","Me","购物车","我的"};
    public MyFragmentAdapter(FragmentManager fm) {
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
