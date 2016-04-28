package com.example.yeohwankyoo.hw2;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;
import java.util.Date;

public class Timetable extends AppCompatActivity {

    public String date;

    LinearLayout second;
    LinearLayout third;
    LinearLayout four;
    LinearLayout five;
    LinearLayout six;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);

        second = (LinearLayout)findViewById(R.id.second);       //월요일 시간표의 레이아웃
        third = (LinearLayout)findViewById(R.id.third);         //화요일 시간표의 레이아웃
        four = (LinearLayout)findViewById(R.id.four);           //수요일 시간표의 레이아웃
        five = (LinearLayout)findViewById(R.id.five);           //목요일 시간표의 레이아웃
        six = (LinearLayout)findViewById(R.id.six);             //금요일 시간표의 레이아웃웃
    }

    @Override
    protected void onPause()                //상태 저장
    {
        super.onPause();
        if(date.startsWith("Mon"))                   //date 문자열 중에서 월요일이 있을떄,
        {
            second.setBackgroundColor(Color.parseColor("#FFFFFFFF"));   //onPause()상태로 들어가면 초기화를 한다.
        }
        else if(date.startsWith("Tue"))
        {
            third.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        }
        else if(date.startsWith("Wed"))
        {
            four.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        }
        else if(date.startsWith("Thu"))
        {
            five.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        }
        else if(date.startsWith("Fri"))
        {
            six.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        updateTime();
        if(date.startsWith("Mon"))
        {
            second.setBackgroundColor(Color.CYAN);            //onResume할때 해당 요일에 색깔을 칠해줌
        }
        else if(date.startsWith("Tue"))
        {
            third.setBackgroundColor(Color.CYAN);
        }
        else if(date.startsWith("Wed"))
        {
            four.setBackgroundColor(Color.CYAN);
        }
        else if(date.startsWith("Thu"))
        {
            five.setBackgroundColor(Color.CYAN);
        }
        else if(date.startsWith("Fri"))
        {
            six.setBackgroundColor(Color.CYAN);
        }


    }
    @Override
    protected void onStop() {
        super.onStop();
        if(date.startsWith("Mon"))
        {
            second.setBackgroundColor(Color.parseColor("#FFFFFFFF"));           //onStop할때 초기화
        }
        else if(date.startsWith("Tue"))
        {
            third.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        }
        else if(date.startsWith("Wed"))
        {
            four.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        }
        else if(date.startsWith("Thu"))
        {
            five.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        }
        else if(date.startsWith("Fri"))
        {
            six.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        }

    }

    //날짜를 받는 메소드
    private void updateTime() {
        date = new Date().toString();
        Toast.makeText(getApplicationContext(), date, Toast.LENGTH_SHORT).show();
    }

}
