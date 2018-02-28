package com.example.testmodel.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by ysl on 2018/2/28.
 * 介绍:
 */

public class ToastUtil {


    public static void showToast(Context context, String msg) {

        if (context == null || msg == null || msg.length() == 0) return;

        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

}
