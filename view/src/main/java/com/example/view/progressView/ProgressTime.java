package com.example.view.progressView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;


public class ProgressTime extends View {


    private Paint yuanPaint;
    private Paint yuanHuPaint;
    private Paint xiaoYuanPaint;

    public ProgressTime(Context context) {
        this(context,null,0);
    }

    public ProgressTime(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public ProgressTime(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        yuanPaint = new Paint();
        yuanPaint.setColor(Color.BLACK);
        yuanPaint.setStyle(Paint.Style.STROKE);
        yuanPaint.setStrokeWidth(2);

        yuanHuPaint = new Paint();
        yuanHuPaint.setColor(Color.BLUE);
        yuanHuPaint.setStyle(Paint.Style.STROKE);
        yuanHuPaint.setStrokeWidth(5);
        
        xiaoYuanPaint = new Paint();
        xiaoYuanPaint.setColor(Color.GREEN);
    }


    private int progress=0;

    private int Max=1;

    public void setMac(int progress){
        this.Max=progress;
        invalidate();
    }


    public void setProgress(int progress){
        this.progress=progress;
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();
        int r=(width>height?height:width)/2;
        canvas.drawCircle(width/2,height/2,r,yuanPaint);

        int jianGe=5;
        RectF rectF=new RectF(0+jianGe,height/2-r+jianGe,width-jianGe,height/2+r-jianGe);

        if(Max!=0){
            canvas.drawCircle(width/2,height/2,progress*r/Max,xiaoYuanPaint);
            canvas.drawArc(rectF,0,progress*360/Max,false,yuanHuPaint);
        }
    }
}
