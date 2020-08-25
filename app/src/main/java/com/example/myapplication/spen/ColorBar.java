package com.example.myapplication.spen;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;

public class ColorBar extends View{
	int width=300,height=50;
	int color=Color.BLACK;
	Context context;
	Handler handler = null;
	Canvas mCanvas = null;
	Bitmap mBmp = null;
	
	public ColorBar(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.context=context;
	}

	public ColorBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		this.context=context;
	}

	public ColorBar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		this.context=context;
	}
	
	public void setHandler(Handler _handler){
		handler=_handler;
	}
	
	@Override
	protected void onFinishInflate() {
		// TODO Auto-generated method stub
		super.onFinishInflate();
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
        // height ��¥ ũ�� ���ϱ�
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = 0;
        switch(heightMode) {
        case MeasureSpec.UNSPECIFIED://mode �� ���õ��� ���� ũ�Ⱑ �Ѿ�ö�
            heightSize = heightMeasureSpec;
            break;
        case MeasureSpec.AT_MOST://wrap_content (�� ������ ũ�⿡ ���� ũ�Ⱑ �޶���)
            heightSize = height;
            break;
        case MeasureSpec.EXACTLY://fill_parent, match_parent (�ܺο��� �̹� ũ�Ⱑ �����Ǿ���)
            heightSize = MeasureSpec.getSize(heightMeasureSpec);
            height=heightSize;
            break;
        }


        // width ��¥ ũ�� ���ϱ�
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = 0;
        switch(widthMode) {
        case MeasureSpec.UNSPECIFIED://mode �� ���õ��� ���� ũ�Ⱑ �Ѿ�ö�
            widthSize = widthMeasureSpec;
            break;
        case MeasureSpec.AT_MOST://wrap_content (�� ������ ũ�⿡ ���� ũ�Ⱑ �޶���)
            widthSize = width;
            break;
        case MeasureSpec.EXACTLY://fill_parent, match_parent (�ܺο��� �̹� ũ�Ⱑ �����Ǿ���)
            widthSize = MeasureSpec.getSize(widthMeasureSpec);
            width=widthSize;
            break;
        }

        setMeasuredDimension(widthSize, heightSize);
        
        mBmp=Bitmap.createBitmap(width, height, Config.ARGB_4444);
        mCanvas= new Canvas(mBmp);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		if(mCanvas==null)
			mCanvas=canvas;
		
		Paint paint = new Paint();
		
        int[] colors = {Color.RED, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE,
                                     Color.MAGENTA, Color.RED};
        float[] color = {0.0f, 0.17f, 0.34f, 0.51f, 0.68f, 0.85f, 1.0f};

        LinearGradient vertical_linear = new LinearGradient(0, 0, width, 0, colors, color,
                                                                                  Shader.TileMode.REPEAT);
        paint.setShader(vertical_linear);
        
        canvas.drawRect(0,0,width,height, paint);
        mCanvas.drawRect(0,0,width,height, paint);
	}


	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		if(event.getAction()==MotionEvent.ACTION_MOVE || event.getAction()==MotionEvent.ACTION_DOWN){
			if(event.getX()>0 && event.getX()<width && event.getY()>0 && event.getY()<height){
				Message msg = handler.obtainMessage();
				Bundle bundle = new Bundle();
				bundle.putInt("key", 2);
				bundle.putInt("color", mBmp.getPixel((int)event.getX(), (int)event.getY()));
				msg.setData(bundle);
				handler.sendMessage(msg);
			}
		}
		return true;
	}
}
