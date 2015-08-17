package com.example.kotchaphanmuangsan.okhttp_json_sqlite_volley;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Kotchaphan Muangsan on 18/8/2558.
 */
public class ApplicationClass extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/Roboto-Bold.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );
    }
}
