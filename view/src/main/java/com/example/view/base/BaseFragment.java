package com.example.view.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 20160903 on 2017/6/12.
 */

public abstract class BaseFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(getLayoutId(),container,false);
        findView(view);
        initData();
        return view;
    }

    protected abstract int getLayoutId();

    protected abstract void findView(View view);

    protected abstract void initData();
}
