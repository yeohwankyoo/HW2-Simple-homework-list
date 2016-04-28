package com.example.yeohwankyoo.hw2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*
Activity for change Password
 */
public class ChangePassword extends AppCompatActivity implements View.OnClickListener{

    EditText oneC;
    EditText twoC;
    EditText threeC;
    EditText fourC;
    Button ok;
    Button cancel;
    String tmp = "";
    String password;
    SharedPreferences sh_Pref;
    SharedPreferences.Editor toEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        oneC = (EditText)findViewById(R.id.oneC);
        twoC = (EditText)findViewById(R.id.twoC);
        threeC = (EditText)findViewById(R.id.threeC);
        fourC = (EditText)findViewById(R.id.fourC);

        ok = (Button)findViewById(R.id.ok);
        cancel = (Button)findViewById(R.id.cancel);
        ok.setOnClickListener(this);
        cancel.setOnClickListener(this);


        //Callback function for EditText "oncC"
        oneC.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            //if EditText fill some string, then focus next EditText
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(oneC.length() == 1)          //if EditText length is 1,
                {
                    tmp = tmp + oneC.getText().toString();        //initial string about password string
                    twoC.requestFocus();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });


        //Callback function for EditText "twoC"
        twoC.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            //if EditText fill some string, then focus next EditText
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (twoC.length() == 1) {                //if EditText length is 1,
                    tmp = tmp + twoC.getText().toString(); //initial string about password string
                    threeC.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        //Callback function for EditText "threeC"
        threeC.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            //if EditText fill some string, then focus next EditText
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (threeC.length() == 1)       //if EditText length is 1,
                {
                    tmp = tmp + threeC.getText().toString();   //initial string about password string
                    fourC.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        //Callback function for EditText "fourC"
        fourC.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            //if EditText fill some string, then focus next EditText
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (fourC.length() == 1)        //if EditText length is 1,
                {
                    tmp = tmp + fourC.getText().toString();   //initial string about password string
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    //after change password, save sharedPreferences.
    public void sharedPreferences() {
        sh_Pref = getSharedPreferences("Login Credentials", MODE_PRIVATE);
        toEdit = sh_Pref.edit();

        toEdit.putString("Password", password);
        toEdit.commit();
    }

    //if buttons are clicked,
    @Override
    public void onClick(View currentButton) {
        switch (currentButton.getId()) {
            case R.id.ok:                   //if "ok" button is clicked, change password.
                password = tmp;
                sharedPreferences();
                Toast.makeText(this, "New Pass saved", Toast.LENGTH_LONG).show();
                break;
            case R.id.cancel:               //if "cancel" button is clicked, not change password.
                finish();
        }

        finish();
    }

}

