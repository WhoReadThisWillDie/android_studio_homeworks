package com.example.homework_9;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<Post> adapter;

    private final Post[] posts = new Post[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        setupUI();
    }

    private void initData() {
        posts[0] = new Post("Райан Гослинг умер в конце драйва",
                "Стало известно, что главный герой киноленты Драйв, так же известный как Водитель всё-таки погиб. Об этом сообщил режиссёр и сценарист фильма Никлас Рефн",
                R.drawable.sad, 17, 2, 124, new String[]{"Грустно", "Да это же буквально я.."});
        posts[1] = new Post("Райан Гослинг не умер в конце драйва???",
                "Актёр Райан Гослинг опроверг догадки фанатов о смерти своего персонажа. Он сказал: 'Да отстаньте вы от меня, я ничего не знаю. Спросите у Рефна'",
                R.drawable.happy, 1000, 2, 74, new String[]{"Как же он хорош", "БАЗАБАЗАБАЗА"});
        posts[2] = new Post("Анонс GTA 6",
                "Студия Rockstar объявила о старте разработки новой игры. Первый тизер выйдет в 2024 году",
                R.drawable.gta, 1337, 5, 1000, new String[]{"СДЕЛАЙТЕ ВСЕ КАК В РЕАЛЬНОЙ ЖИЗНЕ", "физику поправьте", "добавьте собакумедведькошку и других зверей!!"});

    }


    private void setupUI() {
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
            postTitle.setText(post.getTitle());

            TextView postText = convertView.findViewById(R.id.post_text);
            postText.setText(post.getText());

            ImageView postImage = convertView.findViewById(R.id.post_image);
            postImage.setImageResource(post.getImage());

            TextView likeCount = convertView.findViewById(R.id.like_count);
            likeCount.setText(String.valueOf(post.getLikes()));

            TextView commentCount = convertView.findViewById(R.id.comment_count);
            commentCount.setText(String.valueOf(post.getComments()));

            TextView repostCount = convertView.findViewById(R.id.repost_count);
            repostCount.setText(String.valueOf(post.getReposts()));

            ImageView likeImage = convertView.findViewById(R.id.like_image);
            CardView likeButton = convertView.findViewById(R.id.like_button);
            likeButton.setOnClickListener(view -> {
                if (post.isLiked()) {
                    likeImage.setImageResource(R.drawable.sad);
                } else {
                    likeImage.setImageResource(R.drawable.happy);
                }
                post.like();
                notifyDataSetChanged();
            });

            CardView commentButton = convertView.findViewById(R.id.comment_button);
            commentButton.setOnClickListener(view -> {
                Intent intent = new Intent(MainActivity.this, CommentActivity.class);
                intent.putExtra("title", post.getTitle());
                intent.putExtra("comments", post.getSomeComments());
                startActivity(intent);
            });

            CardView shareButton = convertView.findViewById(R.id.repost_button);
            shareButton.setOnClickListener(view -> {
                Toast.makeText(MainActivity.this, "Извините, у вас нет друзей((", Toast.LENGTH_SHORT).show();
            });

            return convertView;
        }

    }
}