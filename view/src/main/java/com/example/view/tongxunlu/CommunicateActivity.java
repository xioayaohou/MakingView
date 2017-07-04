package com.example.view.tongxunlu;

import android.util.Log;

import com.example.view.R;
import com.example.view.base.BaseActivity;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CommunicateActivity extends BaseActivity implements SideBar.ISideBarSelectCallBack, PingyingListview.RemoveListener {

    private SideBar sideBar;
    private PingyingListview listView;
    private List<Selfphone> selfphones;
    private ListviewAdapter listviewAdapter;
    private PinyinComparator pinyinComparator;

    protected int getLayoutId() {
        return R.layout.activity_communicate;
    }

    protected void findView() {
        sideBar = (SideBar) findViewById(R.id.side_bar);
        listView = (PingyingListview)findViewById(R.id.zhuye_ListView);
    }

    protected void initData() {
        sideBar.setOnStrSelectCallBack(this);
        pinyinComparator = new PinyinComparator();
        selfphones = initData(name);
        Collections.sort(selfphones, pinyinComparator);
        listviewAdapter = new ListviewAdapter(selfphones,this);
        listView.setAdapter(listviewAdapter);
        listView.setRemoveListener(this);
    }

    public void onSelectStr(int index, String selectStr) {
        for (int i = 0; i < selfphones.size(); i++) {
            if (selectStr.equalsIgnoreCase(selfphones.get(i).getTitle().toUpperCase())) {
                listView.setSelection(i);
                return;
            }
        }
    }

    private String  name[]={"多个","地方","回复","帅哥","百度","是否","维持","导航","手动","用户","手动","发给","地方","让它","欧尼","通过","平板","美女","怎么","去吗"};

    private List<Selfphone> initData(String [] date){
        List<Selfphone> selfphoneList = new ArrayList<Selfphone>();
        for(int i=0; i<date.length; i++){
            Selfphone sortModel = new Selfphone();
            sortModel.setName(date[i]);
            sortModel.setSelfphone("15185113901");
            String pinyin = getHead(name[i]);
            if(pinyin.matches("[a-z]")){
                sortModel.setTitle(pinyin.toUpperCase());
            }else{
                sortModel.setTitle("#");
            }
            selfphoneList.add(sortModel);
        }
        return selfphoneList;
    }

    public void removeItem(PingyingListview.RemoveDirection direction, int position) {
        if(direction== PingyingListview.RemoveDirection.LEFT){
            Log.e("aaa","left");
            selfphones.remove(position);
            listviewAdapter.notifyDataSetChanged();
        }
    }

    class PinyinComparator implements Comparator<Selfphone> {
        public int compare(Selfphone o1, Selfphone o2) {
            if (o2.getTitle().equals("#")) {
                return -1;
            } else if (o1.getTitle().equals("#")) {
                return 1;
            } else {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        }
    }

    private  int GB_SP_DIFF = 160;
    static final int[] secPosValueList = { 1601, 1637, 1833, 2078, 2274, 2302,2433, 2594, 2787, 3106, 3212, 3472, 3635, 3722, 3730, 3858, 4027,4086, 4390, 4558, 4684, 4925, 5249, 5600 };
    private  char[] firstLetter = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h','j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'w', 'x','y', 'z' };
    private String  getHead(String str){
        String spells = getHeadLetter(str);
        return  spells.substring(0, 1).toLowerCase();
    }

    public  String getHeadLetter(String characters) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < characters.length(); i++) {

            char ch = characters.charAt(i);
            if ((ch >> 7) == 0) {
                return characters;
            } else {
                char spell = getFirstLetter(ch);
                buffer.append(String.valueOf(spell));
            }
        }
        return buffer.toString();
    }
    public  Character getFirstLetter(char ch) {
        byte[] uniCode = null;
        try {
            uniCode = String.valueOf(ch).getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
        if (uniCode[0] < 128 && uniCode[0] > 0) {
            return null;
        } else {
            return convert(uniCode);
        }
    }
    public  char convert(byte[] bytes) {
        char result = '-';
        int secPosValue = 0;
        int i;
        for (i = 0; i < bytes.length; i++) {
            bytes[i] -= GB_SP_DIFF;
        }
        secPosValue = bytes[0] * 100 + bytes[1];
        for (i = 0; i < 23; i++) {
            if (secPosValue >= secPosValueList[i]
                    && secPosValue < secPosValueList[i + 1]) {
                result = firstLetter[i];
                break;
            }
        }
        return result;
    }
}
