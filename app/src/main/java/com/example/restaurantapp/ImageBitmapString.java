package com.example.restaurantapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.room.TypeConverter;

import java.io.ByteArrayOutputStream;

public class ImageBitmapString {


    @TypeConverter
    public static byte [] getStringFromBitmap(Bitmap bitmapPicture)
    {
        ByteArrayOutputStream byteArrayBitmapStream = new ByteArrayOutputStream();
        bitmapPicture.compress(Bitmap.CompressFormat.PNG, 0, byteArrayBitmapStream);
        byte[] b = byteArrayBitmapStream.toByteArray();
        return b;
    }

    @TypeConverter
    public static Bitmap getBitmapFromStr(byte [] arr)
    {
        return BitmapFactory.decodeByteArray(arr,0,arr.length);
    }

}
