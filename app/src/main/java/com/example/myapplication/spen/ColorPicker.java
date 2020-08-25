package com.example.myapplication.spen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Bitmap.Config;
import android.graphics.PorterDuff.Mode;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.SyncStateContract.Constants;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class ColorPicker extends View{
	int width=300,height=300;
	int color=Color.BLACK;
	Handler handler = null;
	Canvas mCanvas = null;
	Bitmap mBmp = null;
	
	public ColorPicker(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public ColorPicker(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public ColorPicker(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onFinishInflate() {
		// TODO Auto-generated method stub
		super.onFinishInflate();
	}
	
	public void setColor(int _color){
		color=_color;
		invalidate();
	}

	public void setHandler(Handler _handler){
		handler=_handler;
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
            break;
        }

        setMeasuredDimension(widthSize, heightSize);
        
        mBmp=Bitmap.createBitmap(width, height, Config.ARGB_4444);
        mCanvas= new Canvas(mBmp);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub

        LinearGradient horizontal_linear = new LinearGradient(0, 0, width, 0, Color.WHITE, color,
                                                                                  Shader.TileMode.REPEAT);
        LinearGradient vertical_linear = new LinearGradient(0, 0, 0, height, 0, Color.BLACK,
                                                                                  Shader.TileMode.REPEAT);
        ComposeShader shader = new ComposeShader(horizontal_linear, vertical_linear, Mode.DARKEN);
        
        Paint shader_paint = new Paint();
        shader_paint.setAntiAlias(true);
        shader_paint.setShader(shader);
        canvas.drawRect(0,0,300,300, shader_paint);
        mCanvas.drawRect(0,0,300,300, shader_paint);
        
		/*
        Paint shader_paint = new Paint();
        shader_paint.setAntiAlias(true);
        Paint shader_paint2 = new Paint();
        shader_paint.setAntiAlias(true);
        Paint shader_paint3 = new Paint();
        shader_paint.setAntiAlias(true);
         
        int[] colors_hor = {Color.RED, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE,
                                     Color.MAGENTA, Color.RED};
        int[] colors_ver = {Color.WHITE,0,Color.BLACK};
        float[] color_hor = {0.0f, 0.17f, 0.34f, 0.51f, 0.68f, 0.85f, 1.0f};
        float[] color_ver = {0.0f,0.5f,1.0f};
 
        LinearGradient horizontal_linear = new LinearGradient(0, 0, width - 1, 0, colors_hor, color_hor,
                                                                                  Shader.TileMode.REPEAT);
        LinearGradient vertical_linear = new LinearGradient(0, 0, 0, height/2, 0, Color.BLACK,
                                                                                  Shader.TileMode.REPEAT);
        LinearGradient vertical_linear2 = new LinearGradient(0, 0, 0, height/2, Color.WHITE, 0,
        																			Shader.TileMode.REPEAT);
        LinearGradient vertical_linear3 = new LinearGradient(0, 0, 0, height, colors_ver, color_ver,
																				Shader.TileMode.REPEAT);
        
        ComposeShader shader = new ComposeShader(horizontal_linear, vertical_linear, Mode.SRC_OVER);
        ComposeShader shader2 = new ComposeShader(horizontal_linear, vertical_linear2,Mode.XOR);
//        ComposeShader shader3 = new ComposeShader(horizontal_linear, vertical_linear3, PorterDuff.Mode.OVERLAY);
        //over, atop, 

        shader_paint.setShader(shader);
        shader_paint2.setShader(shader2);
//        shader_paint3.setShader(shader3);
        canvas.drawRect(0,0,300,150, shader_paint2);
        canvas.drawRect(0,150,300,300, shader_paint);*/
//        canvas.drawRect(0, 0,300,300,shader_paint3);
    }

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub

		if(event.getAction()==MotionEvent.ACTION_MOVE || event.getAction()==MotionEvent.ACTION_DOWN){
			if(event.getX()>0 && event.getX()<width && event.getY()>0 && event.getY()<height){
				Message msg = handler.obtainMessage();
				Bundle bundle = new Bundle();
				bundle.putInt("key", 3);
				bundle.putInt("color", mBmp.getPixel((int)event.getX(), (int)event.getY()));
				msg.setData(bundle);
				handler.sendMessage(msg);
			}
		}
		return true;
	}
}
