package com.ericzhang.androidanvancedlight.chapter01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ericzhang.androidanvancedlight.R;

import java.util.Arrays;
import java.util.List;

public class Chapter01MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private List<Integer> mList;
    private List<Class> mTargetList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter01_main);

        initData();
        initView();
    }

    private void initData() {
        int[] target=
        {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
        mList.add(Arrays.asList());


    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}
