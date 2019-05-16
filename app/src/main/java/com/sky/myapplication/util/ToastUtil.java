package com.sky.myapplication.util;

import android.content.Context;
import android.widget.Toast;

/**
 * @author 施 凯 沅
 * @version 0.0.1
 * Toast工具类,全局设置
 */
public class ToastUtil {
    public static Toast myToast;
    public static void showToast(Context context,String message,int toastTime){
        if(myToast == null){
            myToast = Toast.makeText(context,message,toastTime);
        }else {
            myToast.setText(message);
        }
        myToast.show();
    }
    public static void showToast(Context context,String message){
        if(myToast == null){
            myToast = Toast.makeText(context,message,Toast.LENGTH_SHORT);
        }else {
            myToast.setText(message);
        }
        myToast.show();
    }
}
