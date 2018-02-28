package com.ysl.mymvp.ui.activity;

import android.app.Activity;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ysl.mymvp.R;
import com.ysl.mymvp.ui.view.BaseDragZoomImageView;
import com.ysl.mymvp.ui.view.MoveImageView;
import com.ysl.mymvp.ui.view.RabbitView;

/**
 * Created by ysl on 2018/1/31.
 */

public class MovieActivity extends Activity implements OnTouchListener {

    private ImageView ivMove;
    private RelativeLayout rlRoot;
    //    private TextView tvTips;
//    private int topTitleHeight;
    MoveImageView ivIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_layout);
        ivIcon = (MoveImageView) findViewById(R.id.iv_move);
        rlRoot = (RelativeLayout) findViewById(R.id.rl_root);

        rlRoot.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()) {

            case MotionEvent.ACTION_MOVE:

                Log.i("aaa", "moview");
                break;
            case MotionEvent.ACTION_UP:

                Log.i("aaa", "up ");

                break;
            case MotionEvent.ACTION_DOWN:

                Log.i("aaa", "down");

                break;


        }


        return true;
    }


}
