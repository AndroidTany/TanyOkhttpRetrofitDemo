package com.angcyo.eventbus30demo.OkHttpUtils.response;

/**
 * Created by tsy on 16/8/15.
 */
public interface IResponseHandler {

    void onFailure(int statusCode, String error_msg);

    void onProgress(long currentBytes, long totalBytes);
}
