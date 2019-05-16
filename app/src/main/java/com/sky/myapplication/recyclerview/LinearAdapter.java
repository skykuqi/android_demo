package com.sky.myapplication.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sky.myapplication.androidword1.R;

/**
 * @author 施 凯 沅
 * @version 0.0.1
 */
public class LinearAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private OnItemClickListener listener;
    private OnLongClickListener listenerLong;

    class LinearViewHolder extends RecyclerView.ViewHolder {
        private TextView layout_linear_text;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            layout_linear_text = itemView.findViewById(R.id.layout_linear_text);
        }
    }
    class LinearViewHolder1 extends RecyclerView.ViewHolder {
        private TextView layout_linear_1_text;
        private ImageView layout_linear_1_image;
        public LinearViewHolder1(@NonNull View itemView) {
            super(itemView);
            layout_linear_1_text = itemView.findViewById(R.id.layout_linear_1_text);
            layout_linear_1_image = itemView.findViewById(R.id.layout_linear_1_image);
        }
    }

    public LinearAdapter(Context context, OnItemClickListener listener, OnLongClickListener listenerLong) {
        this.context = context;
        this.listener = listener;
        this.listenerLong = listenerLong;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0){
                return new LinearViewHolder(LayoutInflater.from(context).inflate(
                    R.layout.layout_linear_item, parent, false));
        }else {
            return new LinearViewHolder1(LayoutInflater.from(context).inflate(
                    R.layout.layout_linear_item_1, parent, false));
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return 0;
        }else{
            return 1;
        }
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if(getItemViewType(position) == 0){
            ((LinearViewHolder)holder).layout_linear_text.setText("Hello World!");
            ((LinearViewHolder)holder).layout_linear_text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(position);
                }
            });

        }else {
            ((LinearViewHolder1)holder).layout_linear_1_text.setText("Hello Second!");
        }
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return listenerLong.onLongClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 30;
    }

    public interface OnItemClickListener {
        void onClick(int pos);
    }

    public interface OnLongClickListener {
        boolean onLongClick(int pos);
    }

}
