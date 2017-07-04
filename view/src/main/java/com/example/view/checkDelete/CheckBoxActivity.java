package com.example.view.checkDelete;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;
import com.example.view.R;
import java.util.ArrayList;
import java.util.List;

public class CheckBoxActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener, View.OnClickListener, AbsListView.OnScrollListener, AdapterView.OnItemClickListener {

    private CheckAdapter mCheckAdapter;
    private List<Checkes> stringList;
    private ListView listView;
    private Button button;
    private View view;
    private Handler handler;
    int index=0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        listView = (ListView) findViewById(R.id.listview);
        handler = new Handler();
        initCheck();
    }


    private void initCheck(){
        view = LayoutInflater.from(this).inflate(R.layout.textview,null);
        button = (Button) view.findViewById(R.id.textview1);
        button.setOnClickListener(this);
        listView.addFooterView(view);

        stringList = new ArrayList<>();
        addList();
        mCheckAdapter = new CheckAdapter(stringList,this);
        listView.setAdapter(mCheckAdapter);
        listView.setOnItemLongClickListener(this);
        listView.setOnScrollListener(this);
        listView.setOnItemClickListener(this);
    }


    public void onClick(View v) {
        button.setText("正在加载中。。。");
        handler.postDelayed(new Runnable() {
            public void run() {
                addList();
                mCheckAdapter.notifyDataSetChanged();
                button.setText("点击查看更多");
            }
        },2000);
    }

    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if(listView.getFooterViewsCount()==stringList.size()){
            listView.removeFooterView(view);
        }
    }

    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if(listView.getFooterViewsCount()==stringList.size()){
            listView.removeFooterView(view);
        }
    }

    private void addList(){
        for (int i = 0; i <15; i++) {
            Checkes c=new Checkes("美女"+(index*15+i),false);
            stringList.add(c);
        }
        index++;
    }

    private void showToast(String str){
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    private int count=1;

    public void allchaozuo(View view) {
        switch (view.getId()){
            case R.id.m2_all:
                if(isAllselected==true){
                    for (int i = 0; i < stringList.size(); i++) {
                        if(stringList.get(i).isCheck()==false){
                            stringList.get(i).setCheck(true);
                        }
                    }
                    mCheckAdapter.notifyDataSetChanged();
                }else{
                    showToast("不能执行这个操作");
                }
                break;
            case R.id.m2_delete:
                if(isAllselected==true){
                    for (int i = 0; i < stringList.size(); i++) {
                        if(stringList.get(i).isCheck()==true){
                            stringList.get(i).setCheck(false);
                        }
                    }
                    mCheckAdapter.notifyDataSetChanged();
                }else{
                    showToast("不能执行这个操作");
                }
                break;
            case R.id.m2_shanchu:
                if(isAllselected==true){
                    for (int i = 0; i <stringList.size() ;) {
                        Checkes mCheckes=stringList.get(i);
                        if(mCheckes.isCheck()==true){
                            stringList.remove(i);
                            continue;
                        }
                        i++;
                    }
                    isAllselected=false;
                    mCheckAdapter.setid(View.GONE);
                    mCheckAdapter.notifyDataSetChanged();
                }else{
                    showToast("不能执行这个操作");
                }
                break;
            case R.id.m2_add:
                if(isAllselected==true){
                    showToast("不能执行这个操作");
                }else{
                    Checkes c=new Checkes("美女"+count,false);
                    stringList.add(c);
                    mCheckAdapter.notifyDataSetChanged();
                    count++;
                }
                break;
        }
    }

    private boolean isAllselected=false;

    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        isAllselected=true;
        mCheckAdapter.setid(View.VISIBLE);
        CheckBox checkBox= (CheckBox) view.findViewById(R.id.checkboxs);
        checkBox.setChecked(true);
        mCheckAdapter.notifyDataSetChanged();
        return true;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        showToast(stringList.get(position).getName());
    }
}
