package com.example.myapplication.spen;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
//import com.MadFactory.socialdrawhub.R;
//import com.samsung.samm.common.SObjectStroke;
//import com.samsung.sdraw.AbstractSettingView;
//import com.samsung.sdraw.SettingView;
//import com.samsung.spen.settings.SettingStrokeInfo;
//import com.samsung.spensdk.applistener.SCanvasInitializeListener;
//import com.samsung.spensdk.applistener.SPenTouchListener;

public class SPenSample extends Activity {

//	private ArrayList<RelativeLayout> layoutList;
//	private ArrayList<MyScanvas> canvasList;
//	private ArrayList<ImageView> imageList;
//	private SettingView sv;
//
//	private RelativeLayout    spenMainLayout;
//	private LinearLayout    spenLayout;
//	private LinearLayout    gitLayout;
//	private LinearLayout layer=null;
//	private FrameLayout frame;
//	private LinearLayout mlayer;
//
//	private ImageView		mPenBtn;
//	private ImageView		mEraserBtn;
//	private ImageView		mTextBtn;
//	private ImageView		mUndoBtn;
//	private ImageView		mRedoBtn;
//	private ImageView		gitBtn;
//	private ImageView		uploadBtn;
//	private ImageView		layerBtn;
//
//	ImageView img1, img2, img3, img4, img5, img6;
//
//	Context context = this;
//
//	private String TAG = "SPenSample";
//
//	Boolean Open;
//	boolean isBarOpened;
//
//	ColorPicker myPicker;
//
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.spen_sample);
//
//		layoutList= new ArrayList<RelativeLayout>();
//		canvasList = new ArrayList<MyScanvas>();
//		imageList = new ArrayList<ImageView>();
//
//		frame = (FrameLayout) findViewById(R.id.frame);
//
//		newCanvas();
//		newCanvas();
//		newCanvas();
//
//		spenMainLayout = (RelativeLayout)findViewById(R.id.spen_main);
//		spenLayout = (LinearLayout)findViewById(R.id.spen_sample);
////		gitLayout = (LinearLayout)findViewById(R.id.git_history_scroll);
//
//		DisplayMetrics displaymetrics = new DisplayMetrics();
//		getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
//
//		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//
///*		mlayer = (LinearLayout) inflater.inflate(R.layout.menu_bar, null);
//		FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT
//				, LinearLayout.LayoutParams.MATCH_PARENT, Gravity.RIGHT);
//		mlayer.setLayoutParams(params);
//		frame.addView(mlayer);*/
//		/*		img1= (ImageView) findViewById(R.id.bar_1);
//		img2= (ImageView) findViewById(R.id.bar_2);
//		img3= (ImageView) findViewById(R.id.bar_3);
//		img4= (ImageView) findViewById(R.id.bar_4);
//		img5= (ImageView) findViewById(R.id.bar_5);
//		img6= (ImageView) findViewById(R.id.bar_6);
//		img1.setOnClickListener(menu);
//		img2.setOnClickListener(menu);
//		img3.setOnClickListener(menu);
//		img4.setOnClickListener(menu);
//		img5.setOnClickListener(menu);
//		img6.setOnClickListener(menu);*/
//
//
//		mPenBtn = (ImageView) findViewById(R.id.penBtn);
//		mPenBtn.setOnClickListener(penClickListener);
//		mEraserBtn = (ImageView) findViewById(R.id.eraseBtn);
//		mEraserBtn.setOnClickListener(eraseClickListener);
//		mTextBtn = (ImageView) findViewById(R.id.textBtn);
//		mTextBtn.setOnClickListener(mBtnClickListener);
//		mUndoBtn = (ImageView) findViewById(R.id.undoBtn);
//		mUndoBtn.setOnClickListener(undoNredoBtnClickListener);
//		mRedoBtn = (ImageView) findViewById(R.id.redoBtn);
//		mRedoBtn.setOnClickListener(undoNredoBtnClickListener);
//		gitBtn = (ImageView) findViewById(R.id.gitBtn);
//		gitBtn.setOnClickListener(gitBtnClickListener);
//		layerBtn = (ImageView) findViewById(R.id.layerBtn);
//		layerBtn.setOnClickListener(layerBtnClickListener);
//		uploadBtn = (ImageView) findViewById(R.id.uploadBtn);
//		uploadBtn.setOnClickListener(uploadBtnClickListener);
//
//		Open = false;
//		isBarOpened=true;
//
////		setupLayer(2);
////		canvasList.get(2).setAlpha(0.2f);
//
//		sv = new SettingView(context); // previously initialized setting view
//		canvasList.get(2).setSettingView(layoutList.get(2),sv);
//
//		RelativeLayout.LayoutParams test= new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT
//				,RelativeLayout.LayoutParams.WRAP_CONTENT);
//		test.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
//		test.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
//		RelativeLayout pallet = (RelativeLayout) inflater.inflate(R.layout.pallet, null);
//		pallet.setLayoutParams(test);
//		spenMainLayout.addView(pallet);
//
//		test= new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT
//				,303);
//		test.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
//		test.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
//		RelativeLayout hor = (RelativeLayout) inflater.inflate(R.layout.circular_menu, null);
//		hor.setLayoutParams(test);
//
//		RotateAnimation rotate = new RotateAnimation(-90, 0, 0, 303);
//		rotate.setDuration(700);
//		hor.setAnimation(rotate);
//
//		spenMainLayout.addView(hor);
//
//		CircularMenu c_menu = (CircularMenu) findViewById(R.id.circular_menu);
//		c_menu.setHandler(handler);
//		c_menu.init();
//	}
//
//	private OnClickListener menu =  new OnClickListener() {
//
//		@Override
//		public void onClick(View v) {
//			// TODO Auto-generated method stub
//			if(v==img1){
//				SettingStrokeInfo a= new SettingStrokeInfo();
//				a.setStrokeStyle(SObjectStroke.SAMM_STROKE_STYLE_PENCIL);
//				a.setStrokeColor(Color.BLACK);
//				a.setStrokeWidth(20);
//				canvasList.get(2).setSettingStrokeInfo(a);
//			} else if (v==img2){
//				SettingStrokeInfo a= new SettingStrokeInfo();
//				a.setStrokeStyle(SObjectStroke.SAMM_STROKE_STYLE_MARKER);
//				a.setStrokeColor(Color.BLACK);
//				a.setStrokeAlpha(20);
//				a.setStrokeWidth(20);
//				canvasList.get(2).setSettingStrokeInfo(a);
//			} else if (v==img3){
//				SettingStrokeInfo a= new SettingStrokeInfo();
//				a.setStrokeStyle(SObjectStroke.SAMM_STROKE_STYLE_BRUSH);
//				a.setStrokeColor(Color.BLACK);
//				a.setStrokeAlpha(20);
//				a.setStrokeWidth(20);
//				canvasList.get(2).setSettingStrokeInfo(a);
//			} else if (v==img4){
//				SettingStrokeInfo a= new SettingStrokeInfo();
//				a.setStrokeStyle(SObjectStroke.SAMM_STROKE_STYLE_CHALK);
//				a.setStrokeColor(Color.BLACK);
//				a.setStrokeWidth(20);
//				canvasList.get(2).setSettingStrokeInfo(a);
//			} else if (v==img5){
//				SettingStrokeInfo a= new SettingStrokeInfo();
//				a.setStrokeStyle(SObjectStroke.SAMM_STROKE_STYLE_ERASER);
//				a.setStrokeColor(Color.BLACK);
//				a.setStrokeWidth(20);
//				canvasList.get(2).setSettingStrokeInfo(a);
//			} else if (v==img6){
//				SettingStrokeInfo a= new SettingStrokeInfo();
//				a.setStrokeStyle(SObjectStroke.SAMM_STROKE_STYLE_BEAUTIFY);
//				a.setStrokeColor(Color.BLACK);
//				a.setStrokeWidth(20);
//				canvasList.get(2).setSettingStrokeInfo(a);
//			}
//		}
//	};
//
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.spen_sample, menu);
//		return true;
//	}
//
//	protected void onDestroy() {
//		super.onDestroy();
//		// Release SCanvasView resources
////		if(!mSCanvas.closeSCanvasView())
////			Log.e(TAG, "Fail to close SCanvasView");
//	}
//
//	public void newCanvas(){
//		layoutList.add(new RelativeLayout(context));
//		frame.addView(layoutList.get(layoutList.size()-1));
//
//		MyScanvas temp = new MyScanvas(context,handler);
//
//		layoutList.get(layoutList.size()-1).addView(temp);
//		canvasList.add(temp);
//
//		temp.setSCanvasInitializeListener(scanvasInitializeListener);
//	}
//
//	final Handler handler = new Handler() {
//		public void handleMessage(Message msg) {
////			longpress();
////			Log.d("DEBUG","!"+Integer.toHexString(msg.getData().getInt("color")));
//			Bundle bundle = msg.getData();
//
//			switch(bundle.getInt("key")){
//			case 1:
//				longpress();
//				break;
//			case 2:
//				myPicker.setColor(bundle.getInt("color"));
//				break;
//			case 3:
//				SettingStrokeInfo a= canvasList.get(2).getSettingStrokeInfo();
//				a.setStrokeColor(bundle.getInt("color"));
//				canvasList.get(2).setSettingStrokeInfo(a);
//				break;
//			case 4:
//				ColorCircle myCircle = new ColorCircle(context,false);
//				spenMainLayout.addView(myCircle);
//				break;
//			}
//		}
//	};
//
//	public void longpress(){
//
//		if(isBarOpened){
//			Animation anim = AnimationUtils.loadAnimation(context, R.anim.to_right);
//			anim.setAnimationListener(new AnimationListener() {
//
//				@Override
//				public void onAnimationStart(Animation animation) {
//					// TODO Auto-generated method stub
//
//				}
//
//				@Override
//				public void onAnimationRepeat(Animation animation) {
//					// TODO Auto-generated method stub
//
//				}
//
//				@Override
//				public void onAnimationEnd(Animation animation) {
//					// TODO Auto-generated method stub
//					FrameLayout.LayoutParams menu_params = (FrameLayout.LayoutParams) mlayer.getLayoutParams();
//
//					menu_params.rightMargin=menu_params.rightMargin-100;
//					mlayer.setLayoutParams(menu_params);
//					Log.d("DEBUG","!");
//				}
//			});
//
//			mlayer.startAnimation(anim);
//
//			isBarOpened=false;
//		} else {
//
//			FrameLayout.LayoutParams menu_params = (FrameLayout.LayoutParams) mlayer.getLayoutParams();
//
//			menu_params.rightMargin=menu_params.rightMargin+100;
//			mlayer.setLayoutParams(menu_params);
//			Animation anim = AnimationUtils.loadAnimation(context, R.anim.to_left);
//			mlayer.startAnimation(anim);
//			isBarOpened=true;
//		}
//	}
//
//	public void setupLayer(int c){
//		Bitmap Overlay = Bitmap.createBitmap(frame.getWidth(),frame.getHeight(),Config.ARGB_4444);
//		Canvas canvas = new Canvas(Overlay);
//
//		for(int i=0;i<canvasList.size();i++){
//			if(i<=c)
//				layoutList.get(i).setVisibility(View.VISIBLE);
//			else{
//				layoutList.get(i).setVisibility(View.INVISIBLE);
//				canvas.drawBitmap(canvasList.get(i).getBitmap(true),0,0,null);
//			}
//		}
//
//		ImageView image = (ImageView) findViewById(R.id.upperImage);
//		image.setImageBitmap(Overlay);
//	}
//
//	OnClickListener mBtnClickListener = new OnClickListener() {
//
//		@Override
//		public void onClick(View arg0) {
//			// TODO Auto-generated method stub
////			setupLayer(2);
//
//			LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//			FrameLayout colorpicker = (FrameLayout) inflater.inflate(R.layout.test, null);
//			FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT
//					, FrameLayout.LayoutParams.WRAP_CONTENT);
//			colorpicker.setLayoutParams(params);
//			frame.addView(colorpicker);
//		}
//	};
//
//	OnClickListener penClickListener = new OnClickListener() {
//
//		@Override
//		public void onClick(View arg0) {
//			// TODO Auto-generated method stubcv.changeModeTo(CanvasView.PEN_MODE);
//			if (sv.isShown(AbstractSettingView.PEN_SETTING_VIEW)) {
//				sv.closeView();
//			} else {
//				sv.showView(AbstractSettingView.PEN_SETTING_VIEW);
//			}
//			/*
//			SettingStrokeInfo a= new SettingStrokeInfo();
//			a.setStrokeStyle(SObjectStroke.SAMM_STROKE_STYLE_CUSTOME);
//			a.setStrokeColor(Color.parseColor("#050000ff"));
////			a.setStrokeAlpha(1);
//			a.setStrokeWidth(20);
//			canvasList.get(2).setSettingStrokeInfo(a);*/
////			Bitmap Overlay = canvasList.get(2).getBitmap(false);
////			Canvas canvas = new Canvas(Overlay);
//			/*
//			Path a = new Path();
//			a.lineTo(50, 50);
//			a.moveTo(100, 100);
//			Paint paint = new Paint();
//			paint.setColor(Color.GREEN);
//			paint.setStrokeWidth(20);
//			canvas.drawPath(a,paint);*/
//
////			Bitmap bmp = BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher);
////			canvas.drawBitmap(bmp, 10,10,null);
//
//		}
//	};
//
//	OnClickListener eraseClickListener = new OnClickListener() {
//
//		@Override
//		public void onClick(View arg0) {
//			// TODO Auto-generated method stub
////			setupLayer(2);
//			canvasList.get(2).setEraserStrokeSetting(20);
//		}
//	};
//
//	OnClickListener undoNredoBtnClickListener = new OnClickListener() {
//
//		@Override
//		public void onClick(View v) {
//			// TODO Auto-generated method stub
//			if(v.equals(mUndoBtn))
//			{
//				canvasList.get(2).undo();
//			}else if(v.equals(mRedoBtn))
//			{
//				canvasList.get(2).redo();
//			}
//
//			mUndoBtn.setEnabled(canvasList.get(2).isUndoable());
//			mRedoBtn.setEnabled(canvasList.get(2).isRedoable());
//		}
//	};
//
//	OnClickListener gitBtnClickListener = new OnClickListener() {
//
//		@Override
//		public void onClick(View v) {
////			Log.i("Select", "GIT!!");
//			if(!Open)
//			{
//				RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
//				params.setMargins(-100, 0, 0, 0);
//				spenMainLayout.setLayoutParams(params);
//
//
//
//
////				mSCanvas.setAnimationMode(true);
////				mSCanvas.setAnimationSpeed(SOptionPlay.ANIMATION_SPEED_MAX);
////				mSCanvas.doAnimationStart();
//
//			}else
//			{
//				RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
//				params.setMargins(0, 0, -100, 0);
//				spenMainLayout.setLayoutParams(params);
//
////				mSCanvas.setHistoryUpdateListener(new HistoryUpdateListener() {
////
////					@Override
////					public void onHistoryChanged(boolean arg0, boolean arg1) {
////						// TODO Auto-generated method stub
////						if(arg1)
////							mSCanvas.redo();
////						else
////							mSCanvas.setHistoryUpdateListener(null);
////					}
////				});
////
////				if(mSCanvas.isRedoable())
////					mSCanvas.redo();
//			}
//			Open = !Open;
//		}
//	};
//
//	OnClickListener layerBtnClickListener = new OnClickListener() {
//
//		@Override
//		public void onClick(View v) {
//			// TODO Auto-generated method stub
//			if(!Open) {
//				if(layer==null){
//					LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//					layer = (LinearLayout) inflater.inflate(R.layout.layer_layout, null);
//					FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT
//							, LinearLayout.LayoutParams.MATCH_PARENT, Gravity.RIGHT);
//					layer.setLayoutParams(params);
//				}
//				frame.addView(layer);
//				LinearLayout thumbnail_list = (LinearLayout) findViewById(R.id.layer_scroll);
//
//				for(int i=0;i<canvasList.size();i++){
//					ImageView tempView;
//					if(i<imageList.size()){
////						tempView = imageList.get(i);
//						Bitmap temp = canvasList.get(i).getBitmap(true);
//						imageList.get(i).setImageBitmap(Bitmap.createScaledBitmap(temp,100,150,true));
////						imageList.get(i).setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher));
//						temp.recycle();
//						Log.d("DEBUG","!"+i);
//					} else{
//						tempView = new ImageView(context);
//						imageList.add(tempView);
//						Bitmap temp = canvasList.get(i).getBitmap(true);
//						tempView.setImageBitmap(Bitmap.createScaledBitmap(temp,100,150,true));
//						temp.recycle();
//						thumbnail_list.addView(tempView);
//					}
//				}
//
//			} else {
//				((ViewManager) layer.getParent()).removeView(layer);
//			}
//			Open = !Open;
//		}
//	};
//
//	OnClickListener uploadBtnClickListener = new OnClickListener() {
//
//		@Override
//		public void onClick(View v) {
////			Log.i("Select", "Upload!!");
//			// TODO Auto-generated method stub
////			LinearLayout gitLayout = new LinearLayout(context);
////			LinearLayout.LayoutParams gitLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
//////			spenMainParams.set
////			gitLayoutParams.setMargins(50, 50, 50, 50);
////			gitLayout.setBackgroundColor(Color.GREEN);
////			gitLayout.setLayoutParams(gitLayoutParams);
////			spenLayout.addView(gitLayout);
//		}
//	};
//
//	SPenTouchListener spenListener = new SPenTouchListener() {
//
//		@Override
//		public boolean onTouchPenEraser(View arg0, MotionEvent arg1) {
//			// TODO Auto-generated method stub
//			return false;
//		}
//
//		@Override
//		public boolean onTouchPen(View arg0, MotionEvent arg1) {
//			// TODO Auto-generated method stub
//			return false;
//		}
//
//		@Override
//		public boolean onTouchFinger(View arg0, MotionEvent arg1) {
////			Log.i("Select", "Touch Finger!");
//
////			mUndoBtn.setEnabled(mSCanvas.isUndoable());
////			mRedoBtn.setEnabled(false);
//
//			return false;
//		}
//
//		@Override
//		public void onTouchButtonUp(View arg0, MotionEvent arg1) {
////			Log.i("Select", "Touch Up!");
//
//		}
//
//		@Override
//		public void onTouchButtonDown(View arg0, MotionEvent arg1) {
////			Log.i("Select", "Touch Down!");
//
//		}
//	};
//
//	SCanvasInitializeListener scanvasInitializeListener = new SCanvasInitializeListener() {
//		@Override
//		public void onInitialized() {
////			Log.d("DEBUG","~");
//		}
//	};
//
//	/*public class ImageThread extends Thread{
//		LinkedList<SObject> list;
//
//		public ImageThread(LinkedList<SObject> _list){
//			list=_list;
//		}
//
//		@Override
//		public void run() {
//			// TODO Auto-generated method stub
//			hiddenCanvas.setMultiSelectionMode(true);
////			hiddenCanvas.insertSAMMObjectList(list, true, false);
////			Bitmap temp = hiddenCanvas.getBitmap(true);
////			testView.setImageBitmap(Bitmap.createScaledBitmap(temp,100,150,true));
////			temp.recycle();
//		}
//
//		public void cancel(){
//
//		}
//	}*/
}