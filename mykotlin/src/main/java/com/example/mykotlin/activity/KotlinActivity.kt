package com.example.mykotlin.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ListView
import android.widget.Toast
import com.example.mykotlin.R
import com.example.mykotlin.base.BaseActivity
import com.example.mykotlin.adapter.MyAdapter
import com.example.mykotlin.view.MenuView

class KotlinActivity : BaseActivity(), View.OnClickListener {


    //    private val  tvText: TextView? = null
    private var adapter: MyAdapter? = null
    private val list: MutableList<String> = mutableListOf()
    private val menuView: MenuView by lazy {
        findViewById<MenuView>(R.id.menuView)
//        findViewById(MenuView)(R.id.menuView) as MenuView
    }
    private val listView: ListView by lazy {
        findViewById<ListView>(R.id.listview)
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

    override fun onResume() {
        super.onResume()
        initView()
        afterView()
    }

    override fun initView() {

        val title: MutableList<String> = mutableListOf()
        title.add("菜单一")
        title.add("菜单二")
        title.add("菜单三")
        menuView.setTitle(title)
       val  thread: Thread = Thread(Runnable {


       })
        thread.isDaemon = true
        thread.start()
    }

    override fun afterView() {
        listView.setOnItemClickListener { adapterView, view, i, l ->

            Toast.makeText(this, "item" + i, Toast.LENGTH_LONG).show()
            Log.i("aaa", "点击事件  " + i)
        }

    }

    override fun onClick(view: View?) {


//        tvText?.setOnClickListener(this)

    }


}
