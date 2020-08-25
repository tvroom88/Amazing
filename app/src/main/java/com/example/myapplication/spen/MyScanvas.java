package com.example.myapplication.spen;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

//import com.samsung.spensdk.SCanvasView;
public class MyScanvas{
//public class MyScanvas extends SCanvasView{
//	boolean isPress;
//	boolean isStart;
//	MotionEvent temp;
//	TouchTimer timer = null;
//	Context context;
//	Handler handler;
//
//	public MyScanvas(Context arg0) {
//		super(arg0);
//		// TODO Auto-generated constructor stub
//		context=arg0;
//	}
//
//	public MyScanvas(Context arg0, Handler _handler) {
//		super(arg0);
//		// TODO Auto-generated constructor stub
//		handler=_handler;
//		context=arg0;
//	}
//
//	public MyScanvas(Context arg0, AttributeSet arg1) {
//		super(arg0, arg1);
//		// TODO Auto-generated constructor stub
//		context=arg0;
//	}
//
//	public MyScanvas(Context arg0, AttributeSet arg1, int arg2) {
//		super(arg0, arg1, arg2);
//		// TODO Auto-generated constructor stub
//		context=arg0;
//	}
//
//	public MyScanvas(Context arg0, boolean arg1) {
//		super(arg0, arg1);
//		// TODO Auto-generated constructor stub
//		context=arg0;
//	}
//
//	@Override
//	public boolean drawSAMMStrokePoint(int arg0, float arg1, float arg2,
//			float arg3, int arg4, long arg5, long arg6) {
//		// TODO Auto-generated method stub
//
//		return super.drawSAMMStrokePoint(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
//	}
//
//	@Override
//	public boolean onTouchEvent(MotionEvent arg0) {
//		// TODO Auto-generated method stub
//
//		switch(arg0.getAction() & MotionEvent.ACTION_MASK){
//		case MotionEvent.ACTION_DOWN:
//			isPress=false;
//			isStart=true;
//			temp = MotionEvent.obtain(arg0.getDownTime(), arg0.getEventTime(), arg0.getAction(), arg0.getX(),
//					arg0.getY(), arg0.getMetaState());
//
//			timer = new TouchTimer();
//			timer.start();
//			return true;//super.onTouchEvent(arg0);
//		case MotionEvent.ACTION_MOVE:
//			if(isStart){
//				isStart=false;
//				super.onTouchEvent(temp);
//				temp.recycle();
//			}
//			timer.cancel();
//
//			break;
//		case MotionEvent.ACTION_UP:
//			timer.cancel();
//			timer=null;
//			break;
//		}
//
//		if(!isPress){
//			return super.onTouchEvent(arg0);
//		}
//		else
//			return true;
//	}
//
//	public class TouchTimer extends Thread{
//		boolean pressed=true;
//
//		@Override
//		public void run() {
//			// TODO Auto-generated method stub
//			long start = System.currentTimeMillis();
//
//			while(pressed){
//				if(System.currentTimeMillis()-start>800){
//					isPress=true;
//					Message msg = handler.obtainMessage();
//					Bundle a = new Bundle();
//					a.putInt("key", 1);
//					msg.setData(a);
//					handler.sendMessage(msg);
//					break;
//				}
//			}
//		}
//
//		public void cancel(){
//			pressed=false;
//		}
//	}
}
