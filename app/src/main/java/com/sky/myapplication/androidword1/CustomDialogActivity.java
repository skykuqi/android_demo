package com.sky.myapplication.androidword1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sky.myapplication.dialog.CustomDialog;
import com.sky.myapplication.util.ToastUtil;

public class CustomDialogActivity extends AppCompatActivity {
    private Button custom_button_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);

        custom_button_1 = findViewById(R.id.custom_button_1);
        custom_button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog customDialog = new CustomDialog(CustomDialogActivity.this);
                customDialog.setTitle("提示").setContent("确定删除订单吗?").setOk("确定", new CustomDialog.IOnOkListener() {
                    @Override
                    public void onOk(CustomDialog dialog) {
                        ToastUtil.showToast(CustomDialogActivity.this,"点击了确定",Toast.LENGTH_SHORT);
                    }
                }).setNo("取消", new CustomDialog.IOnNoListener() {
                    @Override
                    public void onNo(CustomDialog dialog) {
                        ToastUtil.showToast(CustomDialogActivity.this,"点击了取消",Toast.LENGTH_SHORT);
                    }
                }).setCancelable(false);
                customDialog.show();
            }
        });
    }
}
