package com.sky.myapplication.androidword1;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.sky.myapplication.util.ToastUtil;

public class AlertDialogActivity extends AppCompatActivity {
    private Button alert_dialog_button_1, alert_dialog_button_2,
            alert_dialog_button_3, alert_dialog_button_4,alert_dialog_button_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        alert_dialog_button_1 = findViewById(R.id.alert_dialog_button_1);
        alert_dialog_button_2 = findViewById(R.id.alert_dialog_button_2);
        alert_dialog_button_3 = findViewById(R.id.alert_dialog_button_3);
        alert_dialog_button_4 = findViewById(R.id.alert_dialog_button_4);
        alert_dialog_button_5 = findViewById(R.id.alert_dialog_button_5);
        onClickListener();
    }

    public void onClickListener() {
        MyOnClick myOnClick = new MyOnClick();
        alert_dialog_button_1.setOnClickListener(myOnClick);
        alert_dialog_button_2.setOnClickListener(myOnClick);
        alert_dialog_button_3.setOnClickListener(myOnClick);
        alert_dialog_button_4.setOnClickListener(myOnClick);
        alert_dialog_button_5.setOnClickListener(myOnClick);
    }

    class MyOnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.alert_dialog_button_1:
                    AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this);
                    /*builder.setTitle("请回答");
                    builder.setMessage("你觉得课程如何?");*/
                    builder.setTitle("请回答").setMessage("你觉得课程如何?")
                            .setIcon(R.drawable.account)
                            .setPositiveButton("棒", new DialogInterface.OnClickListener() {     //积极的按钮
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showToast(AlertDialogActivity.this, "你很诚实", Toast.LENGTH_SHORT);
                                }
                            }).setNeutralButton("还行", new DialogInterface.OnClickListener() {//中性的按钮
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showToast(AlertDialogActivity.this, "你再瞅瞅~", Toast.LENGTH_SHORT);
                        }
                    }).setNegativeButton("不好", new DialogInterface.OnClickListener() {//消极的按钮
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showToast(AlertDialogActivity.this, "睁眼说瞎话~", Toast.LENGTH_SHORT);
                        }
                    }).show();
                    break;
                case R.id.alert_dialog_button_2:
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(AlertDialogActivity.this);
                    final String[] sex = {"男", "女"};
                    builder2.setTitle("选择性别").setItems(sex, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showToast(AlertDialogActivity.this, "你选择了: " + sex[which], Toast.LENGTH_SHORT);
                        }
                    }).show();
                    break;
                case R.id.alert_dialog_button_3:
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(AlertDialogActivity.this);
                    final String[] sex3 = {"男", "女"};
                    builder3.setTitle("选择性别")
                                //checkeditem 默认的选择
                            .setSingleChoiceItems(sex3, 1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showToast(AlertDialogActivity.this,sex3[which],Toast.LENGTH_SHORT);
                            dialog.dismiss();
                        }
                    }).setCancelable(false).show();
                    break;
                case R.id.alert_dialog_button_4:
                    final String[] hobby = {"唱歌","跳舞","写代码"};       //可以选择的兴趣爱好选项
                    final boolean[] hobbyChoice = {false,false,true};            //默认的选择结果
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder4.setTitle("选择兴趣").setMultiChoiceItems(hobby, hobbyChoice, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            ToastUtil.showToast(AlertDialogActivity.this, hobby[which] + ":" + isChecked,Toast.LENGTH_SHORT);
                            hobbyChoice[which] = isChecked;
                        }
                    }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            StringBuilder sb = new StringBuilder();
                            for (int i = 0; i < hobby.length; i++) {
                                sb.append(hobby[i] + ":" + hobbyChoice[i] + " ");
                            }
                            ToastUtil.showToast(AlertDialogActivity.this,sb.toString(),Toast.LENGTH_SHORT);
                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showToast(AlertDialogActivity.this,"好吧,给你脸了",Toast.LENGTH_SHORT);
                        }
                    }).show();
                    break;
                case R.id.alert_dialog_button_5:
                    //自定义样式按钮
                    AlertDialog.Builder builder5 = new AlertDialog.Builder(AlertDialogActivity.this);
                    final View inflate = LayoutInflater.from(AlertDialogActivity.this).inflate(R.layout.layout_alert_dialog_myalert,null,false);
                    final AlertDialog dialog = builder5.setTitle("请先登录").setView(inflate).show();
                    inflate.findViewById(R.id.layout_alert_dialog_my_button).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            TextView layout_alert_dialog_my_text_1 = inflate.findViewById(R.id.layout_alert_dialog_my_text_1);
                            TextView layout_alert_dialog_my_text_2 = inflate.findViewById(R.id.layout_alert_dialog_my_text_2);
                            String text1 = layout_alert_dialog_my_text_1.getText().toString();
                            String text2  = layout_alert_dialog_my_text_2.getText().toString();
                            String str = "你的用户名:" + text1 + "\n你的密码:" + text2;
                            ToastUtil.showToast(AlertDialogActivity.this,str,Toast.LENGTH_SHORT);
                            dialog.dismiss();
                        }
                    });
                    break;
                default:
                    break;
            }
        }
    }
}
