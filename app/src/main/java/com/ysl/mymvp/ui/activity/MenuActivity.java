package com.ysl.mymvp.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.ysl.mymvp.R;
import com.ysl.mymvp.menu.MenuPrensiter;
import com.ysl.mymvp.menu.MenuView;
import com.ysl.mymvp.util.NoDoubleClickListener;


/**
 * Created by ysl on 2017/7/26.
 */

@ContentView(value = R.layout.menu_activity_layout)
public class MenuActivity extends BaseActivity implements MenuView {


    @ViewInject(R.id.bt1)
    private Button bt1;
    @ViewInject(R.id.bt2)
    private Button bt2;
    @ViewInject(R.id.bt3)
    private Button bt3;
    @ViewInject(R.id.bt4)
    private Button bt4;

    private MenuPrensiter prensiter;
    private FragmentManager manager;

    private MyclickListener click = new MyclickListener();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public void initView() {

        ViewUtils.inject(this);
        bt1.setOnClickListener(click);
        bt2.setOnClickListener(click);
        bt3.setOnClickListener(click);
        bt4.setOnClickListener(click);
    }

    @Override
    public void initData() {

        manager = getSupportFragmentManager();
        prensiter = new MenuPrensiter(this, manager.beginTransaction());

    }
    float x1 ,x2 ;
    @Override
    public boolean onTouchEvent(MotionEvent event) {


        if (MotionEvent.ACTION_DOWN == event.getAction()){
            x1 = event.getX();
        }
        if (MotionEvent.ACTION_UP == event.getAction()){
            x2 = event.getX();
            float value = x2 - x1;
            if (Math.abs(value) > 100){

//                direction 0 right 1 left
                if (value > 0) prensiter.scrolled(1,manager.beginTransaction());//朝右滑动,菜单向左移
                if (value < 0) prensiter.scrolled(0,manager.beginTransaction());//朝左滑动，菜单向右移

            }


        }
        return super.onTouchEvent(event);
    }

    @Override
    public void addView() {

        Toast.makeText(MenuActivity.this, "add", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clickView(int position) {
        Toast.makeText(MenuActivity.this, "" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void scrolled(int position) {

    }


    private class MyclickListener extends NoDoubleClickListener {
        @Override
        public void click(View v) {

            switch (v.getId()) {

                case R.id.bt1:

                    prensiter.curPage(0, R.id.bt1, manager.beginTransaction());
                    break;
                case R.id.bt2:

                    prensiter.curPage(1, R.id.bt2, manager.beginTransaction());
                    break;
                case R.id.bt3:

                    prensiter.curPage(2, R.id.bt3, manager.beginTransaction());
                    break;
                case R.id.bt4:

                    prensiter.curPage(3, R.id.bt3, manager.beginTransaction());
                    break;
            }
        }
    }
}
