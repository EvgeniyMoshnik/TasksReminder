package com.test.evgeniy.tasksreminder.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.evgeniy.tasksreminder.Fragments.TaskFragment;
import com.test.evgeniy.tasksreminder.Fragments.Utils;
import com.test.evgeniy.tasksreminder.Model.Item;
import com.test.evgeniy.tasksreminder.Model.ModelTask;
import com.test.evgeniy.tasksreminder.R;

import java.util.ArrayList;
import java.util.List;


public class CurrentTaskAdapter extends TaskAdapter {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_SEPARATOR = 1;

    public CurrentTaskAdapter(TaskFragment taskFragment) {
        super(taskFragment);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType){
            case TYPE_ITEM:
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item, parent, false);
                TextView title = (TextView) v.findViewById(R.id.tvTaskTitle);
                TextView date = (TextView) v.findViewById(R.id.tvTaskDate);
                return new TaskViewHolder(v, title, date);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Item item = getItem(position);

        if (item.isTask()) {
            holder.itemView.setEnabled(true);
            ModelTask task = (ModelTask) item;
            TaskViewHolder taskViewHolder = (TaskViewHolder) holder;

            taskViewHolder.title.setText(task.getTitle());
            if (task.getDate() != 0) {
                taskViewHolder.date.setText(Utils.getFullDate(task.getDate()));
            }
        }



    }
    @Override
    public int getItemViewType(int position) {
        if (getItem(position).isTask()){
            return TYPE_ITEM;
        } else {
            return TYPE_SEPARATOR;
        }
    }

}
