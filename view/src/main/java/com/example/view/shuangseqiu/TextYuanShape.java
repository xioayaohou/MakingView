package com.example.view.shuangseqiu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 20160903 on 2017/1/12.
 */

public class TextYuanShape extends View {

    private Paint paint;
    private String text="0";
    private int h;
    private int w;
    private Paint paintText;
    private int textColor=Color.GRAY;
    private int yuanColor=Color.parseColor("#11000000");


    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
        invalidate();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        invalidate();
    }

    public TextYuanShape(Context context) {
        super(context);
        init(context, null, 0);
    }

    public TextYuanShape(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public TextYuanShape(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        paint = new Paint();
        paintText = new Paint();
        w = getResources().getDisplayMetrics().widthPixels;
        h = getResources().getDisplayMetrics().heightPixels;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(yuanColor);
        canvas.drawCircle(w/12,w/11,w/30,paint);
        paintText.setColor(textColor);
        paintText.setTextSize(w/25);
        canvas.drawText(text,w/15,w/10,paintText);
    }
}
