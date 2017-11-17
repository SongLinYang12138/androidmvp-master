package com.example.mykotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.TextView
import com.example.mykotlin.activity.BaseActivity
import com.example.mykotlin.adapter.MyAdapter
import java.util.*
import kotlin.reflect.KProperty

class KotlinActivity : BaseActivity(), View.OnClickListener {

    //    private val  tvText: TextView? = null
    private var adapter: MyAdapter? = null;
    private val list: MutableList<String> = mutableListOf()

    private val listView: ListView by lazy {
        findViewById(R.id.listview) as ListView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        for (i in 0..10) {
            list.add("" + i)
        }

        adapter = MyAdapter(list, this)
        listView.adapter = adapter


    }


    override fun onClick(view: View?) {


//        tvText?.setOnClickListener(this)

    }


}
