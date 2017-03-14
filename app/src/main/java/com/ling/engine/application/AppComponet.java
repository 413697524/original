package com.ling.engine.application;

import android.content.Context;

import com.ling.engine.db.DBManager;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2017/3/14.
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface AppComponet {

    Context getContext();
    DBManager dbManager();


}
