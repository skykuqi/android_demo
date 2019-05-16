package com.sky.myapplication.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sky.myapplication.androidword1.R;

public class ContainerActivity extends AppCompatActivity implements AFragment.IOnMessageClick {
    private AFragment aFragment;
    private BFragment bFragment;
    private Button activity_container_button;
    private TextView activity_container_text;
    //判断当前Fragment是否为AFragment
    private boolean isAFragment = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        //实例化Fragment
        aFragment = new AFragment().newInstance("我是重新定义的title");
        bFragment = new BFragment();
        activity_container_text = findViewById(R.id.activity_container_text);
        activity_container_button = findViewById(R.id.activity_container_button);
        activity_container_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建Fragment 事务
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                if (isAFragment) {
                    //把aFragment替换到Activity中,需要指定位置
                    fragmentTransaction.replace(R.id.activity_container_fragment, bFragment);
                    isAFragment = false;
                } else {
                    //把bFragment替换到Activity中,需要指定位置
                    fragmentTransaction.replace(R.id.activity_container_fragment, aFragment);
                    isAFragment = true;
                }
                //提交事务
                fragmentTransaction.commit();
            }
        });
    }
   /* public void setData(String text){
        activity_container_text.setText(text);
    }*/

    @Override
    public void onClick(String text) {
        activity_container_text.setText(text);
    }
}
