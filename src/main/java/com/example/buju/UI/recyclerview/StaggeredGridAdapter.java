package com.example.buju.UI.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.buju.R;

public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridAdapter.LinerViewHolder> {
    private Context mContext;
    private OnItemClickListener mlistener;
    private OnItemLongClickListener mlistener1;




    public StaggeredGridAdapter(Context context, OnItemClickListener listener, OnItemLongClickListener listener1){
        this.mContext=context;
        this.mlistener=listener;
        this.mlistener1=listener1;
    }
    @Override
    public StaggeredGridAdapter.LinerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LinerViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_staggered_recyclerview_item,parent,false));
    }

    @Override
    public void onBindViewHolder(StaggeredGridAdapter.LinerViewHolder holder, final int position) {

        if(position%2!=0){
            holder.imageView.setImageResource(R.mipmap.img7);
        }else {
            holder.imageView.setImageResource(R.mipmap.img6);
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
    public int getItemCount() {
        return 30;
    }
    class LinerViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;

        public LinerViewHolder( View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.iv1);
        }
    }
    public interface OnItemClickListener{
        void onClick(int pos);
    }
    public interface OnItemLongClickListener{
        void onLongClick(int pos1);
    }
}
