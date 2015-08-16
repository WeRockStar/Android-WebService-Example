package com.example.kotchaphanmuangsan.okhttp_json_sqlite_volley.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Kotchaphan Muangsan on 16/8/2558.
 */
public class Post {
    @SerializedName("permalink")
    private String permalink;

    @SerializedName("thumbnai")
    private String thumbnaiURL;

    @SerializedName("title")
    private String title;


    public String getTitle() {
        return title;
    }

    public String getPermalink() {
        return permalink;
    }

    public String getThumbnaiURL() {
        return thumbnaiURL;
    }
}
