package com.test.evgeniy.tasksreminder.Model;



public class ModelTask implements Item {

    public static final int STATUS_CURENT = 1;
    public static final int STATUS_DONE = 2;
    public static final int STATUS_OVERDUE = 0;

    private String title;
    private long date;

    public ModelTask() {
    }

    public ModelTask(String title, long date) {
        this.title = title;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    @Override
    public boolean isTask() {
        return true;
    }
}
