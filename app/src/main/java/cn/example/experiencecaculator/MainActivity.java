package cn.example.experiencecaculator;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;




import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //    结果集
    private EditText editText;
    public  boolean key = false;
    //数字1-9
    private Button main_btn1;
    private Button main_btn2;
    private Button main_btn3;
    private Button main_btn4;
    private Button main_btn5;
    private Button main_btn6;
    private Button main_btn7;
    private Button main_btn8;
    private Button main_btn9;
    private  Button main_btn0;

    //运算符
    private  Button main_btn1a  ;// +
    private  Button main_btnj;  // -
    private  Button main_btnx;  // *
    private  Button main_btnc;  // /
    private  Button main_btnd;  //小数点
    private  Button main_btn1d; //=
    private  Button main_btn1f; //+/-
    //清除
    private  Button main_btndel;
    //开平方根
    private Button main_btn1g;
    //三角函数
    private Button main_btn1c;
    private Button main_btn1e;
    //清空
    private Button main_btncl;

    boolean clear_flag;//清空标识

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //数字1-9
        View main_btn1 = findViewById(R.id.main_btn1);
        View main_btn2 = findViewById(R.id.main_btn2);
        View main_btn3 = findViewById(R.id.main_btn3);
        View main_btn4 = findViewById(R.id.main_btn4);
        View main_btn5 = findViewById(R.id.main_btn5);
        View main_btn6 = findViewById(R.id.main_btn6);
        View main_btn7 = findViewById(R.id.main_btn7);
        View main_btn8 = findViewById(R.id.main_btn8);
        View main_btn9 = findViewById(R.id.main_btn9);
        View main_btn0 = findViewById(R.id.main_btn0);
        //运算符
        View main_btn1a = findViewById(R.id.main_btn1a);// +
        View main_btnj = findViewById(R.id.main_btnj);// -
        View main_btnx = findViewById(R.id.main_btnx);// *
        View main_btnc = findViewById(R.id.main_btnc); // /
        View main_btnd = findViewById(R.id.main_btnd);//小数点
        View main_btn1d = findViewById(R.id.main_btn1d);//=
        View main_btndel = findViewById(R.id.main_btndel);//清空
        View main_btn1f = findViewById(R.id.main_btn1f);// +/-
        View main_btn1g =findViewById(R.id.main_btn1g);// 开根号
        View main_btn1c =findViewById(R.id.main_btn1c);//sin
        View main_btn1e =findViewById(R.id.main_btn1e);//cos
        View main_btncl =findViewById(R.id.main_btncl);//clear
        editText = (EditText) findViewById(R.id.main_et_result);//结果集


        //添加点击事件
        main_btn0.setOnClickListener(this);
        main_btn1.setOnClickListener(this);
        main_btn2.setOnClickListener(this);
        main_btn3.setOnClickListener(this);
        main_btn4.setOnClickListener(this);
        main_btn5.setOnClickListener(this);
        main_btn6.setOnClickListener(this);
        main_btn7.setOnClickListener(this);
        main_btn8.setOnClickListener(this);
        main_btn9.setOnClickListener(this);

        main_btnd.setOnClickListener(this);
        main_btndel.setOnClickListener(this);

        main_btn1a.setOnClickListener(this);
        main_btnj.setOnClickListener(this);
        main_btnx.setOnClickListener(this);
        main_btnc.setOnClickListener(this);
        main_btn1d.setOnClickListener(this);
        main_btn1f.setOnClickListener(this);
        main_btn1g.setOnClickListener(this);
        main_btn1c.setOnClickListener(this);
        main_btn1e.setOnClickListener(this);
        main_btncl.setOnClickListener(this);
    }


    //读取每个按钮的点击的内容

    public void onClick(View view) {
        //获取文本内容
        String input = editText.getText().toString();
        switch (view.getId()){
            case R.id.main_btn0:
            case R.id.main_btn1:
            case R.id.main_btn2:
            case R.id.main_btn3:
            case R.id.main_btn4:
            case R.id.main_btn5:
            case R.id.main_btn6:
            case R.id.main_btn7:
            case R.id.main_btn8:
            case R.id.main_btn9:
            case R.id.main_btnd:
                if(clear_flag){
                    clear_flag = false;
                    editText.setText("");//赋值为空
                }//清空标识符clear_flag为true，清空内容
                editText.setText(input + ((Button)view).getText());//结果集就为本身，获取Button中的text内容
                break;
                //以上的按钮全部为输入类型的不具备功能的显示在显示屏上的按钮

            case R.id.main_btn1a:
            case R.id.main_btnj:
            case R.id.main_btnx:
            case R.id.main_btnc:// /
                if(input.charAt(input.length()-1)=='+'||input.charAt(input.length()-1)=='-'||input.charAt(input.length()-1)=='*'||input.charAt(input.length()-1)=='/'){
                    Toast.makeText(MainActivity.this,"error",Toast.LENGTH_LONG).show();
                    editText.setText(input);
                    break;
            }
                if(clear_flag){
                    clear_flag = false;
                    input = "";
                    editText.setText("");
                }
                editText.setText(input + " " + ((Button)view).getText() + " ");
                //区别于数字按钮，添加“ ”空字符串
                break;
                //以上按钮为输入类型是具备功能的按钮

            case R.id.main_btndel://删除
                key=false;
                if(clear_flag){
                    clear_flag = false;
                    input = "";
                    editText.setText("");
                }else if(input != null || !input.equals("")) {//如果获取到的内容不为空
                    editText.setText(input.substring(0, input.length() - 1));//结果集为空
                }// //判断显示屏中的内容是不是为空，如果不为空，使用字符串类型的 substring（int beginIndex,endIndex-1）方法进行减一字符串.
                break;
            case R.id.main_btn1d://运算结果  =
                String inputText=editText.getText().toString();
                Toast.makeText(MainActivity.this,inputText,Toast.LENGTH_SHORT).show();//显示
                getResult();//调用处理结果集的方法
                if (key) {
                    Toast.makeText(MainActivity.this, "输入有误", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.main_btn1f://+/-
                getChange();
                Toast.makeText(MainActivity.this,"此功能必须为单独数字才有效",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_btn1g:
                getSqrt();
                break;
            case R.id.main_btn1c://sin
                Toast.makeText(MainActivity.this,"浮点数存在误差同时有效值范围0~360",Toast.LENGTH_LONG).show();
                getSin();
                break;
            case R.id.main_btn1e://cos
                getCos();
                Toast.makeText(MainActivity.this,"浮点数存在误差同时有效值范围0~360",Toast.LENGTH_LONG).show();
                break;
            case R.id.main_btncl://clear
                editText.setText("");
                if(key){
                    key=false;
                }
            default:
                break;
        }
    }
    public void getSin(){
        String exp = editText.getText().toString();//获取文本框的内容
        double d1 = Double.parseDouble(exp);
        double angle=Math.toRadians(d1);
        editText.setText(Math.sin(angle)+"");
    }
    public void getCos(){
        String exp = editText.getText().toString();//获取文本框的内容
        double d1 = Double.parseDouble(exp);
        double angle=Math.toRadians(d1);
        editText.setText(Math.cos(Math.PI*angle/180)+"");
    }
    public void getSqrt(){
        String exp = editText.getText().toString();//获取文本框的内容
        double d1=Double.parseDouble(exp);
        if (d1<0){
            Toast.makeText(MainActivity.this,"必须正数开平方根，否则报错",Toast.LENGTH_SHORT).show();
        }
        editText.setText(Math.sqrt(d1) + "");
    }

    //数字的正负切换
    public void getChange(){
        String exp = editText.getText().toString();//获取文本框的内容
        int i = 0 ;
        double result =0 ;
        String s1=exp;
        double d1=Double.parseDouble(s1);
        result =0-d1;
        editText.setText(result + "");
        //运算符前的数

    }

    //运算结果的方法
    private void getResult(){
        String exp = editText.getText().toString();//获取文本框的内容
        if(exp==null||exp.equals("")){
            return;
        }
        if(!exp.contains(" ")){
            return;
        }
        if(clear_flag){
            clear_flag = false;
            return;
        }
        clear_flag = true;
        double result = 0;

        //进行截取
        //运算符前的数字(第一个空格前)
        String s1 = exp.substring(0,exp.indexOf(" "));
        //运算符(第一个空格后的第一个字符)
        String op = exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);
        //运算符后的数字(参数为子串起始下标)
        String s2 = exp.substring(exp.indexOf(" ")+3);

        if(!s1.equals("")&&!s2.equals("")) {//如果包含小数点的运算
            double d1 = Double.parseDouble(s1);//则数字都是double类型
            double d2 = Double.parseDouble(s2);
            if (op.equals("+")) {//如果是 +
                result = d1 + d2;
            } else if (op.equals("-")) {
                result = d1 - d2;
            } else if (op.equals("*")) {
                result = d1 * d2;
            } else if (op.equals("/")) {
                if (d2 == 0) { //如果被除数是0
                    result=(float)0.0000000000001;
                    this.key=true;
                   /* result = 0; //则结果是0
                    System.out.println("被除数等于0，默认结果为0");*/
                }
                else {//否则执行正常是除法运算
                    result = d1 / d2;
                }
            }

            if (!s1.contains(".") && !s2.contains(".") && !op.equals("/")) {//如果是整数类型
                int r = (int) result; //都是整形
                editText.setText(r + "");
            } else{
                editText.setText(result + "");
            }
        }else if(!s1.equals("") && s2.equals("")){//如果是只输入运算符前的数
            editText.setText(exp);//直接返回当前文本框的内容
        }else if(s1.equals("") && !s2.equals("")){//如果是只输入运算符后面的数
            double d2 = Double.parseDouble(s2);

            //运算符前没有输入数字
            if (op.equals("+")) {
                d2=0+d2;

                result = d2;
            } else if (op.equals("-")) {
                d2=0-d2;
                result =d2;
            } else if (op.equals("*")) {
                result = 0;
            } else if (op.equals("/")) {
                result = 0;
            }

            if (!s1.contains(".") && !s2.contains(".")) {
                int r = (int) result;
                editText.setText(r + "");
            } else{
                editText.setText(result + "");
            }
        }else {
            editText.setText("");
        }

    }
}
