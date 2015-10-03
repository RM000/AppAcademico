package com.app.appacademico.dao;

import android.content.ContentValues;
import android.content.Context;

import com.app.appacademico.model.Task;

public class TaskDAO extends BaseDAO {
    public static final String TABLE = "task";

    public static final String ID = "_id";
    public static final String ID_DISCIPLINE = "idDiscipline";
    public static final String NAME = "name";
    public static final String TYPE = "type";
    public static final String VALUE = "value";
    public static final String GRADE = "grade";

    public static final String CREATE_TABLE  = "CREATE TABLE "
            + TABLE + "("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
            + ID_DISCIPLINE + "INTEGER FOREIGN KEY NOT NULL, "
            + NAME + " TEXT NOT NULL, "
            + TYPE + " INT NOT NULL, "
            + VALUE + " REAL NOT NULL, "
            + GRADE + " REAL"
            + ");";

    public TaskDAO(Context ctx) {
        super(ctx);
    }

    public void newDiscipline(Task t) {
        mDb.insert(TABLE, null, this.getValues(t));
    }

    public void updateDiscipline(Task t) {
        mDb.update(TABLE, this.getValues(t), "_id = ?", new String[]{"" + t.getId()});
    }

    public void deleteDiscipline(Task t) {
        mDb.delete(TABLE, "_id ="+ t.getId(), null);
    }

    public void listTasksFromDiscipline(int id_discipline) {
        // TODO

    }

    private ContentValues getValues(Task t){
        ContentValues values = new ContentValues();

        values.put(ID_DISCIPLINE, t.getIdDiscipline());
        values.put(NAME, t.getName());
        values.put(TYPE, t.getType());
        values.put(VALUE, t.getType());
        values.put(GRADE, t.getGrade());

        return values;
    }
}
