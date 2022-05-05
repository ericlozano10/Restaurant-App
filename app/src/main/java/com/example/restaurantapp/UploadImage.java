package com.example.restaurantapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;
import androidx.room.RoomDatabase;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.util.ArrayList;

public class UploadImage extends AppCompatActivity{

    Button btnGet, btnSave;
    ImageView imageView;
    Bitmap bitmap = null;
    ImageView defaultImage;
    //constant to compare
    //the activity result
    int SELECT_PICTURE = 200;
    ImageBool pic;
    private ArrayList<Object> bitMaps;
    byte [] imageSources;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_image);
        imageView = findViewById(R.id.image);


    }

    public void upload(View view)
    {
        loadImagesFromGallery();
    }

    public void save(View view)
    {
        ImageData image = new ImageData();
        image.setImages(ImageBitmapString.getStringFromBitmap(bitmap));
        RoomDB.getInstance(getApplicationContext()).imageDao().insert(image);
    }
    public void get(View view)
    {
        pic.setPic(true);
        startActivity(new Intent(UploadImage.this, NewInsertMenu.class));
    }

    private void loadImagesFromGallery()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK)
        {
            if(requestCode == SELECT_PICTURE)
            {
                //get url of the image from data
                Uri selectedImageUri = data.getData();
                if(null != selectedImageUri)
                {
                    imageView.setImageURI(selectedImageUri);
                    try
                    {
                        bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImageUri);
                        imageView.setImageBitmap(bitmap);
                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}