package com.example.myapplication.canvas_bone;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Login.AccountActivity;
import com.example.myapplication.Login.LogOutTask;
//import com.example.myapplication.Login.LogOutTask.LogOutTaskListener;
import com.example.myapplication.Login.TokenSharedPreferences;
import com.example.myapplication.db.DBManager;
import com.example.myapplication.setting.MySetting;
//import com.example.myapplication.sns.SNSActivity;
//import com.example.myapplication.socialdrawhub.R;
import com.example.myapplication.spen.SPenSample;
import com.example.myapplication.ui.CoverFlow;
import com.example.myapplication.ui.GlobalSharedPreference;
//import com.example.myapplication.ui.MenuAdapter;
//import com.example.myapplication.ui.MovingButton;
//import com.example.myapplication.ui.SplashActivity;
import com.example.myapplication.utils.AnimationUtil;
import com.example.myapplication.utils.PushUtils;

public class MainActivity extends Activity implements OnClickListener
{

//    public static Activity activity;
//
//    private Cursor mCursor;
//    RelativeLayout mainLayout;
//    int preSelPos, curSelPos;
//
//    // ****************log in var****************
//    private TokenSharedPreferences tokenAccess = new TokenSharedPreferences(this);
//    private String getAccessToken = null;
//
//    // ***************log out var****************
//    private LogOutTask logOut;
//    DBManager dbManager = DBManager.getSingleTon();
//    List<String> titleArr;
//    List<String> description;
//    CoverFlow coverFlow;


//    // *************** button ****************
//    private ArrayList<MovingButton> buttons = null;
//    private static final int length = 280;
//    private static final int duration = 200;
//    private static final int sub_select_duration = 500;
//    boolean open = false;
//
//    public GlobalSharedPreference globalPref = GlobalSharedPreference.getSingleTon(this);
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        activity = MainActivity.this;
//
//        preSelPos = 0;
//        curSelPos = 0;
//        tokenAccess = new TokenSharedPreferences(MainActivity.this);
//        //tokenAccess.putValue("default", "0");
//
//        // TODO: CoverFlow
//        //		mainLayout = (RelativeLayout)findViewById(R.id.mainArea);
//        titleArr = new ArrayList<String>();// "Plus""새로운 폴더와 그림을 추가해주세요."
//        description = new ArrayList<String>();// "Plus""새로운 폴더와 그림을 추가해주세요."
//
//        coverFlow = (CoverFlow) findViewById(R.id.coverFlow);
//        coverFlow.setSpacing(-25);
//        coverFlow.setAnimationDuration(1000);
//        coverFlow.setMaxZoom(10);
//
//        final TextView menuTitle = (TextView) findViewById(R.id.MenuTitle);
//        final TextView menuDescription = (TextView) findViewById(R.id.MenuDescription);
//        Animation animFadein = AnimationUtils.loadAnimation(
//                getApplicationContext(), R.anim.fade_in);
//        menuTitle.startAnimation(animFadein);
//        menuDescription.startAnimation(animFadein);
//
//        coverFlow.setOnItemSelectedListener(new OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view,
//                                       int position, long id) {
//                // TODO Auto-generated method stub
//                Log.i("Select", position + "");
//                menuTitle.setText(titleArr.get(position));
//                menuDescription.setText(description.get(position));
//                curSelPos = position;
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> arg0) {
//                // TODO Auto-generated method stub
//
//            }
//        });
//
//        // *************** button ****************
//        buttons = new ArrayList<MovingButton>();
//
//        MovingButton button = (MovingButton)findViewById(R.id.add_folder);
//        button.setOnClickListener(this);
//        buttons.add(button);
//        button = (MovingButton)findViewById(R.id.edit_folder);
//        button.setOnClickListener(this);
//        buttons.add(button);
//        button = (MovingButton)findViewById(R.id.delete_folder);
//        button.setOnClickListener(this);
//        buttons.add(button);
//
//        Button originBtn = (Button)findViewById(R.id.origin);
//        originBtn.setClickable(true);
//        originBtn.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                open = !open;
//                if(coverFlow.getSelectedItemPosition() >= 3)
//                {
//                    for (int i = 0; i < buttons.size(); i++)
//                    {
//                        moveSubButton(i, open, length * (3.0f - i) / 3.0f);
//                    }
//                }
//                else
//                {
//                    moveSubButton(0, open, length * (3.0f - (buttons.size() - 1)) / 3.0f);
//                }
//            }
//        });
//
//        getAccessToken = tokenAccess.getValue("accessToken");
//        if (getAccessToken != null) {
//            startActivity(new Intent(this, SplashActivity.class));
//        }
//
//        //앱 처음 시작할 때 필요한 작업들 하기
//        String firstStart = globalPref.getValue("firstStart");
//        if(firstStart == null)
//        {
//            DBManager dbManager = DBManager.getSingleTon();
//            dbManager.insertMenu("Default", "Default Folder");
//            globalPref.putValue("firstStart", "1");
//        }
//        refreshCoverFlow(0);
//
//        PushUtils.registerDevice();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        // author : JHLee
//        getAccessToken = tokenAccess.getValue("accessToken");
//        if (getAccessToken == null)
//        {
//            startActivity(new Intent(this, AccountActivity.class));
//        }
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        //		facebook.authorizeCallback(requestCode, resultCode, data);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        Intent snsActivity;
//        switch (item.getItemId()) {
//            case R.id.debugLoginButton:
//                getAccessToken = tokenAccess.getValue("accessToken");
//
//                if (getAccessToken != null) {
//                    Toast.makeText(getBaseContext(), R.string.toast_message_15, Toast.LENGTH_SHORT).show();
//                } else {
//                    Intent newActivity = new Intent(MainActivity.this, AccountActivity.class);
//                    startActivity(newActivity);
//                }
//                return true;
//            case R.id.debugLogoutButton:
//                getAccessToken = null;
//                getAccessToken = tokenAccess.getValue("accessToken");
//
//                if (getAccessToken != null){
//
//                    logOut = new LogOutTask(MainActivity.this, getAccessToken);
//                    logOut.setListener(new LogOutTaskListener() {
//                        @Override
//                        public void onComplete() {
//                            startActivity(new Intent(MainActivity.this, AccountActivity.class));
//                        }
//                    });
//                    logOut.doTask();
//                }
//                return true;
//            case R.id.debugSnsButton:
//                snsActivity = new Intent(MainActivity.this,SNSActivity.class);
//                startActivity(snsActivity);
//                return true;
//            case R.id.debugSnsGridButton3:
//                getAccessToken = null;
//                getAccessToken = tokenAccess.getValue("accessToken");
//
//                if (getAccessToken != null) {
//                    Intent setting = new Intent(MainActivity.this, MySetting.class);
//                    startActivity(setting);
//                } else {
//                    Toast.makeText(getBaseContext(), R.string.mysetting_enter_error, Toast.LENGTH_SHORT).show();
//                }
//                return true;
//            //		case R.id.debugSnsUpload:
//            //			snsActivity = new Intent(MainActivity.this, SNSUpload.class);
//            //			startActivity(snsActivity);
//            //			return true;
//            case R.id.debugCanvas:
//                snsActivity = new Intent(MainActivity.this, SPenSample.class);
//                startActivity(snsActivity);
//                return true;
//            default:
//                return false;
//        }
//    }
//
//
//    public void refreshCoverFlow(int selIndex)
//    {
//        titleArr.clear();
//        description.clear();
//
//        titleArr.add("Social");
//        titleArr.add("Pictures");
//        titleArr.add("Setting");
//        for (HashMap<String, String> dataMap : dbManager.getMenu()) {
//            titleArr.add(dataMap.get("name"));
//        }
//
//        description.add("다른 사람들과 그림을 공유할 수 있습니다.");
//        description.add("좋아하는 그림을 저장할 수 있습니다.");
//        description.add("사용자 정보와 앱 관련 정보를 설정할 수 있습니다.");
//        for (HashMap<String, String> dataMap : dbManager.getMenu()) {
//            description.add(dataMap.get("description"));
//        }
//
//        coverFlow.setAdapter(new MenuAdapter(this));
//        coverFlow.setSelection(selIndex, true);
//    }
//
//    public void printHashKey() {
//        try {
//            Log.i("FacebookActivity", getPackageName());
//            PackageInfo info = getPackageManager().getPackageInfo("com.MadFactory.socialdrawhub", PackageManager.GET_SIGNATURES);
//
//            for (Signature signature : info.signatures) {
//                MessageDigest md = MessageDigest.getInstance("SHA");
//                md.update(signature.toByteArray());
//
//                // 페북에 적어야할 해쉬키.
//                String hash = Base64.encodeToString(md.digest(), Base64.DEFAULT);
//                Log.i("FacebookActivity", hash);
//            }
//        } catch (NameNotFoundException e) {
//            Log.i("FacebookActivity", "NameNotFoundException");
//        }
//        catch (NoSuchAlgorithmException e) {
//            Log.i("FacebookActivity", "NoSuchAlgorithmException");
//        }
//    }
//
//    public void moveSubButton(int index, boolean open, float _endY)
//    {
//        MovingButton view = buttons.get(index);
//        float endX = 0;
//        float endY = _endY;
//
//        AnimationSet animation = new AnimationSet(false);
//        Animation translate;
//
//        if(open)
//        {
//            translate = new TranslateAnimation(0.0f, endX, 0.0f, -endY);
//            translate.setDuration(duration);
//            view.setOffset(endX, -endY);
//        }
//        else
//        {
//            translate = new TranslateAnimation(endX, 0, -endY, 0);
//            translate.setDuration(duration);
//            view.setOffset(0, 0);
//        }
//
//        animation.setFillAfter(true);
//        animation.addAnimation(translate);
//        view.startAnimation(animation);
//    }
//
//    public void startSubMenuAnimation(final int index)
//    {
//        for(int i = 0 ; i < buttons.size(); i++)
//        {
//            final MovingButton view = buttons.get(i);
//            AnimationSet animation = new AnimationSet(false);
//
//            Animation translate = AnimationUtil.getTranslateAnimation(0.0f, view.getX_offset(),  0.0f, view.getY_offset(), 0);
//            view.setOffset(0, 0);
//
//            if(index == i)
//            {
//                Animation scale = AnimationUtil.getScaleAnimation(1.0f, 3.0f, 1.0f, 3.0f, sub_select_duration);
//                animation.addAnimation(scale);
//
//                animation.setAnimationListener(new AnimationListener() {
//
//                    @Override
//                    public void onAnimationStart(Animation animation) {
//
//                    }
//
//                    @Override
//                    public void onAnimationRepeat(Animation animation) {
//
//                    }
//
//                    @Override
//                    public void onAnimationEnd(Animation animation) {
//                        if(index == 0)
//                        {
//                            FolderUtils.addFolderDialog(MainActivity.this);
//                        }else if(index == 1)
//                        {
//                            int index = coverFlow.getSelectedItemPosition() - 3;
//                            ArrayList<HashMap<String, String>> arr = DBManager.getSingleTon().getMenu();
//                            HashMap<String, String> map = arr.get(index);
//                            FolderUtils.editFolderDialog(MainActivity.this, Long.parseLong(map.get("id")), index + 3);
//                        }else if(index == 2)
//                        {
//                            int index = coverFlow.getSelectedItemPosition() - 3;
//                            ArrayList<HashMap<String, String>> arr = DBManager.getSingleTon().getMenu();
//                            HashMap<String, String> map = arr.get(index);
//                            FolderUtils.deleteFolderDialog(MainActivity.this, Long.parseLong(map.get("id")), index + 3);
//                        }
//                    }
//                });
//            }
//
//            Animation alpha = AnimationUtil.getAlphaAnimation(1.0f, 0.0f, sub_select_duration);
//            animation.addAnimation(translate);
//            animation.addAnimation(alpha);
//            //	            animation.setFillAfter(true);
//            view.startAnimation(animation);
//
//
//            PushUtils.registerDevice();
//        }
//        open = false;
//    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
//            case R.id.add_folder:
//                startSubMenuAnimation(0);
//                break;
//            case R.id.edit_folder:
//                startSubMenuAnimation(1);
//                break;
//            case R.id.delete_folder:
//                startSubMenuAnimation(2);
//
//                break;
//            default:
//                break;
        }
    }
}
