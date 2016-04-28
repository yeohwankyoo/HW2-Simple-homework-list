package com.example.yeohwankyoo.hw2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/*
After click a menu in MainActivity's list, then this activity come into action.
And this activity show each applicable information.
 */
public class Information extends AppCompatActivity {

    TextView name;
    TextView info;
    Button enter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        name = (TextView)findViewById(R.id.name);
        info = (TextView)findViewById(R.id.info);
        enter = (Button)findViewById(R.id.enter);

        //get Intent
        Intent myIntent = getIntent();
        String what = myIntent.getExtras().getString("name");  // get information applicable Activity (해당 엑티비티에 대한 정보를 가져온다)

        if(what.equalsIgnoreCase("time"))        //if bundle name is time, fill data about TimeTable.(번들 이름이 time이면, TimeTable에 대한 정보를 채운다.)
        {
            name.setText("TimeTable");
            info.setText("Show your Time Table");

        }
        else if(what.equalsIgnoreCase("count"))     //if bundle name is count, fill data about Counter.(번들 이름이 count이면, Counter에 대한 정보를 채운다.)
        {
            name.setText("Counter");
            info.setText("TIP: Should payment");  //

        }
        else if(what.equalsIgnoreCase("cal"))       //if bundle name is time, cal data about Calculator.(번들 이름이 cal이면, Calculator에 대한 정보를 채운다.)
        {
            name.setText("Calculator");
            info.setText("What's your operation");  //

        }
    }

    //Click event handler.
    //If button is clicked, start applicable Activity.
    public void onClickEnter(View v){
        Intent myIntent = getIntent();
        String what = myIntent.getExtras().getString("name");

        if(what.equalsIgnoreCase("time"))            // if it is about TimeTable, start TimeTable Activity
        {
            startActivity(new Intent("com.example.yeohwankyoo.Timetable"));
            finish();
        }
        else if(what.equalsIgnoreCase("count"))      // if it is about Counter, start Counter Activity
        {
            startActivity(new Intent("com.example.yeohwankyoo.Counter"));
            finish();

        }
        else if(what.equalsIgnoreCase("cal"))      // if it is about Calculator, start Calculator Activity
        {
            startActivityForResult(new Intent("com.example.yeohwankyoo.Calculator"), 1);     //start Activity. And it want some result.
        }
    }

    //if some result return, check request code and using it.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        try{
            if(requestCode == 1)            // if request code is "1", display Toast Message with return value.
            {
                Toast.makeText(getApplicationContext(), "Result: "+ data.getStringExtra("value"), Toast.LENGTH_SHORT).show();
            }

        }
        catch(Exception e){

        }
    }


}
