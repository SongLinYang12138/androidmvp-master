package com.ysl.mymvp.recycle;

/**
 * Created by ysl on 2017/11/8.
 */

public interface RecycleInterator {

    interface RecycleListener{

        void success(String params);
        void failed(String msg);
    }

    void doNetWork(String url,String params,RecycleListener listener);
}
