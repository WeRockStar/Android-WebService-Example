package com.example.kotchaphanmuangsan.okhttp_json_sqlite_volley;

import android.app.Activity;
import android.os.Bundle;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class MainActivity extends Activity {

    public final String REDDIT_URL = "https://www.reddit.com/r/all.json?limit=5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(REDDIT_URL)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                
            }

            @Override
            public void onResponse(Response response) throws IOException {

            }
        });
    }
}
