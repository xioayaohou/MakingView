package com.example.view.hualang;

import com.example.view.R;
import com.example.view.base.BaseActivity;

public class HuaLangActivity extends BaseActivity {

    private GalleryFlow gallery_flow;
    private int[] imageIds;

    protected int getLayoutId() {
        return R.layout.activity_hua_lang;
    }

    @Override
    protected void findView() {
        gallery_flow = (GalleryFlow) findViewById(R.id.gallery_flow);
    }

    @Override
    protected void initData() {
        imageIds = new int[]{
                R.mipmap.m10,
                R.mipmap.m11,
                R.mipmap.m12,
                R.mipmap.m13,
                R.mipmap.m10,
                R.mipmap.m11,
                R.mipmap.m12,
                R.mipmap.m13,
                R.mipmap.m10,
                R.mipmap.m11,
                R.mipmap.m12,
                R.mipmap.m13
        };
        ImageAdapter adapter = new ImageAdapter(this, imageIds);
        //向图片数组中加载图片
        adapter.createRefectedBitmap();
        gallery_flow.setAdapter(adapter);
    }
}
