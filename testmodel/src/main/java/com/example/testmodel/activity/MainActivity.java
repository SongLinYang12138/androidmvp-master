package com.example.testmodel.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.testmodel.R;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    ExecutorService fixPool;
    Button btnAdd;
    LinearLayout llContent;

    int current = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {

                    Log.i("aaa", "运行  " + isNetworkAvailable());
                    try {
                        if (!isNetworkAvailable()) notification();//记录开启时间11.03
                        Thread.sleep(60000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        thread.start();

        fixPool = Executors.newFixedThreadPool(4);

        btnAdd = (Button) findViewById(R.id.btn_add);
        llContent = (LinearLayout) findViewById(R.id.ll_content);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final TextView textView = new TextView(MainActivity.this);

                ++current;
                textView.setText("" + current);
                llContent.addView(textView);

                doNetWork(textView, current);
            }
        });

    }

    private void notification() {


        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Date date = new Date(System.currentTimeMillis());
        String hours = date.getHours() + "";
        String miniute = date.getMinutes() + "";
        NotificationCompat.Builder buider = new NotificationCompat.Builder(MainActivity.this).setDefaults(Notification.DEFAULT_ALL | Notification.DEFAULT_VIBRATE)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText(hours + " : " + miniute+"  "+isNetworkAvailable());
        manager.notify(1, buider.build());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        notification();
    }

    private boolean isNetworkAvailable() {

        ConnectivityManager manager = (ConnectivityManager) this.getApplicationContext().getSystemService(
                this.CONNECTIVITY_SERVICE);

        if (manager == null) {
            return false;
        }

        NetworkInfo networkinfo = manager.getActiveNetworkInfo();

        if (networkinfo == null || !networkinfo.isAvailable()) {
            return false;
        }

        return true;
    }

    private void doNetWork(final TextView textView, final int currens) {

        fixPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(currens + "完成");
                    }
                });

            }
        });

    }

}
