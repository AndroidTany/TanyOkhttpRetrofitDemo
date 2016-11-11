package com.angcyo.eventbus30demo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by admin on 2016/11/11.
 */

public class NetWorks extends RetrofitUtils{

    //创建实现接口调用
    protected static final NetService service = getRetrofit().create(NetService.class);
    //设缓存有效期为1天
    protected static final long CACHE_STALE_SEC = 60 * 60 * 24 * 1;
    //查询缓存的Cache-Control设置，使用缓存
    protected static final String CACHE_CONTROL_CACHE = "only-if-cached, max-stale=" + CACHE_STALE_SEC;
    //查询网络的Cache-Control设置。不使用缓存
    protected static final String CACHE_CONTROL_NETWORK = "max-age=0";


    public static interface NetService {

        //GET请求，设置缓存
        @Headers("Cache-Control: public," + CACHE_CONTROL_CACHE)
        @GET("users/{user}/repos")
        Observable<Repo> listrepos(@Path("user") String user);

        @GET("Sale/groupBy/pageNo/{pageno}/pageSize/{pagesize}")
        Call<Repo> listrepo(@Path("pageno") int pageNo, @Path("pagesize") int pageSize);
    }
}
