package com.example.kotchaphanmuangsan.okhttp_json_sqlite_volley;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.kotchaphanmuangsan.okhttp_json_sqlite_volley.database.RedditDAO;
import com.example.kotchaphanmuangsan.okhttp_json_sqlite_volley.model.Listing;
import com.example.kotchaphanmuangsan.okhttp_json_sqlite_volley.model.Post;
import com.google.gson.Gson;

import java.util.List;


public class MainActivity extends Activity {

    public final String REDDIT_URL = "https://www.reddit.com/r/all.json?limit=5";
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestQueue queue = ConnectionManager.getInstance(this);
        String url = REDDIT_URL;

        recyclerView = (RecyclerView) findViewById(R.id.recyclerListview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        StringRequest request = new StringRequest(Request.Method.GET, REDDIT_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Listing listing = new Gson().fromJson(response, Listing.class);

                List<Post> postList = listing.getPostList();

                RedditAdapter adapter = new RedditAdapter(postList , MainActivity.this);

                //
                RedditDAO.getsInstance().storePosts(MainActivity.this, postList);

                recyclerView.setAdapter(adapter);

                //Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //WHEN AN ERROR

                List<Post> postList = RedditDAO.getsInstance().getPostsFromDB(MainActivity.this);
                RedditAdapter adapter = new RedditAdapter(postList , MainActivity.this);
                recyclerView.setAdapter(adapter);
            }
        });
        //ConnectionManager.getInstance(this).add(request);
        queue.add(request);
    }
}
