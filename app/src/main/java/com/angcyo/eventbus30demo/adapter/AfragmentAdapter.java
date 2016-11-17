package com.angcyo.eventbus30demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.angcyo.eventbus30demo.ImageUtils.ImageLoadConfig;
import com.angcyo.eventbus30demo.ImageUtils.ImageLoader;
import com.angcyo.eventbus30demo.R;
import com.angcyo.eventbus30demo.StoreBean;

import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2016/11/16.
 * Tany(普通Adapter)
 */

public class AfragmentAdapter extends RecyclerView.Adapter<AfragmentAdapter.ViewHolder>{

    public List<StoreBean.DataBean> mlist;
    public Context mcontext;
    ImageLoadConfig config = ImageLoadConfig.parseBuilder(ImageLoader.defConfig).setCropType(ImageLoadConfig.FIT_CENTER).
            setSkipMemoryCache(false).
            setDiskCacheStrategy(ImageLoadConfig.DiskCache.ALL).
            setRoundedCorners(false).
            setAsBitmap(true).
            setAnimator(null).
            setBlur(true).
            build();

    public AfragmentAdapter(Context context){
        this.mcontext = context;
        this.mlist = new ArrayList<>();
    }

    public AfragmentAdapter(Context context,List<StoreBean.DataBean> list){
        this.mcontext = context;
        this.mlist = list;
    }

    public void setList(List<StoreBean.DataBean> list){
       this.mlist.addAll(list);
        notifyDataSetChanged();

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.text.setText(mlist.get(position).getGoodsName());
        ImageLoader.loadStringRes(holder.image,mlist.get(position).getOriginalImg(),config,null);
    }

    @Override
    public int getItemCount() {
        return mlist.isEmpty() ? 0 : mlist.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.text)
        TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
