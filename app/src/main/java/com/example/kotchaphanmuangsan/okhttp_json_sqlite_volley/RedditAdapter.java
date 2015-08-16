package com.example.kotchaphanmuangsan.okhttp_json_sqlite_volley;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kotchaphanmuangsan.okhttp_json_sqlite_volley.model.Post;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Kotchaphan Muangsan on 16/8/2558.
 */
public class RedditAdapter extends RecyclerView.Adapter<RedditAdapter.MyViewHolder> {

    List<Post> mPostList;

    public RedditAdapter(List<Post> postList) {
        this.mPostList = postList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_post, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {
        myViewHolder.mTextViewPostName.setText(mPostList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mPostList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewPostName;

        public MyViewHolder(View view) {
            super(view);
            mTextViewPostName = (TextView) view.findViewById(R.id.rowTextViewName);
        }
    }
}
