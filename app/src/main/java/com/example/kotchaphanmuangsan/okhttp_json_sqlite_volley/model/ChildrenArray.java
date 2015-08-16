package com.example.kotchaphanmuangsan.okhttp_json_sqlite_volley.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Kotchaphan Muangsan on 16/8/2558.
 */
public class ChildrenArray {

    @SerializedName("children")
    private List<Children> childrenList;

    public List<Children> getChildrenList(){
        return childrenList;
    }
}
