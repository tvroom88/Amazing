package com.example.myapplication.spen;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.CompressFormat;
import android.os.Environment;
import android.util.Log;

//import com.samsung.samm.common.SOptionSAMM;
//import com.samsung.samm.common.SOptionSCanvas;
//import com.samsung.spensdk.SCanvasView;

public class SSAMFiles {
//	public static final String DEFAULT_APP_IMAGEDATA_DIRECTORY = "DrawHub";
//	public static final String SAVED_FILE_EXTENSION = "png";
//	private static String TAG = "SSAMFiles";
//
//	public static boolean saveCanvasImage(boolean bSaveOnlyForegroundImage, SCanvasView mSCanvas) {
//		Bitmap bmCanvas = mSCanvas.getCanvasBitmap(bSaveOnlyForegroundImage);
//		File sdcard_path = Environment.getExternalStorageDirectory();
//		Log.e("e", sdcard_path.getAbsolutePath());
//		File mFolder = new File(sdcard_path, DEFAULT_APP_IMAGEDATA_DIRECTORY);
//		if(!mFolder.exists()){
//			if(!mFolder.mkdirs()){
//				Log.e("e", "Default Save Path Creation Error");
//			}
//		}
//
//		if (!(mFolder.exists()))
//			if(!mFolder.mkdirs())
//				return false;
//		String savePath = mFolder.getPath() + '/' + ExampleUtils.getUniqueFilename(mFolder, "image", SAVED_FILE_EXTENSION);
//		Log.d(TAG, "Save Path = " + savePath);
//
//		return saveBitmapPNG(savePath, bmCanvas);
//	}
//
//	public static boolean loadCanvasImage(String fileName, boolean loadAsForegroundImage, SCanvasView mSCanvas) {
//		File sdcard_path = Environment.getExternalStorageDirectory();
//		Log.e("e", sdcard_path.getAbsolutePath());
//		File mFolder = new File(sdcard_path, DEFAULT_APP_IMAGEDATA_DIRECTORY);
//		if(!mFolder.exists()){
//			if(!mFolder.mkdirs()){
//				Log.e("e", "Default Save Path Creation Error");
//			}
//		}
//
//		String loadPath = mFolder.getPath() + '/' + fileName;
//
//		Log.i(TAG, "Load Path = " + loadPath);
//
//		if(loadAsForegroundImage){
//			Bitmap bmForeground = BitmapFactory.decodeFile(loadPath);
//			if(bmForeground == null)
//				return false;
//			int nWidth = mSCanvas.getWidth();
//			int nHeight = mSCanvas.getHeight();
//			bmForeground = Bitmap.createScaledBitmap(bmForeground, nWidth, nHeight, true);
//			return mSCanvas.setClearImageBitmap(bmForeground);
//		}
//		else {
//			return mSCanvas.setBGImagePath(loadPath);
//		}
//	}
//
//	public static boolean saveSAMMFile(SCanvasView mSCanvas, String DrawName)
//	{
//		File sdcard_path = Environment.getExternalStorageDirectory();
//		File mFolder = new File(sdcard_path, DEFAULT_APP_IMAGEDATA_DIRECTORY);
//		Log.e("e", mFolder.getAbsolutePath());
//		if(!mFolder.exists()){
//			if(!mFolder.mkdirs()){
//				Log.e("e", "Default Save Path Creation Error");
//			}
//		}
//
//		String savePath = mFolder.getPath() + '/' + ExampleUtils.getUniqueFilename(mFolder, DrawName, SAVED_FILE_EXTENSION);
//		Log.d(TAG, "Save Path = " + savePath);
//
//		// canvas option setting
//		SOptionSCanvas canvasOption = mSCanvas.getOption();
//		if(canvasOption == null)
//			return false;
//		canvasOption.mSAMMOption.setSaveImageSize(SOptionSAMM.SAMM_SAVE_OPTION_ORIGINAL_SIZE);
//		mSCanvas.setOption(canvasOption);
//		return mSCanvas.saveSAMMFile(savePath);
//	}
//
////	private void selectSAMMFile(Activity activity) {
////		Intent intent = new Intent(activity.getApplicationContext(), ListActivity.class);
////		startActivityForResult(intent, REQUEST_CODE_LOAD_SAMM_FILE);
////	}
//
//	public static boolean loadSAMMFile(String fileName, SCanvasView mSCanvas, String DrawName) {
//		File sdcard_path = Environment.getExternalStorageDirectory();
//		File mFolder = new File(sdcard_path, DEFAULT_APP_IMAGEDATA_DIRECTORY);
//		if(!mFolder.exists()){
//			if(!mFolder.mkdirs()){
//				Log.e("e", "Default Save Path Creation Error");
//			}
//		}
//
//		String loadPath = mFolder.getPath() + '/' + fileName;
//		return mSCanvas.loadSAMMFile(loadPath, true, true, true);
//	}
//
//	private static boolean saveBitmapPNG(String strFileName, Bitmap bitmap){
//		if(strFileName==null || bitmap==null)
//			return false;
//
//		boolean bSuccess1 = false;
//		boolean bSuccess2;
//		boolean bSuccess3;
//		File saveFile = new File(strFileName);
//
//		if(saveFile.exists()) {
//			if(!saveFile.delete())
//				return false;
//		}
//
//		try {
//			bSuccess1 = saveFile.createNewFile();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//		OutputStream out = null;
//		try {
//			out = new FileOutputStream(saveFile);
//			bSuccess2 = bitmap.compress(CompressFormat.PNG, 100, out);
//		} catch (Exception e) {
//			e.printStackTrace();
//			bSuccess2 = false;
//		}
//		try {
//			if(out!=null)
//			{
//				out.flush();
//				out.close();
//				bSuccess3 = true;
//			}
//			else
//				bSuccess3 = false;
//
//		} catch (IOException e) {
//			e.printStackTrace();
//			bSuccess3 = false;
//		}finally
//		{
//			if(out != null)
//			{
//				try {
//					out.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//
//		return (bSuccess1 && bSuccess2 && bSuccess3);
//	}
}
