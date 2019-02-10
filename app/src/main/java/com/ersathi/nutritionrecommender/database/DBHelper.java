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

        final String SQL_CREATE_DUMMY_FOOD_TABLE =
                "CREATE TABLE dummy_foods (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "name VARCHAR(50) NOT NULL, " +
                        "thumbImageURI VARCHAR(100) NOT NULL, " +
                        "description VARCHAR(100) NOT NULL, " +
                        "calories DOUBLE NOT NULL);";

        db.execSQL(SQL_CREATE_DUMMY_FOOD_TABLE);

        addFewData(db);
    }

    private void addFewData(SQLiteDatabase db) {
        String sql = "INSERT INTO medicines (name, timesInADay, numberOfDays, reminderTimes ) \n" +
                "VALUES \n" +
                "('Paracetamol', 3, 5, '04000800'),('Acetamenophene', 3, 5, '04000800'),('Maalox', 3, 5, '04000800'),('Loperamide', 3, 5, '04000800')";
        db.execSQL(sql);

        sql = "INSERT INTO dummy_foods (name, thumbImageURI, description, calories ) \n" +
                "VALUES \n" +
                "('Popcorn', 'https://www.landolakes.com/RecipeManagementSystem/media/Recipe-Media-Files/Recipes/Retail/DesktopImages/4303.jpg?ext=.jpg', 'Bhuteko Makai', 100), " +
                "('Fruits', 'https://cdn.24.co.za/files/Cms/General/d/7635/c9cb6d629e5e40318d2b120ed91c9b2b.png', 'Apple, Banana, Orange etc.', 200), " +
                "('Meat', 'https://recipegeek.com/sites/default/files/styles/large/public/cover_photos/recipegeek-the_pros_and_cons_of_organic_meat.jpg?itok=daKUYJ1g', 'Pork, Beef, Mutton, Chicken', 400), " +
                "('Popcorn', 'https://www.landolakes.com/RecipeManagementSystem/media/Recipe-Media-Files/Recipes/Retail/DesktopImages/4303.jpg?ext=.jpg', 'Bhuteko Makai', 100), " +
                "('Fruits', 'https://cdn.24.co.za/files/Cms/General/d/7635/c9cb6d629e5e40318d2b120ed91c9b2b.png', 'Apple, Banana, Orange etc.', 200), " +
                "('Meat', 'https://recipegeek.com/sites/default/files/styles/large/public/cover_photos/recipegeek-the_pros_and_cons_of_organic_meat.jpg?itok=daKUYJ1g', 'Pork, Beef, Mutton, Chicken', 400), " +
                "('Butter', 'https://www.nifeislife.com/images/300/M00905.jpg', 'Vegeterian', 540);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
