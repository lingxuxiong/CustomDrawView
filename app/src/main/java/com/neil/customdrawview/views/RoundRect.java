package com.neil.customdrawview.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/11/19 0019.
 */
public class RoundRect extends View {

    public RoundRect(Context context) {
        super(context);
    }

    public RoundRect(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundRect(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RoundRect(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(2.0f);

        float cx = getWidth() / 2;
        float cy = getHeight() / 2;
        float longSemiAxis = 300f;
        float shortSemiAxis = 200f;
        float left = cx - longSemiAxis;
        float top = cy - shortSemiAxis;
        float right = cx + longSemiAxis;
        float bottom = cy + shortSemiAxis;
        float r = 50f;

        RectF rect = new RectF(left, top, right, bottom);
        canvas.drawRoundRect(rect, r, r, paint);
    }
}
