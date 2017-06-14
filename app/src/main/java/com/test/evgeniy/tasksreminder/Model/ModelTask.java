package com.test.evgeniy.tasksreminder.Model;



public class ModelTask {

    public static final int STATUS_CURENT = 1;
    public static final int STATUS_DONE = 2;
    public static final int STATUS_OVERDUE = 0;

    private String title;
    private long date;
    private int status;

    public ModelTask(String title, long date, int status) {
        this.title = title;
        this.date = date;
        this.status = status;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
