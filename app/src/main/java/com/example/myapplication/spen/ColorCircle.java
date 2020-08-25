package com.example.myapplication.spen;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;

public class ColorCircle extends View {
	int width = 70, height = 70;
	int color = Color.BLACK;
	Context context;
	Handler handler = null;
	Canvas mCanvas = null;
	Bitmap mBmp = null;
	Paint paint = new Paint();
	boolean fixed = true, first = true;
	float start_x=0, start_y=0;
	
	public ColorCircle(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.context = context;
	}
	
	public ColorCircle(Context context, boolean _fix) {
		super(context);
		// TODO Auto-generated constructor stub
		this.context = context;
		fixed = _fix;
	}

	public ColorCircle(Context context, boolean _fix, float x, float y, int _color) {
		super(context);
		// TODO Auto-generated constructor stub
		this.context = context;
		fixed = _fix;
		start_x=x;
		start_y=y;
		color=_color;
		
//		Log.d("DEBUG",x+"!"+y);
	}

	public ColorCircle(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	public ColorCircle(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	public void setHandler(Handler _handler) {
		handler = _handler;
	}

	@Override
	protected void onFinishInflate() {
		// TODO Auto-generated method stub
		super.onFinishInflate();
	}

	public void setColor(int c) {
		color = c;
		invalidate();
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		// height ��¥ ũ�� ���ϱ�
		int heightMode = MeasureSpec.getMode(heightMeasureSpec);
		int heightSize = 0;
		switch (heightMode) {
		case MeasureSpec.UNSPECIFIED:// mode �� ���õ��� ���� ũ�Ⱑ �Ѿ�ö�
			heightSize = heightMeasureSpec;
			break;
		case MeasureSpec.AT_MOST:// wrap_content (�� ������ ũ�⿡ ��� ũ�Ⱑ �޶���)
			heightSize = height;
			break;
		case MeasureSpec.EXACTLY:// fill_parent, match_parent (�ܺο��� �̹� ũ�Ⱑ
									// �����Ǿ���)
			heightSize = MeasureSpec.getSize(heightMeasureSpec);
			height = heightSize;
			break;
		}

		// width ��¥ ũ�� ���ϱ�
		int widthMode = MeasureSpec.getMode(widthMeasureSpec);
		int widthSize = 0;
		switch (widthMode) {
		case MeasureSpec.UNSPECIFIED:// mode �� ���õ��� ���� ũ�Ⱑ �Ѿ�ö�
			widthSize = widthMeasureSpec;
			break;
		case MeasureSpec.AT_MOST:// wrap_content (�� ������ ũ�⿡ ��� ũ�Ⱑ �޶���)
			widthSize = width;
			break;
		case MeasureSpec.EXACTLY:// fill_parent, match_parent (�ܺο��� �̹� ũ�Ⱑ
									// �����Ǿ���)
			widthSize = MeasureSpec.getSize(widthMeasureSpec);
			width = widthSize;
			break;
		}

		if (widthSize < heightSize)
			heightSize = widthSize;
		else
			widthSize = heightSize;

		width = widthSize;
		height = heightSize;
		setMeasuredDimension(widthSize, heightSize);

		// mBmp = Bitmap.createBitmap(width, height, Config.ARGB_4444);
		// mCanvas = new Canvas(mBmp);
		paint.setAntiAlias(true);

		if (first) {
			first = false;
			RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this
					.getLayoutParams();
			if((int)start_x-35>0){
				layoutParams.leftMargin = (int)start_x-35;
			}
			else{
				layoutParams.leftMargin = 0;
			}
			
			if((int)start_y-35>0){
				layoutParams.topMargin = 233-(int)start_y+35;
			}
			else
			{
				layoutParams.topMargin = 233;
			}

			layoutParams.rightMargin = -250;
			layoutParams.bottomMargin = -250;
			this.setLayoutParams(layoutParams);
			_xDelta = 35;
			_yDelta = 35;
		}
	}

	@Override
	protected void onDraw(Canvas canvas) {

		paint.setColor(Color.parseColor("#ADADAD"));
		canvas.drawCircle(width / 2, height / 2, width / 2, paint);

		paint.setColor(color);
		canvas.drawCircle(width / 2, height / 2, width / 2 - 3, paint);
		// mCanvas.drawCircle(width / 2, height / 2, width / 2, paint);
	}

	int _xDelta;
	int _yDelta;

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		if (!fixed) {
			int X = (int) event.getRawX();
			int Y = (int) event.getRawY();
			if (Y > 460)
				Y -= 500;

			switch (event.getAction() & MotionEvent.ACTION_MASK) {
			case MotionEvent.ACTION_DOWN:
				RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) this
						.getLayoutParams();
				_xDelta = X - lParams.leftMargin;
				_yDelta = Y - lParams.topMargin;
				break;
			case MotionEvent.ACTION_UP:
				break;
			case MotionEvent.ACTION_POINTER_DOWN:
				break;
			case MotionEvent.ACTION_POINTER_UP:
				break;
			case MotionEvent.ACTION_MOVE:
				RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this
						.getLayoutParams();
				layoutParams.leftMargin = X - _xDelta;
				if(Y-_yDelta>233)
					layoutParams.topMargin = 233;
				else
					layoutParams.topMargin = Y - _yDelta;
				layoutParams.rightMargin = -250;
				layoutParams.bottomMargin = -250;
				this.setLayoutParams(layoutParams);
				break;
			}
		}
		return true;
	}
}
