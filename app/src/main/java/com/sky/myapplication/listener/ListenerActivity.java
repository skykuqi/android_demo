package com.sky.myapplication.listener;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.sky.myapplication.androidword1.R;
import com.sky.myapplication.util.ToastUtil;

public class ListenerActivity extends AppCompatActivity implements View.OnClickListener {
    private Button listener_button_1, listener_button_2, listener_button_3, listener_button_4;
    private MyButton listener_button_5;
    private MyOnclick myOnclick;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listener);

        //通过内部类实现的点击事件
        listener_button_1 = findViewById(R.id.listener_button_1);
        myOnclick = new MyOnclick();
        listener_button_1.setOnClickListener(myOnclick);

        //通过事件源所在类实现点击事件
        listener_button_2 = findViewById(R.id.listener_button_2);
        listener_button_2.setOnClickListener(this);

        //通过外部类
        listener_button_3 = findViewById(R.id.listener_button_3);
        listener_button_3.setOnClickListener(new MyClickListener(ListenerActivity.this));

        //通过布局文件属性实现
        listener_button_4 = findViewById(R.id.listener_button_4);

        //基于回调的事件处理机制
        listener_button_5 = (MyButton) findViewById(R.id.listener_button_5);
        listener_button_5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                System.out.println("内部类中的触摸:回调");
                return false;
            }
        });
        listener_button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("点击了这个按钮");
            }
        });

    }

    class MyOnclick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            switch (v.getId()) {
                case R.id.listener_button_1:
                    ToastUtil.showToast(ListenerActivity.this, "通过内部类实现的点击事件");
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                System.out.println("主页面的按压");
                break;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.listener_button_2:
                ToastUtil.showToast(ListenerActivity.this, "通过事件源所在类实现点击事件");
                break;
            default:
                break;
        }
    }

    public void show(View view) {
        switch (view.getId()) {
            case R.id.listener_button_4:
                ToastUtil.showToast(ListenerActivity.this, "通过布局文件属性实现点击事件");
                break;
            default:
                break;
        }
    }
}
