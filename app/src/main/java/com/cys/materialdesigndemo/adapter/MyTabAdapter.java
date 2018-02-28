package com.cys.materialdesigndemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.cys.materialdesigndemo.fragment.MyFragment;

import java.util.ArrayList;

/**
 * MyTabAdapter
 */
public class MyTabAdapter extends FragmentStatePagerAdapter {

    private ArrayList<MyFragment> mFragments;
    private String[] mTabName;

    public MyTabAdapter(FragmentManager fm, ArrayList<MyFragment> fragments, String[] tabName) {
        super(fm);
        mFragments = fragments;
        mTabName = tabName;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

//    /**
//     * FIXME 调用 setupWithViewPager 方法后会为我们设置与 getCount 等量的空白标题，如果标题只有文字可以在此进行设置
//     *
//     * @param position
//     * @return
//     */
//    @Override
//    public CharSequence getPageTitle(int position) {
//        return mTabName[position];
//    }
}
