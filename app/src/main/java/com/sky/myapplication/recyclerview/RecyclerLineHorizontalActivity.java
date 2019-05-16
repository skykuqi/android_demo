package com.sky.myapplication.recyclerview;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.sky.myapplication.androidword1.R;

public class RecyclerLineHorizontalActivity extends AppCompatActivity {
    private RecyclerView recycler_line_hor_recyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_line_horizontal);

        recycler_line_hor_recyclerview = findViewById(R.id.recycler_line_hor_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RecyclerLineHorizontalActivity.this);
        //设置水平方向
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycler_line_hor_recyclerview.addItemDecoration(new MyDecoration());
        recycler_line_hor_recyclerview.setLayoutManager(linearLayoutManager);
        recycler_line_hor_recyclerview.setAdapter(new RecyclerLineHorAdapter(RecyclerLineHorizontalActivity.this,
                new RecyclerLineHorAdapter.OnClickListener() {
                    @Override
                    public void onClick(int pos) {
                        Toast.makeText(RecyclerLineHorizontalActivity.this,
                                "点击了..." + pos,Toast.LENGTH_SHORT).show();
                    }
                }));


    }
    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,getResources().getDimensionPixelOffset(R.dimen.recycler_linear_dividerHeight),0);
        }
    }

}
