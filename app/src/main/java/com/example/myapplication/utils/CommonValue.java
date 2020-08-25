package com.example.myapplication.utils;

import android.util.DisplayMetrics;

public class CommonValue {
    DisplayMetrics displaymetrics = new DisplayMetrics();
    public static int windowWidth = MyApplication.getAppContext().getResources().getDisplayMetrics().widthPixels;
    public static int windowHeight = MyApplication.getAppContext().getResources().getDisplayMetrics().heightPixels;
    public static int menuWidth = MyApplication.getAppContext().getResources().getDisplayMetrics().widthPixels - 100;
}
