package com.sky.myapplication.androidword1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.sky.myapplication.util.ToastUtil;

public class PopupWindowActivity extends AppCompatActivity {
    private Button popup_window_button;
    private PopupWindow popupWindow;
    private TextView layout_popup_text_1,layout_popup_text_2,layout_popup_text_3;
    private View view;
    private LinearLayout popup_window_linear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);


        popup_window_button = findViewById(R.id.popup_window_button);
        popup_window_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view = getLayoutInflater().inflate(R.layout.layout_popup,null);
                popupWindow = new PopupWindow(view,popup_window_button.getWidth(),ViewGroup.LayoutParams.WRAP_CONTENT);
                layout_popup_text_1 = view.findViewById(R.id.layout_popup_text_1);
                layout_popup_text_2 = view.findViewById(R.id.layout_popup_text_2);
                layout_popup_text_3 = view.findViewById(R.id.layout_popup_text_3);

                layout_popup_text_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //是PopupWindow消失
                        popupWindow.dismiss();
                        ToastUtil.showToast(PopupWindowActivity.this,"点击了:" + layout_popup_text_1.getText(),Toast.LENGTH_SHORT);

                    }
                });
                layout_popup_text_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //是PopupWindow消失
                        popupWindow.dismiss();
                        ToastUtil.showToast(PopupWindowActivity.this,"点击了:" + layout_popup_text_2.getText(),Toast.LENGTH_SHORT);

                    }
                });
                layout_popup_text_3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //是PopupWindow消失
                        popupWindow.dismiss();
                        ToastUtil.showToast(PopupWindowActivity.this,"点击了:" + layout_popup_text_3.getText(),Toast.LENGTH_SHORT);

                    }
                });

               /* popup_window_linear = findViewById(R.id.popup_window_linear);
                popup_window_linear.setOnKeyListener(new View.OnKeyListener() {
                    @Override
                    public boolean onKey(View v, int keyCode, KeyEvent event) {
                        if(event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_BACK){
                            popupWindow.dismiss();
                        }
                        return false;
                    }
                });*/
                //设置该属性使其点击空白区域消失
                popupWindow.setOutsideTouchable(true);
                //设置点击按钮时先消失,下一次点击时再开启
                popupWindow.setFocusable(true);
                popupWindow.showAsDropDown(popup_window_button);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
