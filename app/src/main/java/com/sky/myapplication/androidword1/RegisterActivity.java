package com.sky.myapplication.androidword1;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    Button register_button_on,register_button_sure;
    TextView register_getyzm_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register_button_on = findViewById(R.id.register_button_on);
        register_button_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this,"该用户名未被注册",Toast.LENGTH_SHORT).show();
            }
        });

        register_getyzm_text = findViewById(R.id.register_getyzm_text);
        register_getyzm_text.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        register_getyzm_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this,"验证码已发送",Toast.LENGTH_SHORT).show();
                register_getyzm_text.setText("重新发送");
            }
        });

        register_button_sure = findViewById(R.id.register_button_sure);
        register_button_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*
     * showToast的一种实现方式 一般不用这种方式
     * @param v

    public void showToast(View v){
        Toast.makeText(this,"该用户名未被注册",Toast.LENGTH_SHORT).show();
    }*/
}
