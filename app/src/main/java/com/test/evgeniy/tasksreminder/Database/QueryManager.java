package com.test.evgeniy.tasksreminder.Database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.test.evgeniy.tasksreminder.Model.ModelTask;

import java.util.List;


public class QueryManager {
    private SQLiteDatabase database;

    public QueryManager(SQLiteDatabase database) {
        this.database = database;
    }

    public ModelTask getTask() {
        ModelTask modelTask;
       // Cursor cursor = this.database.query(DBHelper.TASKS_TABLE, null, )

        return modelTask;
    }

    public List<ModelTask> getTasks () {

        return ;
    }
}
