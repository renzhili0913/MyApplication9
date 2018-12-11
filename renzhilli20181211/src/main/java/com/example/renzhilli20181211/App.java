package com.example.renzhilli20181211;

import android.app.Application;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ImageLoader.getInstance().init(
                new ImageLoaderConfiguration.Builder(this)
                        .defaultDisplayImageOptions(
                                new DisplayImageOptions.Builder()
                                        .cacheInMemory(true)
                                        .cacheOnDisk(true)
                                        .build()
                        )
                        .diskCacheSize(50*1024*1024)
                        .memoryCacheSizePercentage(10)
                        .build()
        );
    }
}
