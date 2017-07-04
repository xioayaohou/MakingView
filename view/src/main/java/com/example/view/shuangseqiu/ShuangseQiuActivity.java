package com.example.view.shuangseqiu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import com.example.view.R;
import com.example.view.base.BaseActivity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ShuangseQiuActivity extends BaseActivity implements View.OnClickListener {


    private Random random;
    private HashSet<Integer> integerHashSet;
    private List<Integer> integerList = null;
    private MyAdpter myAdpter1;
    private MyAdpter myAdpter2;
    private List<Integer> integerList2;
    private TextView red;
    private TextView blue;


    protected int getLayoutId() {
        return R.layout.activity_shuangse_qiu;
    }

    @Override
    protected void findView() {
        initGridView();

        random = new Random();
        integerHashSet = new HashSet<>();
        integerList = new ArrayList<>();
        integerList2 = new ArrayList<>();
        red = (TextView) findViewById(R.id.red_result);
        blue = (TextView) findViewById(R.id.blue_result);
    }

    @Override
    protected void initData() {

    }

    private void initGridView() {
        GridView gridView1 = (GridView) findViewById(R.id.g1);
        List<Integer> stringList1 = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            stringList1.add(i + 1);
        }
        myAdpter1 = new MyAdpter(stringList1, this);
        gridView1.setAdapter(myAdpter1);


        GridView gridView2 = (GridView) findViewById(R.id.g2);
        List<Integer> stringList2 = new ArrayList<>();
        for (int j = 0; j < 16; j++) {
            stringList2.add(j + 1);
        }
        myAdpter2 = new MyAdpter(stringList2, this);
        gridView2.setAdapter(myAdpter2);

        TextView kaPai = (TextView) findViewById(R.id.card_fapai);
        kaPai.setOnClickListener(this);
    }

    public void onClick(View view) {
        initShuijiDianming();
    }

    private void initShuijiDianming() {
        if (integerList.size() != 0) {
            myAdpter1.setNowColor(Color.GRAY, integerList);
            myAdpter1.notifyDataSetChanged();
            myAdpter2.setNowColor(Color.GRAY, integerList2);
            myAdpter2.notifyDataSetChanged();
        }
        integerList.clear();
        integerHashSet.clear();
        integerList2.clear();

        randomSet(1, 33, 6, integerHashSet);
        Iterator<Integer> iterator = integerHashSet.iterator();
        while (iterator.hasNext()) {
            integerList.add(iterator.next());
        }

        int  realData = random.nextInt(16) + 1;
        integerList2.add(realData);
        blue.setText(realData+"");

        myAdpter1.setNowColor(Color.RED, integerList);
        myAdpter1.notifyDataSetChanged();
        myAdpter2.setNowColor(Color.BLUE, integerList2);
        myAdpter2.notifyDataSetChanged();

        sort(integerList);
        String good=null;
        for (int i = 0; i < integerList.size(); i++) {
            int data=integerList.get(i);
            if(i==0){
                good=data+"";
            }else{
                good+=" 、 "+data;
            }
        }
        red.setText(good);
    }

    private boolean isSample = false;
    private int realData;

    public void randomSet(int min, int max, int n, HashSet<Integer> set) {
        if (n > (max - min + 1) || max < min) {
            return;
        }
        for (int i = 0; i < n; i++) {
            int num = (int) (Math.random() * (max - min)) + min;
            set.add(num);
        }
        int setSize = set.size();
        if (setSize < n) {
            randomSet(min, max, n - setSize, set);
        }
    }


    private void sort(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 1; j < list.size() - i; j++) {
                Integer a;
                if (list.get(j - 1).compareTo(list.get(j)) > 0) { // 比较两个整数的大小
                    a = list.get(j - 1);
                    list.set((j - 1), list.get(j));
                    list.set(j, a);
                }
            }
        }
    }
}
