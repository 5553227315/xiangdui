package com.example.buju.UI.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.buju.R;

public class MylistAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflateer;
    MylistAdapter(Context context){
        this.mContext=context;
        mLayoutInflateer=LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public static class ViewHolder{
        public ImageView imageView;
        public TextView tvTitle,tvTime,tvContent;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){

            convertView=mLayoutInflateer.inflate(R.layout.layout_list_item,null);
            holder=new ViewHolder();
            holder.imageView=convertView.findViewById(R.id.iv);
            holder.tvTitle=convertView.findViewById(R.id.tv_title);
            holder.tvTime=convertView.findViewById(R.id.tv_time);
            holder.tvContent=convertView.findViewById(R.id.tv_content);
            convertView.setTag(holder);
        }else {
            holder=(ViewHolder)convertView.getTag();
        }
        //给控件赋值
        holder.tvTitle.setText("这是标题");
        holder.tvTime.setText("2888-08-08");
        holder.tvContent.setText("这是内容");
        Glide.with(mContext).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1564219340371&di=cbe55a5ea20b3625ea2b36b0c0d47936&imgtype=0&src=http%3A%2F%2Fimg1.gtimg.com%2F11%2F1155%2F115549%2F11554911_1200x1000_0.jpg").into(holder.imageView);
        return convertView;

    }
}
