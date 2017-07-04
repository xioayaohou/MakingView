package com.example.view.slide;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.view.R;
import com.example.view.base.BaseActivity;

import java.util.ArrayList;

public class SlideDeleteView extends BaseActivity {
    private static final String TAG = "SlideDeleteView";
    private QQListView mSideslipListView;
    private ArrayList<String> mDataList = new ArrayList<String>() {
        {
            for (int i = 0; i < 50; i++) {
                add("ListView item  " + i);
            }
        }
    };
    protected int getLayoutId() {
        return R.layout.activity_slide_delete_view;
    }

    @Override
    protected void findView() {
        mSideslipListView = (QQListView) findViewById(R.id.scrollView1);
        mSideslipListView.setAdapter(new CustomAdapter());//设置适配器
    }

    @Override
    protected void initData() {

    }

    class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return mDataList.size();
        }

        @Override
        public Object getItem(int position) {
            return mDataList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, final ViewGroup parent) {
            ViewHolder viewHolder;
            if (null == convertView) {
                convertView = View.inflate(SlideDeleteView.this, R.layout.chehua_layout, null);
                viewHolder = new ViewHolder();
                viewHolder.textView = (TextView) convertView.findViewById(R.id.textView);
                viewHolder.txtv_delete = (TextView) convertView.findViewById(R.id.txtv_delete);
                viewHolder.zhiding = (TextView) convertView.findViewById(R.id.txtv_zhiding);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.textView.setText(mDataList.get(position));
            final int pos = position;
            viewHolder.txtv_delete.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mDataList.remove(pos);
                    notifyDataSetChanged();
                    mSideslipListView.turnNormal();
                }
            });

            viewHolder.zhiding.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mDataList.add(0,mDataList.get(pos));
                    mDataList.remove(pos+1);
                    notifyDataSetChanged();
                    mSideslipListView.turnNormal();
                }
            });
            return convertView;
        }
    }

    class ViewHolder {
        public TextView textView;
        public TextView txtv_delete;
        public TextView zhiding;
    }
}
