package com.sky.myapplication.listener;

import android.app.Activity;
import android.view.View;

import com.sky.myapplication.util.ToastUtil;

/**
 * @author 施 凯 沅
 * @version 0.0.1
 */
public class MyClickListener implements View.OnClickListener {
    private Activity activity;

    public MyClickListener(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        ToastUtil.showToast(activity,"通过外部类实现点击事件");
    }
}
