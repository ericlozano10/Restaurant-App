package com.example.restaurantapp;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

import androidx.room.Entity;

import java.io.Serializable;

@Entity (tableName = "Images")
public class ImageData implements Serializable {
    //create id column
    @PrimaryKey (autoGenerate = true)
    //@ColumnInfo(name = "image_id")
    private int id;

    //Create text Column
    @ColumnInfo(name = "text")
    private String text;

   public byte[] getImages()
   {
       return images;
   }
   public void setImages(byte[] images)
   {
        this.images = images;
   }
   @ColumnInfo(name = "imageList", typeAffinity = ColumnInfo.BLOB)
   private byte [] images;

   public int getId()
   {
       return id;
   }

   public void setId(int id)
   {
       this.id = id;
   }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
