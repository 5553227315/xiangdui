package com.example.buju.UI.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.buju.R;

public class MyGridViewAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    public MyGridViewAdapter(Context context){
        this.mContext=context;
        mLayoutInflater=LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return 12;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    static class ViewHolder{
        public TextView textView;
        public ImageView imageView;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView==null){
            convertView=mLayoutInflater.inflate(R.layout.layout_grid_item,null);
            holder=new ViewHolder();
            convertView.setTag(holder);
            holder.textView=convertView.findViewById(R.id.tv_title);
            holder.imageView=convertView.findViewById(R.id.iv_grid);
        }else {
            holder=(ViewHolder) convertView.getTag();
        }

        //赋值
        holder.textView.setText("小花");
        Glide.with(mContext).load("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2810627290,1080409091&fm=58&s=8197C732C535FA313E526557030030BB&bpow=121&bpoh=75").into(holder.imageView);
        return convertView;
    }
}

//https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2810627290,1080409091&fm=58&s=8197C732C535FA313E526557030030BB&bpow=121&bpoh=75
//https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=1243496390,2230124329&fm=58&bpow=422&bpoh=471