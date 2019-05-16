package com.sky.myapplication.listview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.sky.myapplication.androidword1.R;


/**
 * @author 施 凯 沅
 * @version 0.0.1
 */
public class ListViewActivity extends Activity {
    ListView listview_list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        listview_list = findViewById(R.id.listview_list);
        listview_list.setAdapter(new MyListAdapter(ListViewActivity.this));
        /**
         * 点击事件
         */
        listview_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this, "点击position: " + position, Toast.LENGTH_SHORT).show();
            }
        });
        /**
         * 长按事件
         */
        listview_list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this, "长按position: " + position, Toast.LENGTH_SHORT).show();
                return true;        //不再需要其他处理  true
            }
        });
    }
}
