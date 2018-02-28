package com.cys.materialdesigndemo.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.cys.materialdesigndemo.R;
import com.cys.materialdesigndemo.adapter.MyRecyclerViewAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * CoordinatorLayout
 */
public class CoordinatorLayoutActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout mRefreshLayout;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private Handler mHandler = new Handler();

    public static Intent getIntent(Context context) {
        return new Intent(context, CoordinatorLayoutActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_coordinator_layout);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        mToolbar.inflateMenu(R.menu.menu_recycle_view_type);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_vertical_layout:
                        LinearLayoutManager verticalManager = new LinearLayoutManager(CoordinatorLayoutActivity.this, LinearLayoutManager.VERTICAL, false);
                        mRecyclerView.setLayoutManager(verticalManager);
                        break;
                    case R.id.action_horizontal_layout:
                        LinearLayoutManager horizontalManager = new LinearLayoutManager(CoordinatorLayoutActivity.this, LinearLayoutManager.HORIZONTAL, false);
                        mRecyclerView.setLayoutManager(horizontalManager);
                        break;
                    case R.id.action_grid_layout:
                        GridLayoutManager gridLayoutManager = new GridLayoutManager(CoordinatorLayoutActivity.this, 2);
                        mRecyclerView.setLayoutManager(gridLayoutManager);
                        break;
                    case R.id.action_staggered_grid_layout:
                        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                        // 空隙不作处理，防止item乱跳
                        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
                        mRecyclerView.setLayoutManager(staggeredGridLayoutManager);
                        break;
                }
                return false;
            }
        });

        // 设置进度条颜色，支持多颜色
        mRefreshLayout.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE);
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // 延时2秒执行，模拟网络访问
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // 结束刷新
                        mRefreshLayout.setRefreshing(false);
                        Toast.makeText(CoordinatorLayoutActivity.this, "刷新完成", Toast.LENGTH_SHORT).show();
                    }
                }, 2000);
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        final ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i + "");
        }
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(list);
        mRecyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new MyRecyclerViewAdapter.IOnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(CoordinatorLayoutActivity.this, "点击了：" + list.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
