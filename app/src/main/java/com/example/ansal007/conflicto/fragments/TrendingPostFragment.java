package com.example.ansal007.conflicto.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ansal007.conflicto.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TrendingPostFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TrendingPostFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrendingPostFragment extends Fragment {

    private View view;
    private ViewGroup container;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.fragment_trending_post, null);
        this.container = container;
        return view;
    }
}
