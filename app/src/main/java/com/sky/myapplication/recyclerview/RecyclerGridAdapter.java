package com.sky.myapplication.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sky.myapplication.androidword1.R;

/**
 * @author 施 凯 沅
 * @version 0.0.1
 */
public class RecyclerGridAdapter extends RecyclerView.Adapter<RecyclerGridAdapter.GridViewHolder> {
    private Context context;
    private OnClickListener onClickListener;

    public RecyclerGridAdapter(Context context, OnClickListener onClickListener) {
        this.context = context;
        this.onClickListener = onClickListener;
    }

    class GridViewHolder extends RecyclerView.ViewHolder {
        private TextView layout_recycler_grid_text;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            layout_recycler_grid_text = itemView.findViewById(R.id.layout_recycler_grid_text);
        }
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GridViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_recycler_grid_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, final int position) {
        holder.layout_recycler_grid_text.setText("网格视图");
        holder.layout_recycler_grid_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onClick(position);
            }
        });
    }
    @Override
    public int getItemCount() {
        return 80;
    }
    public interface OnClickListener {
        void onClick(int pos);
    }
}

