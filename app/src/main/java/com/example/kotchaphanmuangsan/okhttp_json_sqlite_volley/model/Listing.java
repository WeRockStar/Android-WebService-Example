package com.example.kotchaphanmuangsan.okhttp_json_sqlite_volley.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kotchaphan Muangsan on 16/8/2558.
 */
public class Listing {

    @SerializedName("data")
    private ChildrenArray childrenArray;

    public List<Post> getPostList() {
        List<Post> postsList = new ArrayList<Post>();

        for (Children children : childrenArray.getChildrenList()) {
            postsList.add(children.getPost());
        }
        return postsList;
    }
}
