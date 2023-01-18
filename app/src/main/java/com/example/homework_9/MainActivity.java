package com.example.homework_9;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.homework_9.databinding.ActivityMainBinding;
import com.example.homework_9.fragments.FirstFragment;
import com.example.homework_9.fragments.ThirdFragment;
import com.example.homework_9.fragments.ui.login.LoginFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        swapFragment(new Fragment());

        binding.button1.setOnClickListener(view -> swapFragment(new FirstFragment()));
        binding.button2.setOnClickListener(view -> swapFragment(new LoginFragment()));
        binding.button3.setOnClickListener(view -> swapFragment(new ThirdFragment()));
    }

    private void swapFragment(Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.placeholder, fragment);
        transaction.commit();
    }
}