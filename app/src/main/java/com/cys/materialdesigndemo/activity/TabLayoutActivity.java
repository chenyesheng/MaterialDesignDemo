package com.cys.materialdesigndemo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.cys.materialdesigndemo.R;
import com.cys.materialdesigndemo.adapter.MyTabAdapter;
import com.cys.materialdesigndemo.fragment.MyFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * TabLayout
 */
public class TabLayoutActivity extends AppCompatActivity {

    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    private ArrayList<MyFragment> mFragments = new ArrayList<>();

    public static Intent getIntent(Context context) {
        return new Intent(context, TabLayoutActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        ButterKnife.bind(this);

        initViewPager();
        initTabLayout();
    }

    private void initViewPager() {
        String[] tabName = getResources().getStringArray(R.array.tab);
        for (String s : tabName) {
            MyFragment fragment = new MyFragment();
            Bundle bundle = new Bundle();
            bundle.putString(MyFragment.TAB, s);
            fragment.setArguments(bundle);
            mFragments.add(fragment);
        }
        MyTabAdapter adapter = new MyTabAdapter(getSupportFragmentManager(), mFragments, tabName);
        mViewPager.setAdapter(adapter);
        // 关联 viewPager
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initTabLayout() {
        String[] tabName = getResources().getStringArray(R.array.tab);
//        // 给 TabLayout 添加新 Tab
//        for (int i = 0; i < tabName.length; i++) {
//            TabLayout.Tab tab = mTabLayout.newTab();
//            // 使用自带的方法设置图标和文字
////            tab.setIcon(R.drawable.ic_add_black_24dp);
////            tab.setText(tabName[i]);
//            // 使用自定义tab视图
//            tab.setCustomView(R.layout.tab_custom_view);
//            if (null != tab.getCustomView()) {
//                ImageView imageView = tab.getCustomView().findViewById(R.id.iv_tab_icon);
//                TextView textView = tab.getCustomView().findViewById(R.id.tv_tab_text);
//                textView.setText(tabName[i]);
//                if (i == 0) {
//                    imageView.setImageResource(R.drawable.ic_add_white_24dp);
//                    textView.setTextColor(Color.WHITE);
//                }
//            }
//            mTabLayout.addTab(tab);
//        }

        // FIXME 与 viewPager 关联后会为我们添加标题，所以可以通过 getTabAt 获取到标题
        for (int i = 0; i < tabName.length; i++) {
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            if (null != tab) {
                tab.setCustomView(R.layout.tab_custom_view);
                if (null != tab.getCustomView()) {
                    ImageView imageView = tab.getCustomView().findViewById(R.id.iv_tab_icon);
                    TextView textView = tab.getCustomView().findViewById(R.id.tv_tab_text);
                    textView.setText(tabName[i]);
                    // 不使用 selector 方式就需要这样设置
//                    if (i == 0) {
//                        imageView.setImageResource(R.drawable.ic_add_white_24dp);
//                        textView.setTextColor(Color.WHITE);
//                    }
                }
            }
        }

        // 不使用 selector 方式就需要这样设置
//        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                if (null != tab.getCustomView()) {
//                    ImageView imageView = tab.getCustomView().findViewById(R.id.iv_tab_icon);
//                    imageView.setImageResource(R.drawable.ic_add_white_24dp);
//                    TextView textView = tab.getCustomView().findViewById(R.id.tv_tab_text);
//                    textView.setTextColor(Color.WHITE);
//                }
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//                if (null != tab.getCustomView()) {
//                    ImageView imageView = tab.getCustomView().findViewById(R.id.iv_tab_icon);
//                    imageView.setImageResource(R.drawable.ic_add_black_24dp);
//                    TextView textView = tab.getCustomView().findViewById(R.id.tv_tab_text);
//                    textView.setTextColor(Color.BLACK);
//                }
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
    }
}
