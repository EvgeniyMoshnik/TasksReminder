package com.test.evgeniy.tasksreminder.Adapters;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.evgeniy.tasksreminder.Fragments.MainFragment;
import com.test.evgeniy.tasksreminder.Fragments.TaskFragment;
import com.test.evgeniy.tasksreminder.Fragments.Utils;
import com.test.evgeniy.tasksreminder.Model.Item;
import com.test.evgeniy.tasksreminder.Model.ModelTask;
import com.test.evgeniy.tasksreminder.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class CurrentTaskAdapter extends TaskAdapter {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_SEPARATOR = 1;

    public CurrentTaskAdapter(MainFragment mainFragment) {
        super(mainFragment);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType){
            case TYPE_ITEM:
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item, parent, false);
                TextView title = (TextView) v.findViewById(R.id.tvTaskTitle);
                TextView date = (TextView) v.findViewById(R.id.tvTaskDate);
                CircleImageView cviPriority = (CircleImageView) v.findViewById(R.id.cvTaskPriority);
                return new TaskViewHolder(v, title, date, cviPriority);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Item item = getItem(position);

        if (item.isTask()) {
            holder.itemView.setEnabled(true);
            final ModelTask task = (ModelTask) item;
            final TaskViewHolder taskViewHolder = (TaskViewHolder) holder;

            final View itemView = taskViewHolder.itemView;
            final Resources resources = itemView.getResources();

            taskViewHolder.title.setText(task.getTitle());
            if (task.getDate() != 0) {
                taskViewHolder.date.setText(Utils.getFullDate(task.getDate()));
            } else {
                taskViewHolder.date.setText(null);
            }
            itemView.setVisibility(View.VISIBLE);

            itemView.setBackgroundColor(resources.getColor(R.color.grey_50));

            taskViewHolder.title.setTextColor(resources.getColor(android.R.color.primary_text_light));
            taskViewHolder.date.setTextColor(resources.getColor(android.R.color.secondary_text_light));
            taskViewHolder.priority.setColorFilter(resources.getColor(task.getPriorityColor()));
            taskViewHolder.priority.setImageResource(R.drawable.ic_checkbox_blank_circle_white_48dp);

            taskViewHolder.priority.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    task.setStatus(ModelTask.STATUS_DONE);

                    itemView.setBackgroundColor(resources.getColor(R.color.grey_200));

                    taskViewHolder.title.setTextColor(resources.getColor(android.R.color.primary_text_dark));
                    taskViewHolder.date.setTextColor(resources.getColor(android.R.color.secondary_text_light_nodisable));
                    taskViewHolder.priority.setColorFilter(resources.getColor(task.getPriorityColor()));

                    ObjectAnimator flopIn = ObjectAnimator.ofFloat(taskViewHolder.priority, "rotationY", -180f, 0f);

                    flopIn.addListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {

                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    });

                }
            });

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
