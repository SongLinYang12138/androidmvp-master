package com.example.testmodel.util;

import android.util.Log;
import android.webkit.JavascriptInterface;

/**
 * Created by ysl on 2018/2/28.
 * 介绍:
 */

public class JavascriptBridge extends Object {

    private JSCallBack jsCallBack;

    public JavascriptBridge(JSCallBack jsCallBack) {

        this.jsCallBack = jsCallBack;
    }

    @JavascriptInterface
    public void callAndroid(String s) {

        jsCallBack.jsCallBack("callAndroid", s);
        Log.i("aaa", "callAndroid " + s);
    }


}
