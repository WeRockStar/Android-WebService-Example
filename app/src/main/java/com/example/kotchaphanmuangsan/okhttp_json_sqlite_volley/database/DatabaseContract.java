package com.example.kotchaphanmuangsan.okhttp_json_sqlite_volley.database;

/**
 * Created by Kotchaphan Muangsan on 16/8/2558.
 */
public class DatabaseContract {

    public static final String DB_NAME = "reddit_database.db";

    public abstract class PostTable {
        public static final String TABLE_NAME = "post_table";

        public static final String TITLE = "title";

        public static final String LINK = "link";

        public static final String IMAGELINK = "imagelink";
    }
}
