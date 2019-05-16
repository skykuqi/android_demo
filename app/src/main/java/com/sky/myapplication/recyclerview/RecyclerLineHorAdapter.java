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
public class RecyclerLineHorAdapter extends RecyclerView.Adapter<RecyclerLineHorAdapter.LinearViewHolder> {
    private Context context;
    private OnClickListener onClickListener;

    public RecyclerLineHorAdapter(Context context, OnClickListener onClickListener) {
        this.context = context;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(context).inflate(
                R.layout.layout_linear_hor_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull LinearViewHolder holder, final int position) {
        holder.layout_linear_hor_text.setText("你好! 这是水平的哦");
        holder.layout_linear_hor_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{
        private TextView layout_linear_hor_text;
        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            layout_linear_hor_text = itemView.findViewById(R.id.layout_linear_hor_text);
        }
    }
    public interface OnClickListener{
        void onClick(int pos);
    }


}
