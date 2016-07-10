package com.example.ansal007.conflicto.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ansal007.conflicto.R;
//import com.example.ansal007.conflicto.fragments.PostFragment.OnListFragmentInteractionListener;
import com.example.ansal007.conflicto.fragments.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyPostRecyclerViewAdapter extends RecyclerView.Adapter<MyPostRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> mValues;
    private final OnItemClickListener listener;

    public MyPostRecyclerViewAdapter(List<DummyItem> items, OnItemClickListener listener) {
        this.listener  = listener;
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_post_row, parent, false);

        return new ViewHolder(view , listener);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
//        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).content);
//        holder.mDetailsView.setText(mValues.get(position).details);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(holder.mItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

//        private OnItemClickListener listener;
        private View view;
        private DummyItem mItem;
        private TextView mIdView;
        private TextView mContentView;
        private TextView mDetailsView;

        public ViewHolder(View itemView, OnItemClickListener listener) {

            super(itemView);
            this.view = itemView.findViewById(R.id.post_row);
//            this.listener  = listener;
//            this.mIdView = (TextView) itemView.findViewById(R.id.post_id);
            this.mContentView = (TextView) itemView.findViewById(R.id.post_content);
//            this.mDetailsView = (TextView) itemView.findViewById(R.id.post_details);
        }

    }





}
