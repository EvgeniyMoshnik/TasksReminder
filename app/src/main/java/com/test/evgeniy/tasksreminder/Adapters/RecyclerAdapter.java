package com.test.evgeniy.tasksreminder.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.evgeniy.tasksreminder.R;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
   private String[] mDatasetTasks;
   private String[] mDatasetTimeBefore;
   private String[] mDatasetTime;



    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTvTasks;
        TextView mTvTimeBefore;
        TextView mTvTime;

        public ViewHolder(View itemView) {
            super(itemView);
            mTvTasks = (TextView) itemView.findViewById(R.id.checkedTextView_task);
            mTvTimeBefore = (TextView) itemView.findViewById(R.id.tv_time_before);
            mTvTime = (TextView) itemView.findViewById(R.id.tv_time_task);
        }
    }

    public RecyclerAdapter(String[] DatasetTasks, String[] DatasetTimeBefore, String[] DatasetTime) {
        mDatasetTasks = DatasetTasks;
        mDatasetTimeBefore = DatasetTimeBefore;
        mDatasetTime = DatasetTime;
    }
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {

        holder.mTvTasks.setText(mDatasetTasks[position]);
        holder.mTvTimeBefore.setText(mDatasetTimeBefore[position]);
        holder.mTvTime.setText(mDatasetTime[position]);
    }

    @Override
    public int getItemCount() {
        return mDatasetTasks.length;
    }
}
