package com.sky.myapplication.recyclerview;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.sky.myapplication.androidword1.R;

public class RecyclerFallsActivity extends AppCompatActivity {
    private RecyclerView recycler_falls_recyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_falls);

        recycler_falls_recyclerview = findViewById(R.id.recycler_falls_recyclerview);
        recycler_falls_recyclerview.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        recycler_falls_recyclerview.addItemDecoration(new MyDecoration());
        recycler_falls_recyclerview.setAdapter(new RecyclerFallsAdapter(RecyclerFallsActivity.this, new RecyclerFallsAdapter.OnClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(RecyclerFallsActivity.this,"点击了..." + pos,Toast.LENGTH_SHORT).show();
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
