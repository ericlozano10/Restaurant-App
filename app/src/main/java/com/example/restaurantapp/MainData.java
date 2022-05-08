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

    //Create text Column
    @ColumnInfo(name = "price")
    private String price;

    //Create text Column
    @ColumnInfo(name = "description")
    private String description;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
