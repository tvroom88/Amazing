package com.example.myapplication.spen;//package com.MadFactory.spen;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//import android.app.Activity;
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.Color;
//import android.os.Bundle;
//import android.util.DisplayMetrics;
//import android.util.Log;
//import android.view.Gravity;
//import android.view.Menu;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.FrameLayout;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.RelativeLayout;
//import android.widget.Toast;
//
//import com.MadFactory.socialdrawhub.R;
//import com.samsung.spensdk.SCanvasConstants;
//import com.samsung.spensdk.SCanvasView;
//import com.samsung.spensdk.applistener.HistoryUpdateListener;
//import com.samsung.spensdk.applistener.SCanvasInitializeListener;
//import com.samsung.spensdk.applistener.SPenTouchListener;
//
//
//public class SPenSampleBackup extends Activity {
//
//	private SCanvasView mSCanvas;
//	private String TAG = "SPenSample";
//	private String APPLICATION_ID_NAME = "DrawHub";
//	private int APPLICATION_ID_VERSION_MAJOR = 2;
//	private int APPLICATION_ID_VERSION_MINOR = 2;
//	private String APPLICATION_ID_VERSION_PATCHNAME = "rev";
//	
//	private LinearLayout    spenMainLayout;
//	private LinearLayout    spenLayout;
//	private FrameLayout     mLayoutContainer;
//	private LinearLayout    gitLayout;
//
//	private ImageView		mPenBtn;
//	private ImageView		mEraserBtn;
//	private ImageView		mTextBtn;
//	private ImageView		mUndoBtn;
//	private ImageView		mRedoBtn;
//	private ImageView		gitBtn;
//	private ImageView		uploadBtn;
//	
//	ArrayList<Bitmap> bitmapList = new ArrayList<Bitmap>();
//	
//	Context context = this;
//	
//	Boolean gitOpen;
//	int width, height;
//	
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.spen_sample_backup);
//		
//		mLayoutContainer = (FrameLayout) findViewById(R.id.layout_container);
//		RelativeLayout mCanvasContainer = (RelativeLayout) findViewById(R.id.canvas_container);	
//		mSCanvas = new SCanvasView(this);   
//		mSCanvas.addedByResizingContainer(mCanvasContainer);
//		
//		mSCanvas.setSPenTouchListener(spenListener);
//		mSCanvas.setHistoryUpdateListener(new HistoryUpdateListener() {
//			@Override
//			public void onHistoryChanged(boolean undoable, boolean redoable) {
//				Log.i(TAG, "onHistoryChanged");
////				bitmapList.add(mSCanvas.getBitmap(false));
//				mUndoBtn.setEnabled(undoable);
//				mRedoBtn.setEnabled(redoable);
//			}
//		});
//		mSCanvas.setSCanvasInitializeListener(new SCanvasInitializeListener() {
//			@Override
//			public void onInitialized() {
//				if(!mSCanvas.setAppID(APPLICATION_ID_NAME, APPLICATION_ID_VERSION_MAJOR, APPLICATION_ID_VERSION_MINOR,APPLICATION_ID_VERSION_PATCHNAME))
//				{
//					Toast.makeText(context, "Fail to set App ID.", Toast.LENGTH_LONG).show();
//				}
//			}
//		});
//		
//		spenMainLayout = (LinearLayout)findViewById(R.id.spen_main);
//		spenLayout = (LinearLayout)findViewById(R.id.spen_sample);
//		gitLayout = (LinearLayout)findViewById(R.id.git_history_scroll);
//		
//		DisplayMetrics displaymetrics = new DisplayMetrics();
//		getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
//		height = displaymetrics.heightPixels;
//		width = displaymetrics.widthPixels; 	
//		
//		Log.i("Select", "Width:" + width);		
//		FrameLayout.LayoutParams spenMainLayoutParams = new FrameLayout.LayoutParams(width + 100,  LinearLayout.LayoutParams.MATCH_PARENT);
//		spenMainLayout.setLayoutParams(spenMainLayoutParams);
//		
//		LinearLayout.LayoutParams spenLayoutParams = new LinearLayout.LayoutParams(width,  LinearLayout.LayoutParams.MATCH_PARENT);
//		spenLayout.setLayoutParams(spenLayoutParams);
//		
//		
//		mPenBtn = (ImageView) findViewById(R.id.penBtn);
//		mPenBtn.setOnClickListener(mBtnClickListener);
//		mEraserBtn = (ImageView) findViewById(R.id.eraseBtn);
//		mEraserBtn.setOnClickListener(mBtnClickListener);
//		mTextBtn = (ImageView) findViewById(R.id.textBtn);
//		mTextBtn.setOnClickListener(mBtnClickListener);
//		mUndoBtn = (ImageView) findViewById(R.id.undoBtn);
//		mUndoBtn.setOnClickListener(undoNredoBtnClickListener);
//		mRedoBtn = (ImageView) findViewById(R.id.redoBtn);
//		mRedoBtn.setOnClickListener(undoNredoBtnClickListener);
//		gitBtn = (ImageView) findViewById(R.id.gitBtn);
//		gitBtn.setOnClickListener(gitBtnClickListener);
//		uploadBtn = (ImageView) findViewById(R.id.uploadBtn);
//		uploadBtn.setOnClickListener(uploadBtnClickListener);
//		
//		HashMap<String,Integer> settingResourceMapInt = SPenSDKUtils.getSettingLayoutLocaleResourceMap(true, true, true, true);
//		// Talk & Description Setting by Locale
//		SPenSDKUtils.addTalkbackAndDescriptionStringResourceMap(settingResourceMapInt);
//		// Resource Map for Custom font path
//		HashMap<String,String> settingResourceMapString = SPenSDKUtils.getSettingLayoutStringResourceMap(true, true, true, true);
//		// Create Setting View
//		mSCanvas.createSettingView(mLayoutContainer, settingResourceMapInt, settingResourceMapString);
//		
//		mPenBtn.setSelected(true);
//		gitOpen = false;
//	}
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
//		
//		if(!mSCanvas.closeSCanvasView())
//		{
//			Log.e(TAG, "Fail to close SCanvasView");
//		}
//	}
//	
//	OnClickListener mBtnClickListener = new OnClickListener() {
//		
//		@Override
//		public void onClick(View v) {
//			int nBtnID = v.getId();
//			
//			
//			if(nBtnID == mPenBtn.getId())
//			{
//				if(mSCanvas.getCanvasMode() == SCanvasConstants.SCANVAS_MODE_INPUT_PEN)
//				{
//					Log.i(TAG, "SCANVAS_MODE_INPUT_PEN");
//					mSCanvas.setSettingViewSizeOption(SCanvasConstants.SCANVAS_SETTINGVIEW_PEN, SCanvasConstants.SCANVAS_SETTINGVIEW_SIZE_NORMAL);
//					mSCanvas.toggleShowSettingView(SCanvasConstants.SCANVAS_SETTINGVIEW_PEN);
//					
//				}else
//				{
//					Log.i(TAG, "SCANVAS_MODE_INPUT_PEN FIRST");
//					mSCanvas.setCanvasMode(SCanvasConstants.SCANVAS_MODE_INPUT_PEN);
//					mSCanvas.showSettingView(SCanvasConstants.SCANVAS_SETTINGVIEW_PEN, false);
//					
//					mPenBtn.setSelected(true);
//					mEraserBtn.setSelected(false);
//					mTextBtn.setSelected(false);
////					mUndoBtn.setSelected(false);
////					mRedoBtn.setSelected(false);
//				}
//			}else if(nBtnID == mEraserBtn.getId())
//			{
//				if(mSCanvas.getCanvasMode()==SCanvasConstants.SCANVAS_MODE_INPUT_ERASER){
//					Log.i(TAG, "SCANVAS_MODE_INPUT_ERASER");
//					mSCanvas.setSettingViewSizeOption(SCanvasConstants.SCANVAS_SETTINGVIEW_ERASER, SCanvasConstants.SCANVAS_SETTINGVIEW_SIZE_NORMAL);
//					mSCanvas.toggleShowSettingView(SCanvasConstants.SCANVAS_SETTINGVIEW_ERASER);
//				}
//				else {
//					Log.i(TAG, "SCANVAS_MODE_INPUT_ERASER FIRST");
//					mSCanvas.setCanvasMode(SCanvasConstants.SCANVAS_MODE_INPUT_ERASER);
//					mSCanvas.showSettingView(SCanvasConstants.SCANVAS_SETTINGVIEW_ERASER, false);
//					
//					mPenBtn.setSelected(false);
//					mEraserBtn.setSelected(true);
//					mTextBtn.setSelected(false);
////					mUndoBtn.setSelected(false);
////					mRedoBtn.setSelected(false);
//				}
//			}else if(nBtnID == mTextBtn.getId())
//			{
//				if(mSCanvas.getCanvasMode()==SCanvasConstants.SCANVAS_MODE_INPUT_TEXT){
//					Log.i(TAG, "SCANVAS_MODE_INPUT_TEXTBTN");
//					mSCanvas.setSettingViewSizeOption(SCanvasConstants.SCANVAS_SETTINGVIEW_TEXT, SCanvasConstants.SCANVAS_SETTINGVIEW_SIZE_NORMAL);
//					mSCanvas.toggleShowSettingView(SCanvasConstants.SCANVAS_SETTINGVIEW_TEXT);
//				}
//				else{
//					Log.i(TAG, "SCANVAS_MODE_INPUT_TEXTBTN FIRST");
//					mSCanvas.setCanvasMode(SCanvasConstants.SCANVAS_MODE_INPUT_TEXT);
//					mSCanvas.showSettingView(SCanvasConstants.SCANVAS_SETTINGVIEW_TEXT, false);
//					
//					mPenBtn.setSelected(false);
//					mEraserBtn.setSelected(false);
//					mTextBtn.setSelected(true);
////					mUndoBtn.setSelected(false);
////					mRedoBtn.setSelected(false);
//				}
//			}
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
//				mSCanvas.undo();
//				
//				mPenBtn.setSelected(false);
//				mEraserBtn.setSelected(false);
//				mTextBtn.setSelected(false);
////				mUndoBtn.setSelected(true);
////				mRedoBtn.setSelected(false);
//			}else if(v.equals(mRedoBtn))
//			{
//				mSCanvas.redo();
//				
//				mPenBtn.setSelected(false);
//				mEraserBtn.setSelected(false);
//				mTextBtn.setSelected(false);
////				mUndoBtn.setSelected(false);
////				mRedoBtn.setSelected(true);
//			}
//			
//			Log.i("Select", "Undo:" + mSCanvas.isUndoable() + " Redo:" + mSCanvas.isRedoable());
//			
//			mUndoBtn.setEnabled(mSCanvas.isUndoable());
//			mRedoBtn.setEnabled(mSCanvas.isRedoable());
//		}
//	};
//	
//	OnClickListener gitBtnClickListener = new OnClickListener() {
//		
//		@Override
//		public void onClick(View v) {
//			Log.i("Select", "GIT!! GitOpen:" + gitOpen);
//			if(!gitOpen)
//			{
//				FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(width+100, LinearLayout.LayoutParams.MATCH_PARENT, Gravity.LEFT);
//				params.setMargins(-100, 0, 0, 0);
//				spenMainLayout.setLayoutParams(params);
//				
////				LinearLayout gitLayout = new LinearLayout(context);
////				LinearLayout.LayoutParams gitLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
//////				spenMainParams.set
////				gitLayout.setBackgroundColor(Color.GREEN);
////				gitLayout.setLayoutParams(gitLayoutParams);
////				spenLayout.addView(gitLayout);
//				gitLayout.removeAllViews();
//				
////				for (int i = 0 ; i < 4 ; i++)
////				{
////				
////					canvasClone.undo();
////				}
////				for (Bitmap bitmap : bitmapList) 
////				{
////					ImageView imageView = new ImageView(context);  
////					imageView.setImageBitmap(bitmap);
////					LinearLayout.LayoutParams imageViewParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, (int) (100.0 * height / width));
////					imageView.setLayoutParams(imageViewParams);
////					gitLayout.addView(imageView);
////				}
////				SSAMFiles.saveCanvasImage(true, mSCanvas);
//				
////				SSAMFiles.saveSAMMFile(mSCanvas, getFilesDir());
//				
//			}else
//			{
//				FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(width+100, LinearLayout.LayoutParams.MATCH_PARENT, Gravity.LEFT);
//				params.setMargins(0, 0, -100, 0);
//				spenMainLayout.setLayoutParams(params);
//			}
//			gitOpen = !gitOpen;
//		}
//	};
//	
//	OnClickListener uploadBtnClickListener = new OnClickListener() {
//		
//		@Override
//		public void onClick(View v) {
//			Log.i("Select", "Upload!!");
//			// TODO Auto-generated method stub
//			LinearLayout gitLayout = new LinearLayout(context);
//			LinearLayout.LayoutParams gitLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
////			spenMainParams.set
//			gitLayoutParams.setMargins(50, 50, 50, 50);
//			gitLayout.setBackgroundColor(Color.GREEN);
//			gitLayout.setLayoutParams(gitLayoutParams);
//			spenLayout.addView(gitLayout);
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
//			Log.i("Select", "Touch Finger!");
//			return false;
//		}
//		
//		@Override
//		public void onTouchButtonUp(View arg0, MotionEvent arg1) {
//			Log.i("Select", "Touch Up!");
//			
//
//		}
//		
//		@Override
//		public void onTouchButtonDown(View arg0, MotionEvent arg1) {
//			Log.i("Select", "Touch Down!");
//			
//		}
//	};
//	
//	// Update tool button
//	private void updateModeState(){
//		SPenSDKUtils.updateModeState(mSCanvas, null, null, mPenBtn, mEraserBtn, mTextBtn, null, null, null, null);
//	}
//}
