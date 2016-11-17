package com.angcyo.eventbus30demo.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.angcyo.eventbus30demo.NetWorks;
import com.angcyo.eventbus30demo.R;
import com.angcyo.eventbus30demo.StoreBean;
import com.angcyo.eventbus30demo.adapter.AfragmentAdapter;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.recyclerview.animators.adapters.ScaleInAnimationAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2016/11/14.
 * Tany(测试Fragment)
 */

public class A extends BaseLazyFragment {

    @BindView(R.id.recycler_view)
    XRecyclerView recyclerView;

    private Activity activity;
    private View view;
    private AfragmentAdapter adapter;
    private int times = 1;
    private List<StoreBean.DataBean> databean = new ArrayList<>();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (Activity) context;
    }

    @Override
    protected void initData() {
        indexRecommend();
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (null == view) {
                                  view = inflater.inflate(R.layout.a_fragment, container, false);
        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if (null != parent) {
            parent.removeView(view);
        }
        ButterKnife.bind(this, view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setRefreshProgressStyle(ProgressStyle.BallTrianglePath);
        recyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        recyclerView.setArrowImageView(R.mipmap.iconfont_downgrey);
        recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        adapter.notifyDataSetChanged();
                        recyclerView.refreshComplete();
                    }
                }, 1000);
            }

            @Override
            public void onLoadMore() {
                times++;
                indexRecommend();
            }
        });
        return view;
    }

    public void indexRecommend() {
        Call<StoreBean> repos = NetWorks.service.indexRecommend(times, 10);//请求参数
        repos.enqueue(new Callback<StoreBean>() {
            @Override
            public void onResponse(Call<StoreBean> call, Response<StoreBean> response) {
                StoreBean repo = response.body();
                databean = repo.getData();
                if (times == 1){
                    adapter = new AfragmentAdapter(activity);
                    adapter.setList(databean);
                    recyclerView.setAdapter(new ScaleInAnimationAdapter(adapter));
                } else {
                    adapter.setList(databean);
                    recyclerView.loadMoreComplete();
                    if (databean.isEmpty()){
                        recyclerView.setIsnomore(true);
                    }
                }
            }

            @Override
            public void onFailure(Call<StoreBean> call, Throwable t) {
                Toast.makeText(activity, t + "", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
