package com.example.yeohwankyoo.hw2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Counter extends AppCompatActivity {


    EditText amount;        //금액
    RadioButton ten;        //10%
    RadioButton fifteen;    //15%
    RadioButton twenty;     //20%
    TextView tip;       //값에 대한 팁
    TextView total;     //총 내야할 금액
    RadioButton others; // 원하는 팁의 비율
    EditText options;   // 원하는 팁을 쓰기 위한 에딧텍스트
    float cost;     //금액
    float rate;     //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        amount = (EditText)findViewById(R.id.Amount);
        ten = (RadioButton)findViewById(R.id.ten);
        fifteen = (RadioButton)findViewById(R.id.fifteen);
        twenty = (RadioButton)findViewById(R.id.twenty);
        tip = (TextView)findViewById(R.id.Tip);
        total = (TextView)findViewById(R.id.Total);
        others = (RadioButton)findViewById(R.id.others);
        options = (EditText)findViewById(R.id.option);


        if(savedInstanceState!=null)
        {
            Bundle bundle = savedInstanceState.getBundle("save_date1");
            amount.setText(bundle.getString("data1"));

            Bundle bundle2 = savedInstanceState.getBundle("save_date2");
            amount.setText(bundle2.getString("data2"));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)             //상태 저장
    {
        Bundle bundle1 = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle1.putString("data1", amount.getText().toString());
        bundle2.putString("data2", amount.getText().toString());
        outState.putBundle("save_data1", bundle1);
        outState.putBundle("save_data2", bundle2);
    }
    @Override
    protected void onResume(){
        super.onResume();

    }

    //라디오버튼 이벤트핸들러
    public void onRadioButtonClicked(View view) {

        if(ten.isChecked())             //10%가 체크되어있을떄,
        {
            if(amount.getText().toString().equalsIgnoreCase("")==false) {          //amount가 비어있지 않을때만 처리해줌
                cost = Float.parseFloat(amount.getText().toString());
                tip.setText("Tip: " + cost * 0.1);
                total.setText("Total: " + cost * 1.1 + "");
            }
        }
        else if(fifteen.isChecked())
        {
            if(amount.getText().toString().equalsIgnoreCase("")==false) {
                cost = Float.parseFloat(amount.getText().toString());
                tip.setText("Tip: " + cost * 0.15);
                total.setText("Total: " + cost * 1.15);
            }
        }
        else if(twenty.isChecked())
        {
            if(amount.getText().toString().equalsIgnoreCase("")==false) {
                cost = Float.parseFloat(amount.getText().toString());
                tip.setText("Tip: "+cost*0.2);
                total.setText("Total: "+ cost*1.2);
            }
        }
        else if(others.isChecked())
        {
            if(amount.getText().toString().equalsIgnoreCase("")==false) {
                if(options.getText().toString().equalsIgnoreCase("")==false) {
                    rate = Float.parseFloat(options.getText().toString());
                    cost = Float.parseFloat(amount.getText().toString());
                    tip.setText("Tip: " + cost * rate/100.0);
                    total.setText("Total: " + cost * (1+rate/100.0));
                }
            }
        }
    }
    public void onVisable(View view)                //others 입력칸이 라이오버튼을 눌렀을때만 보이게 함
    {
        if(view.getId()==others.getId())
        {
            options.setVisibility(View.VISIBLE);            //눌렀을때 보이게 함
            options.requestFocus();
        }
        else
        {
            options.setVisibility(View.INVISIBLE);      //해제되었을때는 안보임.
            options.setText("");
        }
    }
}

