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

import java.util.ArrayList;
import java.util.List;


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

    class DrawThread extends Thread {
        Canvas canvas;
        private volatile boolean running = true;

        public void run() {
            while (running) {
                try {
                    sleep(50);
                    canvas = surfaceHolder.lockCanvas();
                    canvas.drawColor(Color.DKGRAY);
                    for (MyCircle circle : circles)
                        circle.draw(canvas);
                    surfaceHolder.unlockCanvasAndPost(canvas);
                    for (MyCircle circle : circles)
                        circle.update(5);
                } catch (Exception e) {
                    Log.e("RRR", e.getMessage());
                }
            }
        }
    }

    List<MyCircle> circles = new ArrayList<>();

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        circles.add(new MyCircle(event.getX(), event.getY()));
        return super.onTouchEvent(event);
    }

    private MyCircle circle;

    class MyCircle {
        float x, y, radius;
        Paint paint;

        public MyCircle(float x, float y) {
            this.x = x;
            this.y = y;
            this.radius = 50;
            this.paint = new Paint();
            paint.setColor(Color.YELLOW);
        }

        void draw(Canvas canvas) {
            canvas.drawCircle(x, y, radius, paint);
        }

        void update(float dr) {
            radius += dr;
        }
    }
}

