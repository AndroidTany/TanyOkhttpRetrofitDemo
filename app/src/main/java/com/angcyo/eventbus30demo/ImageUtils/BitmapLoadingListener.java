package com.angcyo.eventbus30demo.ImageUtils;

import android.graphics.Bitmap;

/**
 * Created by SenYe on 2016/9/7.
 */
public interface BitmapLoadingListener {
    void onSuccess(Bitmap bitmap);

    void onError();
}
