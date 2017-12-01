package com.example.psydrw.lab5;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    DBHelper dbHelper;
    SQLiteDatabase db;

    EditText nameText;
    EditText colourText;
    EditText dbView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(getApplicationContext(), List.class));

        nameText = (EditText) findViewById(R.id.editText);
        colourText = (EditText) findViewById(R.id.editText2);
        dbView = (EditText) findViewById(R.id.editText4);


        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();
    }

    public void onSave(View view)
    {
        String name = nameText.getText().toString();
        String colour = colourText.getText().toString();

        db.execSQL("INSERT INTO myList (name, colour) " +
                "VALUES " +
                "('" + name + "','" + colour + "');");



        Cursor c = db.query("myList", new String[] { "_id", "name", "colour"},
                null, null, null, null, null);
        if(c.moveToFirst())
        {
            dbView.setText("");

            while (c.isAfterLast() == false)
            {
                int id2 = c.getInt(0);
                String num2 = c.getString(1);
                dbView.append(num2);
                c.moveToNext();
            }
            c.close();
        }
    }
}
