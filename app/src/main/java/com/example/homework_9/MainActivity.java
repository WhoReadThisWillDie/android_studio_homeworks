package com.example.homework_9;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<Post> adapter;

    private final Post[] posts = new Post[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        posts[0] = new Post("Райан Гослинг умер в конце драйва",
                "Стало известно, что главный герой киноленты Драйв, так же известный как Водитель по сюжету погиб",
                R.drawable.sad, 10, 15, 3);
        posts[1] = new Post("Райан Гослинг не умер в конце драйва",
                "Стало известно, что главный герой киноленты Драйв, так же известный как Водитель по сюжету не погиб",
                R.drawable.happy, 10, 15, 3);

        listView = findViewById(R.id.list_view);
        adapter = new MyPostAdapter(this, posts);
        listView.setAdapter(adapter);
    }


    class MyPostAdapter extends ArrayAdapter<Post> {
        final Post[] posts;

        public MyPostAdapter(@NonNull Context context, Post[] posts) {
            super(context, R.layout.list_item);
            this.posts = posts;
        }

        @Override
        public int getCount() {
            return posts.length;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            Post post = posts[position];
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, null);
            }
            TextView postTitle = convertView.findViewById(R.id.post_title);
            postTitle.setText(post.title);

            TextView postText = convertView.findViewById(R.id.post_text);
            postText.setText(post.text);

            ImageView postImage = convertView.findViewById(R.id.post_image);
            postImage.setImageResource(post.image);

            Button shareButton = convertView.findViewById(R.id.share_button);
            shareButton.setBackgroundColor(getColor(R.color.teal_700));

            return convertView;
        }
    }
}