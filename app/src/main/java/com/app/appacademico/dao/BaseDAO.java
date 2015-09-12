package com.app.appacademico.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class BaseDAO {

    protected static SQLiteDatabase mDb;
    protected static Context context;
    private static DbAdapter dbAdapter;

    public BaseDAO(Context ctx) {
        context = ctx;
    }

    public synchronized void open() {
        if (mDb == null || (mDb != null && !mDb.isOpen())) {
            dbAdapter = new DbAdapter(context);
            mDb = dbAdapter.open();
        }

    }

    public synchronized void close() {
        if (mDb != null && mDb.isOpen()) {
            dbAdapter.close();
            mDb.close();
        }
    }
}
