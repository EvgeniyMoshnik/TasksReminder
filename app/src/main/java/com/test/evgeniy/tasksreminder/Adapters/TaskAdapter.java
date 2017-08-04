package com.test.evgeniy.tasksreminder.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.test.evgeniy.tasksreminder.Fragments.TaskFragment;
import com.test.evgeniy.tasksreminder.Model.Item;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public abstract class TaskAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Item> items;

    private TaskFragment taskFragment;

    public TaskAdapter(TaskFragment taskFragment) {
        items = new ArrayList<>();
        this.taskFragment = taskFragment;
    }

    public Item getItem(int position){
        return items.get(position);
    }

    public void addItem (Item item) {
        items.add(item);
        notifyItemInserted(getItemCount() - 1);
    }

    public void addItem(int location, Item item) {
        items.add(location, item);
        notifyItemInserted(location);
    }

    public void removeItem(int location) {
        if(location >= 0 && location <= getItemCount() - 1) {
            items.remove(location);
            notifyItemRemoved(location);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    protected class TaskViewHolder extends RecyclerView.ViewHolder {

        protected TextView title;
        protected TextView date;
        protected CircleImageView circleImageView;

        protected TaskViewHolder(View itemView, TextView title, TextView date, CircleImageView circleImageView) {
            super(itemView);
            this.title = title;
            this.date = date;
            this.circleImageView = circleImageView;
        }

    }

    public TaskFragment getTaskFragment() {
        return taskFragment;
    }
}
