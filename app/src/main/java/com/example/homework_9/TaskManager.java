package com.example.homework_9;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

import androidx.core.content.ContextCompat;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class TaskManager {

    public Drawable getImageFromNetwork(Context context) {
       try {
           Thread.sleep(2000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       return ContextCompat.getDrawable(context, R.drawable.cucumber);
    }
}

class MyWorker extends Worker {
    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        return ListenableWorker.Result.success();
    }
}
