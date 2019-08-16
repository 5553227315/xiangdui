package com.example.buju.UI.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.buju.R;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.LinerViewHolder> {
    private Context mContext;
    private OnItemClickListener mlistener;
    private OnItemLongClickListener mlistener1;




    public GridAdapter(Context context, OnItemClickListener listener, OnItemLongClickListener listener1){
        this.mContext=context;
        this.mlistener=listener;
        this.mlistener1=listener1;
    }
    @Override
    public GridAdapter.LinerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LinerViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_grid_recyclerview_item,parent,false));
    }

    @Override
    public void onBindViewHolder(GridAdapter.LinerViewHolder holder, final int position) {

        holder.textView.setText("Hello");
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
        return 80;
    }
    class LinerViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;

        public LinerViewHolder( View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tv_title1);
        }
    }
    public interface OnItemClickListener{
        void onClick(int pos);
    }
    public interface OnItemLongClickListener{
        void onLongClick(int pos1);
    }
}
