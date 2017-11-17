package com.ysl.mymvp.menu;


import android.support.v4.app.FragmentTransaction;

/**
 * Created by ysl on 2017/7/26.
 */
public interface MenuInterator {


    interface MainListener{

        void havAdd();
        void havClick(int position, int viewId);
        void setCurenPosition(int position);

    }

    void addView(FragmentTransaction transaction);

    void cutPage(int postion, int viewId, FragmentTransaction transaction);

    /**
     * @param position
     * @param direction direction 0 right 1 left
     */
    void scroView(int position, int direction, FragmentTransaction transaction);
}
