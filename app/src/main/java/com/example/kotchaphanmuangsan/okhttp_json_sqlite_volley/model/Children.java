package com.example.kotchaphanmuangsan.okhttp_json_sqlite_volley.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Kotchaphan Muangsan on 16/8/2558.
 */
public class Children {

    @SerializedName("data")
    private Post post;

    public Post getPost(){
        return post;
    }
}
