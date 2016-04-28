package com.example.yeohwankyoo.hw2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
/*
Main Activity.
After you login, this Activity is Top of Stack.
It shows list of applications.
*/
public class MainActivity extends  ListActivity{

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        String[] values = new String[] { "TimeTable", "Counter", "Calculator", "Change Pwd"};  // String Array for ListView
        MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(this, values);              //make Adapter for ListView
        setListAdapter(adapter);
    }

    //When a list is clicked, start applicable Activity (리스트를 눌렀을때, 해당 엑티비티를 시작한다)
    @Override
   protected void onListItemClick(ListView l, View v, int position, long id) {
        String item = (String) getListAdapter().getItem(position);
        if(item.equalsIgnoreCase("TimeTable"))     // if item equals "TimeTable",
        {
            Intent intent = new Intent(MainActivity.this, Information.class);  // make intent for Information Activity
             intent.putExtra("name", "time");
             startActivity(intent);                      //Start Information Activity for TimeTable (TimeTable 에 대한 정보를 가진 information Activity 를 실행한다.)
        }
        else if(item.equalsIgnoreCase("Counter"))    // if item equals "Counter",
        {
            Intent intent = new Intent(MainActivity.this, Information.class);
            intent.putExtra("name", "count");
            startActivity(intent);                  //Start Information Activity for Counter (Counter 에 대한 정보를 가진 information Activity 를 실행한다.)

        }
        else if(item.equalsIgnoreCase("Calculator"))  // if item equals "Calculator",
        {
            Intent intent = new Intent(MainActivity.this, Information.class);  // make intent for Information Activity
            intent.putExtra("name", "cal");
            startActivity(intent);          //Start Information Activity for Calculator (Caculator 에 대한 정보를 가진 information Activity 를 실행한다.)
        }
        else
        {
            Intent intent = new Intent(MainActivity.this, ChangePassword.class);  // make intent for ChangePassword Activity
            intent.putExtra("name", "change");
            startActivity(intent);          //Start ChangePassword Activity
        }

    }


}
