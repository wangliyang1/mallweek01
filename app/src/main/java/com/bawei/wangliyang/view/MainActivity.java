package com.bawei.wangliyang.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.bawei.wangliyang.R;
import com.bawei.wangliyang.base.BaseActivity;
import com.bawei.wangliyang.view.fragment.HomeFragment;
import com.bawei.wangliyang.view.fragment.OtherFragment;
import com.bawei.wangliyang.view.fragment.ShopFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private ViewPager pager;
    private RadioGroup group;
    private List<Fragment>list = new ArrayList<>();
    @Override
    protected void initData() {
        HomeFragment homeFragment = new HomeFragment();
        list.add(homeFragment);
        OtherFragment otherFragment = new OtherFragment();
        list.add(otherFragment);
        OtherFragment otherFragment1 = new OtherFragment();
        list.add(otherFragment1);
        ShopFragment shopFragment = new ShopFragment();
        list.add(shopFragment);
        OtherFragment otherFragment2 = new OtherFragment();
        list.add(otherFragment2);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
               group.check(group.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.bt1:
                        pager.setCurrentItem(0);
                        break;
                    case R.id.bt2:
                        pager.setCurrentItem(1);
                        break;
                    case R.id.bt3:
                        pager.setCurrentItem(2);
                        break;
                    case R.id.bt4:
                        pager.setCurrentItem(3);
                        break;
                    case R.id.bt5:
                        pager.setCurrentItem(4);
                        break;
                }
            }
        });
    }

    @Override
    protected void initView() {
        pager = findViewById(R.id.pager);
        group = findViewById(R.id.group);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }
}
