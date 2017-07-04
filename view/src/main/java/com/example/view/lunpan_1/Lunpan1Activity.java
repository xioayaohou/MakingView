package com.example.view.lunpan_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.view.R;
import com.example.view.base.BaseActivity;

public class Lunpan1Activity extends BaseActivity {
    
    ZhuanPan mLuckyPanView;
    private ImageView mStartBtn;

    protected int getLayoutId() {
        return R.layout.activity_lunpan1;
    }

    protected void findView() {
        mLuckyPanView = (ZhuanPan) findViewById(R.id.id_luckypan);
        mStartBtn = (ImageView) findViewById(R.id.id_start_btn);
    }

    protected void initData() {
        mStartBtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if (!mLuckyPanView.isStart())
                {
                    mStartBtn.setImageResource(R.mipmap.stop);
                    mLuckyPanView.luckyStart(1);
                } else
                {
                    if (!mLuckyPanView.isShouldEnd())

                    {
                        mStartBtn.setImageResource(R.mipmap.start);
                        mLuckyPanView.luckyEnd();
                    }
                }
            }
        });
    }
}
