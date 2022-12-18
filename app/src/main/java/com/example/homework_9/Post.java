package com.example.homework_9;

public class Post {
    private String title;
    private String text;
    private int image;
    private int likes;
    private int comments;
    private int reposts;
    private boolean liked = false;

    public Post(String title, String text, int image, int likes, int comments, int reposts) {
        this.title = title;
        this.text = text;
        this.image = image;
        this.likes = likes;
        this.comments = comments;
        this.reposts = reposts;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public void setReposts(int reposts) {
        this.reposts = reposts;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public int getImage() {
        return image;
    }

    public int getLikes() {
        return likes;
    }

    public int getComments() {
        return comments;
    }

    public int getReposts() {
        return reposts;
    }

    public boolean isLiked() {
        return liked;
    }
}
