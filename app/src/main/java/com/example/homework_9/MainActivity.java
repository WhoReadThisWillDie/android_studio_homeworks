package com.example.homework_9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.homework_9.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    List<Finances> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initData();
        setupUI();
    }

    private void setupUI() {
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.recyclerView.setAdapter(new MyFinancesAdapter(list));
        binding.addButton.setOnClickListener(view ->
        {
            list.add(Finances.getRandom());
            binding.recyclerView.getAdapter().notifyItemChanged(list.size() - 1);
        });
    }

    private void initData() {
        for (int i = 0; i < 10; ++i) {
            list.add(Finances.getRandom());
        }
    }
}