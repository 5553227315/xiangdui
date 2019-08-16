package com.example.buju.UI.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.buju.R;

public class ContainerActivity extends AppCompatActivity implements AFragment.IOnMessageClick{
    private AFragment aFragment;
//    private Button mBtnChange;
//    private BFragment bFragment;
    private TextView mTvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        mTvTitle=findViewById(R.id.tv_title);
//        mBtnChange=findViewById(R.id.btn_change);
//
//        mBtnChange.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                if (bFragment==null){
//                    bFragment=new BFragment();
//                }
//                getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,bFragment).commitAllowingStateLoss();
//            }
//        });

        //实例化AFargment
        aFragment= AFragment.newInstance("我是参数");
        //把AFragment添加到Activity,记得调用commit
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container,aFragment,"A").commitAllowingStateLoss();
    }
    public void setData(String text){
        mTvTitle.setText(text);

    }

    @Override
    public void onClick(String text) {
        mTvTitle.setText(text);
    }
}
