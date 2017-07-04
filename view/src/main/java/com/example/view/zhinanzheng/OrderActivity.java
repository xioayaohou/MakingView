package com.example.view.zhinanzheng;

import com.example.view.R;
import com.example.view.base.BaseActivity;

public class OrderActivity extends BaseActivity{
    private CompassView compassView;
    protected int getLayoutId() {
        return R.layout.activity_order;
    }

    @Override
    protected void findView() {
        compassView = (CompassView) findViewById(R.id.compass);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onResume(){
        super.onResume();
        compassView.onResume();
    }

    @Override
    public void onPause(){
        super.onPause();
        compassView.onPause();
    }
}
