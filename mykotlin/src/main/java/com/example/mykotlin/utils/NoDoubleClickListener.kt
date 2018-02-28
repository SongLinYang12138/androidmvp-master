package com.example.mykotlin.utils

import android.view.View

/**
 * Created by ysl on 2018/2/27.
 * 介绍: 防止暴力点击的click
 */
 abstract class NoDoubleClickListener : View.OnClickListener{

    var lastClick : Long = 0

    override fun onClick(p0: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        val currentClick = System.currentTimeMillis()

        if(currentClick - lastClick > 500){
            noDoubleClick(p0)
        }


    }
    abstract fun noDoubleClick(v: View?)


}