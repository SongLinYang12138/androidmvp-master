package com.ysl.mymvp.evelautor;

import android.animation.TypeEvaluator;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by ysl on 2017/7/14.
 */
public class PointEvelautor implements TypeEvaluator<Paint> {


    private int[] color = new int[]{Color.BLUE, Color.BLACK, Color.GRAY, Color.WHITE, Color.RED};

    @Override
    public Paint evaluate(float v, Paint startValue, Paint endValue) {

        int position = (int) ((Math.random() * 4));

        Paint paint = new Paint();
        paint.setColor(color[position]);

        return startValue;
    }
}
