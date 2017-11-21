package com.neil.customdrawview.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Histogram extends View {

    public Histogram(Context context) {
        super(context);
    }

    public Histogram(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Histogram(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Histogram(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        setBackgroundColor(Color.parseColor("#506E7A"));
        super.onDraw(canvas);

        final List<Pair<String, Integer>> OS_MARKET_SHARE = new ArrayList<>();
        OS_MARKET_SHARE.add(new Pair("Froyo", 1));
        OS_MARKET_SHARE.add(new Pair("GB", 4));
        OS_MARKET_SHARE.add(new Pair("ICS", 4));
        OS_MARKET_SHARE.add(new Pair("JB", 11));
        OS_MARKET_SHARE.add(new Pair("KitKat", 30));
        OS_MARKET_SHARE.add(new Pair("L", 41));
        OS_MARKET_SHARE.add(new Pair("M", 9));

        Paint histoPaint = new Paint();
        histoPaint.setAntiAlias(true);
        histoPaint.setColor(Color.GREEN);
        histoPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        histoPaint.setStrokeWidth(2.0f);

        Paint textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(30.0f);

        Paint coordinatorPaint = new Paint();
        coordinatorPaint.setStyle(Paint.Style.STROKE);
        coordinatorPaint.setAntiAlias(true);
        coordinatorPaint.setColor(Color.WHITE);
        coordinatorPaint.setTextSize(4.0f);


        int maxValue = 0;
        for (Pair<String, Integer> pair : OS_MARKET_SHARE) {
            if (pair.second > maxValue) {
                maxValue = pair.second;
            }
        }

        final int size = OS_MARKET_SHARE.size();

        // Use 3/4 of the available width, and 2/4 of the available height
        // to represent the histograms.
        float coordinateX = getWidth() / 8;
        float coordinateY = getHeight() * 3 / 4;
        float averageWidth = getWidth() * 3 / 4 / (2 * size);
        float averageHeight = getHeight() / (2 * maxValue);

        float left, top, right, bottom;
        float valueOffset = 10.0f;
        float keyOffset = 40.0f;

        // Draw coordinator
        android.graphics.Path path = new android.graphics.Path();
        path.setLastPoint(coordinateX, coordinateY - averageHeight * (maxValue + 1));
        path.lineTo(coordinateX, coordinateY);
        path.lineTo(coordinateX + (2 * size + 1) * averageWidth, coordinateY);
        canvas.drawPath(path, coordinatorPaint);

        // Draw histograms.
        for (int i = 0; i < OS_MARKET_SHARE.size(); i++) {
            String key = OS_MARKET_SHARE.get(i).first;
            Integer value = OS_MARKET_SHARE.get(i).second;
            left = coordinateX + averageWidth * (2 * i + 1);
            top = coordinateY - value * averageHeight;
            right = left + averageWidth;
            bottom = coordinateY;
            canvas.drawRect(left, top, right, bottom, histoPaint);
            canvas.drawText(String.valueOf(value), left, top - valueOffset, textPaint);
            canvas.drawText(key, left + averageWidth / 4, bottom + keyOffset, textPaint);
        }

    }
}
