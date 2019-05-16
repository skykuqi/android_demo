package com.sky.myapplication.androidword1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageViewActivity extends AppCompatActivity {
    ImageView image_imageview_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        image_imageview_2 = findViewById(R.id.image_imageview_2);
        Glide.with(this).load("https://img.zcool.cn/community/01f5005bbe34c9a8012099c8ce25ac.png@2o.png").into(image_imageview_2);
    }
}
