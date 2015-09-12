package com.app.appacademico.dao;

import android.content.Context;

/**
 * Created by rander on 11/09/15.
 */
public class BaseDAO {
    protected static Context context;

    public BaseDAO(Context ctx) {
        context = ctx;
    }
}


