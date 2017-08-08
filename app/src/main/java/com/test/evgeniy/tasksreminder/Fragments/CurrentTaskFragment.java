package com.test.evgeniy.tasksreminder.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.evgeniy.tasksreminder.Adapters.CurrentTaskAdapter;
import com.test.evgeniy.tasksreminder.Model.ModelTask;
import com.test.evgeniy.tasksreminder.R;


public class CurrentTaskFragment extends TaskFragment {


  //  @Override
  //  public void onCreate(@Nullable Bundle savedInstanceState) {
 //       super.onCreate(savedInstanceState);
  //  }

    OnTaskDoneListener onTaskDoneListener;

    public CurrentTaskFragment() {
    }

    public interface OnTaskDoneListener {
        void onTaskDone(ModelTask modelTask);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            onTaskDoneListener = (OnTaskDoneListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnTaskDoneListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_current_task, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view_current_tasks);
       // recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new CurrentTaskAdapter(this);
        recyclerView.setAdapter(adapter);
        return v;
    }

    @Override
    public void moveTask(ModelTask modelTask) {
        onTaskDoneListener.onTaskDone(modelTask);
    }
}
