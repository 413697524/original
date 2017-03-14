package com.ling.engine.application;

import android.app.Application;

/**
 * Created by Administrator on 2017/3/14.
 */

public class MyApp extends Application {
    private static AppComponet appComponet;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponet = DaggerAppComponet.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        appComponet.dbManager().setDatabase();

    }


    public static AppComponet getAppComponent(){
        return appComponet;
    }
}
