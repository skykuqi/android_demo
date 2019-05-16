package com.sky.myapplication.handler;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.sky.myapplication.androidword1.R;
import com.sky.myapplication.util.ToastUtil;

public class HandlerActivity extends AppCompatActivity {
    private Handler mHandler;

    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        //延迟3秒钟跳转页面
        /*mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(HandlerActivity.this,MainActivity.class);
                startActivity(intent);
            }
        }, 3000);*/

        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 1:
                        ToastUtil.showToast(HandlerActivity.this, "1号消息被接收,线程通信成功");
                        break;
                }
            }
        };
        new Thread() {
            @Override
            public void run() {
                super.run();
                Message message = new Message();
                message.what = 1;
                mHandler.sendMessage(message);
            }
        }.start();
    }
}
