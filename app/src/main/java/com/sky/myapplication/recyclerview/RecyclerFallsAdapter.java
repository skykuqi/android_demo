package com.sky.myapplication.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sky.myapplication.androidword1.R;

/**
 * @author 施 凯 沅
 * @version 0.0.1
 */
public class RecyclerFallsAdapter extends RecyclerView.Adapter<RecyclerFallsAdapter.FallsViewHolder> {

    private Context context;
    private OnClickListener onClickListener;

    public RecyclerFallsAdapter(Context context, OnClickListener onClickListener) {
        this.context = context;
        this.onClickListener = onClickListener;
    }

    class FallsViewHolder extends RecyclerView.ViewHolder{
        private ImageView layout_recycler_falls_image;

        public FallsViewHolder(@NonNull View itemView) {
            super(itemView);
            layout_recycler_falls_image = itemView.findViewById(R.id.layout_recycler_falls_image);

        }
    }

    @NonNull
    @Override
    public FallsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FallsViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_recycler_falls_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull FallsViewHolder holder, final int position) {
        if(position%2 ==0){
            holder.layout_recycler_falls_image.setImageResource(R.drawable.imageview);
        }else {
            holder.layout_recycler_falls_image.setImageResource(R.drawable.main_on);
        }
        holder.layout_recycler_falls_image.setOnClickListener(new View.OnClickListener() {
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
    public interface OnClickListener{
        void onClick(int pos);
    }
}
