package com.example.buju.UI.recyclerview;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.buju.R;

public class LinearRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRvMain;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycler_view);
        mRvMain=findViewById(R.id.rv_main);
        mRvMain.addItemDecoration(new MyDecoration());
        mRvMain.setLayoutManager(new LinearLayoutManager(LinearRecyclerViewActivity.this));
        mRvMain.setAdapter(new LinearAdapter(LinearRecyclerViewActivity.this, new LinearAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(LinearRecyclerViewActivity.this, "点击" + pos, Toast.LENGTH_SHORT).show();
            }
        }, new LinearAdapter.OnItemLongClickListener() {
            @Override
            public void onLongClick(int pos1) {
                Toast.makeText(LinearRecyclerViewActivity.this,"长按"+pos1,Toast.LENGTH_SHORT).show();
            }
        }));


    }
    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets( Rect outRect,  View view,  RecyclerView parent,  RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,getResources().getDimensionPixelOffset(R.dimen.dividerHerght),0,getResources().getDimensionPixelOffset(R.dimen.dividerHerght));
        }

        @Override
        public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.onDraw(c, parent, state);


        }
    }
}
