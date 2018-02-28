package com.ysl.mymvp.application;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.ysl.mymvp.util.CrashHandler;

import org.xutils.x;

/**
 * Created by ysl on 2017/7/3.
 */
public class BaseApplication extends Application {


    private static Context mycontext;

    @Override
    public void onCreate() {
        super.onCreate();
//        CrashHandler catchHandler = CrashHandler.getInstance();
//        catchHandler.init(getApplicationContext());
        Logger.addLogAdapter(new AndroidLogAdapter());
     mycontext = getApplicationContext();
        x.Ext.init(this);
    }

   static public Context getContext(){



       return  mycontext;
    }
}
