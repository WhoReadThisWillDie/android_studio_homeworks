package com.example.homework_9;

import static com.example.homework_9.Constants.*;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.homework_9.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.registerButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Log.d(TAG, "registration button pressed");
        String email = binding.inputEmail.getText().toString();
        String password = binding.inputPassword.getText().toString();
        if (email.length() == 0 || password.length() == 0) {
            Log.e(TAG, "Wrong format: no empty fields allowed");
            Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show();
        }
        else if (!email.contains("@")) {
            Log.e(TAG, "Wrong format: email must contain @");
            Toast.makeText(this, "Почта должна содержать символ @", Toast.LENGTH_SHORT).show();
        }
        else if (password.length() < 8) {
            Log.e(TAG, "Wrong format: password must be at least 8 symbols");
            Toast.makeText(this, "Слишком короткий пароль, минимум 8 символов", Toast.LENGTH_SHORT).show();
        }
        else if (email.equals("rickroll@gmail.com") && password.equals("RickAstley")) {
            Log.i(TAG, "email = " + email + ", password = " + password);
            email = "Rick Astley";
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("email", email);
            startActivity(intent);
            finish();
        }
        else {
            Log.e(TAG, "No such user exists");
            Toast.makeText(this, "Неверно введён логин или пароль", Toast.LENGTH_SHORT).show();
        }

    }
}