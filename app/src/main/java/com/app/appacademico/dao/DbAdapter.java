package com.app.appacademico.dao;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbAdapter {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "appacademico";

    private DatabaseCore mDatabaseCore;
    private SQLiteDatabase mDb;
    private static Context mCtx;

    private static class DatabaseCore extends SQLiteOpenHelper {
        @Override
        public void onOpen(SQLiteDatabase db) {
            super.onOpen(db);
            if (!db.isReadOnly()) {
                db.execSQL("PRAGMA foreign_keys=ON;");
            }
        }

        DatabaseCore(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            removeTables(db);

            createTables(db);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            removeTables(db);

            onCreate(db);
        }

        private void removeTables(SQLiteDatabase db) {
            db.execSQL("DROP TABLE IF EXISTS " + DisciplineDAO.TABLE);
            db.execSQL("DROP TABLE IF EXISTS " + TaskDAO.TABLE);
        }
        

        private void createTables(SQLiteDatabase db) {
            db.execSQL(DisciplineDAO.CREATE_TABLE);
            db.execSQL(TaskDAO.CREATE_TABLE);
        }
    }

    // Construtor da classe
    public DbAdapter(Context ctx) {
        mCtx = ctx;
    }

    public SQLiteDatabase open() throws SQLException {
        mDatabaseCore = new DatabaseCore(mCtx);
        mDb = mDatabaseCore.getWritableDatabase();
        return mDb;
    }

    public void close() {
        mDatabaseCore.close();
        mDb.close();
    }
}