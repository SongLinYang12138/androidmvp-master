package com.ysl.mymvp.ui.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ysl.mymvp.R;

/**
 * Created by ysl on 2017/7/26.
 */
public class MenuFragment4   extends BaseFragment {

    TextView tv;

    @Override
    public View setView(LayoutInflater inflater, ViewGroup container) {

        return inflater.inflate(R.layout.menu_fragment_layout, container, false);
    }

    @Override
    public void afterView(View view) {

        tv = (TextView) view.findViewById(R.id.tv_text);
        tv.setText("4");
    }

    @Override
    public void setKindFlag(int kindFlag) {

        if (tv == null) return;
        tv.setText(kindFlag);

    }
}