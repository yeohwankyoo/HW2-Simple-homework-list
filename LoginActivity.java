package com.example.yeohwankyoo.hw2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.LabeledIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


/*
* It is Login Activity
* When you turn on application, you see this activity first.
* */
public class LoginActivity extends AppCompatActivity {

    EditText[] text;
    String tmp = "";
    String secretNumber = "0000";       //initial Password
    SharedPreferences sh_Pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        text = new EditText[4];
        text[0] = (EditText) findViewById(R.id.one);
        text[1] = (EditText) findViewById(R.id.two);
        text[2] = (EditText) findViewById(R.id.three);
        text[3] = (EditText) findViewById(R.id.four);

        applySharedPrefernces();                //if there is shared Preferences, apply it.

        //add Listener for password entry
        text[0].addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            //if text in EditText change, then focus next EditText (한칸 입력이 끝나는 이벤트가 발생하면 다른 칸으로 포커스가 넘어간다.)
            @Override
            public void afterTextChanged(Editable s) {
                if (text[0].length() == 1) {
                    tmp = tmp + text[0].getText().toString();
                    text[1].requestFocus();
                }
            }
        });

        text[1].addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            //if text in textview change, then focus next texView (한칸 입력이 끝나는 이벤트가 발생하면 다른 칸으로 포커스가 넘어간다.)
            @Override
            public void afterTextChanged(Editable s) {
                if (text[1].length() == 1) {
                    tmp = tmp + text[1].getText().toString();
                    text[2].requestFocus();
                }
            }

        });

        text[2].addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            //if text in textview change, then focus next texView (한칸 입력이 끝나는 이벤트가 발생하면 다른 칸으로 포커스가 넘어간다.)
            @Override
            public void afterTextChanged(Editable s) {
                if (text[2].length() == 1) {
                    tmp = tmp + text[2].getText().toString();
                    text[3].requestFocus();
                }
            }

        });

        text[3].addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            //if text in textview change, then it check password is right.(텍스트뷰 입력이 끝나면 비밀번호가 맞는지 확인한다)
            //if password is right, then start main activity. (비밀번호가 맞다면 메인엑티비티를 시작한다.)
            //if password is invalid, then you must enter password again (비밀번호가 틀리다면, 비밀번호를 다시 입력해야한다.
            @Override
            public void afterTextChanged(Editable s) {
                if (text[3].length() == 1) {

                    tmp = tmp + text[3].getText().toString();


                    if (tmp.equalsIgnoreCase(secretNumber))   /// if password is right
                    {
                        startActivity(new Intent("com.example.yeohwankyoo.MainActivity"));
                        finish();
                    }
                    else                    //if password is not right, all text in TextView is empty. (비밀번호가 틀리다면 모든 칸이 지워지고, 처음부터 다시 입력해야한다.
                    {
                        text[0].setText("");
                        text[1].setText("");
                        text[2].setText("");
                        text[3].setText("");
                        tmp = "";
                        text[0].requestFocus();
                    }

                }
            }
        });
    }

    // if there is preference, it apply data (sharedPreferences 가 존재하다면 데이터를 불러와서 변수에 저장해둔다)
    public void applySharedPrefernces() {
        sh_Pref = getSharedPreferences("Login Credentials", MODE_PRIVATE);

        if(sh_Pref != null && sh_Pref.contains("Password")){
            secretNumber = sh_Pref.getString("Password", "");

        }
    }

}
