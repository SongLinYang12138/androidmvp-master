package com.example.mykotlin.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

/**
 * Created by ysl on 2018/2/27.
 * 介绍:
 */

 abstract class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return setView(inflater, container)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    initData()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        afterView()
    }

    open abstract fun setView(inflater: LayoutInflater?, container: ViewGroup?): View?;

    open abstract fun afterView()

    open abstract fun initData()
}