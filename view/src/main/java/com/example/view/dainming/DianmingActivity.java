package com.example.view.dainming;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.view.R;
import com.example.view.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class DianmingActivity extends BaseActivity {


    private List<CheckBox> buttonList;
    private int runTime=200;
    private boolean isTuichu;
    private int count=0;
    private int actualAll=0;
    private int secondsAll=0;
    private int actualCount=0;
    private int seconds=0;
    private SensorManager sensorManager;


    protected int getLayoutId() {
        return R.layout.activity_dianming;
    }

    protected void findView() {

    }

    protected void initData() {
        buttonList = new ArrayList<>();
        initButton();
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }
    protected void onResume() {
        super.onResume();
        if (sensorManager != null){
            sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    protected void onPause() {
        super.onPause();
        if (sensorManager != null){
            sensorManager.unregisterListener(sensorEventListener);
        }
    }

    private SensorEventListener sensorEventListener = new SensorEventListener() {
        public void onSensorChanged(SensorEvent event) {
            float[] values = event.values;
            float x = values[0];
            float y = values[1];
            float z = values[2];
            int medumValue = 20;
            if (Math.abs(x) > medumValue || Math.abs(y) > medumValue || Math.abs(z) > medumValue) {
                initShuijiDianming();
            }
        }

        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    private int getShuijishu(){
        return (int) (Math.random() * 60);
    }

    private Handler handler=new Handler(){
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==1){
                int nowPosition=msg.arg1;
                for (int i = 0; i < buttonList.size(); i++) {
                    if(i==nowPosition){
                        buttonList.get(nowPosition).setChecked(true);
                    }else{
                        buttonList.get(i).setChecked(false);
                    }
                }
            }
        }
    };

    public void selected(View view) {
        isTuichu=true;
        switch (view.getId()){
            case R.id.m4_start:
                new Thread(){
                    public void run() {
                        super.run();
                        while (true){
                            count=count%buttonList.size();
                            Message message=Message.obtain();
                            message.what=1;
                            message.arg1=count;
                            count++;
                            handler.sendMessage(message);
                            try {
                                Thread.sleep(runTime);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if(isTuichu==false){
                                break;
                            }
                        }
                    }
                }.start();
                break;
            case R.id.m4_end:
                isTuichu=false;
                handler.removeMessages(1);
                break;
        }
    }

    private void initShuijiDianming(){
        seconds=getShuijishu();
        secondsAll+=seconds;
        new Thread(){
            public void run() {
                super.run();
                while (true){
                    count=count%buttonList.size();
                    Message message=Message.obtain();
                    message.what=1;
                    message.arg1=count;
                    count++;
                    actualCount++;
                    handler.sendMessage(message);
                    try {
                        Thread.sleep(runTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(secondsAll==actualAll+actualCount){
                        actualAll+=actualCount;
                        actualCount=0;
                        break;
                    }
                }
            }
        }.start();
    }

    private void initButton(){
        CheckBox b1= (CheckBox) findViewById(R.id.b1);
        CheckBox b2= (CheckBox) findViewById(R.id.b2);
        CheckBox b3= (CheckBox) findViewById(R.id.b3);
        CheckBox b4= (CheckBox) findViewById(R.id.b4);
        CheckBox b5= (CheckBox) findViewById(R.id.b5);
        CheckBox b6= (CheckBox) findViewById(R.id.b6);
        CheckBox b7= (CheckBox) findViewById(R.id.b7);
        CheckBox b8= (CheckBox) findViewById(R.id.b8);
        CheckBox b9= (CheckBox) findViewById(R.id.b9);
        CheckBox b10= (CheckBox) findViewById(R.id.b10);
        CheckBox b11= (CheckBox) findViewById(R.id.b11);
        CheckBox b12= (CheckBox) findViewById(R.id.b12);
        CheckBox b13= (CheckBox) findViewById(R.id.b13);
        CheckBox b14= (CheckBox) findViewById(R.id.b14);
        CheckBox b15= (CheckBox) findViewById(R.id.b15);
        CheckBox b16= (CheckBox) findViewById(R.id.b16);
        CheckBox b17= (CheckBox) findViewById(R.id.b17);
        CheckBox b18= (CheckBox) findViewById(R.id.b18);
        CheckBox b19= (CheckBox) findViewById(R.id.b19);
        CheckBox b20= (CheckBox) findViewById(R.id.b20);
        buttonList.add(b1);
        buttonList.add(b2);
        buttonList.add(b3);
        buttonList.add(b4);
        buttonList.add(b5);
        buttonList.add(b6);
        buttonList.add(b7);
        buttonList.add(b8);
        buttonList.add(b9);
        buttonList.add(b10);
        buttonList.add(b11);
        buttonList.add(b12);
        buttonList.add(b13);
        buttonList.add(b14);
        buttonList.add(b15);
        buttonList.add(b16);
        buttonList.add(b17);
        buttonList.add(b18);
        buttonList.add(b19);
        buttonList.add(b20);
        for (int i = 0; i < buttonList.size(); i++) {
            final int nowPosition = i;
            buttonList.get(i).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        buttonList.get(nowPosition).setBackgroundColor(Color.BLUE);
                    }else{
                        buttonList.get(nowPosition).setBackgroundColor(Color.WHITE);
                    }
                }
            });
        }
    }
}
