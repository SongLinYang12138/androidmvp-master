package com.ysl.mymvp.application;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.ysl.mymvp.util.CrashHandler;

/**
 * Created by ysl on 2017/7/3.
 */
public class BaseApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
//        CrashHandler catchHandler = CrashHandler.getInstance();
//        catchHandler.init(getApplicationContext());
        Logger.addLogAdapter(new AndroidLogAdapter());
    }
}
