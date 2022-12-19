package com.example.homework_9;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Random;


public class CommentActivity extends AppCompatActivity {

    private String title;
    private String[] comments_list;

    private ArrayAdapter<Comment> adapter;
    private Comment[] comments;

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
        String[] names = {"Тайлер", "Патрик", "Райан", "Пашка", "Евгений"};
        String[] surnames = {"Дёрден", "Бейтман", "Гослинг", "Иванов", "Джобс"};
        Random random = new Random();

        title = getIntent().getStringExtra("title");
        comments_list = getIntent().getStringArrayExtra("comments");
        comments = new Comment[comments_list.length];
        for (int i = 0; i < comments_list.length; ++i) {
            comments[i] = new Comment(names[random.nextInt(names.length)] + " " + surnames[random.nextInt(surnames.length)], comments_list[i]);
        }
    }

    private void setupUI() {
        ListView listView = findViewById(R.id.comments_list);
        TextView titleComments = findViewById(R.id.title_comments);
        titleComments.setText(title);
        adapter = new MyCommentAdapter(this, comments);
        listView.setAdapter(adapter);
    }

    class MyCommentAdapter extends ArrayAdapter<Comment> {
        final Comment[] comments;

        public MyCommentAdapter(@NonNull Context context, Comment[] comments) {
            super(context, R.layout.comment_item);
            this.comments = comments;
        }

        @Override
        public int getCount() {
            return comments.length;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            Comment comment = comments[position];
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.comment_item, null);
            }

            TextView username = convertView.findViewById(R.id.username);
            username.setText(comment.getUsername());

            TextView commentText = convertView.findViewById(R.id.comment_text);
            commentText.setText(comment.getText());

            return convertView;
        }
    }
}