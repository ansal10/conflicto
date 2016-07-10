package com.example.ansal007.conflicto.fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ansal007.conflicto.R;
import com.example.ansal007.conflicto.adapters.MyPostRecyclerViewAdapter;
import com.example.ansal007.conflicto.adapters.OnItemClickListener;
import com.example.ansal007.conflicto.fragments.dummy.DummyContent;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link }
 * interface.
 */
public class PostFragment extends Fragment  {

    private ViewGroup container;
    private View view;
    private RecyclerView recyclerView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.container = container;
        this.view = inflater.inflate(R.layout.fragment_post_list, container, false);

        MyPostRecyclerViewAdapter adapter = new MyPostRecyclerViewAdapter(DummyContent.ITEMS, new OnItemClickListener() {
            @Override
            public void onItemClick(DummyContent.DummyItem item) {
                Toast.makeText(getActivity().getApplicationContext(), item.id+" : "+item.content, Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView = (RecyclerView) view.findViewById(R.id.list);
        recyclerView.setAdapter(adapter);


        return view;
    }

}

