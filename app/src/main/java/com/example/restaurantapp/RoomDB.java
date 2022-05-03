package com.example.restaurantapp;
import android.content.Context;

import androidx.room.Room;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

//Add database entity
@Database(entities = {MainData.class, CustomerData.class,ImageData.class}, version = 3, exportSchema = false)
@TypeConverters({ImageBitmapString.class})
public abstract class RoomDB extends RoomDatabase {
    //create database instance
    private static RoomDB database;
    //Define database name
    private static String DATABASE_NAME = "db1";

    public synchronized static RoomDB getInstance(Context context)
    {
        //Check Condition
        if(database == null)
        {
            //When database is null
            //Initialize database
            database = Room.databaseBuilder(context.getApplicationContext()
                    ,RoomDB.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return database;
    }

    //create Dao
    public abstract MainDao mainDao();
    //create customer dao
    public abstract CustomerDao customerDao();
    //create image dao
    public abstract ImageDao imageDao();

}
