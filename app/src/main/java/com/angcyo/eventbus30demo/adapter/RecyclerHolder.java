package com.angcyo.eventbus30demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.angcyo.eventbus30demo.ImageUtils.ImageLoadConfig;
import com.angcyo.eventbus30demo.ImageUtils.ImageLoader;

/**
 * Created by admin on 2016/11/15.
 * Tany
 */

public class RecyclerHolder extends RecyclerView.ViewHolder{
    private final SparseArray<View> mViews;

    ImageLoadConfig config = ImageLoadConfig.parseBuilder(ImageLoader.defConfig).setCropType(ImageLoadConfig.FIT_CENTER).
            setSkipMemoryCache(false).
            setDiskCacheStrategy(ImageLoadConfig.DiskCache.ALL).
            setRoundedCorners(false).
            setAsBitmap(true).
            setAnimator(null).
            setBlur(true).
            build();

    public RecyclerHolder(View itemView) {
        super(itemView);
        //一般不会超过8个吧
        this.mViews = new SparseArray<View>(8);
    }

    public static RecyclerHolder get(Context context, ViewGroup parent, int layoutId, int position) {
        View view = LayoutInflater.from(context).inflate(layoutId, parent, false);
        return new RecyclerHolder(view);
    }

    /**
     * 通过控件的Id获取对于的控件，如果没有则加入views
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * 为TextView设置字符串
     */
    public RecyclerHolder setText(int viewId, String text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }

    /**
     * 为ImageView设置图片
     */
    public RecyclerHolder setImageByUrl(int viewId, String url) {
        ImageView view = getView(viewId);
        ImageLoader.loadStringRes(view,url,config,null);
        return this;
    }

    /**
     * 为ImageView设置图片
     */
    public RecyclerHolder setImageById(int viewId, Integer resourceId) {
        ImageView view = getView(viewId);
        ImageLoader.loadResId(view,resourceId,config,null);
        return this;
    }
}
