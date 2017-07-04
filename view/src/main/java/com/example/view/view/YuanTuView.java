package com.example.view.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by 20160903 on 2017/6/13.
 */

public class YuanTuView extends ImageView {

    private Paint paint;

    public YuanTuView(Context context) {
        super(context);
        init(context,null);
    }

    public YuanTuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }


    public void init(Context context, AttributeSet attrs) {
        paint = new Paint();
        paint.setColor(Color.GREEN);
    }

    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();

        if(drawable!=null&&drawable instanceof BitmapDrawable){
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            canvas.saveLayer(0,0,getWidth(),getHeight(),null,0);
            int width=bitmap.getWidth();
            int height=bitmap.getHeight();
            int r=(width>height?height:width)/2;
            canvas.drawCircle(width/2,height/2,r,paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            Rect rect1 = new Rect(0, 0, width, height);
            Rect rect2 = new Rect(width / 2 - r, height / 2 - r, width / 2 + r, height / 2 + r);
            canvas.drawBitmap(bitmap,rect1,rect2,paint);
            paint.setXfermode(null);
            canvas.restore();
        }else{
            super.onDraw(canvas);
        }
    }
}
