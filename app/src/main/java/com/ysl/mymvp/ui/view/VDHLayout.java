package com.ysl.mymvp.ui.view;

/**
 * Created by ysl on 2018/1/31.
 */
import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class VDHLayout extends LinearLayout {
    private ViewDragHelper mDragger;

    public VDHLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        mDragger = ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback() {

            @Override
            public void onViewReleased(View releasedChild, float xvel, float yvel) {
                Log.e("lx", "xvel:" + xvel + ",yvel:" + yvel);
                Log.e("lx", "top:" + top + ",left:" + left);
                //移动的距离
                int dy = releasedChild.getTop() - top;
                int dx = releasedChild.getLeft() - left;
                Log.e("lx", "releasedChild.getTop():" + releasedChild.getTop() + ",releasedChild.getLeft():" + releasedChild.getLeft());
                Log.e("lx", "dy:" + dy + ",dx:" + dx);
                if (Math.abs(dy) + Math.abs(dx) > 100) {

                    int finalX = 0;
                    int finalY = 0;

                    if (dx > 0) {
                        //向右
                        if (dy > 0) {
                            //向下
                            finalX = getWidth()-releasedChild.getWidth();
                            finalY = getHeight()-releasedChild.getHeight();
                        } else {
                            //向上
                            finalX =  getWidth()-releasedChild.getWidth();
                            finalY = 0;

                        }
                    } else {
                        //向左

                        if (dy > 0) {
                            //向下
                            finalX = 0;
                            finalY = getHeight()-releasedChild.getHeight();

                        } else {
                            //向上
                            finalX = 0;
                            finalY = 0;

                        }
                    }

                    // 2. 启动动画
                    if (mDragger.smoothSlideViewTo(releasedChild, finalX, finalY)) {
                        Log.e("lx", "finalY:" + finalY + ",finalX:" + finalX);
                        ViewCompat.postInvalidateOnAnimation(VDHLayout.this);
                    }

                }
            }

            @Override
            public boolean tryCaptureView(View child, int pointerId) {
                return true;
            }

            @Override
            public int clampViewPositionHorizontal(View child, int left, int dx) {
                return left;
            }

            @Override
            public int clampViewPositionVertical(View child, int top, int dy) {
                return top;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return mDragger.shouldInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mDragger.processTouchEvent(event);
        return true;
    }

    @Override
    public void computeScroll() {
        //正在滑动  重新加载图片
        if (mDragger.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        } else {
            // 动画结束
            synchronized (this) {
//                if (mDragger.getViewDragState() == com.yjmfortune.android_viewdraghelper.demo2.ViewDragHelper.STATE_IDLE) {
//                }
            }
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        tv.layout(tv.getLeft(),b/2-tv.getHeight()/2, tv.getRight(), b/2+tv.getHeight()/2);

        left = tv.getLeft();
        top = tv.getTop();

    }

    TextView tv;
    int left;
    int top;

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        tv = (TextView) getChildAt(0);
    }
}