package com.example.mykotlin.work

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mykotlin.R
import com.example.mykotlin.base.BaseFragment

/**
 * Created by ysl on 2018/2/27.
 * 介绍: workFragment
 */
class WorkFragment : BaseFragment() {

    override fun setView(inflater: LayoutInflater?, container: ViewGroup?): View? {
        val view: View? = inflater?.inflate(R.layout.fragment_work_layout, container, false)

        return view
    }

    override fun afterView() {
    }

    override fun initData() {
    }

}