package com.sky.myapplication.listener;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.MotionEvent;


/**
 * @author 施 凯 沅
 * @version 0.0.1
 */
public class MyButton extends AppCompatButton {
    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    //所有的触摸事件都由dispatchTouchEvent开始分发,相当于一个入口方法
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        System.out.println("dispatchTouchEvent");
        return super.dispatchTouchEvent(event);
    }

    //触摸事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                System.out.println("触摸了这个按钮");
                break;
        }
        return super.onTouchEvent(event);
    }
}
