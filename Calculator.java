package com.example.yeohwankyoo.hw2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity implements View.OnClickListener  {

    static final String STATE_SCORE = "";
    static final String STATE_LEVEL="";
    Boolean check = false; //문자열 안에 연산자가 존재하는지 판단 여부(없으면 false/있으면 true)
    int operIndex;   //문자열 안의 연산자에 대한 index
    Double first, second; //first: 피연산자1, second: 피연산자2
    Boolean check2 = false; //문자열의 끝이 연산자인지 연산자가 아닌지 판단 (없으면 false/있으면 true)
    String operation;  //현재 문자열의 연산자.
    Button button0; Button button1;
    Button button2; Button button3;
    Button button4; Button button5;
    Button button6; Button button7;
    Button button8; Button button9;
    Button buttonEq;Button buttonC;
    Button buttonDiv;Button buttonMulti;
    Button buttonM; Button buttonPlus;
    EditText value;
    String tmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        button0 = (Button)findViewById(R.id.button0);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        button5 = (Button)findViewById(R.id.button5);
        button6 = (Button)findViewById(R.id.button6);
        button7 = (Button)findViewById(R.id.button7);
        button8 = (Button)findViewById(R.id.button8);
        button9 = (Button)findViewById(R.id.button9);
        buttonEq = (Button)findViewById(R.id.buttonEq);
        buttonC = (Button)findViewById(R.id.buttonC);
        buttonDiv = (Button)findViewById(R.id.buttonDiv);
        buttonMulti = (Button)findViewById(R.id.buttonMuti);
        buttonM = (Button)findViewById(R.id.buttonM);
        buttonPlus = (Button)findViewById(R.id.buttonPlus);
        value = (EditText)findViewById(R.id.Value);

        if(savedInstanceState!=null)
        {
            Bundle bundle = savedInstanceState.getBundle("save_date");
            value.setText(bundle.getString("data"));
        }
        //이벤트 헨들러
        button0.setOnClickListener(this); button1.setOnClickListener(this);
        button2.setOnClickListener(this); button3.setOnClickListener(this);
        button4.setOnClickListener(this); button5.setOnClickListener(this);
        button6.setOnClickListener(this); button7.setOnClickListener(this);
        button8.setOnClickListener(this); button9.setOnClickListener(this);
        buttonC.setOnClickListener(this); buttonDiv.setOnClickListener(this);
        buttonMulti.setOnClickListener(this); buttonM.setOnClickListener(this);
        buttonPlus.setOnClickListener(this); buttonEq.setOnClickListener(this);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        Bundle bundle = new Bundle();
        bundle.putString("data", value.getText().toString());
        outState.putBundle("save_data", bundle);
    }

    @Override
    public void onPause()
    {
        super.onPause();

    }
    @Override
    public void onResume()
    {
        super.onResume();

    }

    //이벤트 헨들러
    @Override
    public void onClick(View v)
    {
        if(v.getId()==button0.getId()){
            if(value.getText().toString().equalsIgnoreCase("")==false){  // 문자열이 비어있지 않을때,

                if(check==true){    //연산자가 있을때,
                    if(check2==true) { //문자열의 끝이 연산자일때,
                        if(operation=="/") {}  // 나누기 연산자 일때, 0이 입력이 되지 않는다.
                            //Toast.makeText(getApplicationContext(), "Can't Divide by Zero", Toast.LENGTH_SHORT).show();
                        else {
                            value.setText(value.getText().toString() + "0");  //아닐때는 0입력
                            check2 = false;
                        }
                    }
                    else {
                        value.setText(value.getText().toString()+"0"); // 문자열의 끝이 숫자일때, 0입력 가능
                        check2 = false;
                    }
                }
                else
                {
                    value.setText(value.getText().toString()+"0"); // 연산자가 없을때도 0입력 가능
                    check2 = false;
                }
            }

        }
        else if(v.getId()==button1.getId()){     //버튼이 0일때,
            value.setText(value.getText().toString()+"1");

            check2 = false;
        }
        else if(v.getId()==button2.getId()){         //버튼이 2일때
            if(value.getText().toString().equalsIgnoreCase("")==false){
                value.setText(value.getText().toString()+"2");
            }
            else
            {
                value.setText(2+"");
            }
            check2 = false;
        }
        else if(v.getId()==button3.getId()){      //버튼이 3일때
            if(value.getText().toString().equalsIgnoreCase("")==false){
                value.setText(value.getText().toString()+"3");
            }
            else
            {
                value.setText(3+"");
            }
            check2 = false;
        }
        else if(v.getId()==button4.getId()){      //버튼이 4일때
            if(value.getText().toString().equalsIgnoreCase("")==false){
                value.setText(value.getText().toString()+"4");
            }
            else
            {
                value.setText(4+"");
            }
            check2 = false;
        }
        else if(v.getId()==button5.getId()){        //버튼이 5일때
            if(value.getText().toString().equalsIgnoreCase("")==false){
                value.setText(value.getText().toString()+"5");
            }
            else
            {
                value.setText(5+"");
            }
            check2 = false;
        }
        else if(v.getId()==button6.getId()){        //버튼이 6일때
            if(value.getText().toString().equalsIgnoreCase("")==false){
                value.setText(value.getText().toString()+"6");
            }
            else
            {
                value.setText(6+"");
            }
            check2 = false;
        }
        else if(v.getId()==button7.getId()){        //버튼이 7일때
            if(value.getText().toString().equalsIgnoreCase("")==false){
                value.setText(value.getText().toString()+"7");
            }
            else
            {
                value.setText(7+"");
            }
            check2 = false;
        }
        else if(v.getId()==button8.getId()){        //버튼이 8일때
            if(value.getText().toString().equalsIgnoreCase("")==false){
                value.setText(value.getText().toString()+"8");
            }
            else
            {
                value.setText(8+"");
            }
            check2 = false;
        }
        else if(v.getId()==button9.getId()){        //버튼이 9일때
            if(value.getText().toString().equalsIgnoreCase("")==false){
                value.setText(value.getText().toString()+"9");
            }
            else
            {
                value.setText(9+"");
            }
            check2 = false;
        }
        else if(v.getId()==buttonC.getId()){        //지우기 - 문자열 끝에만 하나씩 지워짐.
            if(value.getText().toString().equalsIgnoreCase("")==false){
                //Toast.makeText(getApplicationContext(), "Cancel", Toast.LENGTH_SHORT).show();

                if(check==true)   //연산자가 있을때,
                {
                    if(check2==true)  // 문자열의 끝이 연산자일때,
                    {
                        check = false;
                        check2 = false;
                    }
                    else  //문자열의 끝이 숫자일때,
                    {
                        int length = value.getText().toString().length();
                        if(length-operIndex-1 !=1)
                            second = Double.parseDouble(value.getText().toString().substring(operIndex+1, length-1));
                        else
                        {
                            check2 = true;
                        }
                    }
                }
                else        //연산자가 없을때,
                {

                }
                int i = value.getText().toString().length() - 1;
                value.setText(value.getText().toString().substring(0, i));
            }

        }
        else if(v.getId()==buttonEq.getId()){       //계산   operation : " = "
            if(value.getText().toString().equalsIgnoreCase("")==false){
                //Toast.makeText(getApplicationContext(), "Equal", Toast.LENGTH_SHORT).show();

                if(check==true) // 식에 연산자가 있을때,
                {

                    if(check2==false) //문자열의 끝이 숫자일때,
                    {
                        int length = value.getText().toString().length();
                        second = Double.parseDouble(value.getText().toString().substring(operIndex+1, length));
                        value.setText(calcul(operation)+"");
                        operation = "";
                        operIndex = -1;
                        check = false;
                        Intent intent = new Intent();     //make intent
                        intent.putExtra("value", value.getText().toString());  //fill value through intent
                        setResult(Activity.RESULT_OK, intent);              //send value with OK message.
                        //Toast.makeText(getApplicationContext(), "Result: "+ value.getText(), Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }

        }
        else if(v.getId()==buttonDiv.getId()){
            if(value.getText().toString().equalsIgnoreCase("")==false){
                //Toast.makeText(getApplicationContext(), "Division", Toast.LENGTH_SHORT).show();

                if(check==false)   //식에 연산자가 없을때,
                {
                    first = Double.parseDouble(value.getText().toString());
                    operation = "/";
                    value.setText(value.getText().toString()+"/");
                    operIndex = value.getText().toString().length()-1;
                    check = true;
                    check2 = true;
                }
                else                      //수식에 연산자가 있을때,
                {
                    if(check2==false) // 문자열의 끝이 숫자일때
                    {
                        int length = value.getText().toString().length();
                        second = Double.parseDouble(value.getText().toString().substring(operIndex+1, length));
                        value.setText(calcul(operation)+"/");
                        operation = "/";
                        operIndex = value.getText().toString().length() - 1;
                        check2 = true;
                    }
                    else
                    {

                    }
                }
            }

        }
        else if(v.getId()==buttonMulti.getId()){
            if(value.getText().toString().equalsIgnoreCase("")==false){
                //Toast.makeText(getApplicationContext(), "Multiply", Toast.LENGTH_SHORT).show();

                if(check==false)   //식에 연산자가 없을때,
                {
                    first = Double.parseDouble(value.getText().toString());
                    operation = "*";
                    value.setText(value.getText().toString()+"*");
                    operIndex = value.getText().toString().length()-1;
                    check = true;
                    check2 = true;
                }
                else                      //수식에 연산자가 있을때,
                {
                    if(check2==false) // 문자열의 끝이 숫자일때
                    {
                        int length = value.getText().toString().length();
                        second = Double.parseDouble(value.getText().toString().substring(operIndex+1, length));
                        value.setText(calcul(operation)+"*");
                        operation = "*";
                        operIndex = value.getText().toString().length() - 1;
                        check2 = true;
                    }
                    else
                    {

                    }
                }
            }

        }
        else if(v.getId()==buttonM.getId()){
            if(value.getText().toString().equalsIgnoreCase("")==false){
               // Toast.makeText(getApplicationContext(), "Minus", Toast.LENGTH_SHORT).show();

                if(check==false)   //식에 연산자가 없을때,
                {
                    first = Double.parseDouble(value.getText().toString());
                    operation = "-";
                    value.setText(value.getText().toString()+"-");
                    operIndex = value.getText().toString().length()-1;
                    check = true;
                    check2 = true;
                }
                else                      //수식에 연산자가 있을때,
                {
                    if(check2==false) // 문자열의 끝이 숫자일때
                    {
                        int length = value.getText().toString().length();
                        second = Double.parseDouble(value.getText().toString().substring(operIndex+1, length));
                        value.setText(calcul(operation)+"-");
                        operation = "-";
                        operIndex = value.getText().toString().length() - 1;
                        check2 = true;
                    }
                    else
                    {

                    }
                }
            }

        }
        else if(v.getId()==buttonPlus.getId()){
            if(value.getText().toString().equalsIgnoreCase("")==false){
               // Toast.makeText(getApplicationContext(), "Plus", Toast.LENGTH_SHORT).show();

                if(check==false)   //식에 연산자가 없을때,
                {
                    first = Double.parseDouble(value.getText().toString());
                    operation = "+";
                    value.setText(value.getText().toString()+"+");
                    operIndex = value.getText().toString().length()-1;
                    check = true;
                    check2 = true;
                }
                else                      //수식에 연산자가 있을때,
                {
                    if(check2==false) // 문자열의 끝이 숫자일때
                    {
                        int length = value.getText().toString().length();
                        second = Double.parseDouble(value.getText().toString().substring(operIndex+1, length));
                        value.setText(calcul(operation)+"+");
                        operation = "+";
                        operIndex = value.getText().toString().length() - 1;
                        check2 = true;
                    }
                    else
                    {

                    }
                }
            }

        }
    }

    // 연산을 하는 함수
    public double calcul(String operation)
    {
        double result;

        switch(operation){
            case "+":
                result = first + second;
                break;
            case "-":
                result = first - second;
                break;
            case "*":
                result = first * second;
                break;
            case "/":
                result = first / second;
                break;
            default:
                result = 0;
                break;
        }
        first = result;
        return result;
    }

}



