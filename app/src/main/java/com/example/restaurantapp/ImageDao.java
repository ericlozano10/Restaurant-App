package com.example.restaurantapp;

import static androidx.room.OnConflictStrategy.REPLACE;

import android.database.Cursor;
import android.media.Image;
import android.provider.MediaStore;

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

    //Select
    @Query("SELECT * FROM Images Where text = :food and ID = :sID")
    List<ImageData> getImageName(String food, int sID);

}
