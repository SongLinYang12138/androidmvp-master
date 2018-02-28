package com.example.mykotlin.view

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Parcel
import android.os.Parcelable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.mykotlin.R
import com.example.mykotlin.utils.CommonUtils
import java.util.jar.Attributes

/**
 * Created by ysl on 2017/12/4.
 */
class MenuView : LinearLayout {

    private var currentList = mutableListOf<String>().toMutableList()
    private var title: GridView? = null
    private var isShow: Boolean = false
    private var dropDwonMenu: PopupWindow? = null
    private var clickCounts: Int = 0
    private var isActive: Boolean = false
    private var clickPostion: Int = 4//0左 1中 2右
    private var lastClick: Int = 5

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {

        View.inflate(context, R.layout.menu_layout, this)
        title = this.findViewById(R.id.menut_gridview)
        title?.setOnItemClickListener { adapterView, view, i, l ->

            CommonUtils.showShort(context, "点击 " + i)
            showDropDown(i)
        }
    }

    fun setTitle(titleName: MutableList<String>) {
        title?.numColumns = titleName.size
        val titlAdapter: ArrayAdapter<String> = ArrayAdapter(context, R.layout.listview_item_layout, R.id.item_text, titleName)
        title?.adapter = titlAdapter
    }


    fun showDropDown(position: Int) {

        clickPostion = position

        if (dropDwonMenu == null) {
        val view: View = LayoutInflater.from(this.context).inflate(R.layout.title_content_layout, null, false)
        dropDwonMenu = PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        dropDwonMenu?.setBackgroundDrawable(ColorDrawable())
        dropDwonMenu?.isOutsideTouchable = true
        dropDwonMenu?.isFocusable = true

        dropDwonMenu?.showAsDropDown(this, 0, 5)
        isActive = true
        } else {

            if (lastClick == position && isActive) {
                dropDwonMenu?.dismiss()
                isActive = false
            } else {
                dropDwonMenu?.showAsDropDown(title)
                isActive = true
            }
    }


}


}