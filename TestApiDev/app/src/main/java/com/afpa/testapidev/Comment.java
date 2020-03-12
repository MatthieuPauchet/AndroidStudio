package com.afpa.testapidev;

import com.google.gson.annotations.SerializedName;

public class Comment {

    private int id;
    private int postId;
    private String name;
    private String mail;
    private String text;

    public Comment() {
    }

    public Comment(int id, int postId, String name, String mail, String text) {
        this.id = id;
        this.postId = postId;
        this.name = name;
        this.mail = mail;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public int getPostId() {
        return postId;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getText() {
        return text;
    }
}
