package com.sky.myapplication.listview;

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
 * ListView Adapter
 */
public class MyListAdapter extends BaseAdapter {
    private Context context;        //为引用该类的Actiyity本身
    private LayoutInflater layoutInflater;
    public MyListAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() { //列表的长度,实际开发并不是给出固定值
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

    static class ViewHolder{
        public ImageView layout_list_image;
        public TextView layout_list_line_text_1,layout_list_line_text_2,layout_list_line_text_3;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.layout_list_item,null);
            holder = new ViewHolder();
            holder.layout_list_image = convertView.findViewById(R.id.layout_list_image);
            holder.layout_list_line_text_1 = convertView.findViewById(R.id.layout_list_line_text_1);
            holder.layout_list_line_text_2 = convertView.findViewById(R.id.layout_list_line_text_2);
            holder.layout_list_line_text_3 = convertView.findViewById(R.id.layout_list_line_text_3);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        //给控件赋值
        holder.layout_list_line_text_1.setText("这是标题");
        holder.layout_list_line_text_2.setText("2019-4-26");
        holder.layout_list_line_text_3.setText("随便说一遍什么吧");
        Glide.with(context).load("https://img.zcool.cn/community/01f5005bbe34c9a8012099c8ce25ac.png@2o.png").into(holder.layout_list_image);
        return convertView;
    }
}
