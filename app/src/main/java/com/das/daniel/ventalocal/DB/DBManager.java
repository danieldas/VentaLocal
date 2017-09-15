package com.das.daniel.ventalocal.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Daniel on 14/09/2017.
 */
public abstract class DBManager {
    private DBHelper dbHelper;
    private SQLiteDatabase db;


    public DBManager(Context context) {
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }


    public DBHelper getDbHelper() {
        return dbHelper;
    }

    public void setDbHelper(DBHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    public void setDb(SQLiteDatabase db) {
        this.db = db;
    }
}
