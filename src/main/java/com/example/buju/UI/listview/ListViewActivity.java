package com.example.buju.UI.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.buju.R;

public class ListViewActivity extends Activity {

    private Button mBtnShuru;
    private EditText mEtn;
    private ListView mlv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        mlv1=findViewById(R.id.lv_1);
        mBtnShuru=findViewById(R.id.jishu);
        mEtn=findViewById(R.id.shuru);
        mlv1.setAdapter(new MylistAdapter(ListViewActivity.this));

        mBtnShuru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int count=Integer.parseInt(mEtn.getText().toString());
                mlv1.clearDisappearingChildren();
                mlv1.setAdapter(new MylistAdapter(ListViewActivity.this){
                    public int getCount(){
                        return count;
                    }
                });
            }
        });


        mlv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this,"点击 pos:"+position,Toast.LENGTH_SHORT).show();
            }
        });
        mlv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this,"长按 pos:"+position,Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}

