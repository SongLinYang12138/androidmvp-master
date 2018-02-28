package com.ysl.mymvp.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.ysl.mymvp.R;

/**
 * Created by ysl on 2018/1/31.
 */
public class RabbitView extends View {
    public float bitmapX;
    public float bitmapY;

    public RabbitView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        bitmapX=290;
        bitmapY=130;
    }
    public RabbitView(Context context, AttributeSet attrs) {
        super(context,attrs);
        bitmapX=290;
        bitmapY=130;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        Paint paint=new Paint();
        Bitmap bitmap= BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_launcher);
        canvas.drawBitmap(bitmap, bitmapX, bitmapY,paint);
        if(bitmap.isRecycled())
        {
            bitmap.recycle();
        }
    }

}