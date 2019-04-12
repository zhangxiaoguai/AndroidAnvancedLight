package com.ericzhang.androidanvancedlight.chapter01;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Chapter01Adapter extends RecyclerView.Adapter<Chapter01Adapter.Chapter01ViewHolder> {

    private List<String> mList;
    private Context mContext;

    public Chapter01Adapter(List<String> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    public void removeData(int position) {
        mList.remove(position);
        notifyItemMoved(position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull Chapter01ViewHolder chapter01ViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class Chapter01ViewHolder extends ViewHolder {

        TextView tv;

        public Chapter01ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
