package com.ysl.mymvp.util;

import android.content.Context;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by ysl on 2017/7/13.
 */
public class CommonUtil {


    public static void showShort(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(Context context, String msg) {

        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    public static boolean isNotEmpty(String msg) {

        if (msg == null)
            return false;
        else {
            if (msg.trim().isEmpty())
                return false;
            else
                return true;
        }
    }

    public static boolean isEmpty(String msg) {

        if (msg == null)
            return true;
        else {

            if (msg.trim().isEmpty())
                return true;
            else
                return false;
        }
    }

    public static String y_m_d(Date date){

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE);

        return dateFormat.format(date);
    }


}
