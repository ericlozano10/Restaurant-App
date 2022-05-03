package com.example.restaurantapp;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Query;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;

import java.util.List;

@Dao
public interface MainDao {
    //insert query
    @Insert(onConflict = REPLACE)
    void insert(MainData mainData);

    //Delete query
    @Delete
    void delete(MainData mainData);

    //Delete all Query
    @Delete
    void reset(List<MainData> mainData);

    //Update Query
    @Query("UPDATE table_name SET text = :sText WHERE ID = :sID ")
    void update(int sID, String sText);

    //Get All data query
    @Query("SELECT * FROM table_name")
    List<MainData> getAll();

}
