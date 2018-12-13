package com.example.renzhili20181212.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.renzhili20181212.fragment.GridFragment;
import com.example.renzhili20181212.fragment.LinnerFragment;
import com.example.renzhili20181212.fragment.StagaredFragment;

public class MYFragmentAdapter extends FragmentPagerAdapter {
    private String[] meuns=new String[]{"线性布局","网格布局","瀑布流"};
    public MYFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                return new LinnerFragment();
            case 1:
                return new GridFragment();
            case 2:
                return new StagaredFragment();
        }
        return null;
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
