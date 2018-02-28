package com.example.mykotlin.adapter

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.mykotlin.R

/**
 * Created by ysl on 2018/2/27.
 * 介绍:
 */
class MessageAdapter() : RecyclerView.Adapter<MessageAdapter.ViewHolder>() {

    private var list = mutableListOf<String>()



    constructor(list: MutableList<String>) : this() {


        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {

        val v: View = LayoutInflater.from(parent?.context).inflate(R.layout.listveiw_item_message_layout, parent, false)

        val holder: ViewHolder = ViewHolder(v)
        return holder
    }

    override fun getItemCount(): Int {

        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {

        holder?.tv?.setText(list[position])
    }



    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        var tv: TextView? = null

        init {

            tv = itemView?.findViewById<TextView>(R.id.message_item_tv)

        }


    }




}