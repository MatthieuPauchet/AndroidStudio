package com.afpa.listview;

//import com.google.gson.annotations.SerializedName;

public class Post {

    private int userId;
    private int id;
    private  String title;

    //On dit à retrofit de faire la liaison entre body du Json et l'attribut text
//    @SerializedName("body")
    private String text;

    public Post(int userId, int id, String title, String text) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }


}
