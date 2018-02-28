package com.ysl.mymvp.ui.activity;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.widget.ViewUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.orhanobut.logger.Logger;
import com.ysl.mymvp.R;
import com.ysl.mymvp.application.BaseApplication;
import com.ysl.mymvp.menu.MenuPrensiter;
import com.ysl.mymvp.menu.MenuView;
import com.ysl.mymvp.util.NoDoubleClickListener;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;



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
    @ViewInject(R.id.zoomImage)
  private   ImageView ivIcon;

    private MenuPrensiter prensiter;
    private FragmentManager manager;


    private MyclickListener click = new MyclickListener();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        sendToXiaoMi2(getApplicationContext(), 5);
//        TestClass.sortMylist();


    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * 向小米手机发送未读消息数广播miui6以后
     *
     * @param count
     */
    private static void sendToXiaoMi2(Context context, int count) {
        NotificationManager mNotificationManager = (NotificationManager) BaseApplication.getContext().getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(BaseApplication.getContext()).setContentTitle("title").setContentText("text").setSmallIcon(R.mipmap.ic_launcher);
        Notification notification = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            notification = builder.build();
        }
        try {
            Field field = notification.getClass().getDeclaredField("extraNotification");
            Object extraNotification = field.get(notification);
            Method method = extraNotification.getClass().getDeclaredMethod("setMessageCount", int.class);
            method.invoke(extraNotification, count);
            mNotificationManager.notify(10, notification);
        } catch (Exception e) {
            e.printStackTrace();
            Logger.w("aaa", e.toString());
//            // miui 6之前的版本
//            Intent localIntent = new Intent(
//                    "android.intent.action.APPLICATION_MESSAGE_UPDATE");
//            localIntent.putExtra(
//                    "android.intent.extra.update_application_component_name",
//                    context.getPackageName() + "/" + getLauncherClassName(context));
//            localIntent.putExtra(
//                    "android.intent.extra.update_application_message_text", String.valueOf(count == 0 ? "" : count));
//            context.sendBroadcast(localIntent);
        }
    }


    @Override
    public void initView() {

        x.view().inject(this);
        bt1.setOnClickListener(click);
        bt2.setOnClickListener(click);
        bt3.setOnClickListener(click);
        bt4.setOnClickListener(click);
    }

    private void initPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else {
            newFilew();
        }
    }

    private void newFilew() {
        Logger.i("开始");
        String filesPath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
        File file = new File(filesPath);
        if (!file.exists()) {
            file.mkdirs();
        }

        try {
            File file1 = new File(filesPath + "新建文件.doc");
            Logger.i("path  " + file1.getAbsolutePath());
            if (file1.exists()) {
                file1.delete();
            }
            Logger.i("新建文件   " + file1.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 进入文件管理器
     */

    private void openFile() {

//        Uri myUri = FileProvider.getUriForFile(this,"com.ysl.mymvp.fileprovider",)
//        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//        intent.setType("application/msword");//设置类型，我这里是任意类型，任意后缀的可以这样写。
//        intent.addCategory(Intent.CATEGORY_OPENABLE);
//        startActivityForResult(intent,1);

        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri;
        File file = new File("");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //data是file类型,忘了复制过来
            uri = FileProvider.getUriForFile(this, "com.ysl.mymvp.fileprovider", file);

        } else {
            uri = Uri.fromFile(file);
        }
        //pdf文件要被读取所以加入读取权限
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        Logger.i("path  " + uri.getPath());
        intent.setDataAndType(uri, "application/msword");
        try {
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initData() {

        manager = getSupportFragmentManager();
        prensiter = new MenuPrensiter(this, manager.beginTransaction());

    }

    float x1, x2;

    @Override
    public boolean onTouchEvent(MotionEvent event) {

//        ivIcon.autoMouse(event);
        if (MotionEvent.ACTION_DOWN == event.getAction()) {
            x1 = event.getX();
        }
        if (MotionEvent.ACTION_UP == event.getAction()) {
            x2 = event.getX();
            float value = x2 - x1;
            if (Math.abs(value) > 100) {

//                direction 0 right 1 left
                if (value > 0) prensiter.scrolled(1, manager.beginTransaction());//朝右滑动,菜单向左移
                if (value < 0) prensiter.scrolled(0, manager.beginTransaction());//朝左滑动，菜单向右移

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

    /**
     * requestCode:相当于一个标志，
     * permissions：需要传进的permission，不能为空
     * grantResults：用户进行操作之后，或同意或拒绝回调的传进的两个参数;
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // 这里实现用户操作，或同意或拒绝的逻辑
        /**
         * grantResults会传进
         * android.content.pm.PackageManager.PERMISSION_GRANTED 或 android.content.pm.PackageManager.PERMISSION_DENIED
         * 前者代表用户同意程序获取系统权限，后者代表用户拒绝程序获取系统权限
         */
        newFilew();
        switch (requestCode) {
            case 1:
                // 处理后,的操作
                break;
        }
    }


    private class MyclickListener extends NoDoubleClickListener {
        @Override
        public void click(View v) {

            switch (v.getId()) {

                case R.id.bt1:
                    initPermission();
                    prensiter.curPage(0, R.id.bt1, manager.beginTransaction());
                    sendToXiaoMi2(getApplicationContext(), 1);
                    break;
                case R.id.bt2:

                    prensiter.curPage(1, R.id.bt2, manager.beginTransaction());
                    sendToXiaoMi2(getApplicationContext(), 2);

                    break;
                case R.id.bt3:

                    prensiter.curPage(2, R.id.bt3, manager.beginTransaction());
                    sendToXiaoMi2(getApplicationContext(), 3);

                    break;
                case R.id.bt4:

                    prensiter.curPage(3, R.id.bt3, manager.beginTransaction());
                    sendToXiaoMi2(getApplicationContext(), 4);

                    break;
            }
        }
    }
}
