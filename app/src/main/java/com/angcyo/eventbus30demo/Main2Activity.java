package com.angcyo.eventbus30demo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Main2Activity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    private Unbinder unbinder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        unbinder = ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                start(Main3Activity.class);
                EventBus.getDefault().postSticky(new MsgEvent.MyMsg("你是傻逼"));
            }
        });
    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onEvent(MsgEvent.MessageInts event){
//        Log.i("-->", "Main2 onEvent" + event.num);
//    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MsgEvent.MyMsg event){
        Log.i("-->", "Main2 onEventstring" + event.jsonData);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
