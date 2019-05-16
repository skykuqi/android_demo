package com.sky.myapplication.androidword1;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.sky.myapplication.util.ToastUtil;

public class ProgressActivity extends AppCompatActivity {
    private ProgressBar progress_bar_3, progress_bar_4;
    private Button progress_button, progress_button_dialog_1, progress_button_dialog_2,progress_button_custom;
    private ProgressDialog dialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        progress_bar_3 = findViewById(R.id.progress_bar_3);
        progress_bar_3.setProgress(30);
        progress_bar_4 = findViewById(R.id.progress_bar_4);
        progress_bar_4.setProgress(22);
        progress_button = findViewById(R.id.progress_button);
        progress_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //handler 会发送消息到handleMessage方法中处理消息
                handler.sendEmptyMessage(0);
            }
        });
        progress_button_dialog_1 = findViewById(R.id.progress_button_dialog_1);
        progress_button_dialog_2 = findViewById(R.id.progress_button_dialog_2);

        progress_button_dialog_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);
                progressDialog.setTitle("提示");
                progressDialog.setMessage("正在加载");
                progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        ToastUtil.showToast(ProgressActivity.this,"你取消了",Toast.LENGTH_SHORT);
                    }
                });

                progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        progressDialog.dismiss();
                    }
                });
                progressDialog.show();
                //外部点击无法取消
                progressDialog.setCancelable(false);

            }
        });

        progress_button_dialog_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);
                //改变为进度条的样式
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setTitle("提示");
                progressDialog.setMessage("正在下载...");
                dialog = progressDialog;
                //handler 会发送消息到handleMessage方法中处理消息
                handler.sendEmptyMessage(0);
                progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        progressDialog.setProgress(0);
                        ToastUtil.showToast(ProgressActivity.this,"取消下载",Toast.LENGTH_SHORT);
                    }
                });
                progressDialog.show();
                progressDialog.setCancelable(false);
            }
        });

        progress_button_custom = findViewById(R.id.progress_button_custom);
        progress_button_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProgressActivity.this,CustomDialogActivity.class);
                startActivity(intent);
            }
        });
    }


    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (dialog.getProgress() < 100) {
                //延迟500毫秒执行 发送消息
                handler.postDelayed(runnable, 100);
            } else {
                ToastUtil.showToast(ProgressActivity.this, "加载完成", Toast.LENGTH_SHORT);
                dialog.dismiss();
            }
        }
    };


    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            dialog.setProgress(dialog.getProgress() + 1);
            //发送空消息
            handler.sendEmptyMessage(0);
        }
    };

}
