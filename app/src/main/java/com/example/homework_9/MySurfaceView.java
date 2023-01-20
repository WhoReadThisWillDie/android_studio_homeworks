package com.example.homework_9;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import java.util.Calendar;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder surfaceHolder;
    private final DrawThread drawThread;

    public MySurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);
        drawThread = new DrawThread();
    }


    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
        drawThread.start();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    class DrawThread extends Thread {
        Canvas canvas;
        private boolean running;

        public void run() {
            while (running) {
                try {
                    sleep(100);
                    canvas = surfaceHolder.lockCanvas();
                    canvas.drawColor(Color.BLUE);
                } catch (Exception e) {
                    Log.e("RRR", e.getMessage());
                }
            }
        }

        class MyCircle {
            float x, y, radius;
            Paint paint;

            public MyCircle(float x, float y, float radius, Paint paint) {
                this.x = x;
                this.y = y;
                this.radius = 50;
                this.paint = new Paint();
                paint.setColor(Color.RED);
            }

            void draw() {
                canvas.drawCircle(x, y, radius, paint);
            }

            void update(float dx, float dy) {
                this.x += dx;
                this.y += dy;
            }
        }
    }
}
