package com.ysl.mymvp.recycle;


/**
 * Created by ysl on 2017/11/7.
 */

public class RecyclePresenter implements RecycleInterator.RecycleListener {

    private MyRecyleView recyleView;
    private RecycleImpl recycleImpl;

    public RecyclePresenter(MyRecyleView recyleView) {

        this.recyleView = recyleView;
        recycleImpl = new RecycleImpl();
    }

    @Override
    public void success(String params) {

        recyleView.NetWorkSucceed(params);
    }

    @Override
    public void failed(String msg) {
       recyleView.NetWorkFailed(msg);
    }
}
