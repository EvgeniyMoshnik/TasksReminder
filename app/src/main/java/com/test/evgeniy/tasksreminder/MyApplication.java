package com.test.evgeniy.tasksreminder;

import android.app.Application;



public class MyApplication extends Application {

    private static boolean activityVisible;

    public static boolean isActivityVisible() {
        return activityVisible;
    }

    public static void activityResume() {
        activityVisible = true;
    }

    public static void activityPause() {
        activityVisible = false;
    }
}
