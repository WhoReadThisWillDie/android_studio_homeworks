package com.example.homework_9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class CommentActivity extends AppCompatActivity {

    private String title;
    private String[] comments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        initData();
        setupUI();

        CardView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(view -> {
            finish();
        });
    }

    private void initData() {
        title = getIntent().getStringExtra("title");
        comments = getIntent().getStringArrayExtra("comments");
    }

    private void setupUI() {
        ListView listView = findViewById(R.id.comments_list);
        TextView titleComments = findViewById(R.id.title_comments);
        titleComments.setText(title);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, comments);
        listView.setAdapter(adapter);
    }
}