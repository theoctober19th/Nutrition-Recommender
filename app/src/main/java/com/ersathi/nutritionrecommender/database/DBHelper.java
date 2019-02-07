package com.ersathi.nutritionrecommender.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "nutritionRecommender.db";
    public static final int DATABSE_VERSION = 1;


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABSE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        final String SQL_CREATE_MEDICINES_TABLE =
                "CREATE TABLE medicines (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                        "name VARCHAR(50) NOT NULL, " +
                                        "timesInADay INTEGER NOT NULL, " +
                                        "numberOfDays INTEGER NOT NULL, " +
                                        "reminderTimes VARCHAR(100) NOT NULL);";

        db.execSQL(SQL_CREATE_MEDICINES_TABLE);

        addFewData(db);
    }

    private void addFewData(SQLiteDatabase db) {
        String sql = "INSERT INTO medicines (name, timesInADay, numberOfDays, reminderTimes ) \n" +
                "VALUES \n" +
                "('Bikalpa', 3, 5, '04000800'),('Sankalpa', 3, 5, '04000800'),('Paroo', 3, 5, '04000800'),('Kendra', 3, 5, '04000800')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
