package com.ericzhang.androidanvancedlight;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.ericzhang.androidanvancedlight.chapter01.Chapter01MainActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements HomeAdapter.OnItemClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private HomeAdapter mHomeAdapter;
    private List<String> mList;
    private List<Class> mTargetList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
    }

    private void initData() {
        mList = new ArrayList<>();
        mList.add("第一章 Android新特性");
        mList.add("第二章 Material Design");
        mList.add("第三章 View体系与自定义View");
        mList.add("第四章 多线程编程");
        mList.add("第五章 网络编程与网络框架");
        mList.add("第六章 设计模式");
        mList.add("第七章 事件总线");
        mList.add("第八章 函数响应式编程");
        mList.add("第九章 注解与依赖注入框架");
        mList.add("第十章 应用架构设计");
        mList.add("第十一章 系统架构与MediaPlayer框架");

        mTargetList = new ArrayList<>();
        mTargetList.add(Chapter01MainActivity.class);

        RecyclerView mRecyclerView = findViewById(R.id.id_recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mHomeAdapter = new HomeAdapter(this, mList);
        mHomeAdapter.setOnItemClickListener(this);
        mRecyclerView.setAdapter(mHomeAdapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.e(TAG, "点击: " + mList.get(position));
        startActivity(new Intent(this, mTargetList.get(position)));
    }

    @Override
    public void onItemLongClick(View view, int position) {
        Log.e(TAG, "onItemLongClick: " + position);
    }
}
