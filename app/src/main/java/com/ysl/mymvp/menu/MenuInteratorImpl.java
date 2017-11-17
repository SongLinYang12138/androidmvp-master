package com.ysl.mymvp.menu;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import com.ysl.mymvp.R;
import com.ysl.mymvp.ui.fragment.MenuFragment1;
import com.ysl.mymvp.ui.fragment.MenuFragment2;
import com.ysl.mymvp.ui.fragment.MenuFragment3;
import com.ysl.mymvp.ui.fragment.MenuFragment4;

/**
 * Created by ysl on 2017/7/26.
 */
public class MenuInteratorImpl implements MenuInterator {

    private MenuFragment1 fragment1;
    private MenuFragment2 fragment2;
    private MenuFragment3 fragment3;
    private MenuFragment4 fragment4;
    private Fragment currentFragment;
    private MenuInterator.MainListener listener;


    public MenuInteratorImpl(MenuInterator.MainListener listener) {

        this.listener = listener;
    }

    @Override
    public void addView(FragmentTransaction transaction) {
        showView(0, transaction);
        listener.havAdd();
    }

    @Override
    public void cutPage(int postion, int viewId, FragmentTransaction transaction) {

        showView(postion, transaction);
        listener.havClick(postion, viewId);
    }

    /**
     * @param direction 0 right 1 left
     */
    @Override
    public void scroView(int position, int direction,FragmentTransaction transaction) {

        if (direction == 0){
            if (position == 3)
                return;
            ++position;
            showView(position,transaction);
        }else {

            if(position == 0)
                return;
            --position;
            showView(position,transaction);
        }


    }


    private void showView(int position, FragmentTransaction transaction) {


        if (currentFragment != null) transaction.hide(currentFragment);
        switch (position) {

            case 0:

                if (fragment1 == null) {
                    fragment1 = new MenuFragment1();
                    transaction.add(R.id.rl_content, fragment1);
                } else {
                    if (fragment1.isHidden()) transaction.show(fragment1);
                    else transaction.hide(fragment1);
                }
                currentFragment = fragment1;
                break;
            case 1:

                if (fragment2 == null) {
                    fragment2 = new MenuFragment2();
                    transaction.add(R.id.rl_content, fragment2);
                } else {

                    if (fragment2.isHidden()) transaction.show(fragment2);
                    else transaction.show(fragment2);
                }
                currentFragment = fragment2;
                break;
            case 2:

                if (fragment3 == null) {

                    fragment3 = new MenuFragment3();
                    transaction.add(R.id.rl_content, fragment3);
                } else {
                    if (fragment3.isHidden()) transaction.show(fragment3);
                    else transaction.hide(fragment3);
                }
                currentFragment = fragment3;
                break;
            case 3:

                if (fragment4 == null) {

                    fragment4 = new MenuFragment4();
                    transaction.add(R.id.rl_content, fragment4);
                } else {

                    if (fragment4.isHidden()) transaction.show(fragment4);
                    else transaction.hide(fragment4);
                }
                currentFragment = fragment4;
                break;

        }
        transaction.commit();
        listener.setCurenPosition(position);
    }

}
