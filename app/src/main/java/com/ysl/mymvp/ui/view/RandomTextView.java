package com.ysl.mymvp.ui.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.ysl.mymvp.R;


/**
 * Created by ysl on 2017/7/13.
 */
public class RandomTextView extends View {

    private String text = "";
    private Paint paint;

    private int text_color;
    private int background_color;
    private int text_size;

    public RandomTextView(Context context) {
        this(context, null, 0);
    }

    public RandomTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RandomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.RandomTextView, defStyleAttr, 0);

        for (int i = 0; i < a.getIndexCount(); ++i) {

            int attr = a.getIndex(i);
            switch (a.getIndex(i)) {

                case R.styleable.RandomTextView_text_color:

                    text_color = a.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.RandomTextView_background_color:

                    background_color = a.getColor(attr, Color.YELLOW);
                    break;
                case R.styleable.RandomTextView_text_size:

                    text_size = a.getInt(attr, 40);
                    break;
            }
        }

        paint = new Paint();
        paint.setTextSize(text_size);
        onRandom();
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {


                onRandom();
            }
        });
    }

    private void onRandom() {

        String random = null;
        for (int i = 0; i < 4; ++i) {
            int j = (int) (Math.random() * 9) + 1;
            if (random == null)
                random = j + "";
            else
                random += j;
        }
        text = random;
        postInvalidate();
    }

    public String getText() {

        return text;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(background_color);
        RectF rectF = new RectF(0, 0, getMeasuredWidth(), getMeasuredHeight());
        canvas.drawRect(rectF, paint);
        paint.setColor(text_color);
        paint.setTextSize(text_size);
        canvas.drawText(text, 0, text.length(), getWidth()*1/ 4, getHeight() * 3 / 4, paint);

        ObjectAnimator anim1 = ObjectAnimator.ofFloat(this, "ScaleX", 0f, 1f);
        anim1.setRepeatCount(0);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(this, "ScaleY", 0f, 1f);
        anim2.setRepeatCount(0);
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(this, "RotationX", 0f, 360f);
        anim3.setRepeatCount(0);

        AnimatorSet set = new AnimatorSet();
        set.playTogether(anim1, anim2, anim3);
        set.setDuration(1500);
        set.start();
    }


}
