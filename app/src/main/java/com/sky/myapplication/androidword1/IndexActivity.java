package com.sky.myapplication.androidword1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sky.myapplication.fragment.ContainerActivity;
import com.sky.myapplication.gridview.GridViewActivity;
import com.sky.myapplication.handler.HandlerActivity;
import com.sky.myapplication.listener.ListenerActivity;
import com.sky.myapplication.listview.ListViewActivity;
import com.sky.myapplication.recyclerview.RecyclerViewActivity;
import com.sky.myapplication.shared.SharedActivity;
import com.sky.myapplication.util.ToastUtil;

//目前作为测试类存在
public class IndexActivity extends AppCompatActivity {
    Button index_button_radiobutton, index_button_checkbox, index_button_imageview, index_button_listview,
            index_button_gridView, index_button_recycler_liner, index_button_web_view, index_button_toast,
            index_button_alertdialog, index_button_progress, index_button_popup, index_button_activiy,
            index_button_container, index_button_listener,index_button_handler,index_button_shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        index_button_radiobutton = findViewById(R.id.index_button_radiobutton);
        index_button_checkbox = findViewById(R.id.index_button_checkbox);
        index_button_imageview = findViewById(R.id.index_button_imageview);
        index_button_listview = findViewById(R.id.index_button_listview);
        index_button_gridView = findViewById(R.id.index_button_gridView);
        index_button_recycler_liner = findViewById(R.id.index_button_recycler_liner);
        index_button_web_view = findViewById(R.id.index_button_web_view);
        index_button_toast = findViewById(R.id.index_button_toast);
        index_button_alertdialog = findViewById(R.id.index_button_alertdialog);
        index_button_progress = findViewById(R.id.index_button_progress);
        index_button_popup = findViewById(R.id.index_button_popup);
        index_button_activiy = findViewById(R.id.index_button_activiy);
        index_button_container = findViewById(R.id.index_button_container);
        index_button_listener = findViewById(R.id.index_button_listener);
        index_button_handler = findViewById(R.id.index_button_handler);
        index_button_shared = findViewById(R.id.index_button_shared);
        index_button_activiy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndexActivity.this, ActivityExampleActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("num", 666);
                bundle.putString("hello", "你好,欢迎来到本界面");
                intent.putExtras(bundle);
                //请求码用来区分请求的对象
                startActivityForResult(intent, 0);
            }
        });
        setListeners();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            Bundle bundle = data.getExtras();
            String title = bundle.getString("title");
            ToastUtil.showToast(IndexActivity.this, title, Toast.LENGTH_SHORT);
        }
    }


    private void setListeners() {
        Onclick onclick = new Onclick();
        index_button_radiobutton.setOnClickListener(onclick);
        index_button_checkbox.setOnClickListener(onclick);
        index_button_imageview.setOnClickListener(onclick);
        index_button_listview.setOnClickListener(onclick);
        index_button_gridView.setOnClickListener(onclick);
        index_button_recycler_liner.setOnClickListener(onclick);
        index_button_web_view.setOnClickListener(onclick);
        index_button_toast.setOnClickListener(onclick);
        index_button_alertdialog.setOnClickListener(onclick);
        index_button_progress.setOnClickListener(onclick);
        index_button_popup.setOnClickListener(onclick);
        index_button_container.setOnClickListener(onclick);
        index_button_listener.setOnClickListener(onclick);
        index_button_handler.setOnClickListener(onclick);
        index_button_shared.setOnClickListener(onclick);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("LifeCycle", "-------onNewIntent IndexActivity-------");
        Log.d("LifeCycle", "taskid: " + getTaskId() + " ,hashCode: " + hashCode());

    }

    private class Onclick implements View.OnClickListener {
        Intent intent = null;

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.index_button_radiobutton:
                    //跳转到RadioButtonActivity
                    intent = new Intent(IndexActivity.this, RadioButtonActivity.class);
                    break;
                case R.id.index_button_checkbox:
                    //跳转到CheckBoxActivity
                    intent = new Intent(IndexActivity.this, CheckBoxActivity.class);
                    break;
                case R.id.index_button_imageview:
                    //跳转到CheckBoxActivity
                    intent = new Intent(IndexActivity.this, ImageViewActivity.class);
                    break;
                case R.id.index_button_listview:
                    //跳转到ListViewActivity
                    intent = new Intent(IndexActivity.this, ListViewActivity.class);
                    break;
                case R.id.index_button_gridView:
                    //跳转到GridViewActivity
                    intent = new Intent(IndexActivity.this, GridViewActivity.class);
                    break;
                case R.id.index_button_recycler_liner:
                    //跳转到RecyclerViewActivity
                    intent = new Intent(IndexActivity.this, RecyclerViewActivity.class);
                    break;
                case R.id.index_button_web_view:
                    intent = new Intent(IndexActivity.this, WebViewActivity.class);
                    break;
                case R.id.index_button_toast:
                    intent = new Intent(IndexActivity.this, ToastActivity.class);
                    break;
                case R.id.index_button_alertdialog:
                    intent = new Intent(IndexActivity.this, AlertDialogActivity.class);
                    break;
                case R.id.index_button_progress:
                    intent = new Intent(IndexActivity.this, ProgressActivity.class);
                    break;
                case R.id.index_button_popup:
                    intent = new Intent(IndexActivity.this, PopupWindowActivity.class);
                    break;
                case R.id.index_button_container:
                    intent = new Intent(IndexActivity.this, ContainerActivity.class);
                    break;
                case R.id.index_button_listener:
                    intent = new Intent(IndexActivity.this, ListenerActivity.class);
                    break;
                case R.id.index_button_handler:
                    intent = new Intent(IndexActivity.this,HandlerActivity.class);
                    break;
                case R.id.index_button_shared:
                    intent = new Intent(IndexActivity.this,SharedActivity.class);
                    break;
                default:
                    break;
            }
            startActivity(intent);
        }
    }
}

