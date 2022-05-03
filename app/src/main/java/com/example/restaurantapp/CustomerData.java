package com.example.restaurantapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity (tableName = "customer_reg")
public class CustomerData implements Serializable {
    //create id column
    @PrimaryKey (autoGenerate = true)
    private int id;

    //Create text Column
    @ColumnInfo(name = "text")
    private String text;
    //generate getter ands setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
