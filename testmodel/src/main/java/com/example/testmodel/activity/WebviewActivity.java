package com.example.testmodel.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.example.testmodel.R;
import com.example.testmodel.util.JSCallBack;
import com.example.testmodel.util.JavascriptBridge;
import com.example.testmodel.util.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ysl on 2018/2/28.
 * 介绍:
 */

public class WebviewActivity extends Activity implements JSCallBack {

    private static final String TAG = "aaa";
    @BindView(R.id.webview_webview)
    WebView webView;
    @BindView(R.id.webview_bt_left)
    Button btLeft;
    @BindView(R.id.webview_bt_right)
    Button btRight;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_webview_layout);
        ButterKnife.bind(this);

        initView();
        afterView();
    }


    private void initView() {

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);//设置js交互
        webSettings.setUseWideViewPort(true);//设置图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true);//缩放至屏幕的大小

        //缩放操作
        webSettings.setSupportZoom(true);//支持缩放
        webSettings.setBuiltInZoomControls(true);///设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.setDisplayZoomControls(false);//隐藏内置的原生缩放控件

        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE); //缓存模式如下：
        //LOAD_CACHE_ONLY: 不使用网络，只读取本地缓存数据
        //LOAD_DEFAULT: （默认）根据cache-control决定是否从网络上取数据。
        //LOAD_NO_CACHE: 不使用缓存，只从网络获取数据.
        //LOAD_CACHE_ELSE_NETWORK，只要本地有，无论是否过期，或者no-cache，都使用缓存中的数据。

        // 设置允许JS弹窗
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

    }


    private void afterView() {
// Android版本变量
        final int version = Build.VERSION.SDK_INT;
        MyWebChromeClient chromeClient = new MyWebChromeClient();
        MyWebviewClient client = new MyWebviewClient();


        webView.addJavascriptInterface(new JavascriptBridge(this), "test");
        webView.loadUrl("file:///android_asset/index.html");
        webView.setWebChromeClient(chromeClient);
        webView.setWebViewClient(client);

        btLeft.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {

                if (version < 18) {
                    webView.loadUrl("javascript:callJS()");
                } else {

                    webView.evaluateJavascript("javascript:callJS()", new ValueCallback<String>() {
                        @Override
                        public void onReceiveValue(String s) {

                            Log.i("aaa", "return  " + s);
                        }
                    });

                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        webView.clearCache(true);
        webView.clearHistory();
        webView.clearFormData();

    }

    @Override
    public void jsCallBack(String method, String msg) {

        switch (method) {

            case "callAndroid":

                ToastUtil.showToast(this, msg);
                break;


        }


    }


    private static class MyWebviewClient extends WebViewClient {


        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);

            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            super.onReceivedSslError(view, handler, error);
        }

    }

    private static class MyWebChromeClient extends WebChromeClient {

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);

            Log.i(TAG, "progress  " + newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);

            Log.i(TAG, "title  " + title);
        }
    }
}
