package com.example.homework_9;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.example.homework_9.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        OneTimeWorkRequest workRequest = new OneTimeWorkRequest.Builder(MyWorker.class).build();
        WorkManager.getInstance().enqueue(workRequest);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.button.setOnClickListener(view -> {
            MyImageTask task = new MyImageTask();
            task.execute();
        });
    }

    class MyImageTask extends AsyncTask<Void, Integer, String> {
        Drawable drawable;
        public final TaskManager taskManager = new TaskManager();

        @Override
        protected void onPreExecute() {
            Toast.makeText(MainActivity.this, "Pre Execute", Toast.LENGTH_SHORT).show();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... voids) {
            drawable = taskManager.getImageFromNetwork(getApplicationContext());
            return "kek";
        }

        @Override
        protected void onPostExecute(Drawable drawable) {
            Toast.makeText(MainActivity.this, "Post Execute", Toast.LENGTH_SHORT).show();
            binding.image.setImageDrawable(drawable);
            super.onPostExecute(drawable);
        }
    }
}