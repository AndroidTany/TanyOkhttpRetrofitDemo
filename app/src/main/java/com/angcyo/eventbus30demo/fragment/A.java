package com.angcyo.eventbus30demo.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.angcyo.eventbus30demo.R;
import butterknife.ButterKnife;

/**
 * Created by admin on 2016/11/14.
 * Tany(测试Fragment)
 */

public class A extends BaseLazyFragment{

    private Activity activity;
    private View view;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (Activity) context;
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (null == view){
            view = inflater.inflate(R.layout.a_fragment,container,false);
        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if (null != parent){
            parent.removeView(view);
        }
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initData() {

    }
}
