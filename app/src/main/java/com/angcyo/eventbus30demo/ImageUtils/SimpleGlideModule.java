package com.angcyo.eventbus30demo.ImageUtils;

import android.content.Context;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheWrapper;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.module.GlideModule;
import java.io.File;
/**
 * Created by SenYe on 2016/9/7.
 */
public class SimpleGlideModule implements GlideModule {

    public static DiskCache cache;
    public static  final String IMG_DIR="ImageCache";
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        // 在 Android 中有两个主要的方法对图片进行解码：ARGB8888 和 RGB565。前者为每个像素使用了 4 个字节，
        // 后者仅为每个像素使用了 2 个字节。ARGB8888 的优势是图像质量更高以及能存储一个 alpha 通道。
        // Picasso 使用 ARGB8888，Glide 默认使用低质量的 RGB565。
        // 对于 Glide 使用者来说：你使用 Glide module 方法去改变解码规则。
        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
        //设置缓存目录
//        File cacheDir = context.getCacheDir();//文件所在目录为getFilesDir();
//        if(!cacheDir.exists()){
//            Log.e("Cache","不存在 缓存目录");
//        }
        //File cacheDir = PathUtils.getDiskCacheDir(context, CacheConfig.IMG_DIR);
        File cacheDir = PathUtils.getCacheDirectory(context,IMG_DIR);
        Log.e("Cache",cacheDir.getAbsolutePath());
        cache = DiskLruCacheWrapper.get(cacheDir, DiskCache.Factory.DEFAULT_DISK_CACHE_SIZE);// 250 MB
        builder.setDiskCache(new DiskCache.Factory() {
            @Override
            public DiskCache build() {
                return cache;
            }
        });
        //设置memory和Bitmap池的大小
        MemorySizeCalculator calculator = new MemorySizeCalculator(context);
        int defaultMemoryCacheSize = calculator.getMemoryCacheSize();
        int defaultBitmapPoolSize = calculator.getBitmapPoolSize();

        int customMemoryCacheSize = (int) (1.2 * defaultMemoryCacheSize);
        int customBitmapPoolSize = (int) (1.2 * defaultBitmapPoolSize);

        builder.setMemoryCache(new LruResourceCache(customMemoryCacheSize));
        builder.setBitmapPool(new LruBitmapPool(customBitmapPoolSize));
    }

    @Override
    public void registerComponents(Context context, Glide glide) {
    /// OkHttpClient client= MyOkHttp.get().getClient();
//        OkHttpClient ddd=new OkHttpClient();
//        glide.get(context).register(GlideUrl.class, InputStream.class,  new OkHttpUrlLoader.Factory(client));
    }
}
