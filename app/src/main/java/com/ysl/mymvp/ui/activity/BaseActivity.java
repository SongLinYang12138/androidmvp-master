package com.ysl.mymvp.ui.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.ysl.mymvp.R;

/**
 * Created by ysl on 2017/7/26.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private LinearLayout title_layout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        super.setContentView(R.layout.title_layout);

        title_layout = (LinearLayout) findViewById(R.id.ll_title);
        Activity activity = this;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //状态栏透明颜色
            activity.getWindow().setStatusBarColor(getResources().getColor(R.color.light_blue));
        }
//为了设置全屏
        ViewGroup mContentView = (ViewGroup) activity.findViewById(android.R.id.content);
        View mChildView = mContentView.getChildAt(0);
        if (mChildView != null) {
            //注意不是设置 ContentView 的 FitsSystemWindows, 而是设置 ContentView 的第一个子 View . 使其不为系统 View 预留空间.
            ViewCompat.setFitsSystemWindows(mChildView, true);
        }
        initData();
        initView();


    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {



        LayoutInflater inflater = (LayoutInflater) this.getSystemService(this.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(layoutResID,null);
        contentView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        title_layout.addView(contentView);
//                super.setContentView(title_layout);
    }

    public abstract void initView();

    public abstract void initData();

}
