package com.example.mykotlin.menu

import android.support.v4.app.FragmentTransaction

/**
 * Created by ysl on 2018/2/27.
 * 介绍:
 */
interface MenuManager {

    interface ClickListener {
        open fun cutPage(position: Int, fragmentTransaction: FragmentTransaction): Unit

    }

    open fun messageClick(fragmentTransaction: FragmentTransaction,listener : ClickListener): Unit
    open fun workClick(fragmentTransaction: FragmentTransaction,listener : ClickListener): Unit
}