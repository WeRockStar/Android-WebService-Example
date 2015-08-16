package com.example.kotchaphanmuangsan.okhttp_json_sqlite_volley.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.kotchaphanmuangsan.okhttp_json_sqlite_volley.model.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kotchaphan Muangsan on 16/8/2558.
 */
public class RedditDAO {

    //Singleton pattern
    private static RedditDAO sInstance = null;

    //TODO return instance
    public static RedditDAO getsInstance() {
        if (sInstance == null)
            sInstance = new RedditDAO();

        return sInstance;
    }

    public boolean storePosts(Context context, List<Post> postList) {

        List<Post> storedPost = RedditDAO.getsInstance().getPostsFromDB(context);

        try {
            //TODO write
            SQLiteDatabase db = new DBOpenHelper(context).getWritableDatabase();

            //start transaction
            db.beginTransaction();

            for (Post post : postList) {
                boolean isInDb = false;
                for (Post postStored : storedPost) {
                    if (post.getTitle().equals(postStored.getTitle())) {
                        isInDb = true;
                    }
                }
                if (!isInDb) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(DatabaseContract.PostTable.TITLE, post.getTitle());
                    contentValues.put(DatabaseContract.PostTable.LINK, post.getPermalink());
                    contentValues.put(DatabaseContract.PostTable.IMAGELINK, post.getThumbnaiURL());

                    //write to db
                    db.insert(DatabaseContract.PostTable.TABLE_NAME, null, contentValues);
                }
            }
            db.setTransactionSuccessful();
            db.endTransaction();

            db.close();
        } catch (
                Exception e
                )

        {
            return false;

        }

        return true;
    }

    public List<Post> getPostsFromDB(Context context) {
        SQLiteDatabase db = new DBOpenHelper(context).getWritableDatabase();
        Cursor cursor = db.query(DatabaseContract.PostTable.TABLE_NAME, null, null, null, null, null, null);

        cursor.moveToFirst();

        List<Post> postList = new ArrayList<>();
        while (cursor.moveToNext()) {
            String title = cursor.getString(cursor.getColumnIndex(DatabaseContract.PostTable.TITLE));
            String link = cursor.getString(cursor.getColumnIndex(DatabaseContract.PostTable.LINK));
            String imageLink = cursor.getString(cursor.getColumnIndex(DatabaseContract.PostTable.IMAGELINK));

            Post post = new Post(link, imageLink, title);

            postList.add(post);
        }
        cursor.close();
        db.close();

        return postList;
    }
}
