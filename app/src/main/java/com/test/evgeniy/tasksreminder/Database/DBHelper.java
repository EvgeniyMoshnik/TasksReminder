package com.test.evgeniy.tasksreminder.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.test.evgeniy.tasksreminder.Model.ModelTask;



public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "reminder_database";
    public static final int DATABASE_VERSION = 1;

    public static final String TASKS_TABLE = "tasks_table";

    public static final String TASK_TITLE_COLUMN = "task_title";
    public static final String TASK_DATE_COLUMN = "task_date";
    public static final String TASK_PRIORITY_COLUMN = "task_priority";
    public static final String TASK_STATUS_COLUMN = "task_status";
    public static final String TASK_TIME_STAMP_COLUMN = "task_time_stamp";

    private static final String TASKS_TABLE_CREATE_SCRIPT = "CREATE TABLE " + TASKS_TABLE
            + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + TASK_TITLE_COLUMN + " TEXT NOT NULL, "
            + TASK_DATE_COLUMN + " LONG, " + TASK_PRIORITY_COLUMN + " INTEGER, "
            + TASK_STATUS_COLUMN + " INTEGER, " + TASK_TIME_STAMP_COLUMN + " LONG);";

    public static final String SELECTION_STATUS = TASK_STATUS_COLUMN + " = ?";

    public static final String SELECTION_TIME_STAMP = TASK_TIME_STAMP_COLUMN + " = ?";

    private QueryManager queryManager;
    private UpdateManager updateManager;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        queryManager = new QueryManager(getReadableDatabase());
        updateManager = new UpdateManager(getWritableDatabase());
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TASKS_TABLE_CREATE_SCRIPT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TASKS_TABLE);
        onCreate(db);
    }

    public QueryManager query() {

        return queryManager;
    }

    public UpdateManager update() {

        return updateManager;
    }

    public void saveTask(ModelTask modelTask) {
        ContentValues cv = new ContentValues();

        cv.put(TASK_TITLE_COLUMN, modelTask.getTitle());
        cv.put(TASK_DATE_COLUMN, modelTask.getDate());
        cv.put(TASK_PRIORITY_COLUMN, modelTask.getPriority());
        cv.put(TASK_STATUS_COLUMN, modelTask.getStatus());
        cv.put(TASK_TIME_STAMP_COLUMN, modelTask.getTimeStamp());

        getWritableDatabase().insert(TASKS_TABLE, null, cv);


    }

    public void removeTask(long timeStamp) {
        getWritableDatabase().delete(TASKS_TABLE, SELECTION_TIME_STAMP, new String[]{Long.toString(timeStamp)});
    }

}
