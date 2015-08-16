package com.example.kotchaphanmuangsan.okhttp_json_sqlite_volley;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.kotchaphanmuangsan.okhttp_json_sqlite_volley.model.Post;

import java.util.List;

/**
 * Created by Kotchaphan Muangsan on 16/8/2558.
 */
public class RedditAdapter extends RecyclerView.Adapter<RedditAdapter.MyViewHolder> {

    List<Post> mPostList;

    Context mContext;

    MyListItemClickListener mListener;

    public RedditAdapter(List<Post> postList, Context context , MyListItemClickListener listener) {
        this.mPostList = postList;
        this.mContext = context;
        this.mListener = listener;


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_post, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {
        Post currentPost = mPostList.get(position);
        myViewHolder.mTextViewPostName.setText(mPostList.get(position).getTitle());
        String string = "";
        if (!TextUtils.isEmpty(currentPost.getThumbnaiURL())) {
            ((View)myViewHolder.mPostImage.getParent()).setVisibility(View.VISIBLE);
            myViewHolder.mPostImage.setImageUrl(currentPost.getThumbnaiURL(), ConnectionManager.getsImageLoader(mContext));
        } else {
            ((View)myViewHolder.mPostImage.getParent()).setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return mPostList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView mTextViewPostName;
        public NetworkImageView mPostImage;

        public MyViewHolder(View view) {
            super(view);
            mTextViewPostName = (TextView) view.findViewById(R.id.rowTextViewName);
            mPostImage = (NetworkImageView) view.findViewById(R.id.rowNetworkImageView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.OnItemClick(mPostList.get(getPosition()));
        }
    }

    public static interface MyListItemClickListener{
        public void OnItemClick(Post itemClicked);
    }
}
