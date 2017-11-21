package com.neil.customdrawview.views;

import android.content.Context;
import android.content.Loader;
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
public class Path extends View {

    public Path(Context context) {
        super(context);
    }

    public Path(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Path(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Path(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
        float r = 150f;
        android.graphics.Path path = new android.graphics.Path();
        path.setFillType(android.graphics.Path.FillType.EVEN_ODD);
        RectF rightArc = new RectF(cx, cy - r, cx + 2 * r, cy + r);
        path.addArc(rightArc, -180.0f, 180.0f);
        path.lineTo(cx, cy + 3 * r);
        path.lineTo(cx - 2 * r, cy);
        RectF leftArc = new RectF(cx - 2 * r, cy - r, cx, cy + r);
        path.addArc(leftArc, -180.0f, 180.f);
        canvas.drawPath(path, paint);
    }
}
