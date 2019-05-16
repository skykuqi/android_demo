package com.sky.myapplication.recyclerview;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.sky.myapplication.androidword1.R;

public class RecyclerLineActivity extends AppCompatActivity {
    private RecyclerView recycler_line_recucleview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_line);

        recycler_line_recucleview = findViewById(R.id.recycler_line_recucleview);
        recycler_line_recucleview.setLayoutManager(new LinearLayoutManager(RecyclerLineActivity.this));
        recycler_line_recucleview.addItemDecoration(new MyDecoration());

        recycler_line_recucleview.setAdapter(new LinearAdapter(RecyclerLineActivity.this, new LinearAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(RecyclerLineActivity.this, "点击了..." + pos, Toast.LENGTH_SHORT).show();
            }
        }, new LinearAdapter.OnLongClickListener() {
            @Override
            public boolean onLongClick(int pos) {
                Toast.makeText(RecyclerLineActivity.this, "长按了..." + pos, Toast.LENGTH_SHORT).show();
                return true;
            }
        }));
    }
    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            //按照左上右下的顺序     颜色取决于背景颜色
            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.recycler_linear_dividerHeight));
        }
    }
}
