package com.example.myapplication.spen;

import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Bitmap.Config;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;

public class Pallet extends View{
	int width=180,height=90;
	int color=Color.BLACK;
	Context context;
	int[][] colors = {{0xff000000,0xff111111,0xff222222,0xff333333,0xff444444,0xff555555},
			{0xff666666,0xff777777,0xff888888,0xff999999,0xffAAAAAA,0xffBBBBBB},
			{0xffCCCCCC,0xffDDDDDD,0xffEEEEEE,0xffFF0000,0xff00FF00,0xff0000FF}};
	Paint p= new Paint();
	boolean start=true;

	public Pallet(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.context=context;
	}

	public Pallet(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		this.context=context;
	}

	public Pallet(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		this.context=context;
	}
	
	public void setColor(int i, int j, int _color){
		colors[i][j]=_color;
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = 0;
        switch(heightMode) {
        case MeasureSpec.UNSPECIFIED:
            heightSize = heightMeasureSpec;
            break;
        case MeasureSpec.AT_MOST:
            heightSize = height;
            break;
        case MeasureSpec.EXACTLY:
            heightSize = MeasureSpec.getSize(heightMeasureSpec);
            height=heightSize;
            break;
        }

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = 0;
        switch(widthMode) {
        case MeasureSpec.UNSPECIFIED:
            widthSize = widthMeasureSpec;
            break;
        case MeasureSpec.AT_MOST:
            widthSize = width;
            break;
        case MeasureSpec.EXACTLY:
            widthSize = MeasureSpec.getSize(widthMeasureSpec);
            width=widthSize;
            break;
        }

        setMeasuredDimension(widthSize, heightSize);
    	p.setAntiAlias(true);
    	p.setColor(color);
	}
	

	@Override
	protected void onDraw(Canvas canvas) {
		Paint paint= new Paint();
		paint.setAntiAlias(true);
		
		
		if(start){
			start=false;
			for(int i=0;i<3;i++){
				for(int j=0;j<6;j++){
					canvas.drawRoundRect(new RectF(j*30, i*30, j*30+30, i*30+30), 10f, 10f, p);
				}
			}
			Log.d("DEBUG","pallet draw!");
		}
		
		for(int i=0;i<3;i++){
			for(int j=0;j<6;j++){				
				paint.setColor(colors[i][j]);
				canvas.drawRoundRect(new RectF(j*30+1, i*30+1, j*30+29, i*30+29), 10f, 10f, paint);
			}
		}
	}
	

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return false;
	}
}
