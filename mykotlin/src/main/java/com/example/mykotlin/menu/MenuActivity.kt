package com.example.mykotlin.menu

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.mykotlin.R
import com.example.mykotlin.base.BaseActivity
import com.example.mykotlin.message.MessageFragment
import com.example.mykotlin.work.WorkFragment

/**
 * Created by ysl on 2018/2/27.
 * 介绍:
 */
class MenuActivity : BaseActivity(), View.OnClickListener, MenuView {

    override fun haveCuted(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    val btWork: Button  by lazy {
        findViewById<Button>(R.id.menu_bt_work)
    }
    val btMessage: Button by lazy {
        findViewById<Button>(R.id.menu_bt_message)
    }

    var workFragment: Fragment? = null
    var messageFragment: Fragment? = null
    var currentFragment: Fragment? = null

    var fragmentManager: FragmentManager? = null
    var menuPresenter: MenuPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_menu_layout)

        fragmentManager = supportFragmentManager

        menuPresenter = MenuPresenter(this)
        menuPresenter?.messageClick(fragmentManager?.beginTransaction()!!)

        //设置click事件使用Lambda表达式
        btMessage.setOnClickListener { view ->

            menuPresenter?.messageClick(fragmentManager?.beginTransaction()!!) }
        btWork.setOnClickListener { view ->
            menuPresenter?.workClick(fragmentManager?.beginTransaction() !!)}
        Log.i("aaa","msg")
    }


    override fun initView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

//        showeMessage(0)
    }

//    fun showeMessage(position: Int) {
//
//        val fragmentTransaction: FragmentTransaction = fragmentManager?.beginTransaction()!!
//        if (currentFragment != null)
//            fragmentTransaction.hide(currentFragment)
//        when (position) {
//            0 -> if (messageFragment == null) {
//                messageFragment = MessageFragment()
//                fragmentTransaction.add(R.id.menu_rl_content, messageFragment)
//            } else {
//                fragmentTransaction.show(messageFragment)
//            }
//
//            1 -> if (workFragment == null) {
//
//                workFragment = WorkFragment()
//                fragmentTransaction.add(R.id.menu_rl_content, workFragment)
//            } else {
//                fragmentTransaction.show(workFragment)
//            }
//
//        }
//        fragmentTransaction.commitNow()
//    }


    override fun afterView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.


    }

    override fun onClick(p0: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}