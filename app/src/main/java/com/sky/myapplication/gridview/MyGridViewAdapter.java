package com.sky.myapplication.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sky.myapplication.androidword1.R;

/**
 * @author 施 凯 沅
 * @version 0.0.1
 */
public class MyGridViewAdapter extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public MyGridViewAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder {
        public ImageView layout_grid_image;
        public TextView layout_grid_text;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.layout_grid_item,null);
            holder = new ViewHolder();
            holder.layout_grid_image = convertView.findViewById(R.id.layout_grid_image);
            holder.layout_grid_text = convertView.findViewById(R.id.layout_grid_text);
            convertView.setTag(holder);
        }else {
           holder = (ViewHolder) convertView.getTag();

        }
        //赋值
        holder.layout_grid_text.setText("花");
        Glide.with(context).load("https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=0da5402e49166d222c7a1dc6274a6292/242dd42a2834349b5b65a960c3ea15ce37d3bef0.jpg").into(holder.layout_grid_image);
        return convertView;
    }
}
