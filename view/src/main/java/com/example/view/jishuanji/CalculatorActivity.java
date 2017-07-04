package com.example.view.jishuanji;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.view.R;
import com.example.view.base.BaseActivity;

public class CalculatorActivity extends BaseActivity implements View.OnClickListener {


    private EditText editText;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_calculator;
    }

    @Override
    protected void findView() {
        initView();
    }

    @Override
    protected void initData() {

    }

    private void initView(){
        //数字
        TextView data0= (TextView) findViewById(R.id.t0);
        TextView data1= (TextView) findViewById(R.id.t1);
        TextView data2= (TextView) findViewById(R.id.t2);
        TextView data3= (TextView) findViewById(R.id.t3);
        TextView data4= (TextView) findViewById(R.id.t4);
        TextView data5= (TextView) findViewById(R.id.t5);
        TextView data6= (TextView) findViewById(R.id.t6);
        TextView data7= (TextView) findViewById(R.id.t7);
        TextView data8= (TextView) findViewById(R.id.t8);
        TextView data9= (TextView) findViewById(R.id.t9);

        //符号
        TextView add= (TextView) findViewById(R.id.add);
        TextView jian= (TextView) findViewById(R.id.jian);
        TextView cheneg= (TextView) findViewById(R.id.cheng);
        TextView chu= (TextView) findViewById(R.id.chu);
        TextView result= (TextView) findViewById(R.id.result);
        TextView back= (TextView) findViewById(R.id.back);
        TextView delete= (TextView) findViewById(R.id.delete);
        TextView dian= (TextView) findViewById(R.id.dian);

        //结果
        editText = (EditText) findViewById(R.id.EditText);

        //监听
        data0.setOnClickListener(this);
        data1.setOnClickListener(this);
        data2.setOnClickListener(this);
        data3.setOnClickListener(this);
        data4.setOnClickListener(this);
        data5.setOnClickListener(this);
        data6.setOnClickListener(this);
        data7.setOnClickListener(this);
        data8.setOnClickListener(this);
        data9.setOnClickListener(this);

        add.setOnClickListener(this);
        jian.setOnClickListener(this);
        cheneg.setOnClickListener(this);
        chu.setOnClickListener(this);
        result.setOnClickListener(this);
        back.setOnClickListener(this);
        delete.setOnClickListener(this);
        dian.setOnClickListener(this);
    }

    public void onClick(View view) {
        String result = editText.getText().toString();
        switch (view.getId()){
            case R.id.t0:
                editText.setText(result+"0");
                break;
            case R.id.t1:
                editText.setText(result+"1");
                break;
            case R.id.t2:
                editText.setText(result+"2");
                break;
            case R.id.t3:
                editText.setText(result+"3");
                break;
            case R.id.t4:
                editText.setText(result+"4");
                break;
            case R.id.t5:
                editText.setText(result+"5");
                break;
            case R.id.t6:
                editText.setText(result+"6");
                break;
            case R.id.t7:
                editText.setText(result+"7");
                break;
            case R.id.t8:
                editText.setText(result+"8");
                break;
            case R.id.t9:
                editText.setText(result+"9");
                break;
            case R.id.add:
                add(result);
                break;
            case R.id.jian:
                jian(result);
                break;
            case R.id.cheng:
                cheng(result);
                break;
            case R.id.chu:
                chu(result);
                break;
            case R.id.result:
                editText.setText(getResult(result));
                break;
            case R.id.back:
                if(result.length()>0){
                    editText.setText(result.substring(0,result.length()-1));
                }
                break;
            case R.id.delete:
                editText.setText(null);
                break;
            case R.id.dian:
                editText.setText(result+".");
                break;
        }
    }

    private void add(String result){
        if(result.length()>=1){
            if(result.length()==1&&result.equals("-")){
                editText.setText(null);
                return;
            }
            String substring = result.substring(result.length() - 1, result.length());
            if(substring.equals("+")||substring.equals("-")||substring.equals("*")||substring.equals("/")){
                String substring1 = result.substring(0, result.length() - 1);
                String replace=substring1+"+" ;
                editText.setText(replace);
            }
            else{
                editText.setText(result+"+");
            }
        }
    }

    private void jian(String result){
        if(result.length()>=1){
            String substring = result.substring(result.length() - 1, result.length());
            if(substring.equals("+")||substring.equals("-")||substring.equals("*")||substring.equals("/")){
                String substring1 = result.substring(0, result.length() - 1);
                String replace=substring1+"-" ;
                editText.setText(replace);
            }else{
                editText.setText(result+"-");
            }
        }
        else{
            editText.setText(result+"-");
        }
    }

    private void cheng(String result){
        if(result.length()>0){
            if(result.length()==1&&result.equals("-")){
                editText.setText(null);
                return;
            }
            String substring = result.substring(result.length() - 1, result.length());
            if(substring.equals("+")||substring.equals("-")||substring.equals("*")||substring.equals("/")){
                String substring1 = result.substring(0, result.length() - 1);
                String replace=substring1+"*" ;
                editText.setText(replace);
            }
            else{
                editText.setText(result+"*");
            }
        }
    }

    private void chu(String result){
        if(result.length()>0){
            if(result.length()==1&&result.equals("-")){
                editText.setText(null);
                return;
            }
            String substring = result.substring(result.length() - 1, result.length());
            if(substring.equals("+")||substring.equals("-")||substring.equals("*")||substring.equals("/")){
                String substring1 = result.substring(0, result.length() - 1);
                String replace=substring1+"/" ;
                editText.setText(replace);
            }
            else{
                editText.setText(result+"/");
            }
        }
    }


    private String  initOrder(String str1){
        String str=str1;
        String headSubstring = str.substring(0, 1);
        if (headSubstring.equals("-")) {
            str = "0" + str;
            Log.e("aaa","add  0 : "+ str);
        }

        if (str.contains("-")) {
            str = str.replace("-", "+-");
            Log.e("aaa", "replace - : "+str);
        }

        if(str.contains("/")){
            str=str.replace("/","*1/");
            Log.e("aaa", "replace / : "+str);
        }

        return str;
    }

    private String getResult(String str1) {
        String result = null;
        if (str1.length() > 1) {
            String str = initOrder(str1);
            if(str.contains("+")&&str.contains("*")){
                String substring = str.substring(str.length() - 1, str.length());
                if (substring.equals("+") || substring.equals("-") || substring.equals("*") || substring.equals("/")) {
                    String result1 = str.substring(0, str.length() - 1);
                    result = allCalculator(result1);
                } else {
                    result = allCalculator(str);
                }
            }
            if (str.contains("+")&&!str.contains("*")) {
                String substring = str.substring(str.length() - 1, str.length());
                if (substring.equals("+") || substring.equals("-") || substring.equals("*") || substring.equals("/")) {
                    String result1 = str.substring(0, str.length() - 1);
                    result = addAll(result1);
                } else {
                    result = addAll(str);
                }
            }
            if (str.contains("*")&&!str.contains("+")) {
                String substring = str.substring(str.length() - 1, str.length());
                if (substring.equals("+") || substring.equals("-") || substring.equals("*") || substring.equals("/")) {
                    String result1 = str.substring(0, str.length() - 1);
                    result = chengAll(result1);
                } else {
                    result = chengAll(str);
                }
            }
            if(!str.contains("+")&&!str.contains("*")){
                result=str1;
            }
        }else if(str1.length()==1){
            if(str1.equals("-")){
                result=null;
            }else{
                result=str1;
            }
        }
        return result;
    }

    private String addAll(String str){
        Log.e("aaa","addAll");
        String[] split = str.split("\\+");
        double addDouble=0;
        for (int i = 0; i <split.length ; i++) {
            String s = split[i];
            double allFloat=Double.parseDouble(s);
            addDouble+=allFloat;
        }
        String jieguo=addDouble+"";
        if(jieguo.endsWith(".0")){
            jieguo=jieguo.substring(0,jieguo.length()-2);
        }
        return jieguo;
    }

    private String allCalculator(String str){
        Log.e("aaa","allCalculator");
        String[] split = str.split("\\+");
        double all=0;
        for (int i = 0; i <split.length ; i++) {
            String s = split[i];
            Log.e("aaa",s);
            if(s.contains("*")){
                s = chengAll(s);
                Log.e("aaa",s);
            }
            int i1 = Integer.parseInt(s);
            all+=i1;
        }
        String jieguo=all+"";
        if(jieguo.endsWith(".0")){
            jieguo=jieguo.substring(0,jieguo.length()-2);
        }
        return jieguo;
    }

    private String chengAll(String str){
        Log.e("aaa","chengAll");
        String[] split = str.split("\\*");
        double all=1.0;
        for (int i = 0; i <split.length ; i++) {
            String s = split[i];
            if(s.contains("/")){
                String[] split1 = s.split("/");
                double daoData = getDaoData(Integer.parseInt(split1[1]));
                s=daoData+"";
                Log.e("aaa", s);
            }
            double i1 = Double.parseDouble(s);
            all*=i1;
        }
        String jieguo=all+"";
        if(jieguo.endsWith(".0")){
            Log.e("aaa", "enter");
            jieguo=jieguo.substring(0,jieguo.length()-2);
        }
        return jieguo;
    }

    private double getDaoData(int data){
        return 1.0/data;
    }
}


