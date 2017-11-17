package com.ysl.mymvp.recycle;

/**
 * Created by ysl on 2017/11/8.
 */

public class RecycleImpl implements RecycleInterator {
    @Override
    public void doNetWork(String url, String params, RecycleListener listener) {

        String msg = "";

        if (msg != null) {
            listener.success(msg);
        } else {
            listener.failed(msg);
        }

    }
}
