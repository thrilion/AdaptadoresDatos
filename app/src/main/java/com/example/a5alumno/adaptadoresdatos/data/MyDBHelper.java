package com.example.a5alumno.adaptadoresdatos.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by A5Alumno on 28/11/2016.
 */

public class MyDBHelper extends SQLiteOpenHelper {

    private static final String CREATE_DB_TABLE = "CREATE TABLE " + ParamsDB.DB_NAME + " (" +
            ParamsDB._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            ParamsDB.STUDENT_NAME + " TEXT, " +
            ParamsDB.STUDENT_AGE + " INTEGER);";


    public MyDBHelper(Context context) {
        super(context, ParamsDB.DB_NAME, null, ParamsDB.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MyDBHelper.CREATE_DB_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) { }
}
