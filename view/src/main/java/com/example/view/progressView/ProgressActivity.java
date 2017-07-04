package com.example.view.progressView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;

import com.example.view.R;
import com.example.view.base.BaseActivity;

public class ProgressActivity extends BaseActivity implements SeekBar.OnSeekBarChangeListener {

    private SeekBar seekBar;
    private ProgressTime progressTime;

    protected int getLayoutId() {
        return R.layout.activity_progress;
    }

    protected void findView() {
        seekBar = (SeekBar) findViewById(R.id.haoyou_seekBar);
        progressTime = (ProgressTime)findViewById(R.id.ProgressTime);
    }

    protected void initData() {
        seekBar.setOnSeekBarChangeListener(this);
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        progressTime.setProgress(i);
        progressTime.setMac(100);
    }

    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
