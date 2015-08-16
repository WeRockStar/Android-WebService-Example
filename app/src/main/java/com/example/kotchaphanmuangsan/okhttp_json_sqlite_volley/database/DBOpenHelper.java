package com.example.kotchaphanmuangsan.okhttp_json_sqlite_volley.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Kotchaphan Muangsan on 16/8/2558.
 */
public class DBOpenHelper extends SQLiteOpenHelper {

    private static final String TEXT_TYPE = "TEXT";
    private static final String INTEGER_TYPE = "INTEGER";

    private static final String CREATE_POST_TABLE = "CREATE TABLE "
            + DatabaseContract.PostTable.TABLE_NAME + " ( "
            + DatabaseContract.PostTable.TITLE + TEXT_TYPE + " , "
            + DatabaseContract.PostTable.LINK + TEXT_TYPE + " , "
            + DatabaseContract.PostTable.IMAGELINK + TEXT_TYPE + " )";


    public DBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
