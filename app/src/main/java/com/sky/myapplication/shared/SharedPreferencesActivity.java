package com.sky.myapplication.shared;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sky.myapplication.androidword1.R;

public class SharedPreferencesActivity extends AppCompatActivity {
    private TextView shared_preferences_text_write,shared_preferences_text_show;
    private Button shared_preferences_button_save,shared_preferences_button_show;
        private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        shared_preferences_text_write = findViewById(R.id.shared_preferences_text_write);
        shared_preferences_text_show = findViewById(R.id.shared_preferences_text_show);
        shared_preferences_button_save = findViewById(R.id.shared_preferences_button_save);
        shared_preferences_button_show = findViewById(R.id.shared_preferences_button_show);

//        sharedPreferences实例获取     文件的名称,  模式
//        模式MODE_PRIVATE:   只有应用本身可以读写  MODE_APPEND  追加填写,不回去覆盖
        sharedPreferences = getSharedPreferences("date",MODE_PRIVATE);
//      获取editor实例
        editor = sharedPreferences.edit();
        shared_preferences_button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //写入数据
                editor.putString("name",shared_preferences_text_write.getText().toString());
                //需要commit提交    是一个同步存储的过程,必须等待存储完成之后才能继续执行
                //apply 方法 存储的时候是一个异步的过程,会在后台进行执行,在内存上及时生效,磁盘上异步
                editor.apply();
            }
        });
        shared_preferences_button_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //读取数据
                shared_preferences_text_show.setText(sharedPreferences.getString("name","未获取到数据"));
            }
        });
    }
}
