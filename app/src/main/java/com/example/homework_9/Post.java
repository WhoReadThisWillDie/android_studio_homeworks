package com.example.homework_9;

public class Post {
    public final String title;
    public final String text;
    public final int image;
    public int likes;
    public int comments;
    public int reposts;
    public boolean liked = false;

    public Post(String title, String text, int image, int likes, int comments, int reposts) {
        this.title = title;
        this.text = text;
        this.image = image;
        this.likes = likes;
        this.comments = comments;
        this.reposts = reposts;
    }
}
