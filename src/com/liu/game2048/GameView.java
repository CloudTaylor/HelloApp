package com.liu.game2048;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class GameView extends LinearLayout{

	public GameView(Context context) {
		super(context);
		initGame();
	}

	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initGame();
	}

	public GameView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initGame();
	}
	
	private void initGame(){
		setOrientation(LinearLayout.VERTICAL);
		setBackgroundColor(Color.GRAY);
		setOnTouchListener(new OnTouchListener() {
			private float startX, startY, offsetX, offsetY;
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch(event.getAction()){
				case MotionEvent.ACTION_DOWN:
					startX = event.getX();
					startY = event.getY();
					break;
				case MotionEvent.ACTION_UP:
					offsetX = event.getX() - startX;
					offsetY = event.getY() - startY;
					
					if(Math.abs(offsetX) > Math.abs(offsetY)){
						if(offsetX < -5){
							System.out.println("swipe left");
						} else if(offsetX > 5){
							System.out.println("swipe right");
						}
					} else if(Math.abs(offsetX) < Math.abs(offsetY)){
						if(offsetY < -5){
							System.out.println("swipe up");
						} else if(offsetY > 5){
							System.out.println("swipe down");
						}
					}
					break;
				}
				return true;
			}
		});
	}

}
