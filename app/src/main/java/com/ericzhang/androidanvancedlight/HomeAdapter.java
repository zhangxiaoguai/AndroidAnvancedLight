package com.ericzhang.androidanvancedlight;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * RecycleView适配器写法
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    private static final String TAG = HomeAdapter.class.getSimpleName();

    private List<String> mList;
    private Context mContext;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public HomeAdapter(Context mContext, List<String> mList) {
        this.mList = mList;
        this.mContext = mContext;
    }

    public void removeData(int position) {
        mList.remove(position);
        notifyItemRemoved(position);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        Log.e(TAG, "onCreateViewHolder: " + position);

        // 在onCreateViewHolder中记载布局条目
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_recycler, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int position) {
        Log.e(TAG, "onBindViewHolder: " + position);

        // 在onBindViewHolder中将视图与数据进行绑定
        myViewHolder.tv.setText(mList.get(position));

        if (mOnItemClickListener != null) {
            myViewHolder.tv.setOnClickListener(v -> {
                int layoutPosition = myViewHolder.getLayoutPosition();
                mOnItemClickListener.onItemClick(myViewHolder.tv, layoutPosition);
            });

            myViewHolder.tv.setOnLongClickListener(v -> {
                int layoutPosition = myViewHolder.getLayoutPosition();
                mOnItemClickListener.onItemLongClick(myViewHolder.tv, layoutPosition);
                return false;
            });
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv_item);
        }
    }

}
