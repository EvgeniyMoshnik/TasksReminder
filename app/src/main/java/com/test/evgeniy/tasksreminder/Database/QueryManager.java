package com.test.evgeniy.tasksreminder.Database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.test.evgeniy.tasksreminder.Model.ModelTask;

import java.util.ArrayList;
import java.util.List;


public class QueryManager {
    private SQLiteDatabase database;

    public QueryManager(SQLiteDatabase database) {
        this.database = database;
    }

    public ModelTask getTask() {
        ModelTask modelTask;
       // Cursor cursor = this.database.query(DBHelper.TASKS_TABLE, null, )

        modelTask = new ModelTask("123", 21, 22);
        return modelTask;
    }

    public List<ModelTask> getTasks (String selection, String[] selectionArgs, String orderBy) {
        List<ModelTask> tasks = new ArrayList<>();
        Cursor cursor = this.database.query(DBHelper.TASKS_TABLE, null, selection, selectionArgs, null, null, orderBy);
        if (cursor.moveToFirst()) {
            do {
                String title = cursor.getString(cursor.getColumnIndex(DBHelper.TASK_TITLE_COLUMN));
                long date = cursor.getLong(cursor.getColumnIndex(DBHelper.TASK_DATE_COLUMN));
                int status = cursor.getInt(cursor.getColumnIndex(DBHelper.TASK_STATUS_COLUMN));
                tasks.add(new ModelTask(title, date, status));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return tasks;
    }
}
