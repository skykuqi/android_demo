package com.sky.myapplication.androidword1;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ForgetPasswordActivity extends AppCompatActivity {

    TextView forget_password_getyzm_text;
    Button forget_password_button_on;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        forget_password_getyzm_text = findViewById(R.id.forget_password_getyzm_text);
        forget_password_getyzm_text.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        forget_password_getyzm_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ForgetPasswordActivity.this,"验证码已发送",Toast.LENGTH_SHORT).show();
                forget_password_getyzm_text.setText("重新发送");
            }
        });

        forget_password_button_on = findViewById(R.id.forget_password_button_on);
        forget_password_button_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgetPasswordActivity.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(ForgetPasswordActivity.this,"修改密码成功",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
