package com.example.restaurantapp;

//import android.arch.persistence.room.Database;
//import android.arch.persistence.room.Room;
//import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import androidx.room.Room;
import androidx.room.Database;
import androidx.room.RoomDatabase;

//Add database entity
@Database(entities = {MainData.class, CustomerData.class}, version = 2, exportSchema = false)
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
    //customer dao
    public abstract CustomerDao customerDao();

}
