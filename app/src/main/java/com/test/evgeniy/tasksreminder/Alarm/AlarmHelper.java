package com.test.evgeniy.tasksreminder.Alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.test.evgeniy.tasksreminder.Model.ModelTask;



public class AlarmHelper {

    private static AlarmHelper instance;
    private Context context;
    private AlarmManager alarmManager;

    public static AlarmHelper getInstance() {
        if (instance == null) {
            instance = new AlarmHelper();
        }
        return instance;
    }

    public void init(Context context) {
        this.context = context;
        alarmManager = (AlarmManager) context.getApplicationContext().getSystemService(Context.ALARM_SERVICE);
    }

    public void setAlarm (ModelTask modelTask) {

        Intent intent = new Intent(context, AlarmReceiver.class);
        intent.putExtra("title", modelTask.getTitle());
        intent.putExtra("time_stamp", modelTask.getTimeStamp());
        intent.putExtra("color", modelTask.getPriorityColor());

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,
        (int) modelTask.getTimeStamp(), intent, PendingIntent.FLAG_CANCEL_CURRENT);

        alarmManager.set(AlarmManager.RTC_WAKEUP, modelTask.getDate(), pendingIntent);
    }

    public void removeAlarm(long taskTimeStamp) {
        Intent intent = new Intent(context, AlarmReceiver.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,
                (int) taskTimeStamp, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        alarmManager.cancel(pendingIntent);
    }
}
