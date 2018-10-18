package com.star.coordinatorlayouttest;

import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class CollapsingToolbarActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_toolbar_layout);

        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mCollapsingToolbarLayout = findViewById(R.id.collapsing_toolbar_layout);
        mCollapsingToolbarLayout.setTitle("机器猫");

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(
                1, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(new RecyclerViewAdapter(CollapsingToolbarActivity.this));
    }
}
