package com.sky.myapplication.androidword1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sky.myapplication.util.ToastUtil;

public class ToastActivity extends AppCompatActivity {
    private Button toast_btton_1, toast_btton_2, toast_btton_3, toast_btton_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        toast_btton_1 = findViewById(R.id.toast_btton_1);
        toast_btton_2 = findViewById(R.id.toast_btton_2);
        toast_btton_3 = findViewById(R.id.toast_btton_3);
        toast_btton_4 = findViewById(R.id.toast_btton_4);
        OnClick onClick = new OnClick();
        toast_btton_1.setOnClickListener(onClick);
        toast_btton_2.setOnClickListener(onClick);
        toast_btton_3.setOnClickListener(onClick);
        toast_btton_4.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.toast_btton_1:
                    ToastUtil.showToast(getApplicationContext(),"默认弹出",Toast.LENGTH_SHORT);
                    break;
                case R.id.toast_btton_2:
                    Toast toastCenter = Toast.makeText(getApplicationContext(), "改变位置-居中", Toast.LENGTH_SHORT);
                    toastCenter.setGravity(Gravity.CENTER, 0, 0);
                    toastCenter.show();
                    break;
                case R.id.toast_btton_3:
                    Toast myToast = new Toast(getApplicationContext());
                    LayoutInflater inflater = LayoutInflater.from(ToastActivity.this);
                    View view = inflater.inflate(R.layout.layout_toast, null);
                    ImageView layout_toast_image = view.findViewById(R.id.layout_toast_image);
                    TextView layout_toast_text = view.findViewById(R.id.layout_toast_text);
                    layout_toast_image.setImageResource(R.drawable.check_on);
                    layout_toast_text.setText("自定义Toaast");
                    myToast.setView(view);
                    myToast.show();
                    break;
                case R.id.toast_btton_4:
                    ToastUtil.showToast(getApplicationContext(),"使用自定义封装类",Toast.LENGTH_SHORT);
                    break;
                default:
                    break;
            }
        }
    }
}
