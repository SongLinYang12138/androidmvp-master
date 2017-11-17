package com.ysl.mymvp.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.ysl.mymvp.R;
import com.ysl.mymvp.recycle.MyRecyleView;
import com.ysl.mymvp.recycle.RecyclePresenter;


/**
 * Created by ysl on 2017/11/7.
 */

public class RecycleActivity extends BaseActivity implements MyRecyleView {

    private RecyclePresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recycle_layout);


    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }


    @Override
    public void NetWorkSucceed(String params) {

    }

    @Override
    public void NetWorkFailed(String msg) {

    }
}
