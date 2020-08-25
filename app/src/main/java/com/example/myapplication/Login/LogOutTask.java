package com.example.myapplication.Login;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.example.myapplication.data.Status;
import com.example.myapplication.network.HttpManager;
import com.example.myapplication.utils.PushUtils;
//import com.android.volley.Response;
//import com.facebook.Session;

public class LogOutTask{

//    private Context mCtx;
//    private String token;
//    final Map<String, String> params = new HashMap<String, String>();
//
//    private TokenSharedPreferences token_pref;
//    LogOutTaskListener listener = null;
//
//    public LogOutTask(Context context, String token){
//
//        this.mCtx = context;
//        this.token = token;
//
//    }
//
//    public boolean doTask(){
//        params.put("accessToken", token);
//        token_pref = new TokenSharedPreferences(mCtx);
//
//        HttpManager.postURL(Status.URL_MOBILE_LOGOUT, params, new Response.Listener<String>(){
//
//            @Override
//            public void onResponse(String str) {
//                JSONObject result;
//                try{
//                    result = new JSONObject(str);
//                    String _result = result.getString("result");
//
//                    if(_result.equals("1")){
//                        token_pref.remove();
//                        token_pref.putValue("default", "1");
//
//                        if(Session.getActiveSession() != null)
//                            Session.getActiveSession().closeAndClearTokenInformation();
//
//                        PushUtils.unRegisterDevice();
//
//
//
//                        if(listener != null)
//                        {
//                            listener.onComplete();
//                        }
//                    } else{
//                    }
//                } catch (JSONException e){
//                    e.printStackTrace();
//
//                }
//            }
//        }, mCtx);
//
//        return true;
//    }
//
//    public interface LogOutTaskListener
//    {
//        public void onComplete();
//    }
//
//    public void setListener(LogOutTaskListener listener) {
//        this.listener = listener;
//    }
}

