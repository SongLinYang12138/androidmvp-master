package com.example.mykotlin.menu

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import com.example.mykotlin.R
import com.example.mykotlin.message.MessageFragment
import com.example.mykotlin.work.WorkFragment


/**
 * Created by ysl on 2018/2/27.
 * 介绍:
 */
class MenuPresenterImp : MenuManager {
    override fun messageClick(fragmentTransaction: FragmentTransaction, listener: MenuManager.ClickListener) {

        listener.cutPage(0,fragmentTransaction)
    }

    override fun workClick(fragmentTransaction: FragmentTransaction, listener: MenuManager.ClickListener) {
    listener.cutPage(1,fragmentTransaction)
    }

//    var currentFragment: Fragment? = null
//    var messageFragment: Fragment? = null
//    var workFragment: Fragment? = null
//
//
//    fragmentTransaction.hide(currentFragment)
//
//    when (position) {
//
//        0 -> {
//
//            if (messageFragment == null) {
//                messageFragment = MessageFragment()
//                fragmentTransaction.add(R.id.menu_rl_content, messageFragment)
//
//            } else {
//                fragmentTransaction.show(messageFragment)
//
//            }
//            currentFragment = messageFragment
//
//        }
//
//        1 -> {
//            if (workFragment == null) {
//                workFragment = WorkFragment()
//                fragmentTransaction.add(R.id.menu_rl_content, workFragment)
//
//            } else {
//                fragmentTransaction.show(workFragment)
//
//            }
//
//            currentFragment = workFragment
//        }
//
//
//
//    }

}