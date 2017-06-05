package com.test.evgeniy.tasksreminder.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.evgeniy.tasksreminder.Adapters.RecyclerAdapter;
import com.test.evgeniy.tasksreminder.R;


public class FragmentMain extends Fragment {

    String[] task = {"Bread", "Shower", "Study"};
    String[] timeBefore = {"33-22", "22-11", "90-22"};
    String[] time = {"0401", "5544", "9992"};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_main, container);

        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view_tasks);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        RecyclerView.Adapter adapter = new RecyclerAdapter(task, timeBefore, time);
        recyclerView.setAdapter(adapter);
        return v;
    }
}
