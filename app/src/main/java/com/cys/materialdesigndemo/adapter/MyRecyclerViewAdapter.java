package com.cys.materialdesigndemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cys.materialdesigndemo.R;

import java.util.ArrayList;

/**
 * MyRecyclerViewAdapter
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    private ArrayList<String> mList;

    private IOnItemClickListener mOnItemClickListener;

    public MyRecyclerViewAdapter(ArrayList<String> list) {
        this.mList = list;
    }

    @Override
    public MyRecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.mTextView.setText(mList.get(position));
        // 动态改变 ImageView 高度
        ViewGroup.LayoutParams params = holder.mImageView.getLayoutParams();
        params.height = (int) (100 + Math.random() * 200);
        holder.mImageView.setLayoutParams(params);

        // 设置item点击监听
        if (null != mOnItemClickListener) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickListener.onItemClick(view, holder.getLayoutPosition());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    /**
     * 设置item监听器
     *
     * @param onItemClickListener
     */
    public void setOnItemClickListener(IOnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.iv_item);
            mTextView = itemView.findViewById(R.id.tv_item);
        }
    }

    /**
     * item 回调监听
     * 由于 RecyclerView 没有提供item的点击监听，所以要自己提供接口进行回调
     */
    public interface IOnItemClickListener {
        void onItemClick(View view, int position);
    }
}
