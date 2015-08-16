package com.example.kotchaphanmuangsan.okhttp_json_sqlite_volley;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by Kotchaphan Muangsan on 16/8/2558.
 */
public class ConnectionManager {
    public static RequestQueue requestQueue;

    private static ImageLoader sImageLoader;

    public static RequestQueue getInstance(Context context) {
        if (requestQueue == null)
            requestQueue = Volley.newRequestQueue(context);
        return requestQueue;
    }

    public static ImageLoader getsImageLoader(Context context) {
        if (sImageLoader == null) {
            sImageLoader = new ImageLoader(getInstance(context), new ImageLoader.ImageCache() {

                private final LruCache<String, Bitmap> mCache = new LruCache<String, Bitmap>(10);

                @Override
                public Bitmap getBitmap(String url) {
                    return mCache.get(url);
                }

                @Override
                public void putBitmap(String url, Bitmap bitmap) {
                    mCache.put(url, bitmap);
                }
            });
        }
        return sImageLoader;
    }
}
