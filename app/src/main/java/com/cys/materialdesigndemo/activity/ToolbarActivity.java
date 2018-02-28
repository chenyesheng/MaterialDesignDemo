package com.cys.materialdesigndemo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.cys.materialdesigndemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Toolbar、DrawerLayout、NavigationView
 */
public class ToolbarActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.nav_view)
    NavigationView mNavView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    public static Intent getIntent(Context context) {
        return new Intent(context, ToolbarActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 隐藏系统默认的导航栏
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_toolbar);
        ButterKnife.bind(this);

        initToolbar();
        initDrawerLayout();
    }

    private void initToolbar() {
        // 设置ActionMenu布局（方式一）
        mToolbar.inflateMenu(R.menu.menu_toobar);
        // 设置logo
        mToolbar.setLogo(R.mipmap.ic_launcher_round);
        // 设置标题
        mToolbar.setTitle("title");
        // 设置副标题
        mToolbar.setSubtitle("sub title");
        // 设置标题的字体颜色
        mToolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        // 设置子标题的字体颜色
        mToolbar.setSubtitleTextColor(getResources().getColor(android.R.color.white));

//        setSupportActionBar(mToolbar);
        // 设置导航按钮图标
        mToolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
        // 设置更多按钮图标
        mToolbar.setOverflowIcon(getResources().getDrawable(R.drawable.ic_more_horiz_white_24dp));

        // 设置导航图标的点击事件（方式一）
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });
        // 设置各菜单的点击事件（方式一）
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                String tip = "";
                switch (id) {
                    case R.id.action_search:
                        tip = "搜索";
                        break;
                    case R.id.action_setting:
                        tip = "设置";
                        break;
                    case R.id.action_help:
                        tip = "帮助";
                        break;
                }
                Toast.makeText(ToolbarActivity.this, tip, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void initDrawerLayout() {
//        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open, R.string.close);
//        // 与 DrawerLayout 的状态同步
//        actionBarDrawerToggle.syncState();
//        // 设置监听器
//        mDrawerLayout.addDrawerListener(actionBarDrawerToggle);

        mNavView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                String tip = "";
                switch (id) {
                    case R.id.setting_item_1:
                        tip = "设置1";
                        break;
                    case R.id.setting_item_2:
                        tip = "设置2";
                        break;
                    case R.id.setting_item_3:
                        tip = "设置3";
                        break;
                    case R.id.setting_item_4:
                        tip = "设置4";
                        break;
                }
                Toast.makeText(ToolbarActivity.this, tip, Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // 设置ActionMenu布局（方式二）
//        getMenuInflater().inflate(R.menu.menu_toobar, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        String tip = "";
//        switch (id) {
//            // 对应 NavigationIcon 的点击
//            case android.R.id.home:
//                tip = "菜单";
//                break;
//            case R.id.action_search:
//                tip = "搜索";
//                break;
//            case R.id.action_setting:
//                tip = "设置";
//                break;
//            case R.id.action_help:
//                tip = "帮助";
//                break;
//        }
//        Toast.makeText(ToolbarActivity.this, tip, Toast.LENGTH_SHORT).show();
//        return false;
//    }
}
