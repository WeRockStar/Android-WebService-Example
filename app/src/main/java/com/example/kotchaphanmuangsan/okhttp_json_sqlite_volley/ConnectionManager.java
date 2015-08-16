package com.example.kotchaphanmuangsan.okhttp_json_sqlite_volley;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Kotchaphan Muangsan on 16/8/2558.
 */
public class ConnectionManager {
    private static RequestQueue requestQueue;

    private static RequestQueue getInstance(Context context) {
        if (requestQueue == null)
            requestQueue = Volley.newRequestQueue(context);
        return requestQueue;
    }
}
