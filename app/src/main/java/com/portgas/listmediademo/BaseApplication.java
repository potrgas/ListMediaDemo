package com.portgas.listmediademo;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import retrofit.Retrofit;

/**
 * Created by Administrator on 2016/1/7 0007.
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
