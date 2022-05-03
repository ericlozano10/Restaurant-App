package com.example.restaurantapp;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CustomerDao {
    //insert query
    @Insert(onConflict = REPLACE)
    void insert(CustomerData customerData);

    //Delete query
    @Delete
    void delete(CustomerData customerData);

    //Delete all Query
    @Delete
    void reset(List<CustomerData> customerData);

    //Update Query
    @Query("UPDATE customer_reg SET text = :sText WHERE ID = :sID ")
    void update(int sID, String sText);

    //Get All data query
    @Query("SELECT * FROM customer_reg")
    List<CustomerData> getAll();

}
