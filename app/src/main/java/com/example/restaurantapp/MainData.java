package com.example.restaurantapp;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

import androidx.room.Entity;

import java.io.Serializable;

@Entity (tableName = "table_name")
public class MainData implements Serializable {
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
