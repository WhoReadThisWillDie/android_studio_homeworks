package com.example.homework_9;

import static com.example.homework_9.Constants.*;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import com.example.homework_9.databinding.ActivityResultBinding;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener{

    ActivityResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String email = getIntent().getStringExtra("email");
        binding.hello.setText("Привет, " + email);
        binding.takePhoto.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Log.d(TAG, "take_photo button pressed");
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, MAKE_PHOTO_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.v(TAG, "request code = " + requestCode + ", resultCode = " + resultCode);
        if (requestCode == MAKE_PHOTO_REQUEST && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            binding.image.setImageBitmap(photo);
            Log.i(TAG, "Photo taken");
        }
    }
}