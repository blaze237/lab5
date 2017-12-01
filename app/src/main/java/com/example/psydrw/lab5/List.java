package com.example.psydrw.lab5;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class List extends AppCompatActivity
{
    DBHelper dbHelper;
    SQLiteDatabase db;
    SimpleCursorAdapter dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();


        Cursor cursor = db.query("myList", new String[] { "_id", "name", "colour"},
                null, null, null, null, null);

        String[] columns = new String[] {
                DBHelper.KEY_NAME,
        };
        int[] to = new int[] {
                R.id.name,
        };
        dataAdapter = new SimpleCursorAdapter(
                this, R.layout.db_item,
                cursor,
                columns,
                to,
                0);


        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setEmptyView(findViewById(R.id.empty));
        listView.setAdapter(dataAdapter);


    }



}
