package com.example.buju.UI.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.buju.R;

public class GridRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRbGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);

        mRbGrid=findViewById(R.id.rv_grid);
        mRbGrid.addItemDecoration(new MyDecoration());
        mRbGrid.setLayoutManager(new GridLayoutManager(GridRecyclerViewActivity.this,3));
        mRbGrid.setAdapter(new GridAdapter(GridRecyclerViewActivity.this, new GridAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(GridRecyclerViewActivity.this, "点击" + pos, Toast.LENGTH_SHORT).show();

            }
        }, new GridAdapter.OnItemLongClickListener() {
            @Override
            public void onLongClick(int pos1) {
                Toast.makeText(GridRecyclerViewActivity.this,"长按"+pos1,Toast.LENGTH_SHORT).show();
            }
        }));
    }
    class MyDecoration extends RecyclerView.ItemDecoration{
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state){
            super.getItemOffsets(outRect,view,parent,state);
            outRect.set(0,0,getResources().getDimensionPixelOffset(R.dimen.dividerHerght),getResources().getDimensionPixelOffset(R.dimen.dividerHerght));
        }


    }
}
