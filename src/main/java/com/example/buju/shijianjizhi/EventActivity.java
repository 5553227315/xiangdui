package com.example.buju.shijianjizhi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.buju.R;
import com.example.buju.util.ToastUtil;

public class EventActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mBtnClassOnClick;
    private Button mBtnNoNameClassOnClick;
    private Button mBtnSjyInLei;
    private Button mBtnWaibuclass;
    private MyButton myButton;
    private Button mBtnHandler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mBtnClassOnClick=findViewById(R.id.btn_neibulei);
        mBtnNoNameClassOnClick=findViewById(R.id.nimingnibu);
        mBtnSjyInLei=findViewById(R.id.sjyinlei);
        mBtnWaibuclass=findViewById(R.id.waibulei);
        myButton=findViewById(R.id.mybutton);
        mBtnHandler=findViewById(R.id.handler);
        mBtnHandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(EventActivity.this, HandlerActivity.class);
                startActivity(intent);
            }
        });
        //内部类点击事件
        mBtnClassOnClick.setOnClickListener(new OnClick());
        //匿名内部类点击事件
        mBtnNoNameClassOnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.showMsg(EventActivity.this,"匿名用内部类点了一下");
            }
        });
        //通过事件源所在的类实现
        mBtnSjyInLei.setOnClickListener(EventActivity.this);
        //通过外部类
        mBtnWaibuclass.setOnClickListener(new MyClickListener(EventActivity.this));




    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.sjyinlei:
                ToastUtil.showMsg(EventActivity.this,"通过事件源所在的类点了一下");
                break;
        }
    }
    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            ToastUtil.showMsg(EventActivity.this,"用内部类点了一下");
        }
    }
    public void show(View view){
        switch (view.getId()){
            case R.id.shuxing:
                ToastUtil.showMsg(EventActivity.this,"通过设置属性点了一下");
                break;
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("Activity","---onTouchEvent---");
                break;
        }
        return false;
    }
}
