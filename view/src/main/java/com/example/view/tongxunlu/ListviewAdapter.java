package com.example.view.tongxunlu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.view.R;
import com.example.view.tongxunlu.Selfphone;

import java.util.List;

/**
 * Created by 20160903 on 2016/12/24.
 */

public class ListviewAdapter extends BaseAdapter{

    List<Selfphone> selfphoneList;
    Context context;

    public ListviewAdapter(List<Selfphone> selfphoneList, Context context) {
        this.selfphoneList = selfphoneList;
        this.context = context;
    }

    public void updateListView(List<Selfphone> list){
        this.selfphoneList = list;
        notifyDataSetChanged();
    }

    public int getCount() {
        return selfphoneList.size();
    }

    public Object getItem(int position) {
        return selfphoneList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        SelfHoldwer selfHoldwer;
        if(convertView==null){
            selfHoldwer=new SelfHoldwer();
            convertView= LayoutInflater.from(context).inflate(R.layout.pingying_item,parent,false);
            selfHoldwer.name= (TextView) convertView.findViewById(R.id.sp_name);
            selfHoldwer.title= (TextView) convertView.findViewById(R.id.sp_pinying);
            selfHoldwer.self= (TextView) convertView.findViewById(R.id.sp_selfphone);
            convertView.setTag(selfHoldwer);
        }else{
            selfHoldwer= (SelfHoldwer) convertView.getTag();
        }
        selfHoldwer.name.setText(selfphoneList.get(position).getName());
        selfHoldwer.self.setText(selfphoneList.get(position).getSelfphone());
        selfHoldwer.title.setEnabled(false);
        selfHoldwer.title.setClickable(false);
        int section = getSectionForPosition(position);
        if(position == getPositionForSection(section)){
            selfHoldwer.title.setVisibility(View.VISIBLE);
            selfHoldwer.title.setText(selfphoneList.get(position).getTitle());
        }else{
            selfHoldwer.title.setVisibility(View.GONE);
        }
        return convertView;
    }

    public int getSectionForPosition(int position) {
        return selfphoneList.get(position).getTitle().charAt(0);
    }

    public int getPositionForSection(int section) {
        for (int i = 0; i < getCount(); i++) {
            String sortStr = selfphoneList.get(i).getTitle();
            char firstChar = sortStr.toUpperCase().charAt(0);
            if (firstChar == section) {
                return i;
            }
        }
        return -1;
    }

    static class SelfHoldwer{
        TextView name;
        TextView title;
        TextView self;
    }
}
