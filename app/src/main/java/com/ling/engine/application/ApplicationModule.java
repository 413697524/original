package com.ling.engine.application;

import android.content.Context;

import com.ling.engine.db.DBManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/1/17.
 *
 */
@Module
public class ApplicationModule {
    private  final Context mContext;
    public ApplicationModule(Context mContext) {
        this.mContext = mContext;
    }

    @Provides
    @Singleton
    Context providesApplicationContext() {
        return this.mContext;
    }

//    @Provides
//    @Singleton
//    SpfManager provideSpfManager(Context context) {return new SpfManager(context);
//    }
//
    @Provides
    @Singleton
    DBManager provideDBManager(Context context) {
        return new DBManager(context);
    }
//
//    @Provides
//    @Singleton
//    FrescoImageLoader provideFresco(Context context){
//        return new FrescoImageLoader(context);
//    }
//
//    @Provides
//    @Singleton
//    MyActivityUtils provideActivityUtils(Context context){
//        return new MyActivityUtils(context);
//    }






}
