package com.sky.myapplication.androidword1;


import android.Manifest;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author 施 凯 沅
 * @version 0.0.1
 * 注册登录界面的首页
 */
public class MainActivity extends AppCompatActivity {
    TextView text_on, text_forget, text_new;
    Button button_on;
    EditText edit_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //动态获取权限
        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        }, 1);
        text_on = findViewById(R.id.text_on);
        Typeface fromAsset = Typeface.createFromAsset(getAssets(), "font/on.TTF");
        text_on.setTypeface(fromAsset);


//        设置下划线效果
        text_forget = findViewById(R.id.text_forget);
        text_forget.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);

        text_new = findViewById(R.id.text_new);
        text_new.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);

        //注册账号的跳转事件
        text_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        //忘记密码的跳转事件
        text_forget = findViewById(R.id.text_forget);
        text_forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ForgetPasswordActivity.class);
                startActivity(intent);
            }
        });

        //点击登录的跳转事件
        button_on = findViewById(R.id.button_on);
        button_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IndexActivity.class);
                startActivity(intent);
            }
        });

        //edit_account用户名输入的监听事件
       /* edit_account = findViewById(R.id.edit_account);
        edit_account.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //文字改变之前
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //文字改变当中 CharSequence当前输入框中的内容
                Log.d("accountText",s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                //文字改变之后
            }
        });*/
    }


}
