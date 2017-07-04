package com.example.view.checkDelete;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.view.R;

import java.util.List;


public class CheckAdapter extends BaseAdapter {

    List<Checkes> stringList;
    Context context;

    int id= View.GONE;

    public void setid(int iidd){
        id=iidd;
    }

    public CheckAdapter(List<Checkes> stringList, Context context) {
        this.stringList = stringList;
        this.context = context;
    }

    public int getCount() {
        return stringList.size();
    }

    public Object getItem(int position) {
        return stringList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View convertView, final ViewGroup parent) {
        final MyCheckHolder myCheckHolder;
        if(convertView==null){
            myCheckHolder=new MyCheckHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
            myCheckHolder.checkBox= (CheckBox) convertView.findViewById(R.id.checkboxs);
            myCheckHolder.textView= (TextView) convertView.findViewById(R.id.textview);
            convertView.setTag(myCheckHolder);
        }else{
            myCheckHolder= (MyCheckHolder) convertView.getTag();
        }
        myCheckHolder.textView.setText(stringList.get(position).getName());
        myCheckHolder.checkBox.setChecked(stringList.get(position).isCheck());
        myCheckHolder.checkBox.setVisibility(id);
        myCheckHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        stringList.get(position).setCheck(true);
                    }else{
                        stringList.get(position).setCheck(false);
                    }
            }
        });
        return convertView;
    }

    class MyCheckHolder{
        CheckBox checkBox;
        TextView textView;
    }
}
