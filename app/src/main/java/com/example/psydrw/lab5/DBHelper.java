package com.example.psydrw.lab5;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Daniel on 29/11/2017.
 */

public class DBHelper extends SQLiteOpenHelper
{

    public DBHelper(Context context) {
        super(context, "testDB", null, 2449);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE myList (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name VARCHAR(128), " +
                "colour VARCHAR(128)," +
                "test VARCHAR(128)" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS myList;");
        onCreate(db);

    }
}
