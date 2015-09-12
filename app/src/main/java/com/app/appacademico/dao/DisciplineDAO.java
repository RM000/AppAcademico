package com.app.appacademico.dao;

import android.content.ContentValues;
import android.content.Context;

import com.app.appacademico.model.Discipline;

/**
 * Created by rander on 11/09/15.
 */
public class DisciplineDAO extends BaseDAO {
    public DisciplineDAO(Context ctx) {
        super(ctx);
    }

    public static final String TAG = "DisciplineDAO";

    public static final String TABLE = "discipline";

    public static final String ID = "_id";
    public static final String NAME = "name";
    public static final String TOTAL_POINTS = "totalPoints";
    public static final String MINIMUM_REQUIRED = "minimumRequired";

    public static final String CREATE_TABLE  = "CREATE TABLE "
            + TABLE + "(" + ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," + NAME
            + " TEXT NOT NULL," + TOTAL_POINTS + " INTEGER, "
            + MINIMUM_REQUIRED + " INTEGER"
            + ");";


    public void newDiscipline(Discipline d) {

        ContentValues values = new ContentValues();

        values.put(NAME, d.getName());
        values.put(TOTAL_POINTS, d.getTotalPoints());
        values.put(MINIMUM_REQUIRED, d.getMinimumRequired());

        mDb.insert(TABLE, null, values);
    }

    public void updateDiscipline(Discipline d) {

        ContentValues values = new ContentValues();

        values.put(NAME, d.getName());
        values.put(TOTAL_POINTS, d.getTotalPoints());
        values.put(MINIMUM_REQUIRED, d.getMinimumRequired());

        mDb.update(TABLE, values, "_id = ?", new String[]{"" + d.getId()});
    }

    public void deleteDiscipline(Discipline d) {
        mDb.delete(TABLE, "_id ="+ d.getId(), null);
    }

    public void listDisciplines(Discipline d) {
        //List<Discipline> list = new ArrayList<Discipline>();
        //String columns = new String[]{"_id", "name", "totalPoints", "minimumRequired" };
        //Cursor cursor = mDb.query(TABLE, columns, null, null, null, null, "name");
    }
}
