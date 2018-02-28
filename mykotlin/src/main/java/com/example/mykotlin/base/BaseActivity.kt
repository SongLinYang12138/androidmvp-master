package com.example.mykotlin.base

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v4.view.ViewCompat
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.LinearLayout
import com.example.mykotlin.R

/**
 * Created by ysl on 2017/11/17.
 */
open abstract class BaseActivity : FragmentActivity() {
    //拉加载
    val title_layout: LinearLayout by lazy {
        findViewById<LinearLayout>(R.id.content)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.title_layout)

        val activity: Activity = this

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            //状态栏透明颜色
            activity.getWindow().setStatusBarColor(getResources().getColor(R.color.light_blue))
        }
//为了设置全屏
        val mContentView: ViewGroup = activity.findViewById(android.R.id.content)
        val mChildView: View = mContentView.getChildAt(0)

        if (mChildView != null) {
            //注意不是设置 ContentView 的 FitsSystemWindows, 而是设置 ContentView 的第一个子 View . 使其不为系统 View 预留空间.
            ViewCompat.setFitsSystemWindows(mChildView, true)
        }

    }

    open override fun setContentView(layoutResID: Int) {

        val contentView: View = LayoutInflater.from(this).inflate(layoutResID, null)
        contentView.layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        title_layout.addView(contentView)
    }


    open abstract fun initView()
    open abstract fun afterView()

}