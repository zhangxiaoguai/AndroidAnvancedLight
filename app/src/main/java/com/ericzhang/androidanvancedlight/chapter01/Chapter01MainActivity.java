package com.ericzhang.androidanvancedlight.chapter01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ericzhang.androidanvancedlight.R;
import com.ericzhang.androidanvancedlight.chapter01.mycardview.CardViewActivity;
import com.ericzhang.androidanvancedlight.chapter01.mynotification.NotificationActivity;
import com.ericzhang.androidanvancedlight.chapter01.myrecyclerview.RecyclerViewActivity;

import java.util.ArrayList;
import java.util.List;

public class Chapter01MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private List<String> mList;
    private List<Class> mTargetList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter01_main);

        initData();
        initView();
    }

    private void initData() {
        mList = new ArrayList<>();
        mList.add("RecyclerView");
        mList.add("卡片CardView");
        mList.add("三种Notification");
        mList.add("Toolbar与Palette");

        mTargetList = new ArrayList<>();
        mTargetList.add(RecyclerViewActivity.class);
        mTargetList.add(CardViewActivity.class);
        mTargetList.add(NotificationActivity.class);
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        // 布局管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        // item分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        // 增加删除动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
