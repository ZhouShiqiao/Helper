package com.fjnu.edu.helper.datebase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by ZhouShiqiao on 2017/5/30 0030.
 */

public class DBManager {
    private DBHelper helper;
    protected SQLiteDatabase db;

    public DBManager(Context context) {
        helper = new DBHelper(context);
        db = helper.getWritableDatabase();
    }
}
