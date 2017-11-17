package com.ysl.mymvp.ui.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.ysl.mymvp.R;
import com.ysl.mymvp.util.CommonUtil;
import com.ysl.mymvp.util.NoDoubleClickListener;


/**
 * Created by ysl on 2017/7/26.
 */
public class MenuFragment1 extends BaseFragment {

    private TextView tv;
    private EditText editText;

    @Override
    public View setView(LayoutInflater inflater, ViewGroup container) {

        return inflater.inflate(R.layout.menu_fragment_layout, container, false);
    }

    @Override
    public void afterView(View view) {

        tv = (TextView) view.findViewById(R.id.tv_text);
        editText = (EditText) view.findViewById(R.id.et_pop);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (CommonUtil.isNotEmpty(s.toString())) {

                    showPopWindow();
                }

            }
        });
        tv.setText("1");
    }

    @Override
    public void setKindFlag(int kindFlag) {

        if (tv == null) return;
        tv.setText(kindFlag);

    }

    PopupWindow popupWindow;

    private void showPopWindow() {

        if (popupWindow != null)
            popupWindow.dismiss();
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.popupwindow_fragmen1_layout, null);
        popupWindow = new PopupWindow(view, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);

        popupWindow.setWidth(300);
        popupWindow.setHeight(400);

        popupWindow.setSoftInputMode(PopupWindow.INPUT_METHOD_NOT_NEEDED);
        popupWindow.showAsDropDown(editText);

    }
}
