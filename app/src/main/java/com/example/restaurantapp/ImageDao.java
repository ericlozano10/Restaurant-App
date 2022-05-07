package com.example.restaurantapp;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Query;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;

import java.util.List;

@Dao
public interface ImageDao {
    //insert query
    @Insert
    void insert(ImageData...images);

    //Get All data query
    @Query("SELECT * FROM Images")
    List<ImageData> getAllImage();

    //Update Query
    @Query("UPDATE images SET text = :sText WHERE ID = :sID ")
    void update(int sID, String sText);
}
