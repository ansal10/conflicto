package com.example.ansal007.conflicto.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ansal007.conflicto.R;

import java.util.List;

/**
 * Created by Ansal007 on 7/4/16.
 */
public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.MyViewHolder>{

    private List<Topic> topicList;
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.topic_list_row, parent, false);

        return new MyViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Topic topic = topicList.get(position);

        holder.title.setText(topic.getDescription());
        holder.userProfileName.setText(topic.getUserDisplayName());
        holder.postedOn.setText(topic.getPostedOn());
        holder.likers.setText(String.valueOf(topic.getLikers()));
        holder.dislikers.setText(String.valueOf(topic.getDislikers()));
        holder.followers.setText(String.valueOf(topic.getFollowers()));
    }

    @Override
    public int getItemCount() {
        return topicList.size();
    }

    public TopicAdapter(List<Topic> topicList) {
        this.topicList = topicList;
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView title, userProfileName, postedOn, likers, dislikers, followers;

        public MyViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title_text);
            userProfileName = (TextView) itemView.findViewById(R.id.profile_name_text);
            postedOn = (TextView) itemView.findViewById(R.id.postedon_text);
            likers = (TextView) itemView.findViewById(R.id.likers_text);
            dislikers = (TextView) itemView.findViewById(R.id.dislikers_text);
            followers = (TextView) itemView.findViewById(R.id.followers_text);
        }


        }
    }
