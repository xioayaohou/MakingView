package com.example.view.shuangseqiu;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.view.R;

import java.util.List;

/**
 * Created by 20160903 on 2017/5/22.
 */

public class MyAdpter extends BaseAdapter {

    List<Integer> integerList;
    Context context;

    private int nowColor= Color.GRAY;
    private List<Integer>iLs=null;

    public void setNowColor(int nowColor,List<Integer>iLs) {
        this.nowColor = nowColor;
        this.iLs=iLs;
    }

    public MyAdpter(List<Integer> integerList, Context context) {
        this.integerList = integerList;
        this.context = context;
    }

    public int getCount() {
        return integerList.size();
    }

    public Object getItem(int i) {
        return integerList.get(i);
    }

    public long getItemId(int i) {
        return i;
    }


    public View getView(int i, View contentView, ViewGroup viewGroup) {
        ShuangSheHolder shuangSheHolder;
        if(contentView==null){
            shuangSheHolder=new ShuangSheHolder();
            contentView= LayoutInflater.from(context).inflate(R.layout.textview_only,viewGroup,false);
            shuangSheHolder.textView= (TextYuanShape) contentView.findViewById(R.id.only1);
            contentView.setTag(shuangSheHolder);
        }else{
            shuangSheHolder= (ShuangSheHolder) contentView.getTag();
        }
        shuangSheHolder.textView.setText(integerList.get(i)+"");

        if(iLs!=null){
            shuangSheHolder.textView.setTextColor(Color.GRAY);
            for (int j = 0; j <iLs.size() ; j++) {
                int data=iLs.get(j);
                if(data-1==i){
                    shuangSheHolder.textView.setTextColor(nowColor);
                }
            }
        }
        return contentView;
    }

    static class ShuangSheHolder{
        TextYuanShape textView;
    }
}
