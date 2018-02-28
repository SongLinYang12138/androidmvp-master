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
class MenuPresenter : MenuManager.ClickListener {

    var currentFragment: Fragment? = null
    var messageFragment: Fragment? = null
    var workFragment: Fragment? = null


    var menuView: MenuView? = null
    var menuPresenterImp: MenuPresenterImp? = null

    constructor(menuView: MenuView) {

        this.menuView = menuView
        menuPresenterImp = MenuPresenterImp()
    }


    fun messageClick(fragmentTransaction: FragmentTransaction) {

        menuPresenterImp?.messageClick(fragmentTransaction,this)
    }

    fun workClick(fragmentTransaction: FragmentTransaction) {
        menuPresenterImp?.workClick(fragmentTransaction,this)
    }


    override fun cutPage(position: Int, fragmentTransaction: FragmentTransaction) {


      if(currentFragment != null)  fragmentTransaction.hide(currentFragment)

        when (position) {

            0 -> {

                if (messageFragment == null) {
                    messageFragment = MessageFragment()
                    fragmentTransaction.add(R.id.menu_rl_content, messageFragment)

                } else {
                    fragmentTransaction.show(messageFragment)

                }
                currentFragment = messageFragment

            }

            1 -> {
                if (workFragment == null) {
                    workFragment = WorkFragment()
                    fragmentTransaction.add(R.id.menu_rl_content, workFragment)

                } else {
                    fragmentTransaction.show(workFragment)

                }

                currentFragment = workFragment
            }
        }

        try {
            fragmentTransaction.commitNow()
        }catch (e : Exception){
            e.printStackTrace()
        }

    }


}