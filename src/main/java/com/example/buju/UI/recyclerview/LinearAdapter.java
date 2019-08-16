package com.example.buju.UI.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.example.buju.R;

public class LinearAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private OnItemClickListener mlistener;
    private OnItemLongClickListener mlistener1;




    public LinearAdapter(Context context,OnItemClickListener listener,OnItemLongClickListener listener1){
        this.mContext=context;
        this.mlistener=listener;
        this.mlistener1=listener1;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        if (viewType==0){
            return new LinerViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item,parent,false));
        }else {
            return new LinerViewHolder2(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item_2,parent,false));
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(getItemViewType(position)==0)
        {
            ((LinerViewHolder)holder).textView.setText("Hello World");
        }else {
            ((LinerViewHolder2)holder).textView.setText("我就不想跑");
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mlistener.onClick(position+1);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mlistener1.onLongClick(position+1);
                return true;
            }
        });




    }

    @Override
    public int getItemViewType(int position) {
        if (position%2==0){
            return 0;
        }else {
            return 1;
        }

    }

    @Override
    public int getItemCount() {
        return 30;
    }
    class LinerViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;

        public LinerViewHolder( View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tv_title);
        }
    }
    class LinerViewHolder2 extends RecyclerView.ViewHolder{
        private TextView textView;
        private ImageView imageView;

        public LinerViewHolder2( View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tv_title);
            imageView=itemView.findViewById(R.id.iv_image);
        }
    }
    public interface OnItemClickListener{
        void onClick(int pos);
    }
    public interface OnItemLongClickListener{
        void onLongClick(int pos1);
    }
}
