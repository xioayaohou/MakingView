package com.example.view.slide;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListView;

/**
 * Created by 20160903 on 2017/6/14.
 */

public class QQListView extends ListView {

    public QQListView(Context context) {
        this(context,null);
    }

    public QQListView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public QQListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        WindowManager windowManager= (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics=new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        screenWidth = displayMetrics.widthPixels;
    }

    private int pressX;
    private int pressY;
    private int pointToPosition;
    private ViewGroup childViewGroup;
    private boolean isSlideShow;
    private boolean isSlideClick;
    private int slideWidth;
    private int screenWidth;
    private LinearLayout.LayoutParams layoutParams;

    private VelocityTracker velocityTracker;  //速度追踪对象

    private void addVelocityTracker(MotionEvent event) {
        if (velocityTracker == null) {
            velocityTracker = VelocityTracker.obtain();
        }
        velocityTracker.addMovement(event);
    }

    private void deleteVelocityTracker(){
        if(velocityTracker!=null){
            velocityTracker.recycle();
            velocityTracker=null;
        }
    }

    public float dp2px(int dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp,getContext().getResources().getDisplayMetrics());
    }

    public boolean onInterceptTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:

                addVelocityTracker(event);

                isSlideClick=true;
                pressX= (int) event.getX();
                pressY= (int) event.getY();
                pointToPosition=pointToPosition(pressX,pressY);
                if(pointToPosition!=-1){
                    if(isSlideShow){
                        ViewGroup viewGroup= (ViewGroup) getChildAt(pointToPosition-getFirstVisiblePosition());
                        if(!childViewGroup.equals(viewGroup)){
                            turnNormal();
                        }
                    }
                    childViewGroup= (ViewGroup) getChildAt(pointToPosition-getFirstVisiblePosition());
                    slideWidth=childViewGroup.getChildAt(1).getLayoutParams().width;
                    layoutParams = (LinearLayout.LayoutParams)childViewGroup. getChildAt(0).getLayoutParams();
                    layoutParams.width=screenWidth;
                    childViewGroup.getChildAt(0).setLayoutParams(layoutParams);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                int nowX= (int) event.getX();
                int nowY= (int) event.getY();
                int diffX=nowX-pressX;
                if(Math.abs(diffX)>dp2px(4)||Math.abs(nowY-pressY)>dp2px(4)){
                    return true;
                }
                break;
            case MotionEvent.ACTION_UP:
                deleteVelocityTracker();
                break;
        }
        return super.onInterceptHoverEvent(event);
    }

    public boolean onTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                pressY= (int) ev.getY();
                pressX= (int) ev.getX();
                pointToPosition=pointToPosition(pressX,pressY);
                if(isSlideShow){
                    ViewGroup viewgroup= (ViewGroup) getChildAt(pointToPosition-getFirstVisiblePosition());
                    if(!childViewGroup.equals(viewgroup)){
                        turnNormal();
                    }
                }
                childViewGroup= (ViewGroup) getChildAt(pointToPosition-getFirstVisiblePosition());
                slideWidth=childViewGroup.getChildAt(1).getLayoutParams().width;

                Log.e("aaa","onTouchEvent+slideWidth: "+slideWidth);

                layoutParams= (LinearLayout.LayoutParams) childViewGroup.getChildAt(0).getLayoutParams();
                layoutParams.width=screenWidth;
                childViewGroup.getChildAt(0).setLayoutParams(layoutParams);
                break;
            case MotionEvent.ACTION_MOVE:
                int nowX= (int) ev.getX();
                int nowY= (int) ev.getY();
                int diffX=nowX-pressX;
                int diffY=nowY-pressY;

                Log.e("aaa",diffX+"");

                if(Math.abs(diffX)>Math.abs(diffY)&&Math.abs(diffY)<20){
                    if(!isSlideShow&&nowX<pressX){
                        if(-diffX>slideWidth){
                            diffX=-slideWidth;
                        }
                        layoutParams.leftMargin=diffX;
                        childViewGroup.getChildAt(0).setLayoutParams(layoutParams);
                        isSlideClick=false;
                    }else if(isSlideShow&&nowX>pressX){
                        if(diffX>slideWidth){
                            diffX=slideWidth;
                        }
                        layoutParams.leftMargin=diffX-slideWidth;
                        childViewGroup.getChildAt(0).setLayoutParams(layoutParams);
                        isSlideClick=false;
                    }

                }

             if(Math.abs(diffY)>20&&Math.abs(layoutParams.leftMargin)>5){
                  return true;
              }else{
                   break;
              }
            case MotionEvent.ACTION_UP:
                if(-layoutParams.leftMargin>=slideWidth/2){
                    layoutParams.leftMargin=-slideWidth;
                    childViewGroup.getChildAt(0).setLayoutParams(layoutParams);
                    isSlideShow=true;
                }else{
                    turnNormal();
                }
                break;
        }
        return super.onTouchEvent(ev);
    }

    public void turnNormal(){
        layoutParams.leftMargin=0;
        childViewGroup.getChildAt(0).setLayoutParams(layoutParams);
        isSlideShow=false;
    }
}
