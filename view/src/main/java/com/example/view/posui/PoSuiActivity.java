package com.example.view.posui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.view.R;
import com.example.view.base.BaseActivity;

public class PoSuiActivity extends BaseActivity {
    protected int getLayoutId() {
        return R.layout.activity_po_sui;
    }

    protected void findView() {

    }

    protected void initData() {
        ExplosionField explosionField = new ExplosionField(this);
        explosionField.addListener(findViewById(R.id.activity_po_sui));
    }
}
