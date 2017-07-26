package com.test.evgeniy.tasksreminder.Fragments;

import java.text.SimpleDateFormat;
import java.util.Locale;


public class Utils {

    public static String getDate(long date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy", Locale.ENGLISH);
        return dateFormat.format(date);
    }

    public static String getTime(long time) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH.mm", Locale.ENGLISH);
        return timeFormat.format(time);
    }
}
