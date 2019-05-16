package com.sky.myapplication.gridview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.sky.myapplication.androidword1.R;
public class GridViewActivity extends AppCompatActivity {
    //也可以直接继承Activity   AppCompatActivitys是Activity的衍生类
    //Activity 继承activity 将不再存在原始的头标题
    GridView gridview_grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        gridview_grid = findViewById(R.id.gridview_grid);
        gridview_grid.setAdapter(new MyGridViewAdapter(GridViewActivity.this));

        gridview_grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this,"按压position: " + position,Toast.LENGTH_SHORT).show();
            }
        });
        gridview_grid.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this,"长按position: " + position,Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}
