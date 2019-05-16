package com.sky.myapplication.androidword1;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityExampleActivity extends AppCompatActivity {
    private Button activity_example_button,activity_example_button_result,activity_example_button_again;
    private TextView activity_example_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        logTaskName();
        Log.d("LifeCycle", "-------onCreate-------");
        Log.d("LifeCycle","taskid: " + getTaskId() + " ,hashCode: " + hashCode());

        activity_example_button = findViewById(R.id.activity_example_button);
        activity_example_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显示跳转1 最基本的跳转方法
                /*Intent intent = new Intent(ActivityExampleActivity.this, IndexActivity.class);
                startActivity(intent);*/
                //显示跳转2
                /*Intent intent = new Intent();
                intent.setClass(ActivityExampleActivity.this,IndexActivity.class);
                startActivity(intent);*/
                //显示跳转3
                /*Intent intent = new Intent();
                intent.setClassName(ActivityExampleActivity.this,
                        "com.sky.myapplication.androidword1.IndexActivity");
                startActivity(intent);*/
                //显示跳转4
                /*Intent intent = new Intent();
                intent.setComponent(new ComponentName(ActivityExampleActivity.this,
                        "com.sky.myapplication.androidword1.IndexActivity"));
                startActivity(intent);*/

                //隐式调用
                Intent intent = new Intent();
                intent.setAction("myGoto");
                startActivity(intent);
            }
        });
        activity_example_button_result = findViewById(R.id.activity_example_button_result);
        activity_example_button_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("title","正确返回");
                intent.putExtras(bundle);
                setResult(Activity.RESULT_OK,intent);
                //结束当前页面
                finish();
            }
        });
        activity_example_button_again = findViewById(R.id.activity_example_button_again);
        activity_example_button_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityExampleActivity.this, ActivityExampleActivity.class);
                startActivity(intent);
            }
        });

        //接收前一个Activity发送的数据
        /*Bundle bundle = getIntent().getExtras();
        String hello = bundle.getString("hello");
        int num = bundle.getInt("num");
        activity_example_text = findViewById(R.id.activity_example_text);
        activity_example_text.setText(hello + "  " + num);*/
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle", "-------onStart-------");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle", "-------onResume-------");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle", "-------onPause-------");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle", "-------onStop-------");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle", "-------onRestart-------");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle", "-------onDestroy-------");

    }

    private void logTaskName(){
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(),PackageManager.GET_META_DATA);
            Log.d("LifeCycle","当前Activity所在任务栈的名称: " + info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("LifeCycle", "-------onNewIntent ActivityExampleActivity-------");
        Log.d("LifeCycle","taskid: " + getTaskId() + " ,hashCode: " + hashCode());

    }
}
