package com.test.evgeniy.tasksreminder.Database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.test.evgeniy.tasksreminder.Model.ModelTask;

import java.util.ArrayList;
import java.util.List;


public class QueryManager {
    private SQLiteDatabase database;

    public QueryManager(SQLiteDatabase database)
    {
        this.database = database;
    }

//    public ModelTask getTask() {
 //       ModelTask modelTask;
       // Cursor cursor = this.database.query(DBHelper.TASKS_TABLE, null, )

 //       modelTask = new ModelTask();
  //      return modelTask;
  //  }

    public List<ModelTask> getTasks (String selection, String[] selectionArgs, String orderBy) {
        List<ModelTask> tasks = new ArrayList<>();
        Cursor cursor = database.query(DBHelper.TASKS_TABLE, null, selection, selectionArgs, null, null, orderBy);
        if (cursor.moveToFirst()) {
            do {
                String title = cursor.getString(cursor.getColumnIndex(DBHelper.TASK_TITLE_COLUMN));
                long date = cursor.getLong(cursor.getColumnIndex(DBHelper.TASK_DATE_COLUMN));
                int priority = cursor.getInt(cursor.getColumnIndex(DBHelper.TASK_PRIORITY_COLUMN));
                int status = cursor.getInt(cursor.getColumnIndex(DBHelper.TASK_STATUS_COLUMN));
                long timeStamp = cursor.getLong(cursor.getColumnIndex(DBHelper.TASK_TIME_STAMP_COLUMN));

                ModelTask modelTask = new ModelTask(title, date, priority, status, timeStamp);
                tasks.add(modelTask);

            } while (cursor.moveToNext());
        }
        cursor.close();
        return tasks;
    }
}
