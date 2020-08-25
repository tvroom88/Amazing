package com.example.myapplication.spen;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.support.v7.widget.AppCompatImageView;

public class PalletColor extends AppCompatImageView{
	int width=300,height=50;
	int color=Color.BLACK;
	Context context;

	public PalletColor(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.context=context;
	}

	public PalletColor(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		this.context=context;
	}

	public PalletColor(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		this.context=context;
	}
}
