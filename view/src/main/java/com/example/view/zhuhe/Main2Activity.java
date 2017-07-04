package com.example.view.zhuhe;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.view.View;

import com.example.view.R;
import com.example.view.base.BaseActivity;

public class Main2Activity extends BaseActivity {

    private HaoyouFragment haoyouFragment;
    private XiaoXiFragment xiaoXiFragment;
    private ZhuyeFragment zhuyeFragment;
    private BottomView lastBottomView;
    private Fragment lastFragment;

    protected int getLayoutId() {
        return R.layout.activity_main2;
    }

    protected void findView() {
        lastBottomView = (BottomView) findViewById(R.id.bottom_pengyou);
    }


    protected void initData() {

        lastBottomView.Selected();

        haoyouFragment = new HaoyouFragment();
        xiaoXiFragment = new XiaoXiFragment();
        zhuyeFragment = new ZhuyeFragment();

        lastFragment=haoyouFragment;

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_FrameLayout,xiaoXiFragment);
        fragmentTransaction.hide(xiaoXiFragment);
        fragmentTransaction.add(R.id.main_FrameLayout,zhuyeFragment);
        fragmentTransaction.hide(zhuyeFragment);
        fragmentTransaction.add(R.id.main_FrameLayout,haoyouFragment);
        fragmentTransaction.commit();


    }

    public void onChoose(View view){
        BottomView  bottomView = (BottomView) view;
        if(!bottomView.equals(lastBottomView)){
            lastBottomView.UnSelected();
        }
        bottomView.Selected();
        lastBottomView=bottomView;

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

        switch (view.getId()){
            case R.id.bottom_pengyou:
                if(!(lastFragment instanceof HaoyouFragment)){
                    fragmentTransaction.hide(lastFragment);
                }
                lastFragment=haoyouFragment;
                fragmentTransaction.show(haoyouFragment);
                break;
            case R.id.bottom_xiaoxi:
                if(!(lastFragment instanceof XiaoXiFragment)){
                    fragmentTransaction.hide(lastFragment);
                }
                lastFragment=xiaoXiFragment;
                fragmentTransaction.show(xiaoXiFragment);
                break;
            case R.id.bottom_zhuye:
                if(!(lastFragment instanceof ZhuyeFragment)){
                    fragmentTransaction.hide(lastFragment);
                }
                lastFragment=zhuyeFragment;
                fragmentTransaction.show(zhuyeFragment);
                break;
        }
        fragmentTransaction.commit();
    }
}
