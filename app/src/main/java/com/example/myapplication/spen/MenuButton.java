package com.example.myapplication.spen;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

public class MenuButton extends View{
	int width=80,height=80;
	int color=0xFFFFD400;
	Context context;
	Handler handler = null;
	
	public MenuButton(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.context=context;
	}

	public MenuButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		this.context=context;
	}

	public MenuButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		this.context=context;
	}
	@Override
	protected void onFinishInflate() {
        // TODO Auto-generated method stub
        super.onFinishInflate();
    }
	
	public void setColor(int c){
		color=c;
		invalidate();
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
        // height ��¥ ũ�� ���ϱ�
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

        if(widthSize<heightSize)
        	heightSize=widthSize;
        else
        	widthSize=heightSize;

        width=widthSize;
        height=heightSize;
        setMeasuredDimension(widthSize, heightSize);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		Paint paint = new Paint();
        paint.setAntiAlias(true);
        
        paint.setColor(color);
//		Log.d("DEBUG",hsv[1]+"!"+hsv[2]);
        canvas.drawCircle(0, 80, 80, paint);
	}
}
