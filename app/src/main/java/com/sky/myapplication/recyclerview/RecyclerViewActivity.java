package com.sky.myapplication.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.sky.myapplication.androidword1.R;

public class RecyclerViewActivity extends AppCompatActivity {
    private Button recycler_button_list,recycler_button_list_horizontal,recycler_button_grid,
            recycler_button_falls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recycler_button_list = findViewById(R.id.recycler_button_list);
        recycler_button_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewActivity.this, RecyclerLineActivity.class);
                startActivity(intent);
            }
        });
        recycler_button_list_horizontal = findViewById(R.id.recycler_button_list_horizontal);
        recycler_button_list_horizontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewActivity.this, RecyclerLineHorizontalActivity.class);
                startActivity(intent);
            }
        });

        recycler_button_grid = findViewById(R.id.recycler_button_grid);
        recycler_button_grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewActivity.this, RecyclerGridActivity.class);
                startActivity(intent);
            }
        });

        recycler_button_falls = findViewById(R.id.recycler_button_falls);
        recycler_button_falls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewActivity.this, RecyclerFallsActivity.class);
                startActivity(intent);
            }
        });
    }
}
