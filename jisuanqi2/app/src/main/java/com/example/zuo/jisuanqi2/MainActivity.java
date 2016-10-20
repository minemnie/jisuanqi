package com.example.zuo.jisuanqi2;
import java.util.ArrayList;
import java.util.Arrays;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity implements OnClickListener{

        Button bt_1;
        Button bt_2;
        Button bt_3;
        Button bt_4;
        Button bt_5;
        Button bt_6;
        Button bt_7;
        Button bt_8;
        Button bt_9;
        Button bt_0;
        Button bt_add;
        Button bt_sub; // 减
        Button bt_multiply; // 乘
        Button bt_divide; // 除
        Button bt_back;
        Button bt_equal; // 等于
        Button bt_point; // 点
        Button bt_clear; // 清除
        Button bt_two;//10进制转2进制
        Button bt_sixteen;//10进制转16进制
        EditText et_showview; // 显示
        boolean clear_flag;//清空标示；

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_1=(Button) findViewById(R.id.bt_1);
        bt_2=(Button) findViewById(R.id.bt_2);
        bt_3=(Button) findViewById(R.id.bt_3);
        bt_4=(Button) findViewById(R.id.bt_4);
        bt_5=(Button) findViewById(R.id.bt_5);
        bt_6=(Button) findViewById(R.id.bt_6);
        bt_7=(Button) findViewById(R.id.bt_7);
        bt_8=(Button) findViewById(R.id.bt_8);
        bt_9=(Button) findViewById(R.id.bt_9);
        bt_0=(Button) findViewById(R.id.bt_0);
        bt_add=(Button) findViewById(R.id.bt_add);
        bt_sub=(Button) findViewById(R.id.bt_sub);
        bt_multiply=(Button) findViewById(R.id.bt_multiply);
        bt_divide=(Button) findViewById(R.id.bt_divide);
        bt_back=(Button) findViewById(R.id.bt_back);
        bt_equal=(Button) findViewById(R.id.bt_equal);
        bt_point=(Button) findViewById(R.id.bt_point);
        bt_clear=(Button) findViewById(R.id.bt_clear);
        bt_two=(Button) findViewById(R.id.bt_two);
        bt_sixteen=(Button) findViewById(R.id.bt_sixteen);//以上是实例化按钮
        et_showview = (EditText) findViewById(R.id.et);//实例化显示屏
        bt_1.setOnClickListener(this);
        bt_2.setOnClickListener(this);
        bt_3.setOnClickListener(this);
        bt_4.setOnClickListener(this);
        bt_5.setOnClickListener(this);
        bt_6.setOnClickListener(this);
        bt_7.setOnClickListener(this);
        bt_8.setOnClickListener(this);
        bt_9.setOnClickListener(this);
        bt_0.setOnClickListener(this);
        bt_add.setOnClickListener(this);
        bt_sub.setOnClickListener(this);
        bt_multiply.setOnClickListener(this);
        bt_divide.setOnClickListener(this);
        bt_back.setOnClickListener(this);
        bt_equal.setOnClickListener(this);
        bt_point.setOnClickListener(this);
        bt_clear.setOnClickListener(this);
        bt_two.setOnClickListener(this);
        bt_sixteen.setOnClickListener(this);
          //设置按钮的点击事件
    }
    public void onClick(View v){
           String str=et_showview.getText().toString();
            switch(v.getId()){
                case R.id.bt_0:
                case R.id.bt_1:
                case R.id.bt_2:
                case R.id.bt_3:
                case R.id.bt_4:
                case R.id.bt_5:
                case R.id.bt_6:
                case R.id.bt_7:
                case R.id.bt_8:
                case R.id.bt_9:
                case R.id.bt_point:
                if(clear_flag){
                    clear_flag=false;
                    str="";
                    et_showview.setText("");
                }
                et_showview.setText(str+((Button)v).getText());
                break;
                case R.id.bt_multiply:
                case R.id.bt_divide:
                case R.id.bt_add:
                case R.id.bt_sub:
                if(clear_flag){
                    clear_flag=false;
                    str="";
                    et_showview.setText("");
                }
                et_showview.setText(str+" "+((Button)v).getText()+" ");
                break;
                case R.id.bt_back:
                if(clear_flag){
                    clear_flag=false;
                    str="";
                    et_showview.setText("");
                }else if(str!=null&&!str.equals("")){
                    et_showview.setText(str.substring(0,str.length()-1));
                }
                break;
                case R.id.bt_clear:
                clear_flag=false;
                str="";
                et_showview.setText("");
                break;
                case R.id.bt_two:
                    gettwo();
                    break;
                case R.id.bt_sixteen:
                    getsexteen();
                    break;
                case R.id.bt_equal:
                getResult();
                break;
        }
    }

        private  void gettwo() {
            String exp=et_showview.getText().toString();
            int n=Integer.parseInt(exp);//强制转换
            String a="";
            int i=0;
            int r;
            do{
                if(n%2==1){
                    r=1;
                }
                else {
                    r=0;
                }
                a+=r;
                n=n/2;
                i++;
            }
           while(n>0);
            String p="";
            for (int j = 0;j<a.length(); j++) {
                p+=a.charAt(a.length()-j-1);

            }et_showview.setText(p);
        }

        public void getsexteen() {
            String exp=et_showview.getText().toString();
            int n=Integer.parseInt(exp);//强制转换
            int i=0;
            String a="";
            do{
                a+=n%8;
                n=n/8;
                i++;
            } while(n>0);
            String p="";
            for (int j = 0;j<a.length(); j++) {
                p+=a.charAt(a.length()-j-1);
            }
           et_showview.setText(p);
        }



    private void getResult(){
        String exp=et_showview.getText().toString();
        if(exp==null||exp.equals("")){
            return;
        }
        if(!exp.contains(" ")){
            return;
        }
        if(clear_flag){
            clear_flag=false;
            return;
        }
        clear_flag=true;
        double result = 0;
        String s1=exp.substring(0,exp.indexOf(" "));//运算符前面的字符串
        String op=exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);
        String s2=exp.substring(exp.indexOf(" ")+3);//运算符后面的字符船
        if(!s1.equals("")&&!s2.equals("")){
            double d1= Double.parseDouble(s1);
            double d2= Double.parseDouble(s2);
            if(op.equals("+")) {
                result=d1+d2;
            }else if(op.equals("-")){
                result=d1-d2;
            }else if(op.equals("×")){
                result=d1*d2;
            }else if(op.equals("÷")){
                if(d2==0){
                    result=0;
                }else{
                    result=d1/d2;
                }
            }
            if(!s1.contains(".")&&!s2.contains(".")&&!op.equals("÷")){
                int r=(int)result;
                et_showview.setText(r+"");
            }else{
                et_showview.setText(result+"");
            }
        }
        else if(!s1.equals("")&&s2.equals("")){
            et_showview.setText(exp);
        }else if(s1.equals("")&&!s2.equals("")) {
            double d2=Double.parseDouble(s2);
            if(op.equals("+")) {
                result=0+d2;
            }else if(op.equals("-")){
                result=0-d2;
            }else if(op.equals("×")){
                result=0*d2;
            }else if(op.equals("÷")){
                    result=0;
                }
            if(!s2.contains(".")){
                int r=(int)result;
                et_showview.setText(r+"");
            }else{
                et_showview.setText(result+"");
            }
        }else{
            et_showview.setText("");
        }
    }
}
