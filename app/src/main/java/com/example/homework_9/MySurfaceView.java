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
    private MyCircle circle;
    private Canvas canvas;
    public MySurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);
        drawThread = new DrawThread();
        Log.d("RRR", "initialized");
    }


    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
        drawThread.start();
        circle = new MyCircle(getWidth() / 2f, getHeight() / 2f);
        Log.d("RRR", "created");
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        circle.x1 = event.getX();
        circle.y1 = event.getY();
        return super.onTouchEvent(event);
    }

    class DrawThread extends Thread {
        private volatile boolean running = true;

        public void run() {
            while (running) {
                try {
                    sleep(100);
                    canvas = surfaceHolder.lockCanvas();
                    canvas.drawColor(Color.BLUE);
                    circle.draw(canvas);
                    circle.update();
                    surfaceHolder.unlockCanvasAndPost(canvas);
                } catch (Exception e) {
                    Log.e("RRR", e.getMessage());
                }
            }
        }
    }

    class MyCircle {
        float x, y, radius, x1, y1;

        Paint paint;

        public MyCircle(float x, float y) {
            this.x = x;
            this.y = y;
            this.radius = 50;
            this.x1 = x;
            this.y1 = y;
            this.paint = new Paint();
            paint.setColor(Color.RED);
        }

        void draw(Canvas canvas) {
            canvas.drawCircle(x, y, radius, paint);
        }

        void update() {
            if (Math.abs((int)circle.x - (int)circle.x1) > 1 && Math.abs((int)circle.y - (int)circle.y1) > 1) {
                x += (int) (x1 - x) / Math.sqrt(Math.pow(y1 - y, 2) + Math.pow(x1 - x, 2)) * 20;
                y += (int) (y1 - y) / Math.sqrt(Math.pow(y1 - y, 2) + Math.pow(x1 - x, 2)) * 20;
            }
        }
    }
}

