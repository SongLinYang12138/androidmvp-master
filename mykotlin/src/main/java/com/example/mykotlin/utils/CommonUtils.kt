package com.example.mykotlin.utils

import android.content.Context
import android.widget.Toast

/**
 * Created by ysl on 2017/12/6.
 */
object CommonUtils {


    fun showShort(context: Context, msg: String) {

        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()

    }

}