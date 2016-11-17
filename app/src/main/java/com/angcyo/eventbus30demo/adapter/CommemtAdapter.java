package com.angcyo.eventbus30demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by admin on 2016/11/15.
 * Tany(公共适配器)
 */

public abstract class CommemtAdapter<T> extends RecyclerView.Adapter<RecyclerHolder>{

    private Context mContext;
    private List<T> list;
    protected LayoutInflater mInflater;
    private int mItemLayoutId;

    public CommemtAdapter(Context context) {
        // TODO Auto-generated constructor stub
        this.mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
        this.mItemLayoutId = new LinearLayout(mContext).getId();
        this.list = new ArrayList<T>();
    }

    public CommemtAdapter(Context context, List<T> list) {
        // TODO Auto-generated constructor stub
        this.mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
        this.mItemLayoutId = new LinearLayout(mContext).getId();
        this.list = list;
    }

    public CommemtAdapter(Context context, List<T> list, int itemLayoutId) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
        this.mItemLayoutId = itemLayoutId;
        this.list = list;
    }

    public CommemtAdapter(Context context, int itemLayoutId) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
        this.mItemLayoutId = itemLayoutId;
        this.list = new ArrayList<T>();

    }

    public void setitemLayoutId(int itemLayoutId) {
        this.mItemLayoutId = itemLayoutId;
    }

    public List<T> getList() {
        return this.list;
    }

    public void appendList(List<T> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void addList(List<T> list2) {
        this.list.addAll((Collection<? extends T>) list2);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    boolean hasHeader = false;
    boolean hasFooter = false;
    View headerView;
    View footerView;

    public void setHeaderView(View headerView) {
        hasHeader=true;
        this.headerView = headerView;
    }

    public void setFooterView(View footerView) {
        hasFooter = true;
        this.footerView = footerView;
    }

    public View getHeaderView() {
        return headerView;
    }

    public View getFooterView() {
        return footerView;
    }

    @Override
    public void onBindViewHolder(RecyclerHolder holder, int position) {
        if (hasHeader && position == 0) {
            return;
        } else if (hasFooter && position == (list.size() + (hasHeader ? 1 : 0))) {
            return;
        } else {
            convert(holder, (T) list.get(position));
        }
    }

    @Override
    public RecyclerHolder onCreateViewHolder(ViewGroup parent, int position) {
        if (hasHeader && position == 0) {
            return new RecyclerHolder(headerView);
        } else if (hasFooter && position == (list.size() + (hasHeader ? 1 : 0))) {
            return new RecyclerHolder(footerView);
        } else
            return RecyclerHolder.get(mContext, parent, mItemLayoutId, position);
    }
    //这里定义抽象方法，我们在匿名内部类实现的时候实现此方法来调用控件
    public abstract void convert(RecyclerHolder holder, T item);
}
