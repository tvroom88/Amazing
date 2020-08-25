package com.example.myapplication.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ImageUtils {
    public static Bitmap readImageFromSDCard(String pathName)
    {
        return BitmapFactory.decodeFile(pathName);
    }

    public static void saveImage()
    {

    }
}
