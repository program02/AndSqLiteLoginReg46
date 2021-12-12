package com.example.loginregr46;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
    SQLiteDatabase database;

    public DbHelper(@Nullable Context context) {
        super(context, "stdb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE student(id Integer PRIMARY KEY,name TEXT, email TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE  IF EXISTS student");
        onCreate(db);
    }

    public void insert(Student s) {
        database = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id", s.getId());
        cv.put("name", s.getName());
        cv.put("email", s.getEmail());
        cv.put("password", s.getPassword());
        database.insert("student", null, cv);
    }

    public Student login(String name, String password) {
        List<Student> list = new ArrayList<>();
        database = this.getReadableDatabase();
        Cursor c = database.rawQuery("SELECT * FROM student WHERE name='" + name + "' and password='" + password + "'", null);
        while (c.moveToNext()) {
            list.add(new Student(c.getInt(0), c.getString(1), c.getString(2), c.getString(3)));
        }
        if (list.size() > 0) {
            return list.get(0);
        } else return null;

    }
}
