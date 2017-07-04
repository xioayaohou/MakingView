package com.example.view.zhuhe;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.view.R;

public class BottomView extends LinearLayout {

    private int normalImageView;
    private int pressImageView;
    private TextView textView;
    private ImageView imageView;

    public BottomView(Context context) {
        super(context);
        initData(context,null,0);
    }

    public BottomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initData(context,attrs,0);
    }

    public BottomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData(context,attrs,defStyleAttr);
    }

    public void initData(Context context, AttributeSet attrs, int defStyleAttr){
        View view= LayoutInflater.from(context).inflate(R.layout.bottom_view,this,true);
        textView = (TextView) view.findViewById(R.id.bottom_TextView);
        imageView = (ImageView) view.findViewById(R.id.bottom_ImageView);
        TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.BottomView);
        String nowString = typedArray.getString(R.styleable.BottomView_text);
        normalImageView = typedArray.getResourceId(R.styleable.BottomView_normal, -1);
        pressImageView = typedArray.getResourceId(R.styleable.BottomView_press, -1);
        textView.setText(nowString);
        imageView.setImageResource(normalImageView);
    }


    private boolean pressBoolean;

    public void Selected(){
        if(pressBoolean){
            return;
        }
        pressBoolean=true;
        imageView.setImageResource(pressImageView);
        TranslateAnimation animation=new TranslateAnimation(
                Animation.RELATIVE_TO_SELF,0,
                Animation.RELATIVE_TO_SELF,0,
                Animation.RELATIVE_TO_SELF,0,
                Animation.RELATIVE_TO_SELF,1.2f);
        animation.setDuration(100);
        animation.setFillAfter(true);
        textView.startAnimation(animation);

        ScaleAnimation scaleAnimation=new ScaleAnimation(1,1.3f,1,1.5f,
                Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0);
        scaleAnimation.setDuration(200);
        scaleAnimation.setFillAfter(true);
        imageView.startAnimation(scaleAnimation);
    }

    public void UnSelected(){
        pressBoolean=false;
        imageView.setImageResource(normalImageView);
        TranslateAnimation animation=new TranslateAnimation(
                Animation.RELATIVE_TO_SELF,0,
                Animation.RELATIVE_TO_SELF,0,
                Animation.RELATIVE_TO_SELF,0.3f,
                Animation.RELATIVE_TO_SELF,0);
        animation.setDuration(100);
        animation.setFillAfter(true);
        textView.startAnimation(animation);

        ScaleAnimation scaleAnimation=new ScaleAnimation(1.3f,1f,1.5f,1f,
                Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0);
        scaleAnimation.setDuration(200);
        scaleAnimation.setFillAfter(true);
        imageView.startAnimation(scaleAnimation);


    }
}
