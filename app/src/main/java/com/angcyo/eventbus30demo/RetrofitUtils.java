package com.angcyo.eventbus30demo;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 2016/11/11.
 * Tany(retrofit网络请求封装)
 */

public abstract class RetrofitUtils {

    /**
     * 服务器地址
     */
    private static final String SERVICE_HOST_ADDRESS = "http://www.wsqonline.com/index.php/API";
    private static Retrofit mRetrofit;
    private static OkHttpClient mOkHttpClient;

    /**
     * 获取Retrofit对象
     *
     * @return
     */
    protected static Retrofit getRetrofit() {

        if (null == mRetrofit) {

            if (null == mOkHttpClient) {
                mOkHttpClient = OkHttp3Utils.getOkHttpClient();
            }
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(SERVICE_HOST_ADDRESS + "/")//设置服务器路径
                    .addConverterFactory(GsonConverterFactory.create())//添加转化库，默认是Gson
                    .client(mOkHttpClient)//设置使用okhttp网络请求
                    .build();
        }
        return mRetrofit;
    }
}
