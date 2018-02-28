package com.example.mykotlin.message

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mykotlin.R
import com.example.mykotlin.adapter.MessageAdapter
import com.example.mykotlin.base.BaseFragment

/**
 * Created by ysl on 2018/2/27.
 * 介绍:
 */
class MessageFragment : BaseFragment() {

    var listView: RecyclerView? = null

    override fun setView(inflater: LayoutInflater?, container: ViewGroup?): View {

        val view: View = inflater?.inflate(R.layout.fragment_message_layout, container, false)!!

        listView = view.findViewById(R.id.fragment_message_listvew)
        return view
    }

    override fun afterView() {

        val manager: RecyclerView.LayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        listView?.layoutManager = manager

        val list = mutableListOf<String>()

        for (i in 0 until 6) {
            list.add(i.toString())
        }
        val adapter = MessageAdapter(list)

        listView?.adapter = adapter
    }

    override fun initData() {
    }

}