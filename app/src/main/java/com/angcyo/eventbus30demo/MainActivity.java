package com.angcyo.eventbus30demo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.angcyo.eventbus30demo.ImageUtils.ImageLoadConfig;
import com.angcyo.eventbus30demo.ImageUtils.ImageLoader;
import com.angcyo.eventbus30demo.ImageUtils.LoaderListener;
import com.bumptech.glide.request.animation.ViewPropertyAnimation;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.img_icon)
    ImageView imgIcon;

    private Unbinder unbinder;
    ViewPropertyAnimation.Animator animationObject1 = new ViewPropertyAnimation.Animator() {
        @Override
        public void animate(View view) {
            ObjectAnimator moveIn = ObjectAnimator.ofFloat(view, "translationX", -1080f, 0f);
            ObjectAnimator rotate = ObjectAnimator.ofFloat(view, "rotation", 0f, 360f);
            ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f, 1f);
            ObjectAnimator moveTop = ObjectAnimator.ofFloat(view, "translationY", 0f, -2000, 0f);
            AnimatorSet animSet = new AnimatorSet();
            animSet.play(rotate).with(fadeInOut).after(moveIn).before(moveTop);
            animSet.setDuration(5000);
            animSet.start();
        }
    };
    ImageLoadConfig config1 = ImageLoadConfig.parseBuilder(ImageLoader.defConfig).setCropType(ImageLoadConfig.FIT_CENTER).
            setSkipMemoryCache(false).
            setDiskCacheStrategy(ImageLoadConfig.DiskCache.ALL).
            setRoundedCorners(false).
            setAsBitmap(true).
                setAnimator(animationObject1).
                    setBlur(true).
                    build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                start(Main2Activity.class);
                EventBus.getDefault().postSticky(new MsgEvent.MyMsg("MDZZ"));
            }
        });
        imgIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start(MoreTab2Activity.class);
            }
        });

        Call<Repo> repos = NetWorks.service.listrepo(1,100);//请求参数
        repos.enqueue(new Callback<Repo>() {

            @Override
            public void onResponse(Call<Repo> call, Response<Repo> response) {
                Repo repo = response.body();
                ImageLoader.loadStringRes(imgIcon,repo.getData().get(0).getOriginalImg(),config1,null);
            }

            @Override
            public void onFailure(Call<Repo> call, Throwable t) {
                Toast.makeText(MainActivity.this,t + "",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MsgEvent.MyMsg event) {
        Log.i("-->", "Main onEvent"+event.jsonData);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
