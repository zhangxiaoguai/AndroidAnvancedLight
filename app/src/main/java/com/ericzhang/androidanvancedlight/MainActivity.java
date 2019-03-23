package com.ericzhang.androidanvancedlight;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
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
        initView();
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
    }

    private void initView() {
        RecyclerView mRecyclerView = findViewById(R.id.id_recyclerView);
        // 设置布局管理器，默认是垂直排列
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 设置水平排列的布局管理器
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        mRecyclerView.setLayoutManager(linearLayoutManager);

        // 设置分割线，在setAdapter之前调用
        // 默认分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        // 自定义分割线
//        mRecyclerView.addItemDecoration(new OriginalDividerItemDecoration(this, OriginalDividerItemDecoration.VERTICAL_LIST));

        // 设置item增加和删除时的动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        // 设置适配器
        mHomeAdapter = new HomeAdapter(this, mList);
        mHomeAdapter.setOnItemClickListener(this);
        mRecyclerView.setAdapter(mHomeAdapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.e(TAG, "点击: " + mList.get(position));
        if (mTargetList.size() <= position) {
            Log.e(TAG, "尚未实现该功能");
            return;
        }
        startActivity(new Intent(this, mTargetList.get(position)));
    }

    @Override
    public void onItemLongClick(View view, final int position) {
        Log.e(TAG, "onItemLongClick: " + position);

        new AlertDialog.Builder(MainActivity.this)
                .setTitle("确认删除吗？")
                .setNegativeButton("取消", (dialog, which) -> Log.e(TAG, "取消"))
                .setPositiveButton("确定", (dialog, which) -> mHomeAdapter.removeData(position))
                .show();
    }
}
