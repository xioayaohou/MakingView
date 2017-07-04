package com.example.view.yanhua;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;

import com.example.view.R;

public class YuanHuaActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SurfaceView v = new SurfaceView(this);
        HolderSurfaceView.getInstance().setSurfaceView(v);
        v.setBackgroundResource(R.mipmap.m11);
        this.setContentView(v);
        DrawYH yh=new DrawYH();
        v.setOnTouchListener(yh);
        yh.begin();
        DrawText drawText=new DrawText();
        drawText.set();
    }
}
