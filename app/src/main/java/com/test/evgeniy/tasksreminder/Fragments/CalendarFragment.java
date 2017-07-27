package com.test.evgeniy.tasksreminder.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.evgeniy.tasksreminder.R;


public class CalendarFragment extends Fragment {

    private RecyclerView rvDoneTask;
    private RecyclerView.LayoutManager layoutManager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_calendar, container, false);

        //rvDoneTask = (RecyclerView) container.findViewById(R.id.recycler_view_done_tasks);
        //layoutManager = new LinearLayoutManager(getContext());
      //  rvDoneTask.setLayoutManager(layoutManager);



        return v;
    }
}
