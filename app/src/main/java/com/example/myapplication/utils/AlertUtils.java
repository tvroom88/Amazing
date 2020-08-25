package com.example.myapplication.utils;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.EditText;

import com.example.myapplication.canvas_bone.MainActivity;
import com.example.myapplication.db.DBManager;
import com.example.myapplication.socialdrawhub.R;

public class AlertUtils {
    public static void showAlert()
    {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MyApplication.getAppContext());
        alertDialog.setTitle("프로필 수정").setMessage("");
//		alertDialog.setView(plusBtn);
        alertDialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
            }
        });
        alertDialog.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {

            }
        });
        alertDialog.show();
    }
}