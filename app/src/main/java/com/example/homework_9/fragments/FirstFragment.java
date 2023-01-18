package com.example.homework_9.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.homework_9.R;
import com.example.homework_9.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    FragmentFirstBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        binding.buttonTest.setOnClickListener(someView -> {
            Toast.makeText(getContext(), "Test", Toast.LENGTH_SHORT).show();
        });
        return binding.getRoot();
    }
}
