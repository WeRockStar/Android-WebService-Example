package com.example.kotchaphanmuangsan.okhttp_json_sqlite_volley.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Kotchaphan Muangsan on 16/8/2558.
 */
public class DBOpenHelper extends SQLiteOpenHelper {

    //VERSION
    private static final int DATABASE_VERSION = 1;

    private static final String TEXT_TYPE = "TEXT";
    private static final String INTEGER_TYPE = "INTEGER";

    //SQL Statements
    private static final String CREATE_POST_TABLE = "CREATE TABLE "
            + DatabaseContract.PostTable.TABLE_NAME + " ( "
            + DatabaseContract.PostTable.TITLE + TEXT_TYPE + " , "
            + DatabaseContract.PostTable.LINK + TEXT_TYPE + " , "
            + DatabaseContract.PostTable.IMAGELINK + TEXT_TYPE + " )";


    //DROP POST TABLE
    public static final String DROP_POST_TABLE = "DROP TABLE IF EXISTS " + DatabaseContract.PostTable.TABLE_NAME;

    //Constructor
    public DBOpenHelper(Context context) {
        super(context, DatabaseContract.DB_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_POST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_POST_TABLE);
        onCreate(db);
    }
}
