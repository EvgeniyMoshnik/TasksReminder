package com.test.evgeniy.tasksreminder.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.evgeniy.tasksreminder.Adapters.DoneTaskAdapter;
import com.test.evgeniy.tasksreminder.Database.DBHelper;
import com.test.evgeniy.tasksreminder.Model.ModelTask;
import com.test.evgeniy.tasksreminder.R;

import java.util.ArrayList;
import java.util.List;


public class DoneTaskFragment extends TaskFragment {


    OnTaskRestoreListener onTaskRestoreListener;

    public DoneTaskFragment() {
    }

    public interface OnTaskRestoreListener {
        void onTaskRestore(ModelTask modelTask);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try{
            onTaskRestoreListener = (OnTaskRestoreListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + "must implement OnTaskRestoreListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_done_task, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view_done_tasks);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new DoneTaskAdapter(this);
        recyclerView.setAdapter(adapter);

        return v;
    }

    @Override
    public void findTasks(String title) {

        adapter.removeAllItems();
        List<ModelTask> tasks = new ArrayList<>();
        tasks.addAll(activity.dbHelper.query().getTasks(DBHelper.SELECTION_LIKE_TITLE + " AND " + DBHelper.SELECTION_STATUS,
                new String[]{"%" + title + "%",Integer.toString(ModelTask.STATUS_DONE)}, DBHelper.TASK_DATE_COLUMN ));
        for (int i = 0; i < tasks.size(); i++) {
            addTask(tasks.get(i), false);
        }
    }

    @Override
    public void addTaskFromDB() {
        adapter.removeAllItems();
        List<ModelTask> tasks = new ArrayList<>();
        tasks.addAll(activity.dbHelper.query().getTasks(DBHelper.SELECTION_STATUS,
                new String[]{Integer.toString(ModelTask.STATUS_DONE)}, DBHelper.TASK_DATE_COLUMN ));
        for (int i = 0; i < tasks.size(); i++) {
            addTask(tasks.get(i), false);
        }
    }

    @Override
    public void moveTask(ModelTask modelTask) {
        if (modelTask.getDate() != 0) {
            alarmHelper.removeAlarm(modelTask.getTimeStamp());
        }
        onTaskRestoreListener.onTaskRestore(modelTask);
    }
}
