package com.sky.myapplication.recyclerview;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.sky.myapplication.androidword1.R;

public class RecyclerGridActivity extends AppCompatActivity {
    private RecyclerView recycler_grid_recyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_grid);
        recycler_grid_recyclerview = findViewById(R.id.recycler_grid_recyclerview);
        recycler_grid_recyclerview.setLayoutManager(new GridLayoutManager(RecyclerGridActivity.this,3));
        recycler_grid_recyclerview.addItemDecoration(new MyDecoration());
        recycler_grid_recyclerview.setAdapter(new RecyclerGridAdapter(RecyclerGridActivity.this, new RecyclerGridAdapter.OnClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(RecyclerGridActivity.this,"点击了..." + pos,Toast.LENGTH_SHORT).show();
            }
        }));
    }
    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,getResources().getDimensionPixelOffset(R.dimen.recycler_linear_dividerHeight),getResources().getDimensionPixelOffset(R.dimen.recycler_linear_dividerHeight));
        }
    }
}
