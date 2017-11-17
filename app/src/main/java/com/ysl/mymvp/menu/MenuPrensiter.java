package com.ysl.mymvp.menu;

import android.support.v4.app.FragmentTransaction;

/**
 * Created by ysl on 2017/7/26.
 */
public class MenuPrensiter implements MenuInterator.MainListener{

    private  MenuInteratorImpl mainInterato;
    private MenuView mainView;
    private int currentPostion = 0;


    public MenuPrensiter(MenuView mainView,FragmentTransaction transaction){

        this.mainView = mainView;
        mainInterato = new MenuInteratorImpl(this);
        mainInterato.addView(transaction);
    }

    public void curPage(int position, int viewId, FragmentTransaction transaction){

        mainInterato.cutPage(position,viewId,transaction);
    }

    /**
     * @param   direction 0 right 1 left
     */
    public void scrolled(int direction,FragmentTransaction transaction){

        mainInterato.scroView(currentPostion,direction,transaction);
    }
    @Override
    public void havAdd() {

        mainView.addView();
    }

    @Override
    public void havClick(int position, int viewId) {

        mainView.clickView(position);
    }

    @Override
    public void setCurenPosition(int position) {
        currentPostion = position;
    }


}
