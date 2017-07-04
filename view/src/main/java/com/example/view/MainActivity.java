package com.example.view;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.view.base.BaseActivity;
import com.example.view.checkDelete.CheckBoxActivity;
import com.example.view.d3d3v.M_3DActivity;
import com.example.view.dainming.DianmingActivity;
import com.example.view.hualang.HuaLangActivity;
import com.example.view.jishuanji.CalculatorActivity;
import com.example.view.lunpan_1.Lunpan1Activity;
import com.example.view.lunpan_2.Lunpan2Activity;
import com.example.view.posui.PoSuiActivity;
import com.example.view.progressView.ProgressActivity;
import com.example.view.shuangseqiu.ShuangseQiuActivity;
import com.example.view.slide.SlideDeleteView;
import com.example.view.tongxunlu.CommunicateActivity;
import com.example.view.yanhua.YuanHuaActivity;
import com.example.view.zhinanzheng.OrderActivity;
import com.example.view.zhuhe.Main2Activity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener {


    private ListView listView;

    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    protected void findView() {
        listView = (ListView) findViewById(R.id.main_listview);
    }

    protected void initData() {
        List<String>stringList=new ArrayList<>();
        stringList.add("炫酷进度条");
        stringList.add("转盘特效1");
        stringList.add("转盘特效2");
        stringList.add("多彩通讯录");
        stringList.add("炫酷画廊");
        stringList.add("3D立体图");
        stringList.add("指南针特效");
        stringList.add("侧滑栏删除");
        stringList.add("组合型动画");
        stringList.add("烟花及动画");
        stringList.add("粒子破碎图");
        stringList.add("点名特效图");
        stringList.add("批量删除图");
        stringList.add("计算器效图");
        stringList.add("双色球中奖");
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,stringList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i){
            case 0:
                startActivity(new Intent(MainActivity.this, ProgressActivity.class));
                break;
            case 1:
                startActivity(new Intent(MainActivity.this, Lunpan1Activity.class));
                break;
            case 2:
                startActivity(new Intent(MainActivity.this, Lunpan2Activity.class));
                break;
            case 3:
                startActivity(new Intent(MainActivity.this, CommunicateActivity.class));
                break;
            case 4:
                startActivity(new Intent(MainActivity.this, HuaLangActivity.class));
                break;
            case 5:
                startActivity(new Intent(MainActivity.this, M_3DActivity.class));
                break;
            case 6:
                startActivity(new Intent(MainActivity.this, OrderActivity.class));
                break;
            case 7:
                startActivity(new Intent(MainActivity.this, SlideDeleteView.class));
                break;
            case 8:
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
                break;
            case 9:
                startActivity(new Intent(MainActivity.this, YuanHuaActivity.class));
                break;
            case 10:
                startActivity(new Intent(MainActivity.this, PoSuiActivity.class));
                break;
            case 11:
                startActivity(new Intent(MainActivity.this, DianmingActivity.class));
                break;
            case 12:
                startActivity(new Intent(MainActivity.this, CheckBoxActivity.class));
                break;
            case 13:
                startActivity(new Intent(MainActivity.this, CalculatorActivity.class));
                break;
            case 14:
                startActivity(new Intent(MainActivity.this, ShuangseQiuActivity.class));
                break;
        }
    }
}
