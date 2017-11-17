package com.example.mykotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.mykotlin.R

/**
 * Created by ysl on 2017/11/17.
 */
class MyAdapter(val list: List<String>, val context: Context) : BaseAdapter() {


    override fun getItem(position: Int): Any {
        return list.get(position)
    }

    override fun getItemId(id: Int): Long {

        return id.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }

    private class ViewHolder {
        var text: TextView? = null
    }

    private var holder: ViewHolder? = null
    override fun getView(position: Int, view: View?, parent: ViewGroup?): View? {

        var v: View? = null
        if (view == null) {
           holder = ViewHolder()
            v = LayoutInflater.from(context).inflate(R.layout.listview_item_layout,parent,false)
            holder?.text = v.findViewById(R.id.item_text)

            v.setTag(holder)
        }else{
            v = view
            holder = view.tag as ViewHolder?
        }

        return  v
    }


}