package com.neil.customdrawview.views;

import android.content.Context;
import android.graphics.*;
import android.graphics.Color;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/11/19 0019.
 */
public class Circle extends View {

    public Circle(Context context) {
        super(context);
    }

    public Circle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Circle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Circle(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);

        float cx, cy;
        float r1 = 200f;
        float r2 = 160f;


        // Draw the first circle
        cx = getWidth() / 3;
        cy = getHeight() / 3;
        canvas.drawCircle(cx, cy, r1, paint);

        // Draw the second circle
        cx = getWidth() * 2 / 3;
        cy = getHeight() / 3;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(6.0f);
        canvas.drawCircle(cx, cy, r1, paint);

        // Draw the third circle
        cx = getWidth() / 3;
        cy = getHeight() * 2 / 3;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(0.0f);
        canvas.drawCircle(cx, cy, r1, paint);

        // Draw the fourth ring
        cx = getWidth() * 2 / 3;
        cy = getHeight() * 2 / 3;
        paint.setColor(Color.BLACK);
        android.graphics.Path path = new android.graphics.Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(cx, cy);
        path.addCircle(cx, cy, r1, Path.Direction.CW);
        path.addCircle(cx, cy, r2, Path.Direction.CW);
        canvas.drawPath(path, paint);
    }
}
