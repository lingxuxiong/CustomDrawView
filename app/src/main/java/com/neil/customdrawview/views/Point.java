package com.neil.customdrawview.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/11/19 0019.
 */
public class Point extends View {

    public Point(Context context) {
        super(context);
    }

    public Point(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Point(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Point(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(200f);

        float offset = 200f;
        float cx = getWidth() / 2;
        float cy = getHeight() / 2;

        float point1[] = new float[] {cx - offset, cy};
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(point1[0], point1[1], paint);

        float point2[] = new float[] {cx + offset, cy};
        paint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(point2[0], point2[1], paint);
    }
}
