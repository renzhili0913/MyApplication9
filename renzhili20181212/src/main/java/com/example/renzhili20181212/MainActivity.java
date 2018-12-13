package com.example.renzhili20181212;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.renzhili20181212.adapter.MYFragmentAdapter;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取资源id
        viewPager=findViewById(R.id.viewpager);
        tabLayout=findViewById(R.id.tablayout);
        //创建适配器
        viewPager.setAdapter(new MYFragmentAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }
}
