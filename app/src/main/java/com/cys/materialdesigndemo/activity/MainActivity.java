package com.cys.materialdesigndemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.cys.materialdesigndemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_toolbar)
    Button mBtnToolBar;
    @BindView(R.id.btn_coordinator_layout)
    Button mBtnCoordinatorLayout;
    @BindView(R.id.btn_tab_layout)
    Button mBtnTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initListener();
    }

    private void initListener() {
        mBtnToolBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(ToolbarActivity.getIntent(MainActivity.this));
            }
        });

        mBtnCoordinatorLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(CoordinatorLayoutActivity.getIntent(MainActivity.this));
            }
        });

        mBtnTabLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(TabLayoutActivity.getIntent(MainActivity.this));
            }
        });
    }
}
