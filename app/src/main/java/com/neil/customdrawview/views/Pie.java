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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2017/11/19 0019.
 */
public class Pie extends View {

    private List<Piece> mPieces = new ArrayList<>();

    public Pie(Context context) {
        super(context);
    }

    public Pie(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Pie(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Pie(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        setBackgroundColor(Color.parseColor("#506E7A"));
        super.onDraw(canvas);

        List<Piece> data = new ArrayList<>();
        data.add(new Piece("GB", 4, Color.parseColor("#9B27AF")));
        data.add(new Piece("ICS", 4, Color.parseColor("#9D9D9D")));
        data.add(new Piece("JB", 11, Color.parseColor("#009587")));
        data.add(new Piece("KitKat", 30, Color.parseColor("#2195F2")));
        data.add(new Piece("L", 41, Color.parseColor("#9B27AF")));
        data.add(new Piece("M", 9, Color.parseColor("#F34336")));
        data.add(new Piece("GB", 4, Color.parseColor("#FDC007")));
        addPData(data);

        int max = 0, sum = 0;
        final int size = mPieces.size();
        for (int i = 0; i < size; i++) {
            Piece piece = mPieces.get(i);
            sum += piece.value;
            if (piece.value > max) {
                max = piece.value;
            }
        }

        float dividerAngle = 3.0f;
        float anglePerValue = (360.0f - size * dividerAngle) / sum;

        float cx = getWidth() / 2;
        float cy = getHeight() / 2;
        float r = 300.0f;
        RectF oval = new RectF(cx - r, cy - r, cx + r, cy + r);


        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.GREEN);

        float startAngle = 0.0f;
        float sweepAngle = 0.0f;

        for (int i = 0; i < size; i++) {
            Piece piece = mPieces.get(i);
            sweepAngle = piece.value * anglePerValue;
            paint.setColor(piece.color);
            canvas.drawArc(oval, startAngle, sweepAngle, true, paint);
            startAngle += sweepAngle + dividerAngle;
        }
    }

    public void addPData(Collection<Piece> data) {
        mPieces.clear();
        mPieces.addAll(data);
    }

    public static class Piece {

        String name;
        int value;
        int color;

        Piece(String name, int value, int color) {
            this.name = name;
            this.value = value;
            this.color = color;
        }
    }
}
