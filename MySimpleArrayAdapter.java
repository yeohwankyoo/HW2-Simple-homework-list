package com.example.yeohwankyoo.hw2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


/*
To make adapter for ListView
*/
public class MySimpleArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;
    //using activity_main xml
    public MySimpleArrayAdapter(Context context, String[] values) {
        super(context, R.layout.activity_main, values);
        this.context = context;
        this.values = values;         //initial String array from MainActivity's array.
    }

    //make activity_xml view object, and fill information
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //make activity_xml view object through inflater
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_main, parent, false);

        TextView textView = (TextView) rowView.findViewById(R.id.label);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        textView.setText(values[position]);


        String s = values[position];
        if (s.startsWith("TimeTable"))          //if string is "TimeTable",
        {
            imageView.setImageResource(R.drawable.timetable);
        }
        else if(s.startsWith("Counter"))        //if string is "Counter",
        {
            imageView.setImageResource(R.drawable.count);
        }
        else if(s.startsWith("Calculator"))         //if string is "Calculator",
        {
            imageView.setImageResource(R.drawable.calculator);
        }
        else {                              //if string is "Change Pwd"
            imageView.setImageResource(R.drawable.change);
        }
        return rowView;
    }
}