package com.example.myapplication.utils;

import android.content.Context;
import android.util.Log;

import com.example.myapplication.push.PushSettings;
import com.google.android.gcm.GCMRegistrar;

public class PushUtils {


    public static void registerDevice()
    {
        Log.i("Push", "registerDevice");
        Context mContext = MyApplication.getAppContext();
        GCMRegistrar.checkDevice(mContext);
        GCMRegistrar.checkManifest(mContext);
        String regId = GCMRegistrar.getRegistrationId(mContext);
        GCMRegistrar.register(mContext, PushSettings.GCM_SENDER);
    }

    public static void unRegisterDevice()
    {
        Log.i("Push", "unRegisterDevice");
        Context mContext = MyApplication.getAppContext();
        GCMRegistrar.checkDevice(mContext);
        GCMRegistrar.checkManifest(mContext);
        String regId = GCMRegistrar.getRegistrationId(mContext);
        GCMRegistrar.unregister(mContext);
    }
}
