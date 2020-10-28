package com.example.buju.shijianjizhi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.buju.R;
import com.example.buju.util.ToastUtil;

public class ShiJianFragment extends Fragment {
    private Button mBtnClassOnClick;
    private Button mBtnNoNameClassOnClick;
    private Button mBtnSjyInLei;
    private Button mBtnWaibuclass;
    private MyButton myButton;
    private Button mBtnHandler;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_event, container,false);
        mBtnClassOnClick=view.findViewById(R.id.btn_neibulei);
        mBtnNoNameClassOnClick=view.findViewById(R.id.nimingnibu);
        mBtnSjyInLei=view.findViewById(R.id.sjyinlei);
        mBtnWaibuclass=view.findViewById(R.id.waibulei);
//        myButton=view.findViewById(R.id.mybutton);
        mBtnHandler=view.findViewById(R.id.handler);

        mBtnHandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getActivity();
                Intent intent=new Intent(context, HandlerActivity.class);
                startActivity(intent);
            }
        });

        //内部类点击事件
        mBtnClassOnClick.setOnClickListener(new OnClick());
        //匿名内部类点击事件
        mBtnNoNameClassOnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getActivity();
                ToastUtil.showMsg(context,"匿名用内部类点了一下");
            }
        });
        Context context=getActivity();
        //通过事件源所在的类实现
        mBtnSjyInLei.setOnClickListener((View.OnClickListener) context);
        //通过外部类
        mBtnWaibuclass.setOnClickListener(new MyClickListener(context));
        return view;
    }

    public void onClick(View v){
        Context context = getActivity();
        switch (v.getId()){

            case R.id.sjyinlei:
                ToastUtil.showMsg(context,"通过事件源所在的类点了一下");
                break;
        }
    }
    class OnClick implements View.OnClickListener{
        Context context = getActivity();

        @Override
        public void onClick(View view) {
            ToastUtil.showMsg(context,"用内部类点了一下");
        }
    }



    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("Activity","---onTouchEvent---");
                break;
        }
        return false;
    }


}